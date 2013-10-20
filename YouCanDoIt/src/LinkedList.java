public class LinkedList {

	LinkedList next;
	private int data;

	LinkedList(int d) {
		data = d;
	}

	public LinkedList() {
		// TODO Auto-generated constructor stub
	}

	void print() {
		System.out.print(data + " ");
	}

	void printFromCurrent() {
		LinkedList t = this;
		System.out.println();
		while (t != null) {
			t.print();
			t = t.next;
		}
	}

	void insert(LinkedList head, int d) {
		LinkedList n = new LinkedList();
		n.data = d;
		if (head == null) {
			head = n;
			return;
		}

		LinkedList t = head;
		while (t.next != null) {
			t = t.next;

		}
		t.next = n;
	}

	LinkedList reverse() {
		LinkedList head = this;
		if (head == null)
			return null;
		LinkedList current = head;
		LinkedList prev = null;
		LinkedList next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}

	// wrong!! SAHIL, how could you write the following code?
	LinkedList reverse2() {
		LinkedList current = this;
		LinkedList prev = null, next = current.next;
		while (current != null) {
			current.next = prev;
			prev = current;
			current = next;
			next = next.next;

		}
		return current;
	}

	LinkedList delete(int val) {
		LinkedList current = this;
		while (current.data == val) {
			current.next = current.next.next;
			System.out.println("skipping head");
		}
		if (current == null)
			return null;
		while (current.next != null) {
			if (current.next.data == val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}

		}

		return this;
	}

	void changeMe(int f, LinkedList node) {
		node.data = f;
	}

	public static void main(String[] args) {
		LinkedList head = new LinkedList(1);
		head.insert(head, 5);
		head.insert(head, 2);
		head.insert(head, 3);
		head.insert(head, 4);
		head.insert(head, 5);
		head.insert(head, 5);
		head.insert(head, 6);
		head.insert(head, 5);
		head.printFromCurrent();

		// head = head.delete(5);
		// head.printFromCurrent();
		// head.printFromCurrent();
		// head = head.reverse();
		// head.print();
		// head.printFromCurrent();

		// head = reversePairs(head);
		// head.printFromCurrent();

	}

	private static LinkedList reversePairs(LinkedList current) {
		LinkedList ret = null;
		if (current != null && current.next != null) {
			ret = current.next;
		}
		System.out.println();
		LinkedList second = current.next;
		while (current != null && current.next != null) {
			LinkedList t = current.next;
			LinkedList t2 = t.next;
			t.next = current;
			current.next = t2;
			current = current.next;
			current.print();
		}
		return ret;
	}

}
