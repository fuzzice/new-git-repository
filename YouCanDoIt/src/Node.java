import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {

	Node left, right;
	int data;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
	}

	public static void main(String[] args) {

		/*
		 * 4 3 5 1 2 6 7
		 */

		int[] inorder = { 1, 2, 3, 4, 5, 6, 7 };
		// List<Integer> i = Arrays.asList(inorder);
		List<Integer> i = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		int[] preorder = { 4, 3, 1, 2, 5, 6, 7 };
		// List p = Arrays.asList(preorder);
		List<Integer> p = Arrays.asList(4, 3, 1, 2, 5, 6, 7);
		int start = 0, end = inorder.length;
		// Node h = createTree(i, p);
		// h.inorder(h);

		Node n = createBinTree(inorder, 0, inorder.length - 1);
		n.inorder(n);

	}

	public static void inorder(Node n) {
		if (n == null)
			return;
		inorder(n.left);
		System.out.print(n.data + " ");
		inorder(n.right);
	}

	static Node createBinTree(int a[], int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node n = new Node(a[mid]);
		if (start == end)
			return n;
		n.left = createBinTree(a, start, mid - 1);
		n.right = createBinTree(a, mid + 1, end);
		return n;

	}

	static Node createTree(List i, List p) {

		// given a inorder and preorder, this tries to create a binary tree

		System.out.println("i= " + i.toString());
		System.out.println("p " + p.toString());
		if (i.size() != p.size())
			return null;
		if (i.size() == 0)
			return null;
		Node n = new Node(Integer.parseInt(p.get(0).toString()));
		int find = -1;
		for (int j = 0; j < i.size(); j++) {
			if (i.get(j).equals(p.get(0))) {
				find = j;
				break;
			}
		}
		System.out.println("find= " + find);

		if (find == 0)
			return n;
		List i2 = i.subList(0, find);
		List i3 = i.subList(find + 1, i.size());

		System.out.println("i2= " + i2.toString());
		System.out.println("i3 " + i3.toString());

		List p2 = null, p3 = null;
		p2 = new ArrayList<Integer>();
		p3 = new ArrayList<Integer>();

		for (int k = 0; k < i.size(); k++) {
			if (i2.contains(p.get(k))) {
				p2.add((p.get(k)));
			}
		}
		for (int k = 0; k < i.size(); k++) {
			if (i3.contains(p.get(k))) {
				p3.add((p.get(k)));
			}
		}
		System.out.println("p2= " + p2.toString());
		System.out.println("p3 " + p3.toString());

		n.left = createTree(i2, p2);
		n.right = createTree(i3, p3);
		return n;

	}
}
