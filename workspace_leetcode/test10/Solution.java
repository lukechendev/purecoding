/*
  Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

 

Example 1:



Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 

Note:

You must return the copy of the given head as a reference to the cloned list.
*/

public class Solution {
  
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }

    Node res = head;

    Node copyHead = new Node();
    Node copy = copyHead;

    // Copy the linked list
    copy.val = res.val;
    while (res.next != null) {
      copy.next = new Node();
      res = res.next;
      copy = copy.next;
      copy.val = res.val;
    }

    res = head;
    copy = copyHead;
    do {
      if (res.random != null) {
        int i = 0;
        Node inode = head;
        do {
          i++;
          if (inode == res.random) {
            break;
          }
        } while ((inode = inode.next) != null);

        Node icopy = copyHead;
        for (int j = i - 1; j > 0; j--) {
          icopy = icopy.next;
        }

        copy.random = icopy;
      }
    } while ((res = res.next) != null && (copy = copy.next) != null);
    
    return copyHead;
  }

  public static void test(Node input) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    Node ret = s.copyRandomList(input);
    // System.out.println(System.nanoTime() - ts);
    
    if (input != ret && 
      input.val == ret.val &&
      input.next != ret.next &&
      input.random != ret.random &&
      input.next.val == ret.next.val &&
      input.next.next == ret.next.next &&
      input.next.random != ret.next.random ) {

      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    Node input = new Node();
    input.val = 1;
    input.next = new Node();
    input.next.val = 2;
    input.next.next = null;
    input.next.random = input.next;
    input.random = input.next;

    test(input);
  }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
