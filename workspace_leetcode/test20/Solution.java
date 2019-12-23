/*
Odd Even Jump
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.TreeMap;

public class Solution {

    public int oddEvenJumps3(int[] A) {
        int N = A.length;
        if (N <= 1) return N;
        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];
        odd[N-1] = even[N-1] = true;

        TreeMap<Integer, Integer> vals = new TreeMap<Integer, Integer>();
        vals.put(A[N-1], N-1);
        for (int i = N-2; i >= 0; --i) {
            int v = A[i];
            if (vals.containsKey(v)) {
                odd[i] = even[vals.get(v)];
                even[i] = odd[vals.get(v)];
            } else {
                Integer lower = vals.lowerKey(v);
                Integer higher = vals.higherKey(v);

                if (lower != null)
                    even[i] = odd[vals.get(lower)];
                if (higher != null) {
                    odd[i] = even[vals.get(higher)];
                }
            }
            vals.put(v, i);
        }

        int ans = 0;
        for (boolean b: odd)
            if (b) ans++;
        return ans;
    }

    private void printList(List<Item> l) {
        System.out.println();
        System.out.print("[");
        Iterator<Item> i = l.iterator();
        while (i.hasNext()) {
            Item p = i.next();
            System.out.print("[" + p.val + "," + p.index + "," + p.valid + "],");
        }
        System.out.print("]");
        System.out.println();
    }

    private List<Item> copy(List<Item> l) {
        List<Item> r = new ArrayList<Item>();

        Iterator<Item> i = l.iterator();
        while (i.hasNext()) {
            Item c = i.next();
            r.add(new Item(c.val, c.index, c.valid));
        }

        return r;
    }

    public int oddEvenJumps2(int[] A) {
        int num = 0;

        TreeSet<Item> tset = new TreeSet<Item>(new Comparator<Item>() {
            @Override
            public int compare(final Item p1, final Item p2) {
                if (p1.val < p2.val) {
                    return -1;
                } else if (p1.val > p2.val) {
                    return 1;
                } else {
                    if (p1.index == p2.index) {
                        return 0;
                    } else if (p1.index > p2.index) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        for (int i = 0; i < A.length; ++i) {
            tset.add(new Item(A[i], i));
        }
boolean a = false;

        int last = A[A.length - 1];
        for (int i = 0; i < A.length; ++i) {
            Item curItem = new Item(A[i], i);
            Item nextItem = curItem;

System.out.println("curItem: " + curItem);

            boolean isOdd = true;
            while (nextItem != null && nextItem.val != last) {
                if (isOdd) {
		    do {
System.out.println("nextItem odd: " + nextItem);
System.out.println("tset odd: " + tset);
			nextItem = tset.higher(nextItem);
System.out.println("nextItem odd: " + nextItem);
if (a) {
return num;
}
                        if (nextItem == null || nextItem.val == last) {
                           break;
                        }
		    } while (nextItem.index < curItem.index);

		    if (nextItem == null) {
			break;
		    }
                } else {
                    do {
System.out.println("nextItem even: " + nextItem);
System.out.println("tset even: " + tset);
                        nextItem = tset.lower(nextItem);
System.out.println("nextItem even: " + nextItem);
                        if (nextItem == null || nextItem.val == last) {
                            break;
                        }
                    } while (nextItem.index < curItem.index);
                }
                isOdd = !isOdd;
            }

            if (nextItem != null && nextItem.val == last) {
                num++;
            }
        }

        return num; 
    }
  
    public int oddEvenJumps(int[] A) {
        int num = 0;
        
        List<Item> slist = new ArrayList<Item>(A.length);
        for (int i = 0; i < A.length; ++i) {
            slist.add(new Item(A[i], i));
        }

        Collections.sort(slist, new Comparator<Item>() {
            @Override
            public int compare(final Item p1, final Item p2) {
                if (p1.val < p2.val) {
                    return -1;
                } else if (p1.val > p2.val) {
                    return 1;
                } else {
                    if (p1.index == p2.index) {
                        return 0;
                    } else if (p1.index > p2.index) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        int last = A[A.length - 1];
        for (int i = 0; i < A.length; ++i) {

            int cur = A[i];
            if (cur == last) {
                // for sure it is able to go to the end
                num++;
                continue;
            }

            List<Item> slistcopy = copy(slist);

            boolean jumpOdd = true;
            int icur = slistcopy.indexOf(new Item(cur, i));
            int sizes = slistcopy.size();
            int lo = icur;
            int hi = icur;
            while (true) {
                if (jumpOdd) {
                    int inext = hi + 1;
                    while (inext < sizes && !slistcopy.get(inext).valid) {
                        inext++;
                    }
                    if (inext >= sizes) {
                        // cannot continue
                        break;
                    }

                    Item p = slistcopy.get(inext);
System.out.println("odd cur: " + cur + ", inext: " + inext);
printList(slistcopy);
                    if (p.val == last) {
                      // for sure it is able to go the end
                      num++;
                      break;
                    }

                    int start = slistcopy.get(hi).index;
                    int end = slistcopy.get(inext).index;
System.out.println("start: " + start + ", end: " + end);
                    for (int x = start; x <= end; ++x) {
                        int j = slistcopy.indexOf(new Item(A[x], x));
                        slistcopy.get(j).valid = false;
System.out.println("invalid: " + x + ", " + j);
                    }

                    hi = inext;
                } else {
                    int inext = lo - 1;
                    while (inext >= 0 && !slistcopy.get(inext).valid) {
                        inext--;
                    }

                    if (inext < 0) {
                        // cannot continue
                        break;
                    }

                    Item p = slistcopy.get(inext);
System.out.println("even cur: " + cur + ", inext: " + inext);
printList(slistcopy);
                    if (p.val == last) {
                      // for sure it is able to go the end
                      num++;
                      break;
                    }

                    int start = slistcopy.get(lo).index;
                    int end = slistcopy.get(inext).index;
System.out.println("start: " + start + ", end: " + end);
                    for (int x = start; x <= end; ++x) {
                        int j = slistcopy.indexOf(new Item(A[x], x));
                        slistcopy.get(j).valid = false;
System.out.println("invalid: " + x + ", " + j);
                    }

                    lo = inext;
                }

                jumpOdd = !jumpOdd;
            } // end of while

            // mark the cur not valid from slist
            slist.get(icur).valid = false;

        } // end of for
        
        return num;
    }

    public static void test(int[] input, int expected) {
        Solution s = new Solution();
        // long ts = System.nanoTime();
        int ret = s.oddEvenJumps3(input);
        // System.out.println(System.nanoTime() - ts);
        if (ret == expected) {
            System.out.println("Passed");
        } else {
            System.out.println("Excepted: " + expected + " Failed: " + ret);
        }
    }

    public static void main(String[] args) {
        int[] input = {10,13,12,14,15};
        test(input, 2);

        int[] input2 = {2,3,1,1,4};
        test(input2, 3);

        int[] input3 = {5,1,3,4,2};
        test(input3, 3);
    }
}

class Item {
    int val;
    int index;
    boolean valid;

    Item(int v, int i) {
        this.val = v;
        this.index = i;
        valid = true;
    }

    Item(int v, int i, boolean valid) {
        this.val = v;
        this.index = i;
        this.valid = valid;
    }

    public boolean equals(Object o) {
        Item i = (Item) o;
        return ((this.val == i.val) && (this.index == i.index));
    }

    public String toString() {
        return Integer.toString(val);
    }
}
