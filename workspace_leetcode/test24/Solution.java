/**
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3284/
 * Happy Number
 * Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

*/

class Solution {
    private int getNext(int n) {
        int newInt = 0;
        
        int d = n % 10;
        newInt += d * d;
        n = n / 10;
        while (n != 0) {
            d = n % 10;
            newInt += d * d;
            n = n / 10;
        }
        
        return newInt;
    }
    
    public boolean isHappy(int n) {
        HashSet<Integer> history = new HashSet<Integer>();
        
        while (n != 1) {
            System.out.println(n);
            if (history.contains(n)) {
                // found loop
                return false;
            }
            
            history.add(n);
            n = getNext(n);
        }
        
        return true;
    }
}
