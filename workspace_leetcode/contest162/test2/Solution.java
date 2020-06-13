/*
https://leetcode.com/contest/weekly-contest-162/problems/reconstruct-a-2-row-binary-matrix/

1253. Reconstruct a 2-Row Binary Matrix
Difficulty:Medium
Given the following details of a matrix with n columns and 2 rows :

The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.
The sum of elements of the 0-th(upper) row is given as upper.
The sum of elements of the 1-st(lower) row is given as lower.
The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum is given as an integer array with length n.
Your task is to reconstruct the matrix with upper, lower and colsum.

Return it as a 2-D integer array.

If there are more than one valid solution, any of them will be accepted.

If no valid solution exists, return an empty 2-D array.

 

Example 1:

Input: upper = 2, lower = 1, colsum = [1,1,1]
Output: [[1,1,0],[0,0,1]]
Explanation: [[1,0,1],[0,1,0]], and [[0,1,1],[1,0,0]] are also correct answers.
Example 2:

Input: upper = 2, lower = 3, colsum = [2,2,1,1]
Output: []
Example 3:

Input: upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
Output: [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 

Constraints:

1 <= colsum.length <= 10^5
0 <= upper, lower <= colsum.length
0 <= colsum[i] <= 2
*/

public class Solution {
  
  public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();

    int[][] arr = new int[2][colsum.length];
    int utotal = 0;
    int ltotal = 0;
    for (int i = 0; i < colsum.length; ++i) {
      if (colsum[i] == 0) {
        continue;
      }
      
      if (colsum[i] == 2) {
        arr[0][i] = 1;
        arr[1][i] = 1;
        utotal++;
        ltotal++;
        
        if (utotal > upper || ltotal > lower) {
          return ret;
        }
      }
    }
    
    for (int i = 0; i < colsum.length; ++i) {
      if (colsum[i] == 1) {
        // try upper first
        if (utotal < upper) {
          arr[0][i] = 1;
          utotal++;
        } else if (ltotal < lower) {
          arr[1][i] = 1;
          ltotal++;
        } else {
          return ret;
        }
      }
    }
    
    if (utotal != upper || ltotal != lower) {
      return ret;
    }
    
    for (int i = 0; i < 2; ++i) {
      List<Integer> row = new ArrayList<Integer>();
      for (int j = 0; j < colsum.length; ++j) {
        row.add(arr[i][j]);
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
