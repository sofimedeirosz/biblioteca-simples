package atv1BoasPraticas;
import java.util.Scanner;

public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int op;
        String titulo;

        do{
            System.out.println("\n====== MENU ======");
            System.out.println("Insira a opção desejada: ");
            System.out.println("1-Adicionr\n2-Emprestar\n3-Listar\n4-Sair");
            op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1: //Adicionar
                    System.out.println("Insira o título do livro desejado: ");
                    titulo = sc.nextLine().toLowerCase().trim();
                    biblioteca.adicionarLivro(new Livro(titulo));
                    break;

                case 2: //Emprestar
                    System.out.println("Insira o título do livro desejado: ");
                    titulo = sc.nextLine().toLowerCase().trim();
                    biblioteca.emprestarLivro(titulo);
                    break;

                case 3: //Listar
                    System.out.println("=== BIBLIOTECA ORGANIZADA ===");
                    biblioteca.listarLivros();
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");

            }
        }while (op != 4);

        sc.close();
    }
}
