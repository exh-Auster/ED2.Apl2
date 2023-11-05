import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner m = new Scanner(System.in);

        while (true) {
            String option;

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

            option = m.next();

            switch (option) {
                case "1": //TODO
//                    AVL titles = new AVL();

                    System.out.print("Insira o nome do arquivo CSV (ou ENTER para o padrão): ");
                    String filePath;
                    m.nextLine();

                    String opt = m.nextLine();

                    filePath = opt.isEmpty() ? "./titles.csv" : opt;

                    Scanner f = openFile(filePath);

                    String line = f.nextLine();
                    String[] lineValues;
                    String nextLine = f.nextLine();

                    int counter = 0; // TODO: remove

                    while (f.hasNextLine()) {
                        lineCreation: {
                            line = nextLine;
                            nextLine = f.nextLine();

                            while (!nextLine.startsWith("ts") && !nextLine.startsWith("tm")) {
                                line = line.concat(nextLine);
                                nextLine = f.nextLine();
                            }

                            lineValues = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

//                            if (lineValues.length < 15) System.err.println(lineValues.length + Arrays.toString(lineValues));

                            for (int i = 0; i < lineValues.length; i++) { // TODO
                                if (lineValues[i].isBlank()) {
                                    break lineCreation;
                                }
                            }

                            if (lineValues.length != 15) {
                                break lineCreation;
                            }

//                            ProgramaNetflix title = new ProgramaNetflix(
//                                    lineValues[0],
//                                    lineValues[1],
//                                    lineValues[2],
//                                    lineValues[3],
//                                    Integer.parseInt(lineValues[4]),
//                                    lineValues[5],
//                                    Integer.parseInt(lineValues[6]),
//                                    new String[]{lineValues[7]}, // TODO
//                                    new String[]{lineValues[8]}, // TODO
//                                    (int) Double.parseDouble(lineValues[9]),
//                                    lineValues[10],
//                                    Double.parseDouble(lineValues[11]),
//                                    (int) Double.parseDouble(lineValues[12]),
//                                    Double.parseDouble(lineValues[13]),
//                                    Double.parseDouble(lineValues[14])
//                            );
//
//                            titles.insert(title);

                            counter++;

                        }
                    }

                    System.err.printf("\nDEBUG: %d entries\n\n", counter); // TODO: remove
                case "2": //TODO
                    break;
                case "3": //TODO
                    break;
                case "4": //TODO
                    break;
                case "5": //TODO
                    break;
                case "6": //TODO
                    break;
                case "7": //TODO
                    break;
                case "8":
                    m.close();
                    System.exit(0);
                default:
                    System.err.println("Opção inválida.\n");
            }
        }
    }

    public static Scanner openFile(String filePath) throws FileNotFoundException {
        return new Scanner(new File(filePath));
    }
}