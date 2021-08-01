
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mapa {

	ArrayList<Cell> cellmaster = new ArrayList<>();

	Scanner scan = new Scanner(System.in);

	public void criamapa() {
		int n, i;

		System.out.println("Bem Vindo ao Jogo!!!");
		System.out.print("\nDigite o número de Locais: ");
		n = scan.nextInt();
		Cell t1 = new Cell();
		t1.Cidade();
		cellmaster.add(t1);
		meachar().local = t1;

		for (i = 0; i < n - 2; i++) {

			Cell c = new Cell();
			c.MCell();
			c.rota.add(cellmaster.get(i));

			if (i >= 3) {

				c.rota.add(cellmaster.get(i - 3));
			}
			cellmaster.add(c);
		}

		Cell tF = new Cell();
		tF.FaseFinal();
		tF.rota.add(cellmaster.get(n - 2));
		cellmaster.add(tF);

		for (i = 0; i < n - 1; i++) {

			cellmaster.get(i).rota.add(cellmaster.get(i + 1));

			if (i < n - 3) {

				cellmaster.get(i).rota.add(cellmaster.get(i + 3));
			}
		}

	}

	public void andar() {

		System.out.println("\n------ MOVER: ------");
		for (int i = 0; i < localplayer().rota.size(); i++) {

			System.out.println("[" + (i + 1) + "] LOCAL " + localplayer().rota.get(i).getId());
		}

		System.out.println("[0] VOLTAR");
		System.out.print("\nPara onde deseja ir: ");
		int n = scan.nextInt();

		if (n > 0 && n <= localplayer().rota.size()) {

			int temp = localplayer().id;
			localplayer().player.get(0).setLocal(localplayer().rota.get(n - 1));
			localplayer().player.add(meachar());

			for (int i = 0; i < cellmaster.get(temp - 1).player.size(); i++) {

				cellmaster.get(temp - 1).player.remove(i);
			}

		} else {

			System.out.println(">>>> Você não pode ir para este Local!!! <<<<");
		}
	}

	public Cell localplayer() {

		return meachar().local;
	}

	// achar onde eu estou no mapa
	public Personagem meachar() {

		for (int i = 0; i < cellmaster.size(); i++) {

			if (!cellmaster.get(i).player.isEmpty()) {

				return cellmaster.get(i).player.get(0);
			}
		}
		return null;
	}

	// menu se não tiver monstro
	public void MenuSafe() {
		System.out.println("\n|========== LOCAL " + meachar().local.id + " ==========|");
		System.out.println("|     Escolha uma Opção:      |");
		System.out.println("|[1] Curar                    |");
		System.out.println("|[2] Ver Status               |");
		System.out.println("|[3] Andar                    |");
		System.out.println("|[4] Sair do jogo             |");
		System.out.println("|=============================|");
		System.out.print("Resposta: ");
	}

	// printar status
	public void VerStts() {
		Personagem p = new Personagem();
		p = meachar();
		System.out.println("|=========================|");
		System.out.println("|   Status do Personagem  |");
		System.out.println("|Nome: " + p.getNome() + "             |");
		System.out.printf("|HP: " + "%.2f" + "                |\n", p.getHP());
		System.out.printf("|Ataque: " + "%.2f" + "             |\n", p.getATK());
		System.out.printf("|MP: " + "%.2f" + "                |\n", p.getMP());
		System.out.printf("|Resistência a Fogo: " + "%.2f" + " |\n", p.getRFOGO());
		System.out.printf("|Resistência a Gelo: " + "%.2f" + " |\n", p.getRGELO());
		System.out.printf("|Resistência Física: " + "%.1f" + " |\n", p.getRFISICA());
		System.out.printf("|Esquiva: " + "%.2f" + "            |\n", p.getESQUIVA());
		if (p.getSTATUS() == 0) {
			System.out.println("|Status: Normal           |");
		} else {
			System.out.println("|Status: Amaldiçoado      |");
		}
		System.out.println("|=========================|");

	}

	// caso tenha mostro
	public void menuMonstro() {
		System.out.println("\n|========== LOCAL " + meachar().local.id + " ==========|");
		System.out.println("|     Escolha uma Opção:      |");
		System.out.println("|[1] Batalhar                 |");
		System.out.println("|[2] Ver Status               |");
		// System.out.println("|[3] Andar |");
		System.out.println("|[4] Sair do jogo             |");
		System.out.println("|=============================|");
		System.out.print("Resposta: ");
	}

	// curar o personagem
	public void curar() {
		meachar().Upar(meachar().getEXP());
	}

	public void Batalha() {

		for (int i = 0; i < localplayer().monstros.size(); i++)

		{
			System.out.println("(" + (i + 1) + ") " + localplayer().monstros.get(i).getNome());

		}
		System.out.println("Digite o numero do mosntro para lutar:");
		try {
			int n = scan.nextInt();
			Arena bat = new Arena(meachar(), localplayer().monstros.get(n - 1));
			meachar().Upar(localplayer().monstros.get(n - 1).getEXP() * 0.25);
			localplayer().monstros.remove(n - 1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Número inválido!\n");
			Batalha();
		}

	}

}
