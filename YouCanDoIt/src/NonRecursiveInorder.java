import java.util.Stack;

public class NonRecursiveInorder {

	public static void main(String[] args) {
		BinaryTreeNode n = BinaryTreeNode.Balanced15NodeTree;
		nonRecursiveInorder(n);
		// n.inorder(n);
	}

	static void nonRecursiveInorder(BinaryTreeNode n) {
		Stack s = new Stack<BinaryTreeNode>();

		if (n == null)
			return;
		s.push(n);
		BinaryTreeNode l = n.left;
		// BinaryTreeNode r=n.right;
		while (!s.empty()) {
			if (l != null) {
				s.push(l);
				l = l.left;
			} else {
				// poor lefty is null time to pop one out
				l = (BinaryTreeNode) s.pop();
				System.out.print(l.data + " ");
				l = l.right;
				if (s.isEmpty() && l != null) {
					s.push(l);
				}
			}
		}
	}

}
