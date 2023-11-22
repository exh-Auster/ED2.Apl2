public class BST extends BinaryTree {
    private int numOfComparisons;

    public BST() {
        super();
    }

    public BST(Node root) {
        super(root);
    }

    public int getNumOfComparisons() {
        return numOfComparisons;
    }

    public Node search(String id) {
        numOfComparisons = 0;
        return search(super.getRoot(), id);
    }

    private Node search(Node node, String id) {
        if (node == null) {
            return null;
        }

        int diff = id.compareToIgnoreCase(node.getData().getId());
        numOfComparisons++;

        if (diff < 0) {
            return search(node.getLeft(), id);
        }

        if (diff > 0) {
            return search(node.getRight(), id);
        }

        return node;
    }

    public void insert(ProgramaNetflix data) {
        super.setRoot(insert(super.getRoot(), null, data));
    }

    private Node insert(Node node, Node parent, ProgramaNetflix data) {
        if (node == null) {
            return new Node(parent, data);
        }

        int diff = data.getId().compareTo(node.getKey());

        if (diff < 0) {
            node.setLeft(insert(node.getLeft(), node, data));
        } else if (diff > 0) {
            node.setRight(insert(node.getRight(), node, data));
        } else {
            System.err.printf("Duplicatas não são permitidas nessa implementação - pulando a inserção de %s%n", data.getId());
        }

        return node;
    }

    public void remove(String id) {
        super.setRoot(remove(super.getRoot(), id));
    }

    private Node remove(Node node, String id) {
        if (node == null) {
            return null;
        }

        int diff = id.compareToIgnoreCase(node.getData().getId());

        if (diff < 0) {
            node.setLeft(remove(node.getLeft(), id));
        } else if (diff > 0) {
            node.setRight(remove(node.getRight(), id));
        } else {
            node = removeNode(node);
        }

        return node;
    }

    private Node removeNode(Node node) {
        if (node.isLeaf()) {
            return null;
        }

        if (!node.hasLeft()) {
            return node.getRight();
        }

        if (!node.hasRight()) {
            return node.getLeft();
        }

        Node predecessor = predecessor(node.getData().getId());
        node.setData(predecessor.getData());
        node.setLeft(remove(node.getLeft(), predecessor.getData().getId()));

        return node;
    }

    public Node findMin() {
        return findMin(super.getRoot());
    }

    private Node findMin(Node node) {
        if (node == null) {
            return null;
        }

        while (node.hasLeft()) {
            node = node.getLeft();
        }

        return node;
    }

    public Node findMax() {
        return findMax(super.getRoot());
    }

    private Node findMax(Node node) {
        if (node == null) {
            return null;
        }

        while (node.hasRight()) {
            node = node.getRight();
        }

        return node;
    }

    private Node predecessor(String id) {
        Node node = search(id);
        return node == null ? null : predecessor(node);
    }

    private Node predecessor(Node node) {
        if (node.hasLeft()) {
            return findMax(node.getLeft());
        }

        Node current = node;
        Node parent = node.getParent();

        while (parent != null && current == parent.getLeft()) {
            current = parent;
            parent = current.getParent();
        }

        return parent;
    }

    private Node successor(String id) {
        Node node = search(id);
        return node == null ? null : successor(node);
    }

    private Node successor(Node node) {
        if (node.hasRight()) {
            return findMin(node.getRight());
        }

        Node current = node;
        Node parent = node.getParent();

        while (parent != null && current == parent.getRight()) {
            current = parent;
            parent = current.getParent();
        }

        return parent;
    }
}