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
		System.out.println(data);
	}

	void printFromCurrent() {
		LinkedList t = this;
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

	void changeMe(int f, LinkedList node) {
		node.data = f;
	}

	public static void main(String[] args) {
		LinkedList head = new LinkedList(1);
		head.insert(head, 2);
		head.insert(head, 3);
		head.insert(head, 4);
		head.insert(head, 5);
		head.insert(head, 6);
		// head.printFromCurrent();
		head = head.reverse();
		// head.print();
		head.printFromCurrent();

		LinkedList node = new LinkedList(100);
		node.print();
		node.changeMe(34, node);
		node.print();

	}

}
