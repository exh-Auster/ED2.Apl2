/**
 * //TODO
 * 
 * @author André Matteucci - 32273541
 * @author Felipe Ribeiro  - 32212720
 * @author Enzo Koji       - 32273754
 * 
 * @see BinaryTree
*/

public class Node {
    protected String key; // TODO: key
    protected Node parent;
    protected Node left;
    protected Node right;
    protected int height;
    private int bf;
    protected ProgramaNetflix data;

    public Node() {
        this.key = ""; // TODO: key
        this.parent = null;
        this.left = null;
        this.right = null;
        this.bf = 0;
        this.data = null;
    }

//    public Node(Node parent) {
//        this.parent = parent;
//        this.left = null;
//        this.right = null;
//        this.bf = 0;
//        this.data = null;
//    }
//
//    public Node(Node left, Node right) {
//        this.parent = null;
//        this.left = left;
//        this.right = right;
//        this.data = null;
//    }
//
//    public Node(Node parent, Node left, Node right) {
//        this.parent = parent;
//        this.left = left;
//        this.right = right;
//        this.data = null;
//    }

    public Node(ProgramaNetflix data) {
        this.key = data.getId(); // TODO: key
        this.parent = null;
        this.left = null;
        this.right = null;
        this.bf = 0;
        this.data = data;
    }

    public Node(Node parent, ProgramaNetflix data) {
        this.key = data.getId(); // TODO: key
        this.parent = parent;
        this.left = null;
        this.right = null;
        this.bf = 0;
        this.data = data;
    }

    public Node(ProgramaNetflix data, int bf, Node parent, Node left, Node right) {
        this.key = data.getId(); // TODO: key
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.bf = bf;
        this.data = data;
    }

//    public Node(ProgramaNetflix data, Node left, Node right) {
//        this.key = data.getId(); // TODO: key
//        this.data = data;
//        this.left = left;
//        this.right = right;
//    }
    
    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setLeft(Node left) {
        this.left = left;
        left.setParent(this);
    }

    public void setRight(Node right) {
        this.right = right;
        right.setParent(this);
    }

    public void setData(ProgramaNetflix data) {
        this.key = data.getId(); // TODO: key
        this.data = data;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Node getParent() {
        return this.parent;
    }
    
    public Node getLeft() {
        return this.left;
    }
    
    public Node getRight() {
        return this.right;
    }

     public ProgramaNetflix getData() { //TODO
        return this.data;
    }

    public int getBf() {
        return bf;
    }

    public String getKey() {
        return key;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

	public int getDegree() {
		int degree = 0;

		if (hasLeft()) {
            ++degree;
        }

		if (hasRight()) {
            ++degree;
        }

		return degree;
	}

    public int getLevel() {
		if (isRoot()) {
			return 0;
		}

		return parent.getLevel() + 1;
	}

	public int getHeight() {
		if (isLeaf()) {
			return 0;
		}

        int height = 0;

		if (hasLeft())
			height = Math.max(height, left.getHeight());

		if (hasRight())
			height = Math.max(height, right.getHeight());

		return height + 1;
	}
}