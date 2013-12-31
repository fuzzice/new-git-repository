import java.util.Stack;

public class IterativeInorder {

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeNode.Balanced15NodeTree;
		inorder(root);
	}

	static void iterativeInorder(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		if (root == null)
			return;
		s.push(root);
		BinaryTreeNode current = root.left;
		while (!s.empty()) {

		}
	}

	static void inorder(BinaryTreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

}
