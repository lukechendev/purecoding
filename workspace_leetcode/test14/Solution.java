/*
Group Anagrams

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

public class Solution {
  
  int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
  public int hashStr(String str) {
      int hash = 1;
      for (char c: str.toCharArray()) {
	  hash *= primes[c - 'a'];
      }
      return hash;
  }
  
  public List<List<String>> groupAnagramsSample2(String[] strs) {
      List<List<String>> res = new ArrayList<List<String>>();
      Map<Integer, List<String>> map = new HashMap<>();
      for (String str: strs) {
	  int hash = hashStr(str);
	  List<String> list = map.get(hash);
	  if (list == null) {
	      list = new ArrayList<>();
	      map.put(hash, list);
	      res.add(list);
	  }
	  list.add(str);
      }
      return res;
  }

  public List<List<String>> groupAnagramsSample(String[] strs) {
    List<List<String>> anagrams = new ArrayList<List<String>>();
    if (strs.length==0) {
      return anagrams;
    }

    HashMap<String,Integer> hashMap = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] cur_chars = strs[i].toCharArray();
      Arrays.sort(cur_chars);
      String s = new String(cur_chars);
      if (!hashMap.containsKey(s)) {
        hashMap.put(s, hashMap.size());
        List<String> list = new ArrayList<>();
        list.add(strs[i]);
        anagrams.add(list);
      } else {
        anagrams.get(hashMap.get(s)).add(strs[i]);
      }
    }

    return anagrams;
  }

  public List<List<String>> groupAnagrams2(String[] strs) {
    List<List<String>> anagrams = new ArrayList<List<String>>();
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < strs.length; ++i) {
      char[] chars = strs[i].toCharArray();
      Arrays.sort(chars);
      String ts = new String(chars);
      if (!map.containsKey(ts)) {
        map.put(ts, map.size());

        List<String> item = new ArrayList<String>();
        item.add(strs[i]);
        anagrams.add(item);
      } else {
        anagrams.get(map.get(ts)).add(strs[i]);
      }
    }

    return anagrams;
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> ret = new ArrayList<List<String>>();

    int buckets[] = new int[strs.length];
    for (int i = 0; i < strs.length; ++i) {
      // Check if an existing anagram
      if (buckets[i] > 0) {
        continue;
      }

      List<String> item = new ArrayList<String>();
      String curi = strs[i];
      item.add(curi);
      buckets[i]++;

      final byte charbuckets[] = new byte[26];
      for (int n = 0; n < curi.length(); ++n) {
        charbuckets[curi.charAt(n)-'a']++;
      }

      for (int j = i + 1; j < strs.length; ++j) {
        // Check if an existing anagram
        if (buckets[j] > 0) {
          continue;
        }

        byte check[] = new byte[charbuckets.length];
        System.arraycopy(charbuckets, 0, check, 0, charbuckets.length);

        // Check if it's an anagram
        boolean isAnagram = true;
        String curj = strs[j];
        for (int n = 0; n < curj.length(); ++n) {
          check[curj.charAt(n)-'a']--;
          if (check[curj.charAt(n)-'a'] < 0) {
            isAnagram = false;
            break;
          }
        }

        if (isAnagram) {
          for (int n = 0; n < check.length; ++n) {
            if (check[n] != 0) {
              isAnagram = false;
              break;
            }
          }
        }

        if (isAnagram) {
          item.add(curj);
          buckets[j]++;
        }
      }
      ret.add(item);
    }
    
    return ret;
  }

  public static void test(String[] input, List<List<String>> expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    List<List<String>> ret = s.groupAnagramsSample2(input);
    // System.out.println(System.nanoTime() - ts);
    if (expected.toString().equals(ret.toString())) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
      System.out.println("Excepted: " + expected);
    }
  }

  public static void main(String[] args) {
    String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> expected = new ArrayList<List<String>>();
    List<String> item1 = new ArrayList<String>();
    item1.add("ate");
    item1.add("eat");
    item1.add("tea");
    expected.add(item1);
    List<String> item2 = new ArrayList<String>();
    item2.add("nat");
    item2.add("tan");
    expected.add(item2);
    List<String> item3 = new ArrayList<String>();
    item3.add("bat");
    expected.add(item3);
    test(input, expected);

    String[] input2 = {"tea","","eat","","tea",""};
    expected = new ArrayList<List<String>>();
    item1 = new ArrayList<String>();
    item1.add("eat");
    item1.add("tea");
    item1.add("tea");
    expected.add(item1);
    item2 = new ArrayList<String>();
    item2.add("");
    item2.add("");
    item2.add("");
    expected.add(item2);
    test(input2, expected);

    String[] input3 = {};
    expected = new ArrayList<List<String>>();
    item1 = new ArrayList<String>();
    test(input3, expected);

    String[] input4 = {"","",""};
    expected = new ArrayList<List<String>>();
    item1 = new ArrayList<String>();
    item1.add("");
    item1.add("");
    item1.add("");
    expected.add(item1);
    test(input4, expected);

    String[] input5 = {"teaate","eat","tea"};
    expected = new ArrayList<List<String>>();
    item1 = new ArrayList<String>();
    item1.add("teaate");
    expected.add(item1);
    item2 = new ArrayList<String>();
    item2.add("eat");
    item2.add("tea");
    expected.add(item2);
    test(input5, expected);
  }
}
