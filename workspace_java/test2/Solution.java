public class Solution {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    System.out.println(l1.val);
    ListNode l2 = l1;
    l2.val = 2;
    System.out.println(l1.val);
    System.out.println(l2.val);
    l1.val = 4;
    System.out.println(l1.val);
    System.out.println(l2.val);

    l1.next = new ListNode(10);
    System.out.println(l1.next.val);
    System.out.println(l2.next.val);

    ListNode l3 = new ListNode(33);
    l1 = l3;
    System.out.println(l1.val);
    System.out.println(l2.val);

    System.out.println();
    System.out.println();
    System.out.println();

    ListNode l5 = new ListNode(5);
    l5.next = new ListNode(6);
    System.out.println(l5.val);
    System.out.println(l5.next.val);
    ListNode l6 = l5;
    System.out.println(l6.val);
    System.out.println(l6.next.val);
    l6 = l6.next;
    System.out.println(l6.val);
    System.out.println(l5.val);
    System.out.println(l5.next.val);

    System.out.println();
    System.out.println();
    System.out.println();

    ListNode l8 = new ListNode(8);
    ListNode l9 = l8;
    l9.next = new ListNode(9);
    System.out.println(l8.val);
    System.out.println(l8.next.val);
    System.out.println(l9.val);
    System.out.println(l9.next.val);

    System.out.println();
    System.out.println();
    System.out.println();

    l1 = new ListNode(1);
    l2 = l1;
    l2.next = new ListNode(2);
    System.out.println(l1.next.val);
  }
}

class ListNode {
  int val;
  ListNode next;
  public ListNode(int x) {
    val = x;
  }
}
