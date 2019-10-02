/*
Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

public class Solution {

  public ListNode addTwoNumbersSample(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode result = new ListNode(0);
    ListNode track = result;
    while(l1 != null && l2 != null) {
	int sum = l1.val + l2.val + carry;
	carry = sum / 10;
	sum = sum % 10;
	track.next = new ListNode(sum);
	track = track.next;
	l1 = l1.next;
	l2 = l2.next;
    }
    while (l1 != null) {
	int sum = l1.val + carry;
	carry = sum / 10;
	sum = sum % 10;
	track.next = new ListNode(sum);
	track = track.next;
	l1 = l1.next;
    }
    while (l2 != null) {
	int sum = l2.val + carry;
	carry = sum / 10;
	sum = sum % 10;
	track.next = new ListNode(sum);
	track = track.next;
	l2 = l2.next;
    }
    if (carry == 1) {
	track.next = new ListNode(1);
    }
    return result.next;
  }
  
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null;

    ListNode ret = null;
    int n = 0;
    do {
      int sum = l1.val + l2.val + n;
      int d = sum%10;
      n = sum/10;

      if (ret == null) {
        ret = new ListNode(d);
        head = ret;
      } else {
        ret.next = new ListNode(d);
        ret = ret.next;
      }

      l1 = l1.next;
      l2 = l2.next;
    } while (l1 != null && l2 != null);

    while (l1 != null) {
      int sum = l1.val + n;
      int d = sum%10;
      n = sum/10;

      ret.next = new ListNode(d);
      ret = ret.next;
      l1 = l1.next;
    }

    while (l2 != null) {
      int sum = l2.val + n;
      int d = sum%10;
      n = sum/10;

      ret.next = new ListNode(d);
      ret = ret.next;
      l2 = l2.next;
    }

    if (n != 0) {
      ret.next = new ListNode(n);
    }

    return head;
  }

  public static void test(ListNode l1, ListNode l2, ListNode expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    ListNode ret = s.addTwoNumbers(l1, l2);
    // System.out.println(System.nanoTime() - ts);
    if (ret.equals(expected)) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret.toString());
    }
  }

  public static void main(String[] args) {
    // 342 + 465 = 807
    ListNode x1 = new ListNode(2);
    x1.next = new ListNode(4);
    x1.next.next = new ListNode(3);

    ListNode x2 = new ListNode(5);
    x2.next = new ListNode(6);
    x2.next.next = new ListNode(4);

    ListNode sum = new ListNode(7);
    sum.next = new ListNode(0);
    sum.next.next = new ListNode(8);

    test(x1, x2, sum);

    // 5 + 5 = 10
    x1 = new ListNode(5);
    x2 = new ListNode(5);
    sum = new ListNode(0);
    sum.next = new ListNode(1);

    test(x1, x2, sum);

    // 0 + 0 = 0
    x1 = new ListNode(0);
    x2 = new ListNode(0);
    sum = new ListNode(0);

    test(x1, x2, sum);

    // 999 + 9999 = 10998
    x1 = new ListNode(9);
    x1.next = new ListNode(9);
    x1.next.next = new ListNode(9);

    x2 = new ListNode(9);
    x2.next = new ListNode(9);
    x2.next.next = new ListNode(9);
    x2.next.next.next = new ListNode(9);

    sum = new ListNode(8);
    sum.next = new ListNode(9);
    sum.next.next = new ListNode(9);
    sum.next.next.next = new ListNode(0);
    sum.next.next.next.next = new ListNode(1);

    test(x1, x2, sum);
    test(x2, x1, sum);
  }
}

class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public String toString() {
    StringBuffer strBuf = new StringBuffer();

    ListNode cur = this;
    do {
      strBuf.insert(0, cur.val);
      cur = cur.next;
    } while(cur != null);

    return strBuf.toString();
  }

  public boolean equals(ListNode another) {
    return this.toString().equals(another.toString());
  }
}
