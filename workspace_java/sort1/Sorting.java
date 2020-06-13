import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.lang.IndexOutOfBoundsException;

public class Sorting {
  private int partition(List<Integer> v, int lo, int hi) {
    int pivot = v.get((lo + hi - 1) / 2);
    
    int i = lo - 1;
    int j = hi;

    int t;
    while (true) {
      do {
	i = i + 1;
      } while (v.get(i) < pivot);

      do {
	j = j - 1;
      } while (v.get(j) > pivot);

      if (j <= i) {
        return j;
      }

      if (v.get(i) > v.get(j)) {
        t = v.get(i);
        v.set(i, v.get(j));
        v.set(j, t);
      }
    }
  }

  public void quickSort(List<Integer> v, int lo, int hi) {
    if (hi - lo <= 1) {
      return;
    }

    int p = partition(v, lo, hi);
    quickSort(v, lo, p);
    quickSort(v, p + 1, hi);
  }

  private void merge(List<Integer> v, int lo, int mid, int hi) {
    if (mid <= lo && hi <= mid) {
      return;
    }

    int i = lo;
    int j = mid;

    List<Integer> t = new ArrayList<Integer>();
    while (i < mid && j < hi) {
      if (v.get(i) < v.get(j)) {
        t.add(v.get(i++));
      } else {
        t.add(v.get(j++));
      }
    }

    while (i < mid) {
      t.add(v.get(i++));
    }

    while (j < hi) {
      t.add(v.get(j++));
    }

    int sizeT = t.size();
    for (int n = 0; n < sizeT; ++n) {
      v.set(lo + n, t.get(n));
    }
  }

  public void mergeSort(List<Integer> v, int lo, int hi) {
    if (hi - 1 <= lo) {
      return;
    }

    int mid = (lo + hi) / 2;
    mergeSort(v, lo, mid);
    mergeSort(v, mid, hi);
    merge(v, lo, mid, hi);
  }

  public void bubbleSort(List<Integer> v) {
    int sizeV = v.size();
    int t;
    for (int i = 0; i < sizeV; ++i) {
      for (int j = i + 1; j < sizeV; ++j) {
        if (v.get(j) < v.get(i)) {
          t = v.get(j);
          v.set(j, v.get(i));
          v.set(i, t);
        }
      }
    }
  }

  public void buketSort(List<Integer> v) {
    if (v.size() == 0) {
      return;
    }

    // find max
    int max = v.get(0);
    for (int i : v) {
      if (max < i) {
        max = i;
      }
    }

    // build bucket
    List<List<Integer>> buckets = new ArrayList<List<Integer>>();
    for (int i = 0; i <= max; ++i) {
      buckets.add(new ArrayList<Integer>());
    }

    // drop
    for (int i : v) {
      buckets.get(i).add(i);
    }

    // retrieve
    int n = 0;
    try {
      for (List<Integer> b : buckets) {
	for (int i : b) {
	  v.set(n++, i);
	} 
      }
    } catch (IndexOutOfBoundsException e) {
      e.printStackTrace();
    }
  }

  public void buketSort2(List<Integer> v) {
    if (v.size() == 0) {
      return;
    }

    // find max
    int max = v.get(0);
    int min = v.get(0);
    for (int i : v) {
      if (max < i) {
        max = i;
      }
      if (min > i) {
        min = i;
      }
    }

    // build bucket
    final int iMax = max - min;
    List<List<Integer>> buckets = new ArrayList<List<Integer>>();
    for (int i = 0; i <= iMax; ++i) {
      buckets.add(new ArrayList<Integer>());
    }

    // drop
    for (int i : v) {
      buckets.get(i - min).add(i);
    }

    // retrieve
    int n = 0;
    try {
      for (List<Integer> b : buckets) {
	for (int i : b) {
	  v.set(n++, i);
	} 
      }
    } catch (IndexOutOfBoundsException e) {
      e.printStackTrace();
    }
  }

  public void radixSort(List<Integer> v) {
    // build buckets
    // drop and retrieve until the highest digit
  }

  public void insertionSort(List<Integer> v) {
  }

  private static class Utils {

    static List<Integer> readData(String path) {
      List<Integer> list = new ArrayList<Integer>();

      Scanner s = null;
      try {
	s = new Scanner(new File(path));
	while (s.hasNextInt()) {
          int n = s.nextInt();
	  list.add(n);
	}
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (s != null) {
          s.close();
        }
      }

      return list;
    }

   static void printV(List<Integer> v) {
     printV(v, null);
   }

    static void printV(List<Integer> v, String msg) {
      if (msg != null) {
        System.out.println(msg);
      }

      for (int i : v) {
        System.out.print(i + " ");
      }
      System.out.println();
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Sorting instance = new Sorting();

    List<Integer> v = Utils.readData("data1");
    Utils.printV(v);

    List<Integer> v1 = new ArrayList<Integer>(v);
    instance.quickSort(v1, 0, v1.size());
    Utils.printV(v1, "quickSort");

    List<Integer> v2 = new ArrayList<Integer>(v);
    instance.mergeSort(v2, 0, v2.size());
    Utils.printV(v2, "mergeSort");

    List<Integer> v3 = new ArrayList<Integer>(v);
    instance.bubbleSort(v3);
    Utils.printV(v3, "bubbleSort");

    // List<Integer> v4 = new ArrayList<Integer>(v);
    // instance.buketSort(v4);
    // Utils.printV(v4, "bucketSort");

    List<Integer> v5 = new ArrayList<Integer>(v);
    instance.buketSort2(v5);
    Utils.printV(v5, "bucketSort");

    List<Integer> v6 = new ArrayList<Integer>(v);
    instance.radixSort(v6);
    Utils.printV(v6, "radixSort");

    List<Integer> v7 = new ArrayList<Integer>(v);
    instance.insertionSort(v7);
    Utils.printV(v7, "insertionSort");

    List<Integer> v8 = new ArrayList<Integer>(v);
    instance.insertionSort(v8);
    Utils.printV(v8, "selectionSort");
  }
}

