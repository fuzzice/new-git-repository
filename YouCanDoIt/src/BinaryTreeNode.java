import java.util.ArrayDeque;
import java.util.Stack;

public class BinaryTreeNode {
	int data;
	BinaryTreeNode left, right;
	boolean marker = false;

	static BinaryTreeNode Balanced7NodeTree = new BinaryTreeNode();
	static BinaryTreeNode Balanced3NodeTree = new BinaryTreeNode();
	static BinaryTreeNode Balanced15NodeTree = new BinaryTreeNode();
	static {
		Balanced7NodeTree.create();
		Balanced3NodeTree.create3NodesBalanced();
		Balanced15NodeTree.create15NodesBalanced();
		// Balanced15NodeTree.inorder(Balanced15NodeTree);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode b = new BinaryTreeNode();
		b.create();
		b.inorder(b);
		System.out.println("Zigzag print: ");
		b.zigzagPrint();
		System.out.println("Its like you're my mirror:");
		b.makeMirror(b);
		b.inorder(b);
		System.out.println("inorder ");

		System.out.println("levels:");
		// b.levelPrint();

		{
			String s = "abcdefg";
			for (int i = 0; i < s.length() / 2; i++) {
				char t = s.charAt(i);
			}
		}

	}

	private void create15NodesBalanced() {
		// TODO Auto-generated method stub

		// 1
		// 23
		// 4567
		// 89101112131415
		BinaryTreeNode h = this;
		h.data = 1;
		h.left = new BinaryTreeNode();
		h.left.data = 2;
		h.right = new BinaryTreeNode();
		h.right.data = 3;
		h.left.left = new BinaryTreeNode();
		h.left.left.data = 4;
		h.left.right = new BinaryTreeNode();
		h.left.right.data = 5;
		h.right.right = new BinaryTreeNode();
		h.right.right.data = 7;
		h.right.left = new BinaryTreeNode();
		h.right.left.data = 6;
		h.left.left.left = new BinaryTreeNode();
		h.left.left.left.data = 8;
		h.left.left.right = new BinaryTreeNode();
		h.left.left.right.data = 9;
		h.left.right.left = new BinaryTreeNode();
		h.left.right.left.data = 10;
		h.left.right.right = new BinaryTreeNode();
		h.left.right.right.data = 11;
		h.right.left.left = new BinaryTreeNode();
		h.right.left.left.data = 12;
		h.right.left.right = new BinaryTreeNode();
		h.right.left.right.data = 13;
		h.right.right.left = new BinaryTreeNode();
		h.right.right.left.data = 14;
		h.right.right.right = new BinaryTreeNode();
		h.right.right.right.data = 15;

	}

	private void create3NodesBalanced() {
		BinaryTreeNode h = this;
		h.data = 1;
		h.left = new BinaryTreeNode();
		h.left.data = 2;
		h.right = new BinaryTreeNode();
		h.right.data = 3;

	}

	public BinaryTreeNode() {
		data = -1;
		left = right = null;
	}

	void create() {
		BinaryTreeNode h = this;
		h.data = 1;
		h.left = new BinaryTreeNode();
		h.left.data = 2;
		h.right = new BinaryTreeNode();
		h.right.data = 3;
		h.left.left = new BinaryTreeNode();
		h.left.left.data = 4;
		h.left.right = new BinaryTreeNode();
		h.left.right.data = 5;
		h.right.right = new BinaryTreeNode();
		h.right.right.data = 7;
		h.right.left = new BinaryTreeNode();
		h.right.left.data = 6;

	}

	void levelPrint() {
		ArrayDeque<BinaryTreeNode> t1 = new ArrayDeque<BinaryTreeNode>();
		t1.add(this);
		BinaryTreeNode marker = new BinaryTreeNode();
		marker.marker = true;
		t1.add(marker);
		while (!t1.isEmpty()) {
			BinaryTreeNode t2 = t1.remove();

			if (t2.left != null)
				t1.add(t2.left);
			if (t2.right != null)
				t1.add(t2.right);
			if (t2.marker == true) {
				System.out.println();
				t1.add(marker);
			} else {
				System.out.print(t2.data + " ");

			}
		}

	}

	void zigzagPrint() {
		Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();
		s1.push(this);
		boolean flip = true;
		while (!s1.isEmpty()) {
			BinaryTreeNode t = s1.pop();
			System.out.print(t.data + " ");
			if (flip) {
				if (t.left != null)
					s2.push(t.left);
				if (t.right != null)
					s2.push(t.right);
			} else {
				if (t.right != null)
					s2.push(t.right);
				if (t.left != null)
					s2.push(t.left);

			}

			if (s1.isEmpty()) {
				Stack s3 = s1;
				s1 = s2;
				s2 = s3;
				flip = !flip;
			}
		}

	}

	void makeMirror(BinaryTreeNode b) {
		if (b == null)
			return;
		makeMirror(b.left);
		makeMirror(b.right);
		BinaryTreeNode t = b.left;
		b.left = b.right;
		b.right = t;
	}

	void inorder(BinaryTreeNode b) {
		if (b == null)
			return;
		inorder(b.left);
		System.out.print(b.data + " ");
		inorder(b.right);

	}

}
