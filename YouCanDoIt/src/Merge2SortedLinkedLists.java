import java.util.Arrays;

public class Merge2SortedLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedListNode a = new LinkedListNode();
		LinkedListNode b = new LinkedListNode();
		b.createLinkedListAsHead(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15));
		a.printFromCurrent();
		b.printFromCurrent();
		LinkedListNode c = merge2LinkedLists(a, b);

		c.printFromCurrent();
	}

	private static LinkedListNode merge2LinkedLists(LinkedListNode a,
			LinkedListNode b) {
		LinkedListNode head = null;
		LinkedListNode c = null, d = null;
		if (head == null) {
			if (a.getData() < b.getData()) {
				head = a;
				c = head;
				// a=a.next;
				d = b;
			} else {
				head = b;
				c = head;
				// b=b.next;
				d = a;
			}
		}

		while (c != null && d != null) {

			if (c.next != null && c.next.data >= d.data) {
				// make link and swap c and d
				LinkedListNode t = c.next;
				c.next = d;
				c = d;
				d = t;
			} else if (c.next != null && c.next.data < d.data)
				c = c.next;
			else if (c.next == null) {
				c.next = d;
				break;

			}

		}

		/*
		 * 2 4 6 8 1 1.5 3 5 7 9 11 13
		 */
		return head;
	}

}
