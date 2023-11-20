import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Main {
    /**
     * Método utilizado para pausar a execução do programa por 1500ms.
     */
    public static void sleep() {
        sleep(1500);
    }

    /**
     * Método utilizado para pausar a execução do programa por um determinado tempo.
     *
     * @param ms tempo em milissegundos
     */
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        BST titlesBST = new BST();
        AVL titlesAVL = new AVL();

        int maxCompleted = 0;
        String notCompleted = "   ";
        String completed = " x ";

        while (true) {
            String option;

            System.out.println();
            System.out.println(new String(new char[12]).replace("\0", "#") + " MENU " + new String(new char[12]).replace("\0", "#"));
            System.out.println(" 1. Ler dados de arquivo");

            if (maxCompleted > 1) {
                System.out.println();
                System.out.println(" 2. Séries de animes com mais de uma temporada e classificação adequada para crianças");
                System.out.println(" 3. Documentários históricos com classificação +16");
                System.out.println(" 4. Filmes com IMDB score acima do valor inserido, que não são de origem dos EUA, Canadá ou Reino Unido");
                System.out.println(" 5. ");
                System.out.println(" 6. Filmes com duração maior que três horas e score acima de 8");
                System.out.println();

                System.out.println(" 7. Inserir Programa");
                System.out.println(" 8. Buscar Programa");
                System.out.println(" 9. Remover Programa");
                System.out.println("10. Exibir a Altura das Árvores");
                System.out.println("11. Salvar Dados em Arquivo");
            }

            System.out.println("\n 0. Encerrar a Aplicação");
            System.out.println();
            System.out.print("Insira a opção desejada: ");

            option = m.next();

            switch (option) {
                case "1": //TODO
                    System.out.print("\nInsira o nome do arquivo CSV (ou ENTER para o padrão): ");
                    String filePath;
                    m.nextLine();

                    String opt = m.nextLine();

                    filePath = opt.isEmpty() ? "./titles.csv" : opt;

                    Scanner f;
                    try {
                        f = openFile(filePath);
                    } catch (FileNotFoundException e) {
                        System.err.println("\nArquivo não encontrado - tente novamente.");
                        sleep();

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
                            titlesAVL.insert(title);

                            counter++; // TODO: remove
                        }
                    }

                    System.out.println("\nÁrvores criadas com sucesso!");
                    sleep();
                    System.err.printf("\nDEBUG: %d entries\n\n", counter); // TODO: remove

                    maxCompleted = 1;
                    sleep();
                    break;
                case "2":
                    if (maxCompleted < 1) {
                        System.out.println("\nOpção indisponível. É necessário ler os dados do arquivo antes de analisá-los.");
                        break;
                    }

                    AVL stats1 = titlesAVL.stats1();
                    System.out.println("\nSéries de animes com mais de uma temporada e classificação adequada para crianças:\n");
                    System.out.println(stats1.preorderTraversal());

                    maxCompleted = 2;
                    sleep();
                    break;
                case "3": //TODO
                    if (maxCompleted < 1) {
                        System.out.println("\nOpção indisponível. É necessário ler os dados do arquivo antes de analisá-los.");
                        break;
                    }

                    AVL stats2 = titlesAVL.stats2();
                    System.out.println("\nDocumentários históricos com classificação +16:\n");
                    System.out.println(stats2.inorderTraversal());

                    maxCompleted = 3;
                    sleep();
                    break;
                case "4":
                    if (maxCompleted < 1) {
                        System.out.println("\nOpção indisponível. É necessário ler os dados do arquivo antes de analisá-los.");
                        break;
                    }

                    AVL stats3 = titlesAVL.stats3();
                    System.out.println("\nFilmes com IMDB score acima do valor inserido, que não são de origem dos EUA, Canadá ou Reino Unido:\n");
                    System.out.println(stats3.postorderTraversal());

                    maxCompleted = 4;
                    sleep();
                    break;
                case "5": //TODO
                    if (maxCompleted < 1) {
                        System.out.println("\nOpção indisponível. É necessário ler os dados do arquivo antes de analisá-los.");
                        break;
                    }

//                    AVL stats4 = titlesAVL.stats4();
//                    stats4.preorderTraversal();

                    maxCompleted = 5;
                    sleep();
                    break;
                case "6":
                    if (maxCompleted < 1) {
                        System.out.println("\nOpção indisponível. É necessário ler os dados do arquivo antes de analisá-los.");
                        break;
                    }

                    AVL stats5 = titlesAVL.stats5();
                    System.out.println("\nFilmes com duração maior que três horas e score acima de 8:\n");
                    System.out.println(stats5.preorderTraversal());

                    maxCompleted = 6;
                    sleep();
                    break;
                case "7": //TODO
                    if (maxCompleted < 1) {
                        System.out.println("\nOpção indisponível. É necessário ler os dados do arquivo antes de inserir novos programas.");
                        break;
                    }

                    maxCompleted = 7;
                    sleep();
                    break;
                case "8": //TODO
                    if (maxCompleted < 1) {
                        System.out.println("\nOpção indisponível. É necessário ler os dados do arquivo antes de realizar buscas.");
                        break;
                    }

                    System.out.print("\nInsira o ID do programa a ser buscado: ");
                    m.nextLine();
                    String searchId = m.nextLine();
                    System.out.println();


                    try {
                        Instant bstStart = Instant.now();
                        Node bstResult = titlesBST.search(searchId);
                        Instant bstEnd = Instant.now();
                        Duration bstTimeElapsed = Duration.between(bstStart, bstEnd);


                        Instant avlStart = Instant.now();
                        Node avlResult = titlesAVL.search(searchId);
                        Instant avlEnd = Instant.now();
                        Duration timeElapsed = Duration.between(avlStart, avlEnd);

                        System.out.println(avlResult.getData().toString());

                        System.out.printf("%nTempo de busca via BST: %d ns%n", bstTimeElapsed.toNanos());
                        System.out.printf("Tempo de busca via AVL: %d ns%n", timeElapsed.toNanos());

                        System.out.printf("%nNúmero de comparações via BST: %d", titlesBST.getNumOfComparisons());
                        System.out.printf("%nNúmero de comparações via AVL: %d%n", titlesAVL.getNumOfComparisons());
                    } catch (NullPointerException e) {
                        System.out.printf("Programa %s não encontrado.%n", searchId);
                    }

                    maxCompleted = 8;
                    sleep(2500);
                    break;
                case "9": //TODO
                    if (maxCompleted < 1) {
                        System.out.println("\nOpção indisponível. É necessário ler os dados do arquivo antes de realizar remoções.");
                        break;
                    }

                    System.out.print("\nInsira o ID do programa a ser removido: ");
                    m.nextLine();
                    String removeId = m.nextLine();
                    System.out.println();

                    try {
                        titlesAVL.remove(removeId);
                    } catch (NullPointerException e) {
                        System.out.printf("Programa %s não encontrado.%n", removeId);
                    }

                    maxCompleted = 9;
                    sleep();
                    break;
                case "10": //TODO
                    if (maxCompleted < 1) {
                        System.out.println("\nOpção indisponível. É necessário ler os dados do arquivo antes de calcular a altura das árvores.");
                        break;
                    }

                    System.out.printf("Altura da BST: %d%n", titlesBST.getHeight());
                    System.out.printf("Altura da AVL: %d%n", titlesAVL.getHeight());

                    maxCompleted = 10;
                    sleep();
                    break;
                case "11": //TODO
                    if (maxCompleted < 1) {
                        System.out.println("\nOpção indisponível. É necessário ler os dados do arquivo antes de realizar buscas.");
                        break;
                    }

                    maxCompleted = 11;
                    sleep();
                    break;
                case "0":
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