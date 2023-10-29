import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            int option;

            System.out.println();
            System.out.println(new String(new char[12]).replace("\0", "#") + " MENU " + new String(new char[12]).replace("\0", "#"));
            System.out.println("1. Ler dados de arquivo");
            System.out.println("2. Analisar Dados");
            System.out.println("3. Inserir Programa");
            System.out.println("4. Buscar Programa");
            System.out.println("5. Remover Programa");
            System.out.println("6. Exibir a Altura das Árvores");
            System.out.println("7. Salvar Dados em Arquivo");
            System.out.println("8. Encerrar a Aplicação");
            System.out.println();
            System.out.print("Insira a opção desejada: ");

            option = s.nextInt();

            switch (option) {
                case 1: //TODO
                    break;
                case 2: //TODO
                    break;
                case 3: //TODO
                    break;
                case 4: //TODO
                    break;
                case 5: //TODO
                    break;
                case 6: //TODO
                    break;
                case 7: //TODO
                    break;
                case 8:
                    s.close();
                    System.exit(0);
                default:
                    System.err.println("Opção inválida.");
            }
        }
    }
}