/*
Reorder List

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

public class Solution {
  
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    ListNode l = head;
    int len = 0;
    do {
      len++;
    } while ((l = l.next) != null);

    // construct the array of the second half
    int firstHalf = len%2 == 0 ? len/2 : len/2+1;
    int secHalf = len - firstHalf;
    ListNode[] l2arr = new ListNode[secHalf];
    
    l = head;
    for (int i = 0; i < firstHalf; i++) {
      l = l.next;
    }

    int i = 0;
    do {
      l2arr[i++] = l;
    } while ((l = l.next) != null);

    // reorder the list
    l = head;
    int j = secHalf - 1;
    for (i = 0; i < firstHalf; i++) {
      ListNode t = l.next;
      if (l.next == l2arr[j]) {
        l.next.next = null;
        break;
      }
      l.next = l2arr[j--];
      l.next.next = t;
      l = l.next.next;

      if (j < 0) {
        l.next = null;
        break;
      }
    }
  }

  public static void test(ListNode input, ListNode expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    s.reorderList(input);
    // System.out.println(System.nanoTime() - ts);
    if ((input == null && expected == null) || input.equals(expected)) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + input);
    }
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(3);
    l1.next.next.next = new ListNode(4);
    l1.next.next.next.next = new ListNode(5);

    ListNode expected = new ListNode(1);
    expected.next = new ListNode(5);
    expected.next.next = new ListNode(2);
    expected.next.next.next = new ListNode(4);
    expected.next.next.next.next = new ListNode(3);
    test(l1, expected);


    l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(3);
    l1.next.next.next = new ListNode(4);
    l1.next.next.next.next = new ListNode(5);
    l1.next.next.next.next.next = new ListNode(6);

    expected = new ListNode(1);
    expected.next = new ListNode(6);
    expected.next.next = new ListNode(2);
    expected.next.next.next = new ListNode(5);
    expected.next.next.next.next = new ListNode(3);
    expected.next.next.next.next.next = new ListNode(4);
    test(l1, expected);

    l1 = new ListNode(1);
    expected = new ListNode(1);
    test(l1, expected);

    l1 = null;
    expected = null;
    test(l1, expected);
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }

  public String toString() {
    StringBuffer str = new StringBuffer();
    str.append(val);
    
    ListNode cur = this.next;
    while (cur != null) {
      str.append("->").append(cur.val);
      cur = cur.next;
    }

    return str.toString();
  }

  public boolean equals(ListNode another) {
    return this.toString().equals(another.toString());
  }
}
