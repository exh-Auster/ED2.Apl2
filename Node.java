/**
 * Implementação de um nó para uso em uma árvore binária, BST e AVL.
 * 
 * @author André Matteucci - 32273541
 * @author Felipe Ribeiro  - 32212720
 * @author Enzo Koji       - 32273754
 * 
 * @see BinaryTree
 * @see BST
 * @see AVL
*/

public class Node {
    protected String key;
    protected Node parent;
    protected Node left;
    protected Node right;
    protected int height;
    protected ProgramaNetflix data;

    public Node() {
        this.key = "";
        this.parent = null;
        this.left = null;
        this.right = null;
        this.data = null;
    }

    public Node(ProgramaNetflix data) {
        this.key = data.getId();
        this.parent = null;
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public Node(Node parent, ProgramaNetflix data) {
        this.key = data.getId();
        this.parent = parent;
        this.left = null;
        this.right = null;
        this.data = data;
    }
    
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
        this.key = data.getId();
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

     public ProgramaNetflix getData() {
        return this.data;
    }

    public String getKey() {
        return key;
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