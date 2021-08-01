import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {

        Mapa map = new Mapa();
        map.criamapa();
        Scanner scan = new Scanner(System.in);
        int op = 0;

        do {
            //vai me achar e olhar se no lugar onde estou tem mostro
            if (map.meachar().local.monstros.isEmpty()) {

                map.MenuSafe();
                op = scan.nextInt();
                switch (op) {

                    case 1:
                        //Curar Maldi��o
                        map.curar();
                        System.out.println(">>>> Pressione Enter para Continuar... <<<<");
                        System.in.read();
                        break;

                    case 2:
                        //Ver Status
                        map.VerStts();
                        System.out.println(">>>> Pressione Enter para Continuar... <<<<");
                        System.in.read();
                        break;

                    case 3:
                        //Andar
                        map.andar();
                        break;

                    case 4:
                        //Encerra o jogo
                        System.out.println(">>>> MSG: Saindo do programa...!!! <<<<\n>>>> Pressione Enter para Continuar... <<<<");
                        System.in.read();
                        System.exit(0);
                        break;

                    default:
                        System.out.println(">>>> MSG: Digite uma op��o valida!!! <<<<\n>>>> Pressione Enter para Continuar... <<<<");
                        System.in.read();
                }

            } else {

                map.menuMonstro();

                op = scan.nextInt();
                switch (op) {

                    case 1:
                        //Batalhar
                        map.Batalha();
                        System.out.println(">>>> Pressione Enter para continuar... <<<<");
                        System.in.read();
                        break;

                    case 2:
                        //Ver Status
                        map.VerStts();
                        System.out.println(">>>> Pressione Enter para Continuar... <<<<");
                        System.in.read();
                        break;

                   /* case 3:
                        //Andar
                        map.andar();
                        break;*/

                    case 4:
                        //Sair do Jogo
                        System.out.println(">>>> MSG: Saindo do programa...!!! <<<<\n>>>> Precione Enter para Continuar... <<<<");
                        System.in.read();
                        System.exit(0);
                        break;

                    default:
                        System.out.println(">>>> MSG: Digite uma op��o valida!!! <<<<\n>>>> Precione Enter para Continuar... <<<<");
                        System.in.read();
                        break;
                }
            }
        } while (op != 4);
    }
}
