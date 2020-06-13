import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Sorting {
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

  static void merge(int[] v, int lo, int mid, int hi) {
    if (mid <= lo && hi <= mid) {
      return;
    }

    int i = lo;
    int j = mid;

    int n = 0;
    int[] t = new int[hi-lo];
    while (i < mid && j < hi) {
      if (v[i] < v[j]) {
        t[n++] = v[i++];
      } else {
        t[n++] = v[j++];
      }
    }

    while (i < mid) {
      t[n++] = v[i++];
    }

    while (j < hi) {
      t[n++] = v[j++];
    }

    for (n = 0; n < t.length; ++n) {
      v[lo + n] = t[n];
    }
  }

  static void mergeSort(int[] v, int lo, int hi) {
    if (hi - lo <= 1) {
      return;
    }

    int mid = (lo + hi) / 2;
    mergeSort(v, lo, mid);
    mergeSort(v, mid, hi);
    merge(v, lo, mid, hi);
  }

  static int partition(int[] v, int lo, int hi) {
    int pivot = v[(lo+hi)/2];

    int i = lo - 1;
    int j = hi + 1;

    while (true) {
      do {
        i++;
      } while (v[i] < pivot);

      do {
        j--;
      } while (v[j] > pivot);

      if (j <= i) {
        return j;
      }

      if (v[i] > v[j]) {
        int t = v[i];
        v[i] = v[j];
        v[j] = t;
      }
    }
  }

  static void quickSort(int[] v, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int p = partition(v, lo, hi);
    quickSort(v, lo, p);
    quickSort(v, p+1, hi);
  }

  public static void main(String[] args) {
    int data[] = readData("data1");
    printV(data);

    mergeSort(data, 0, data.length);
    printV(data);

    quickSort(data, 0, data.length - 1);
    printV(data);
  }
}
