/**
 * Implementação de uma árvore binária.
 * 
 * @author André Matteucci - 32273541
 * @author Felipe Ribeiro  - 32212720
 * @author Enzo Koji       - 32273754
 *
 * @see Node
 * @see BST
 * @see AVL
*/

public class BinaryTree {
    protected Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

	public int getHeight() {
		if (isEmpty()) {
			return -1;
		}

		return root.getHeight();
	}

    public String inorderTraversal() {
		return inorderTraversal(root);
	}

	/**
	 * Percorre a árvore em ordem simétrica.
	 * 
	 * @param node nó de início do percurso
	 * @return     string com a expressão em ordem simétrica
	 */
	private String inorderTraversal(Node node) {
		if (node == null) {
			return "";
		}

		StringBuilder traversal = new StringBuilder();
		
		traversal.append(inorderTraversal(node.getLeft()));
		traversal.append(node.getData() + "\n\n");
		traversal.append(inorderTraversal(node.getRight()));
		
		return traversal.toString();
	}

	public String preorderTraversal() {
		return preorderTraversal(root);
	}

	/**
	 * Percorre a árvore em pré-ordem.
	 * 
	 * @param node nó de início do percurso
	 * @return     string com a expressão em pré-ordem
	 */
	private String preorderTraversal(Node node) {
		if (node == null) {
			return "";
		}

		StringBuilder traversal = new StringBuilder();
		
		traversal.append(node.getData() + "\n\n");
		traversal.append(preorderTraversal(node.getLeft()));
		traversal.append(preorderTraversal(node.getRight()));
		
		return traversal.toString();
	}

	public String postorderTraversal() {
		return postorderTraversal(root);
	}

	/**
	 * Percorre a árvore em pós-ordem.
	 * 
	 * @param node nó de início do percurso
	 * @return     string com a expressão em pós-ordem
	 */
	private String postorderTraversal(Node node) {
		if (node == null) {
			return "";
		}

		StringBuilder traversal = new StringBuilder();

		traversal.append(postorderTraversal(node.getLeft()));
		traversal.append(postorderTraversal(node.getRight()));
		traversal.append(node.getData() + "\n\n");
		
		return traversal.toString();
	}
}