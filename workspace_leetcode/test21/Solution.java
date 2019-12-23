/*
562. Longest Line of Consecutive One in Matrix

Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
Example:
Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3
Hint: The number of elements in the given matrix will not exceed 10,000.

*/

public class Solution {

    public int longestLine(int[][] M) {
        int m = M.length;
        
        if (m == 0) {
            return 0;
        }
        
        int n = M[0].length;
        
        // 0: curMax; 1: max
        int[][] mArr = new int[m][2];
        int[][] nArr = new int[n][2];
        int[][] diagArr = new int[m+n-1][2];
        int[][] adiagArr = new int[m+n-1][2];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (M[i][j] == 1) {
                    mArr[i][0]++;
                    nArr[j][0]++;
                    diagArr[((m-1)-i)+j][0]++;
                    adiagArr[j+i][0]++;
                } else {
                    if (mArr[i][1] < mArr[i][0]) {
                        mArr[i][1] = mArr[i][0];
                    }
                    mArr[i][0] = 0;
                    
                    if (nArr[j][1] < nArr[j][0]) {
                        nArr[j][1] = nArr[j][0];
                    }
                    nArr[j][0] = 0;
                    
                    
                    if (diagArr[((m-1)-i)+j][1] < diagArr[((m-1)-i)+j][0]) {
                        diagArr[((m-1)-i)+j][1] = diagArr[((m-1)-i)+j][0];
                    }
                    diagArr[((m-1)-i)+j][0] = 0;
                    
                    
                    if (adiagArr[j+i][1] < adiagArr[j+i][0]) {
                        adiagArr[j+i][1] = adiagArr[j+i][0];
                    }
                    adiagArr[j+i][0] = 0;
                }
            }
        }
        
        int numMax = 0;
        for (int i = 0; i < mArr.length; ++i) {
            if (numMax < mArr[i][1]) {
                numMax = mArr[i][1];
            }
            if (numMax < mArr[i][0]) {
                numMax = mArr[i][0];
            }
        }
        for (int i = 0; i < nArr.length; ++i) {
            if (numMax < nArr[i][1]) {
                numMax = nArr[i][1];
            }
            if (numMax < nArr[i][0]) {
                numMax = nArr[i][0];
            }
        }
        for (int i = 0; i < diagArr.length; ++i) {
            if (numMax < diagArr[i][1]) {
                numMax = diagArr[i][1];
            }
            if (numMax < diagArr[i][0]) {
                numMax = diagArr[i][0];
            }
        }
        for (int i = 0; i < adiagArr.length; ++i) {
            if (numMax < adiagArr[i][1]) {
                numMax = adiagArr[i][1];
            }
            if (numMax < adiagArr[i][0]) {
                numMax = adiagArr[i][0];
            }
        }
        
        return numMax;
    }
  
    public static void test(int[][] M, int expected) {
        Solution s = new Solution();
        // long ts = System.nanoTime();
        int ret = s.longestLine(M);
        // System.out.println(System.nanoTime() - ts);
        if (ret == expected) {
            System.out.println("Passed");
        } else {
            System.out.println("Expected: " + expected + " Failed: " + ret);
        }
    }

    public static void main(String[] args) {
        int[][] M1 = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};
        test(M1, 3);

        int[][] M2 = {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        test(M2, 3);
    }
}
