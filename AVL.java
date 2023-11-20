import java.util.Arrays;
import java.util.Scanner;

public class AVL extends BST {
    private int numOfComparisons;
    private Scanner s = new Scanner(System.in);

    public void insert(ProgramaNetflix data) {
        root = insert(root, data);
    }

    private Node insert(Node root, ProgramaNetflix data) {
        String key = data.getId();

        if (root == null) {
            return new Node(data);
        } else if (root.getKey().compareToIgnoreCase(key) > 0) {
            root.left = insert(root.left, data);
        } else if (root.getKey().compareToIgnoreCase(key) < 0) {
            root.right = insert(root.right, data);
        } else {
            System.err.printf("Duplicatas não são permitidas nessa implementação - pulando a inserção de %s%n", data.getId());
        }

        return rebalance(root);
    }

    public void delete(String key) {
        root = delete(root, key);
    }

    private Node delete(Node node, String key) {
        if (node == null) {
            return node;
        } else if (node.getKey().compareToIgnoreCase(key) > 0) {
            node.left = delete(node.left, key);
        } else if (node.getKey().compareToIgnoreCase(key) < 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node leftmostChild = getLeftmostChild(node.right);
                node.key = leftmostChild.key;
                node.right = delete(node.right, node.key);
            }
        }

        if (node != null) {
            node = rebalance(node);
        }

        return node;
    }

    private int getHeight(Node node) {
        return node == null ? -1 : node.height;
    }

    private Node getLeftmostChild(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    private Node rebalance(Node node) {
        refreshHeight(node);

        int balance = getBalanceFactor(node);

        if (balance > 1) {
            if (getHeight(node.right.right) <= getHeight(node.right.left)) {
                node.right = rotateRight(node.right);
            }

            node = rotateLeft(node);
        } else if (balance < -1) {
            if (getHeight(node.left.left) <= getHeight(node.left.right)) {
                node.left = rotateLeft(node.left);
            }

            node = rotateRight(node);
        }

        return node;
    }

    private Node rotateRight(Node node) {
        Node out = node.left;
        Node aux = out.right;

        out.right = node;
        node.left = aux;

        refreshHeight(node);
        refreshHeight(out);

        return out;
    }

    private Node rotateLeft(Node node) {
        Node out = node.right;
        Node aux = out.left;

        out.left = node;
        node.right = aux;

        refreshHeight(node);
        refreshHeight(out);

        return out;
    }

    private void refreshHeight(Node node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int getBalanceFactor(Node node) {
        return (node == null) ? 0 : getHeight(node.right) - getHeight(node.left);
    }

    public AVL stats1() {
        return stats1(this.root);
    }

    private AVL stats1(Node node) {
        if (node == null) {
            return null;
        }

        AVL left = stats1(node.getLeft());
        AVL right = stats1(node.getRight());

        ProgramaNetflix data = node.getData();
        String ageCertification = data.getAgeCertification();

        Boolean typeCheck = data.getType().equals("SHOW");
        Boolean genresCheck = Arrays.toString(data.getGenres()).contains("animation");
        Boolean productionCountriesCheck = Arrays.toString(data.getProductionCountries()).contains("JP");
        Boolean seasonsCheck = data.getSeasons() > 1;
        Boolean ageCertificationCheck = ageCertification.contains("G") ||
                                        ageCertification.contains("PG") ||
                                        ageCertification.contains("TV-G") ||
                                        ageCertification.contains("TV-PG") ||
                                        ageCertification.contains("TV-Y") ||
                                        ageCertification.contains("TV-Y7");

        if (typeCheck && genresCheck && productionCountriesCheck && seasonsCheck && ageCertificationCheck) {
            AVL newTree = new AVL();
            newTree.insert(node.data);

            if (left != null) {
                newTree.root.left = left.root;
            }

            if (right != null) {
                newTree.root.right = right.root;
            }

            return newTree;
        } else {
            if (left != null) {
                if (right != null) {
                    left.root.right = right.root;
                }
                return left;
            } else {
                return right;
            }
        }
    }

    public AVL stats2() {
        return stats2(this.root);
    }

    private AVL stats2(Node node) {
        if (node == null) {
            return null;
        }

        AVL left = stats2(node.getLeft());
        AVL right = stats2(node.getRight());

        ProgramaNetflix data = node.getData();
        String genres = Arrays.toString(data.getGenres());
        String ageCertification = data.getAgeCertification();

        Boolean genresCheck = genres.contains("documentation") && genres.contains("history");
        Boolean ageCertificationCheck = ageCertification.contains("R") ||
                ageCertification.contains("TV-MA") ||
                ageCertification.contains("NC-17");

        if (genresCheck && ageCertificationCheck) {
            AVL newTree = new AVL();
            newTree.insert(node.data);

            if (left != null) {
                newTree.root.left = left.root;
            }

            if (right != null) {
                newTree.root.right = right.root;
            }

            return newTree;
        } else {
            if (left != null) {
                if (right != null) {
                    left.root.right = right.root;
                }
                return left;
            } else {
                return right;
            }
        }
    }

    public AVL stats3() {
        System.out.print("Insira o IMDB Score para a pesquisa: ");
        Double imdbScore = s.nextDouble();
        return stats3(this.root, imdbScore);
    }

    private AVL stats3(Node node, Double imdbScore) {
        if (node == null) {
            return null;
        }

        AVL left = stats3(node.getLeft(), imdbScore);
        AVL right = stats3(node.getRight(), imdbScore);

        ProgramaNetflix data = node.getData();
        String productionCountries = Arrays.toString(data.getProductionCountries());

        Boolean typeCheck = data.getType().equals("MOVIE");
        Boolean productionCountriesCheck = !productionCountries.contains("US") &&
                                           !productionCountries.contains("UK") &&
                                           !productionCountries.contains("CA");
        Boolean imdbScoreCheck = data.getImdbScore() > imdbScore;

        if (typeCheck && productionCountriesCheck && imdbScoreCheck) {
            AVL newTree = new AVL();
            newTree.insert(node.data);

            if (left != null) {
                newTree.root.left = left.root;
            }

            if (right != null) {
                newTree.root.right = right.root;
            }

            return newTree;
        } else {
            if (left != null) {
                if (right != null) {
                    left.root.right = right.root;
                }
                return left;
            } else {
                return right;
            }
        }
    }

    public AVL stats5() {
        return stats5(this.root);
    }

    private AVL stats5(Node node) {
        if (node == null) {
            return null;
        }

        AVL left = stats5(node.getLeft());
        AVL right = stats5(node.getRight());

        ProgramaNetflix data = node.getData();

        Boolean typeCheck = data.getType().equals("MOVIE");
        Boolean runtimeCheck = data.getRuntime() > 180;
        Boolean imdbScoreCheck = data.getImdbScore() > 8;

        if (typeCheck && runtimeCheck && imdbScoreCheck) {
            AVL newTree = new AVL();
            newTree.insert(node.data);

            if (left != null) {
                newTree.root.left = left.root;
            }

            if (right != null) {
                newTree.root.right = right.root;
            }

            return newTree;
        } else {
            if (left != null) {
                if (right != null) {
                    left.root.right = right.root;
                }
                return left;
            } else {
                return right;
            }
        }
    }
}