
import java.util.ArrayList;
import java.util.Scanner;

public class Cell {

    ArrayList<Cell> rota = new ArrayList<>();
    ArrayList<Personagem> monstros = new ArrayList<>();
    ArrayList<Personagem> player = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    int prob, status, monstro, id;
    static int i = 1;
    Scanner usuario = new Scanner(System.in);
    int n, m;
    String nome;

    // construir a celula
    public Cell() {

    }

    public void MCell() {

        i = i + 1;
        this.id = i;
        ChanceBat();
        if (status == 1) {
            for (int j = 0; j < monstro; j++) {

                Personagem Mons = new Personagem(((int) (Math.random() * 2) + 4), "Monstro", 0);
                monstros.add(Mons);
            }
        }
    }

    public void Cidade() {
        this.status = 0;
        this.id = i;

            System.out.print("\nJogador, selecione sua classe:\n[1]Guerreiro \n[2]Mago \n[3]Ninja \n[8]Arqueiro\nResposta: ");
            m = usuario.nextInt();
            if(m != 1 && m != 2 && m != 3 && m != 8) {
            	System.out.println("Número Inválido!");
            	Cidade();
            }
            System.out.print("\nJogador Digite seu nome: ");
            nome = usuario.next();
            Personagem play = new Personagem(m, nome, 0);
            player.add(play);
        }

    public void FaseFinal() {

        this.status = 1;
        i = i + 1;
        this.id = i;
        Personagem Dragao = new Personagem(7, "Dragão Eamaus", 0);
        monstros.add(Dragao);
    }

    public void ChanceBat() {

        prob = (int) (Math.random() * 120);
        if (prob < 70) {
            status = 1;
            prob = (int) (Math.random() * 100);
            if (prob < 33) {
                monstro = 1;
            } else if (prob >= 33 && prob < 66) {
                monstro = 2;
            } else if (prob >= 66 && prob < 100) {
                monstro = 3;
            }
        } else if (prob < 100 && prob >= 70) {
            status = 0;
        } else if (prob <= 120 && prob >= 100) {
            status = 2;
        }
    }

    public int getId() {

        return id;
    }
}
