import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.System;

public class Sorting {

  private static class Util {
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

    static void printV(int[] v) {
      for (int i = 0; i < v.length; ++i) {
        System.out.print(v[i] + " ");
      }
      System.out.println();
    }
  }

  private int partition(int[] v, int lo, int hi) {
    int pivot = v[(lo + hi - 1) / 2];

    int i = lo - 1;
    int j = hi;
    int t;
    while (true) {
      do {
        ++i;
      } while (v[i] < pivot);

      do {
        --j;
      } while (v[j] > pivot);

      if (j <= i) {
        return j;
      }

      if (v[i] > v[j]) {
        t = v[i];
        v[i] = v[j];
        v[j] = t;
      }
    }
  }

  public void quickSort(int[] v, int lo, int hi) {
    if (hi - lo <= 1) {
      return;
    }

    int p = partition(v, lo, hi);
    quickSort(v, lo, p);
    quickSort(v, p + 1, hi);
  }

  private void merge(int[] v, int lo, int mid, int hi) {
    if (mid <= lo && hi <= mid) {
      return;
    }

    int i = lo;
    int j = mid;
    int[] t = new int[hi - lo];

    int ti = 0;
    while (i < mid && j < hi) {
      if (v[i] < v[j]) {
        t[ti++] = v[i++];
      } else {
        t[ti++] = v[j++];
      }
    }

    while (i < mid) {
      t[ti++] = v[i++];
    }

    while (j < hi) {
      t[ti++] = v[j++];
    }

    for (int n = 0; n < t.length; ++n) {
      v[lo + n] = t[n];
    }
  }

  public void mergeSort(int[] v, int lo, int hi) {
    if (hi - lo <= 1) {
      return;
    }

    int mid = (hi + lo) / 2;
    mergeSort(v, lo, mid);
    mergeSort(v, mid, hi);
    merge(v, lo, mid, hi);
  }

  public static void main(String[] args) {
    int[] v = Util.readData("data2");
    Util.printV(v);

    Sorting sorting = new Sorting();

    int[] v1 = new int[v.length];
    System.arraycopy(v, 0, v1, 0, v.length);
    sorting.quickSort(v1, 0, v1.length);
    Util.printV(v1);

    int[] v2 = new int[v.length];
    System.arraycopy(v, 0, v2, 0, v.length);
    sorting.mergeSort(v2, 0, v2.length);
    Util.printV(v2);
  }
}
