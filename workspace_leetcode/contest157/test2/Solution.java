/*
5214. Longest Arithmetic Subsequence of Given Difference
User Accepted:0
User Tried:0
Total Accepted:0
Total Submissions:0
Difficulty:Medium
Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

 

Example 1:

Input: arr = [1,2,3,4], difference = 1
Output: 4
Explanation: The longest arithmetic subsequence is [1,2,3,4].
Example 2:

Input: arr = [1,3,5,7], difference = 1
Output: 1
Explanation: The longest arithmetic subsequence is any single element.
Example 3:

Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
Output: 4
Explanation: The longest arithmetic subsequence is [7,5,3,1].
 

Constraints:

1 <= arr.length <= 10^5
-10^4 <= arr[i], difference <= 10^4
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import java.util.Set;
import java.util.HashSet;

public class Solution {
  
  public int longestSubsequenceSample(int[] arr, int difference) {
      int[] res = new int[2*10001];
      for(int i =0;i<arr.length;i++){
	  int index =arr[i]+10000;
	  int prev = index- difference;
	  if(prev >= 0 && prev<res.length){
	      
	      res[index] = res[prev]+1;
	  }
	  else{
	      res[index]=1;
	  }
      }
      
      int max = Integer.MIN_VALUE;
      for(int n: res){
	  if(max<n){
	      max = n;
	  }
      }
      return max;
  }

  public int longestSubsequence4(int[] arr, int difference) {
    int max = 0;

    int[] buckets = new int[20001];

    for (int i = 0; i < arr.length; ++i) {
      int v = arr[i];

      if (buckets[v+10000] > 0) {
        continue;
      }

      buckets[v+10000]++;
      int steps = 1;
      for (int j = i + 1; j < arr.length; ++j) {
        if (arr[j] == v + difference) {
          steps++;
          v = arr[j];
          buckets[v+10000]++;
        }
      }

      if (max < steps) {
        max = steps;
      }
    }

    return max;
  }

  public int longestSubsequence3(int[] arr, int difference) {
    int max = 0;

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; ++i) {
      int v = arr[i];

      if (set.contains(v)) {
        continue;
      }

      set.add(v);
      int steps = 1;
      for (int j = i + 1; j < arr.length; ++j) {
        if (arr[j] == v + difference) {
          steps++;
          v = arr[j];
          set.add(v);
        }
      }

      if (max < steps) {
        max = steps;
      }
    }

    return max;
  }

  class Data {
    int val;
    List<Integer> index = new ArrayList<>();
  }
  
  public int longestSubsequence2(int[] arr, int difference) {
    int max = 0;

    Data[] buckets = new Data[20001];
    for (int i = arr.length - 1; i >= 0; --i) {
      if (buckets[arr[i]+10000] == null) {
        buckets[arr[i]+10000] = new Data();
      }
      buckets[arr[i]+10000].val++;
      buckets[arr[i]+10000].index.add(i);

      if (difference == 0) {
        if (max < buckets[arr[i]+10000].val) {
          max = buckets[arr[i]+10000].val;
        }
      } else {
        int steps = 0;
        int j = arr[i] + difference + 10000;
        int curIndex = i;
        while (j >= 0 && j < buckets.length && buckets[j] != null && buckets[j].val != 0 && buckets[j].index.get(0) > curIndex) {
          steps++;
          for (int m = buckets[j].index.size() - 1; m >= 0; --m) {
            if (buckets[j].index.get(m) > curIndex) {
              curIndex = buckets[j].index.get(m);
              break;
            }
          }
          j = j + difference;
        }
        if (steps > 0) {
          steps++;
        }

        if (max < steps) {
          max = steps;
        }
      }

      if (max == 0) {
        max = 1;
      }
    }

    return max;
  }

  public int longestSubsequence(int[] arr, int difference) {
    int max = 0;

    int[] buckets = new int[20001];
    for (int i = 0; i < arr.length; ++i) {
      buckets[arr[i] + 10000]++;
    }

    if (difference == 0) {
      for (int i = 0; i < arr.length; ++i) {
        if (max < buckets[arr[i] + 10000]) {
          max = buckets[arr[i] + 10000];
        }
      }
    } else {
      for (int i = 0; i < arr.length; ++i) {
        int steps = 0;
        int j = arr[i] + difference + 10000;
        while (j < buckets.length && buckets[j] != 0) {
          steps++;
          j = j + difference;
        }
        if (steps > 0) {
          steps++;
        }

        if (max < steps) {
          max = steps;
        }
        buckets[arr[i]+10000]--;
      }

      if (difference == 1 && max == 0) {
        max = 1;
      }
    }
    
    return max;
  }

  public static void test(int[] input, int diff, int expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    int ret = s.longestSubsequenceSample(input, diff);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  static int[] readData(String path) {
    Scanner scanner = null;
    try {
      scanner = new Scanner(new File(path));

      List<Integer> v = new ArrayList<Integer>();
      while (scanner.hasNextInt()) {
        v.add(scanner.nextInt());
      }

      return v.stream().mapToInt(i -> i).toArray();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (scanner != null) {
        scanner.close();
      }
    }

    return new int[0];
  }

  public static void main(String[] args) {
    int input[] = {1,2,3,4};
    test(input, 1, 4);

    int input2[] = {1,3,5,7};
    test(input2, 1, 1);

    int input3[] = {1,5,7,8,5,3,4,2,1};
    test(input3, -2, 4);

    int input4[] = {3,0,-3,4,-4,7,6};
    test(input4, 3, 2);

    int input5[] = {10,-11,8,-1,-14,-5,7,15,7,-2,14,5,-3,-9,12,-9};
    test(input5, -2, 2);

    int input6[] = {-12,-12,-10,-3,-8,-11,-7,3,12,3,7,4};
    test(input6, -11, 1);

    int input7[] = {-10,21,3,25,-8,-14,-18,19,-11,6,11,-3,1,21,11,-15,1,0,-14,9,-20,3,27,-24,-12,-2,23};
    test(input7, -3, 3);

    int input8[] = {-8,-14,-11,-14};
    test(input8, -3, 3);

    int input9[] = {-8,-11,-14,-11};
    test(input9, -3, 3);

    int input10[] = {-8,-14,-11,-14,-17,-14,-11};
    test(input10, -3, 4);

    int input11[] = readData("data");
    test(input11, -8645, 3);

    int input12[] = readData("data2");
    test(input12, 1, 9710);

    int input13[] = readData("data3");
    test(input13, -1960, 11);
  }
}
