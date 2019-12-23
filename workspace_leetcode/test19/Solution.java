/*
<Problem description>
*/

import java.util.LinkedList;

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    public int numIslands2(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int numislands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]== '1'){
                    numislands += dfs(grid, i, j);
                }
            }
        }
        return numislands;
    }
    
    public int dfs(char[][] grid, int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j]=='0'){
            return 0;
        }
        grid[i][j] = '0';
        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid, i,j+1);
        dfs(grid, i,j-1);
        return 1;
        
    }

    public int numIslands(char[][] grid) {
        int nums = 0;
        
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        
        LinkedList<Point> queue = new LinkedList<Point>();
        int[][] visited = new int[m][n];
        int[][] queued = new int[m][n];
        
        Point nextStart = new Point(m, n);
        for (int i = 0; i < m; ++i) {
            boolean found = false;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    nextStart.x = i;
                    nextStart.y = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        
        while (nextStart.x < m && nextStart.y < n) {
            
            // find and mark the current island
            nums++;

            queue.add(new Point(nextStart.x, nextStart.y));
            queued[nextStart.x][nextStart.y] = 1;
            while (!queue.isEmpty()) {
                Point cur = queue.poll();
                visited[cur.x][cur.y] = 1;
                
                // check up
                int i = cur.x - 1;
                int j = cur.y;
                if (i >= 0) {
                    if (grid[i][j] == '1') {
                        if (visited[i][j] == 0 && queued[i][j] == 0) {
                            queue.add(new Point(i, j));
                            queued[i][j] = 1;
                        }
                    } else if (visited[i][j] == 0) {
                        visited[i][j] = 1;
                    }
                }
                // check down
                i = cur.x + 1;
                j = cur.y;
                if (i < m) {
                    if (grid[i][j] == '1') {
                        if (visited[i][j] == 0 && queued[i][j] == 0) {
                            queue.add(new Point(i, j));
                            queued[i][j] = 1;
                        }
                    } else if (visited[i][j] == 0) {
                        visited[i][j] = 1;
                    }
                }
                // check left
                i = cur.x;
                j = cur.y - 1;
                if (j >= 0) {
                    if (grid[i][j] == '1') {
                        if (visited[i][j] == 0 && queued[i][j] == 0) {
                            queue.add(new Point(i, j));
                            queued[i][j] = 1;
                        }
                    } else if (visited[i][j] == 0) {
                        visited[i][j] = 1;
                    }
                }
                // check right
                i = cur.x;
                j = cur.y + 1;
                if (j < n) {
                    if (grid[i][j] == '1') {
                        if (visited[i][j] == 0 && queued[i][j] == 0) {
                            queue.add(new Point(i, j));
                            queued[i][j] = 1;
                        }
                    } else if (visited[i][j] == 0) {
                        visited[i][j] = 1;
                    }
                }
            }
            
            // Move to the next (unvisited) start point
            boolean found = false;
            int i = nextStart.x;
            int j = nextStart.y + 1;
            for (; i < m; ++i) {
                while (j < n) {
                    if (visited[i][j] == 0) {
                        if (grid[i][j] == '1') {
                            found = true;
                            break;
                        } else {
                            visited[i][j] = 1;
                        }
                    }
                    j++;
                }
                if (found) {
                    break;
                }
                j = 0;
            }
            
            nextStart.x = i;
            nextStart.y = j;
        }

        return nums;
    }

    public static void test(char[][] grid, int expected) {
      Solution s = new Solution();
      // long ts = System.nanoTime();
      int ret = s.numIslands2(grid);
      // System.out.println(System.nanoTime() - ts);
      if (ret == expected) {
        System.out.println("Passed");
      } else {
        System.out.println("Failed: " + ret + " Expected: " + expected);
      }
    }

    public static void main(String[] args) {
      char[][] grid1 = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
      test(grid1, 1);

      char[][] grid2 = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
      test(grid2, 1);

      char[][] grid3 = {{'0'}};
      test(grid3, 0);

      char[][] grid4 = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
      test(grid4, 3);

      char[][] grid5 = {{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},{'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},{'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
      test(grid5, 1);
    }
}
