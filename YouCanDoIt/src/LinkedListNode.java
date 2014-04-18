import java.util.List;

public class LinkedListNode {

	LinkedListNode next;
	int data;

	LinkedListNode(int d) {
		data = d;
	}

	public LinkedListNode() {
		// TODO Auto-generated constructor stub
	}

	void print() {
		System.out.print(data + " ");
	}

	void printFromCurrent() {
		LinkedListNode t = this;
		System.out.println();
		while (t != null) {
			t.print();
			t = t.next;
		}
	}

	void insert(LinkedListNode head, int d) {
		LinkedListNode n = new LinkedListNode();
		n.data = d;
		if (head == null) {
			head = n;
			return;
		}

		LinkedListNode t = head;
		while (t.next != null) {
			t = t.next;

		}
		t.next = n;
	}

	LinkedListNode reverse() {
		LinkedListNode head = this;
		if (head == null)
			return null;
		LinkedListNode current = head;
		LinkedListNode prev = null;
		LinkedListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}

	// wrong!! SAHIL, how could you write the following code?
	LinkedListNode reverse2() {
		LinkedListNode current = this;
		LinkedListNode prev = null, next = current.next;
		while (current != null) {
			current.next = prev;
			prev = current;
			current = next;
			next = next.next;

		}
		return current;
	}

	LinkedListNode delete(int val) {
		// delete a node at the head
		LinkedListNode current = this;
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

	void changeMe(int f, LinkedListNode node) {
		node.data = f;
	}

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(1);
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

	private static LinkedListNode reversePairs(LinkedListNode current) {
		LinkedListNode ret = null;
		if (current != null && current.next != null) {
			ret = current.next;
		}
		System.out.println();
		LinkedListNode second = current.next;
		while (current != null && current.next != null) {
			LinkedListNode t = current.next;
			LinkedListNode t2 = t.next;
			t.next = current;
			current.next = t2;
			current = current.next;
			current.print();
		}
		return ret;
	}

	public void createLinkedListAsHead(List<Integer> asList) {
		LinkedListNode h=this;
		for(int i=0;i<asList.size();i++){
			if(i==0)
				h.data=asList.get(i);
			else{
				LinkedListNode n=new LinkedListNode(asList.get(i));
				h.next=n;
				h=n;
			}
		}
	}

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}


}
