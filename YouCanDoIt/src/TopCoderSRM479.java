import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopCoderSRM479 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> s = new Stack<String>();
		s.push("Yes");
		s.push("hello");

		LinkedList l = new LinkedList();
		ArrayDeque ad = new ArrayDeque();
		ad.add("blah obj 1");
		ad.add("blah obj 2");
		Queue q = new LinkedList();
		System.out.println(ad.toString());
		System.out.println(s.toString());
	}

	public int documentAccess(String[] records, String[] user, String[] room) {

		HashMap<String, ArrayList<String>> u = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<String>> r = new HashMap<String, ArrayList<String>>();
		int ans = 0;
		for (int i = 0; i < records.length; i++) {
			String[] splitStr = records[i].split(" ");
			if (!u.containsKey(splitStr[2])) {
				u.put(splitStr[2], new ArrayList<String>());
				u.get(splitStr[2]).add(splitStr[0]);
			} else
				u.get(splitStr[2]).add(splitStr[0]);
			;
			if (!r.containsKey(splitStr[1])) {
				r.put(splitStr[1], new ArrayList<String>());
				r.get(splitStr[1]).add(splitStr[0]);
			} else
				r.get(splitStr[1]).add(splitStr[0]);
			;

		}
		HashSet<String> ud = new HashSet<String>();
		for (int i = 0; i < user.length; i++) {
			ArrayList udocs = u.get(user[i]);
			if (udocs != null && !udocs.isEmpty())
				ud.addAll(udocs);
		}
		HashSet<String> rd = new HashSet<String>();
		for (int i = 0; i < room.length; i++) {
			ArrayList rdocs = r.get(room[i]);
			if (rdocs != null && !rdocs.isEmpty())
				rd.addAll(rdocs);
		}
		HashSet<String> third = new HashSet<String>();
		for (String s : ud) {
			if (rd.contains(s)) {
				third.add(s);
			}
		}
		return third.size();

	}

	String winner(int size0, int size1) {
		Stack<String> s = new Stack<String>();
		s.push("Yes");
		return s.push("hello");

	}
}
