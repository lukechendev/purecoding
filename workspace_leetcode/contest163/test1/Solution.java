/*
https://leetcode.com/contest/weekly-contest-163/problems/shift-2d-grid/

5263. Shift 2D Grid
Difficulty:Easy
Given a 2D grid of size n * m and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] becomes at grid[i][j + 1].
Element at grid[i][m - 1] becomes at grid[i + 1][0].
Element at grid[n - 1][m - 1] becomes at grid[0][0].
Return the 2D grid after applying shift operation k times.

 

Example 1:


Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]
Example 2:


Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]
 

Constraints:

1 <= grid.length <= 50
1 <= grid[i].length <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100

*/

public class Solution {
  
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    
    int n = grid.length;
    int m = grid[0].length;
    
    while (k-- > 0) {
      int[][] t = new int[n][m];
      
      for (int i = 1; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          t[j][i] = grid[j][i-1];
        }
      }
      
      for (int j = 1; j < n; ++j) {
        t[j][0] = grid[j-1][m-1];
      }
      
      t[0][0] = grid[n-1][m-1];
      
      grid = t;
    }
    
    for (int i = 0; i < n; ++i) {
      List<Integer> row = new ArrayList<Integer>();
      for (int j = 0; j < m; ++j) {
        row.add(grid[i][j]);
      }
      ret.add(row);
    }
    
    return ret;
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
