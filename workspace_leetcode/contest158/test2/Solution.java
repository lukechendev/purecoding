/*
5223. Queens That Can Attack the King
User Accepted:0
User Tried:0
Total Accepted:0
Total Submissions:0
Difficulty:Medium
On an 8x8 chessboard, there can be multiple Black Queens and one White King.

Given an array of integer coordinates queens that represents the positions of the Black Queens, and a pair of coordinates king that represent the position of the White King, return the coordinates of all the queens (in any order) that can attack the King.

 

Example 1:



Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
Output: [[0,1],[1,0],[3,3]]
Explanation:  
The queen at [0,1] can attack the king cause they're in the same row. 
The queen at [1,0] can attack the king cause they're in the same column. 
The queen at [3,3] can attack the king cause they're in the same diagnal. 
The queen at [0,4] can't attack the king cause it's blocked by the queen at [0,1]. 
The queen at [4,0] can't attack the king cause it's blocked by the queen at [1,0]. 
The queen at [2,4] can't attack the king cause it's not in the same row/column/diagnal as the king.
Example 2:



Input: queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
Output: [[2,2],[3,4],[4,4]]
Example 3:



Input: queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
Output: [[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 

Constraints:

1 <= queens.length <= 63
queens[0].length == 2
0 <= queens[i][j] < 8
king.length == 2
0 <= king[0], king[1] < 8
At most one piece is allowed in a cell.
*/

import java.util.List;
import java.util.ArrayList;

public class Solution {
  
  // 1,2,3
  // 4,k,5
  // 6,7,8
  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();

    List<Integer> item1 = new ArrayList<Integer>();
    List<Integer> item2 = new ArrayList<Integer>();
    List<Integer> item3 = new ArrayList<Integer>();
    List<Integer> item4 = new ArrayList<Integer>();
    List<Integer> item5 = new ArrayList<Integer>();
    List<Integer> item6 = new ArrayList<Integer>();
    List<Integer> item7 = new ArrayList<Integer>();
    List<Integer> item8 = new ArrayList<Integer>();

    for (int i = 0; i < queens.length; ++i) {
      int qr = queens[i][0];
      int qc = queens[i][1];
      int kr = king[0];
      int kc = king[1];

      if (qr == kr) {
        if (qc < kc) {
          if (item4.size() == 0) {
            item4.add(qr);
            item4.add(qc);
          } else if (item4.get(1) < qc) {
            item4.set(0, qr);
            item4.set(1, qc);
          }
        } else {
          if (item5.size() == 0) {
            item5.add(qr);
            item5.add(qc);
          } else if (item5.get(1) > qc) {
            item5.set(0, qr);
            item5.set(1, qc);
          }
        }
      } else if (qc == kc) {
        if (qr < kr) {
          if (item2.size() == 0) {
            item2.add(qr);
            item2.add(qc);
          } else if (item2.get(0) < qr) {
            item2.set(0, qr);
            item2.set(1, qc);
          }
        } else {
          if (item7.size() == 0) {
            item7.add(qr);
            item7.add(qc);
          } else if (item7.get(0) > qr) {
            item7.set(0, qr);
            item7.set(1, qc);
          }
        }
      } else if (Math.abs(qr-kr) == Math.abs(qc-kc)) {
        if (qr < kr && qc < kc) {
          if (item1.size() == 0) {
            item1.add(qr);
            item1.add(qc);
          } else if (item1.get(0) < qr) {
            item1.set(0, qr);
            item1.set(1, qc);
          }
        } else if (qr < kr && qc > kc) {
          if (item3.size() == 0) {
            item3.add(qr);
            item3.add(qc);
          } else if (item3.get(0) < qr) {
            item3.set(0, qr);
            item3.set(1, qc);
          }
        } else if (qr > kr && qc < kc) {
          if (item6.size() == 0) {
            item6.add(qr);
            item6.add(qc);
          } else if (item6.get(0) > qr) {
            item6.set(0, qr);
            item6.set(1, qc);
          }
        } else if (qr > kr && qc > kc) {
          if (item8.size() == 0) {
            item8.add(qr);
            item8.add(qc);
          } else if (item8.get(0) > qr) {
            item8.set(0, qr);
            item8.set(1, qc);
          }
        }
      }
    }
    
    if (item1.size() > 0) {
      ret.add(item1);
    }
    if (item2.size() > 0) {
      ret.add(item2);
    }
    if (item3.size() > 0) {
      ret.add(item3);
    }
    if (item4.size() > 0) {
      ret.add(item4);
    }
    if (item5.size() > 0) {
      ret.add(item5);
    }
    if (item6.size() > 0) {
      ret.add(item6);
    }
    if (item7.size() > 0) {
      ret.add(item7);
    }
    if (item8.size() > 0) {
      ret.add(item8);
    }

    return ret;
  }

  public static void test(int[][] queens, int[] king, List<List<Integer>> expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    List<List<Integer>> ret = s.queensAttacktheKing(queens, king);
    // System.out.println(System.nanoTime() - ts);
    if (ret.equals(expected)) {
      System.out.println("Passed" + ret);
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    int[][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
    int[] king = {0,0};
    List<List<Integer>> expected = new ArrayList<List<Integer>>();
    List<Integer> item1 = new ArrayList<Integer>();
    item1.add(0);
    item1.add(1);
    expected.add(item1);
    List<Integer> item2 = new ArrayList<Integer>();
    item2.add(1);
    item2.add(0);
    expected.add(item2);
    List<Integer> item3 = new ArrayList<Integer>();
    item3.add(3);
    item3.add(3);
    expected.add(item3);
    test(queens, king, expected);

    int[][] queens2 = {{4,0},{0,4},{1,0},{0,1},{3,3},{2,4}};
    int[] king2 = {0,0};
    test(queens2, king2, expected);
  }
}
