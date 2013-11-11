import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

public class StackQueueDemo {

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		s.add("int");
		s.pop();

		ArrayList<String> d = new ArrayList<String>();

		d.add("One");
		d.add("Two");
		d.add("Three");
		d.add("Four");
		d.add("One");

		String s1 = "sahil";
		String s2 = "sahil";

		String a = "hi";
		String b = "hi";
		System.out.println(a.hashCode() + " " + b.hashCode());
		System.out.println((s1 == s2) + " s1=" + s1 + " s2=" + s2);

		for (Iterator<String> it = d.iterator(); it.hasNext();) {
			String str = it.next();
			if (StringUtils.equalsIgnoreCase(str, "one")) {
				it.remove();
			}
			System.out.println("With iterator:" + str);
		}

		for (String str : d) {
			System.out.println("After" + str);
		}
		System.out.println(d.toString());

	}

}
