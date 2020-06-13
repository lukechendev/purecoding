/*
1310. XOR Queries of a Subarray

User Accepted:2485
User Tried:3021
Total Accepted:2529
Total Submissions:4473
Difficulty:Medium
Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri], for each query i compute the XOR of elements from Li to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ). Return an array containing the result for the given queries.
 

Example 1:

Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8] 
Explanation: 
The binary representation of the elements in the array are:
1 = 0001 
3 = 0011 
4 = 0100 
8 = 1000 
The XOR values for queries are:
[0,1] = 1 xor 3 = 2 
[1,2] = 3 xor 4 = 7 
[0,3] = 1 xor 3 xor 4 xor 8 = 14 
[3,3] = 8
Example 2:

Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
Output: [8,0,4,4]
 

Constraints:

1 <= arr.length <= 3 * 10^4
1 <= arr[i] <= 10^9
1 <= queries.length <= 3 * 10^4
queries[i].length == 2
0 <= queries[i][0] <= queries[i][1] < arr.length
*/

public class Solution {
  
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ret = new int[queries.length];
        
        if (arr.length == 1) {
            for (int i = 0; i < ret.length; ++i) {
                ret[i] = arr[0];
            }
            
            return ret;
        }
        
        // build left XOR, right XOR and total XOR talbes
        int[] lXor = new int[arr.length];
        lXor[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            lXor[i] = lXor[i-1]^arr[i];
        }
        
        int[] rXor = new int[arr.length];
        rXor[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; --i) {
            rXor[i] = rXor[i+1]^arr[i];
        }
        
        int tXor = lXor[lXor.length-1];
        
        // answer queries
        for (int i = 0; i < queries.length; ++i) {
            int start = queries[i][0];
            int end = queries[i][1];
            
            int value = tXor;
            if (start > 0) {
                value = value^lXor[start-1];
            }
            if (end < arr.length-1) {
                value = value^rXor[end+1];
            }
            ret[i] = value;
        }
        
        return ret;
    }

    public static void test(String input, int expected) {
        Solution s = new Solution();
        // long ts = System.nanoTime();
        int ret = s.resolve(input);
        // System.out.println(System.nanoTime() - ts);
        System.out.println("Result: \n" + ret);
        if (ret == expected) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed - Expected: \n" + expected);
        }
        System.out.println("=============================================");
    }

    public static void main(String[] args) {
        test("", 0);
    }
}
