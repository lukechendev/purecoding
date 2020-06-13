/*
<Problem description>
*/

public class Solution {
  
  public int oddEvenJumps(int[] A) {
    int num = 0;

    List<Pair<Integer, Integer>> slist = new ArrayList<Pair<Integer, Integer>>(A.length);
    for (int i = 0; i < slist.size(); ++i) {
	slist.add(new Pair(A[i], i));
    }
    Collections.sort(slist);

    int last = A[A.length - 1];
    for (int i = 0; i < A.length; ++i) {
	int cur = A[i];
	if (cur == last) {
	    // for sure it is able to go to the end
	    num++;
	    continue;
	}
	
	int icur = slist.indexOf(cur);
	boolean stepOdd = true;
	while (true) {
	    if (cur == last) {
		// for sure it is able to go the end
		num++;
		break;
	    }
	    
	    int inext = icur + 1;
	    int iprev = icur - 1;
	    
	    // considering the equal values case
	    if (inext < slist.size() && slist.get(inext) == cur) {
		slist.remove(icur);
		stepOdd = !stepOdd;
		continue;
	    } else if (iprev >= 0 && slist.get(iprev) == cur) {
		slist.remove(icur);
		icur = iprev;
		stepOdd = !stepOdd;
		continue;
	    }
	    
	    if (stepOdd) {
		if (inext < slist.size()) {
		    // jump forward
		    cur = slist.get(inext);
		    slist.remove(icur);
		    stepOdd = !stepOdd;
		    continue;
		} else {
		    break;
		}
	    } else {
		if (iprev >= 0) {
		    // jump backward
		    cur = slist.get(iprev);
		    slist.remove(icur);
		    icur = iprev;
		    stepOdd = !stepOdd;
		    continue;
		} else {
		    break;
		}
	    }
	}
	
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
