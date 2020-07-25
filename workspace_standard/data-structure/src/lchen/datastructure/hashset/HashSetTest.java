package lchen.datastructure.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set<Node> set = new HashSet<Node>();
		set.add(new Node(1, 2));
		set.add(new Node(2, 1));
		set.add(new Node(3, 3));

		System.out.println(set.contains(new Node(1, 2)));
		System.out.println(set.contains(new Node(2, 1)));
		System.out.println(set.contains(new Node(3, 3)));
		System.out.println(set.contains(new Node(2, 2)));
	}

	private static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			return (obj instanceof Node) && ((Node) obj).x == this.x && ((Node) obj).y == this.y;
		}

		@Override
		public int hashCode() {
			return x * 31 + y;
		}
	}
}