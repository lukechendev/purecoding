/*
Array of Products of All Elements Except Itself
*/

public class Solution {
  
   public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        left[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            left[i] = left[i-1] * nums[i-1];
        }
        
        right[nums.length-1] = 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            right[i] = right[i+1] * nums[i+1];
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            result[i] = left[i] * right[i];
        }
        
        return result;
    }

   public static int[] findProduct(int arr[]) {    
     int[] result = new int[arr.length];

     // write your code here
     long product = 1;
     int numZeros = 0;
     for (int i = 0; i < arr.length; ++i) {
	 if (arr[i] == 0) {
	     numZeros++;
	 } else {
	     product = product * arr[i];
	 }
     }

     if (numZeros > 1) {
	 return result;
     }

     for (int i = 0; i < arr.length; ++i) {
	 if (arr[i] == 0) {
	     result[i] = (int) product;
	 } else if (numZeros == 1) {
	     result[i] = 0;
	 } else {
	     result[i] = (int) (product/arr[i]);
	 }
      }

      return result; 
    } 

    public int resolve(String s) {
        return 0;
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
