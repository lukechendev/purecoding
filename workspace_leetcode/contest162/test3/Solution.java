/*
https://leetcode.com/contest/weekly-contest-162/problems/number-of-closed-islands/

(Unfinished)

1254. Number of Closed Islands
User Accepted:1358
User Tried:1602
Total Accepted:1377
Total Submissions:2494
Difficulty:Medium
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

 

Example 1:



Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 

Constraints:

1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1
*/

public class Solution {
  
  private boolean connectToGraph(List<List<List<Integer>>> g, List<Boolean> t, boolean isEdge, int[] nei, int[] origin) {
    boolean connected = false;
    
    int gsize = g.size();
    for (int i = 0; i < gsize; ++i) {
      List<List<Integer>> island = g.get(i);
      int lsize = island.size();
      for (int j = 0; j < lsize; ++j) {
        List<Integer> point = island.get(j);
        if (point.get(0) == nei[0] && point.get(1) == nei[1]) {
          // found it's neighbour in this island
          List<Integer> newP = new ArrayList<Integer>();
          newP.add(origin[0]);
          newP.add(origin[1]);
          island.add(newP);
          connected = true;
          break;
        }
      }
      
      if (connected && isEdge) {
        t.set(i, false);
      }
    }
    
    return connected;
  }
  
  public int closedIsland(int[][] grid) {
    int total = 0;
    
    List<Boolean> t = new ArrayList<Boolean>(); // Track if island i is closed
    List<List<List<Integer>>> g = new ArrayList<List<List<Integer>>>(); // List of n islands
    
    int n = grid.length;
    int m = grid[0].length;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        
        if (grid[i][j] == 1) {
          continue;
        }

        boolean isEdge = (i-1 < 0) || (j-1 < 0) || (i+1 >= n) || (j+1 >= m);
        
        // search if it belongs to any existing island
        boolean connected = false;
        // up
        int r = i - 1;
        int c = j;
        if (r >= 0) {
          connected = connectToGraph(g, t, isEdge, new int[]{r, c}, new int[]{i, j}) || connected;
        }
        
        // down
        r = i + 1;
        c = j;
        if (r < n) {
          connected = connectToGraph(g, t, isEdge, new int[]{r, c}, new int[]{i, j}) || connected;
        }
        
        // left
        r = i;
        c = j - 1;
        if (c >= 0) {
          connected = connectToGraph(g, t, isEdge, new int[]{r, c}, new int[]{i, j}) || connected;
        }
        
        // right
        r = i;
        c = j + 1;
        if (c < m) {
          connected = connectToGraph(g, t, isEdge, new int[]{r, c}, new int[]{i, j}) || connected;
        }
        
        if (!connected) {
          // A new island!
          List<List<Integer>> island = new ArrayList<List<Integer>>();
          List<Integer> p = new ArrayList<Integer>();
          p.add(i);
          p.add(j);
          island.add(p);
          g.add(island);
          
          t.add(!isEdge);
        }
        
      }
    }
    
    for (int i = 0; i < t.size(); ++i) {
      if (t.get(i).equals(true)) {
        total++;
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
