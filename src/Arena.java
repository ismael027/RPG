import java.util.Scanner;
public class Arena {
	Personagem eu = new Personagem();
	Personagem monstro = new Personagem();
	public Arena(final Personagem eu, final Personagem monstro) {
        this.eu = eu;
        this.monstro = monstro;
        batalhar();
    }

    public void batalhar() {

        final int op;
        final Scanner scan = new Scanner(System.in);

        double k, j;

        while (eu.getHP() > 0 || monstro.getHP() > 0) {
            System.out.println("|==========================|");
            System.out.println("|         BATALHAR         |");
            System.out.println("| ESCOLHA O TIPO DE ATAQUE |");
            System.out.println("|[1]: Ataque f�sico simples|");
            System.out.println("|[2]: Ataque f�sico cruzado|");
            System.out.println("|[3]: Ataque m�gico de fogo|");
            System.out.println("|[4]: Ataque m�gico de gelo|");
            System.out.println("|==========================|");

            final int tipo_ataque = scan.nextInt();

            // Dano gerado pelo Jogador
            k = danoGerado(tipo_ataque);
            System.out.printf("\nDano gerado pelo Jogador: %.2f", k);

            // Dano infligido ao Monstro
            monstro.setHP(monstro.getHP() - k);
            if (monstro.getESQUIVA() <= (double) monstro.getcESQUIVA() + (Math.random() * monstro.getcESQUIVA())) {
                System.out.printf("\nHP Monstro: %.2f", monstro.getHP());
            }

            System.out.println("\n");

            // Dano gerado pelo Monstro
            j = danoGeradom((int) ((Math.random() * 4 + 1)));
            System.out.printf("Dano gerado pelo monstro: %.2f", j);

            // Dano infligido ao Jogador
            if (eu.getcESQUIVA() <= (double) eu.getcESQUIVA() + (Math.random() * eu.getESQUIVA())) {
                eu.setHP(eu.getHP() - j);
            }
            System.out.printf("\nHP Jogador: %.2f\n", eu.getHP());

            // Verificar quem morreu
            if (eu.getHP() <= 0) {
                System.out.println("\nJOGADOR PERDEU!\n");

                System.exit(0);
            } else if (monstro.getHP() <= 0) {
                System.out.println("\nMONSTRO ELIMINADO!\n");

                break;
            }
        }
    }

    // Dano gerado pelo personagem
    public double danoGerado(final int tipo_ataque) {

        double d = 0.0;
        final double p = 0.17 * (100 - eu.getATK() / 100);
        final double fc = (eu.getHP() + 0.1 * eu.getcHP()) / Math.min(500, eu.getcHP());
        final double fm = (eu.getMP() + 0.1 * eu.getcMP()) / Math.min(500, eu.getcMP());

        switch (tipo_ataque) {
        case 1: // Ataque f�sico simples
            d = (double) (eu.getATK() / 100 * 210)
                    + (Math.random()) * Math.max(0, ((eu.getATK() / 100) * 210 - Math.abs(p * 210)) * fc);
            break;
        case 2: // Ataque f�sico cruzado
            d = (double) (eu.getATK() / 100 * 362)
                    + (Math.random()) * Math.max(0, ((eu.getATK() / 100) * 362 - Math.abs(p * 362)) * fc);
            break;
        case 3: // Ataque m�gico fogo
            d = (double) (eu.getATK() / 100 * 200)
                    + (Math.random()) * Math.max(0, ((eu.getATK() / 100) * 200 - Math.abs(p * 200)) * fm);
            break;
        case 4: // Ataque m�gico gelo
            d = (double) (eu.getATK() / 100 * 350)
                    + (Math.random()) * Math.max(0, ((eu.getATK() / 100) * 350 - Math.abs(p * 350)) * fm);
            break;
        default:
            System.out.println("Op��o inv�lida!");
            break;
        }
        return danoInfligido(d, tipo_ataque);
    }

    // Dano infligido ao personagem
    public double danoInfligido(final double d, final int tipo_ataque) {
        switch (tipo_ataque) {
        case 1: // Ataque f�sico simples
            return d * (100 / (100 + eu.getRFISICA()));
        case 2: // Ataque f�sico cruzado
            return d * (100 / (100 + eu.getRFISICA()));
        case 3: // Ataque m�gico fogo
            return d * (100 / (100 + eu.getRFOGO()));
        case 4: // Ataque m�gico gelo
            return d * (100 / (100 + eu.getRGELO()));
        default:
            System.out.println("Op��o inv�lida!");
            break;
        }
        return 0;
    }

    // dano gerado pelo monstro
    public double danoGeradom(final int tipo_ataque) {

        double d = 0.0;
        final double p = 0.17 * (100 - monstro.getATK() / 100);
        final double fc = (monstro.getHP() + 0.1 * monstro.getcHP()) / Math.min(500, monstro.getcHP());
        final double fm = (monstro.getMP() + 0.1 * monstro.getcMP()) / Math.min(500, monstro.getcMP());

        switch (tipo_ataque) {
        case 1: // Ataque f�sico simples
            d = (double) (monstro.getATK() / 100 * 210)
                    + (Math.random()) * Math.max(7, ((monstro.getATK() / 100) * 210 - Math.abs(p * 210)) * fc);
            break;
        case 2: // Ataque f�sico cruzado
            d = (double) (monstro.getATK() / 100 * 362)
                    + (Math.random()) * Math.max(7, ((monstro.getATK() / 100) * 362 - Math.abs(p * 362)) * fc);
            break;
        case 3: // Ataque m�gico fogo
            d = (double) (monstro.getATK() / 100 * 200)
                    + (Math.random()) * Math.max(7, ((monstro.getATK() / 100) * 200 - Math.abs(p * 200)) * fm);
            break;
        case 4: // Ataque m�gico gelo
            d = (double) (monstro.getATK() / 100 * 350)
                    + (Math.random()) * Math.max(7, ((monstro.getATK() / 100) * 350 - Math.abs(p * 350)) * fm);
            break;
        default:
            System.out.println("Op��o inv�lida!");
            break;
        }
        return danoInfligidom(d, tipo_ataque);
    }

    // Dano infligido ao monstro
    public double danoInfligidom(final double d, final int tipo_ataque) {
        switch(tipo_ataque){ 
            case 1:     // Ataque f�sico simples
                return d * (100 / (100 + monstro.getRFISICA()));
            case 2:     // Ataque f�sico cruzado
                return d * (100 / (100 + monstro.getRFISICA()));
            case 3:     // Ataque m�gico fogo
                return d * (100 / (100 + monstro.getRFOGO()));
            case 4:     // Ataque m�gico gelo
                return d * (100 / (100 + monstro.getRGELO()));
            default:
                System.out.println("Op��o inv�lida!");
                break;
        }
	return 0;
}
} 

	
        
      
	
		
	

