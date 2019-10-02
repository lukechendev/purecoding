/*
Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

public class Solution {
  
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = null;

    if (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        head = l1;
        l1 = l1.next;
      } else {
        head = l2;
        l2 = l2.next;
      }
    } else if (l1 != null) {
      head = l1;
      return head;
    } else if (l2 != null) {
      head = l2;
      return head;
    }

    ListNode r = head;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        r.next = l1; 
        l1 = l1.next;
      } else {
        r.next = l2;
        l2 = l2.next;
      }
      r = r.next;
    }

    while (l1 != null) {
      r.next = l1;
      l1 = l1.next;
      r = r.next;
    }

    while (l2 != null) {
      r.next = l2;
      l2 = l2.next;
      r = r.next;
    }

    return head;
  }

  public static void test(ListNode l1, ListNode l2, ListNode expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    ListNode ret = s.mergeTwoLists(l1, l2);
    // System.out.println(System.nanoTime() - ts);
    if ((ret == null && expected == null) || ret.equals(expected)) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret.toString());
    }
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);
    ListNode ex = new ListNode(1);
    ex.next = new ListNode(1);
    ex.next.next = new ListNode(2);
    ex.next.next.next = new ListNode(3);
    ex.next.next.next.next = new ListNode(4);
    ex.next.next.next.next.next = new ListNode(4);
    test(l1, l2, ex);

    l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    l2 = null;
    ex = new ListNode(1);
    ex.next = new ListNode(2);
    ex.next.next = new ListNode(4);
    test(l1, l2, ex);

    l2 = new ListNode(1);
    l2.next = new ListNode(2);
    l2.next.next = new ListNode(4);
    l1 = null;
    ex = new ListNode(1);
    ex.next = new ListNode(2);
    ex.next.next = new ListNode(4);
    test(l1, l2, ex);

    l1 = null;
    l2 = null;
    ex = null;
    test(l1, l2, ex);

    l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(7);
    ex = new ListNode(1);
    ex.next = new ListNode(2);
    ex.next.next = new ListNode(4);
    ex.next.next.next = new ListNode(5);
    ex.next.next.next.next = new ListNode(6);
    ex.next.next.next.next.next = new ListNode(7);
    test(l1, l2, ex);
  }
}

class ListNode {
  int val;
  ListNode next;
  public ListNode(int val) {
    this.val = val;
  }

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
