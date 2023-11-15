import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        BST titlesBST = new BST();
//        AVL titlesAVL = new AVL();

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
                    System.out.print("Insira o nome do arquivo CSV (ou ENTER para o padrão): ");
                    String filePath;
                    m.nextLine();

                    String opt = m.nextLine();

                    filePath = opt.isEmpty() ? "./titles.csv" : opt;

                    Scanner f;
                    try {
                        f = openFile(filePath);
                    } catch (FileNotFoundException e) {
                        System.err.println("Arquivo não encontrado - tente novamente.\n");
                        break;
                    }

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
//
//                            for (int i = 0; i < lineValues.length; i++) { // TODO
//                                if (lineValues[i].isBlank()) {
//                                    break lineCreation;
//                                }
//                            }

                            if (lineValues.length != 15) {
                                break lineCreation;
                            }

                            String id = lineValues[0];
                            String titleName = lineValues[1].isBlank() ? "" : lineValues[1];
                            String type = lineValues[2];
                            String description = lineValues[3].isBlank() ? "" : lineValues[3];
                            int releaseYear = Integer.parseInt(lineValues[4]);
                            String ageCertification = lineValues[5].isBlank() ? "" : lineValues[5];
                            int runtime = Integer.parseInt(lineValues[6]);
                            String[] genres = new String[]{lineValues[7]}; // TODO
                            String[] productionCountries = new String[]{lineValues[8]}; // TODO
                            int seasons = lineValues[9].isBlank() ? -1 : (int) Double.parseDouble(lineValues[9]);
                            String imdbId = lineValues[10].isBlank() ? "" : lineValues[10];
                            Double imdbScore = lineValues[11].isBlank() ? -1 : Double.parseDouble(lineValues[11]);
                            int imdbVotes = lineValues[12].isBlank() ? -1 : (int) Double.parseDouble(lineValues[12]);
                            Double tmdbPopularity = lineValues[13].isBlank() ? -1 : Double.parseDouble(lineValues[13]);
                            Double tmdbScore = lineValues[14].isBlank() ? -1 : Double.parseDouble(lineValues[14]);

                            ProgramaNetflix title = new ProgramaNetflix(
                                    id,
                                    titleName,
                                    type,
                                    description,
                                    releaseYear,
                                    ageCertification,
                                    runtime,
                                    genres,
                                    productionCountries,
                                    seasons,
                                    imdbId,
                                    imdbScore,
                                    imdbVotes,
                                    tmdbPopularity,
                                    tmdbScore
                            );

                            titlesBST.insert(title);
//                            titlesAVL.insert(title);

                            counter++; // TODO: remove
                        }
                    }

                    System.err.printf("\nDEBUG: %d entries\n\n", counter); // TODO: remove
                case "2": //TODO
                    break;
                case "3": //TODO
                    break;
                case "4": //TODO
                    System.out.print("Insira o ID do programa a ser buscado: ");
                    m.nextLine();
                    String id = m.nextLine();
                    System.out.println();
                    System.out.println(titlesBST.search(id).getData().toString());
                    break;
                case "5": //TODO
                    System.out.print("Insira o ID do programa a ser removido: ");
                    m.nextLine();
                    String removeId = m.nextLine();
                    titlesBST.remove(removeId);

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