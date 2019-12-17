/*
https://leetcode.com/contest/weekly-contest-162/problems/cells-with-odd-values-in-a-matrix/

1252. Cells with Odd Values in a Matrix

Difficulty:Easy
Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.

Return the number of cells with odd values in the matrix after applying the increment to all indices.

 

Example 1:


Input: n = 2, m = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
Example 2:


Input: n = 2, m = 2, indices = [[1,1],[0,0]]
Output: 0
Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.
 

Constraints:

1 <= n <= 50
1 <= m <= 50
1 <= indices.length <= 100
0 <= indices[i][0] < n
0 <= indices[i][1] < m
*/

public class Solution {
  
  public int oddCells(int n, int m, int[][] indices) {
    int[][] matrix = new int[n][m];
    for (int i = 0; i < indices.length; ++i) {
      // Update row
      for (int c = 0; c < m; ++c) {
        matrix[indices[i][0]][c]++;
      }
      // Update column
      for (int r = 0; r < n; ++r) {
        matrix[r][indices[i][1]]++;
      }
    }
    
    int total = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        int t = matrix[r][c];
        if (t%2 == 1) {
          total++;
        }
      }
    }
    
    return total;
  }

  public static void test(String input, int expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    int ret = s.resolve(input);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    test("", 0);
  }
}
