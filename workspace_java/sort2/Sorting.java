package com.lchendev.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Sorting {

  public void radixSort(List<Integer> v) {

    MaxMin ret = Utils.getMaxMin(v);
    int numDigits = Utils.getNumDigits(ret.max);
    for (int i = 1; i <= numDigits; ++i) {
      List<List<Integer>> buckets = new ArrayList<List<Integer>>(10);
      for (int j = 0; j < 10; ++j) {
	buckets.add(new ArrayList<Integer>());
      }

      for (int j : v) {
        int digit = Utils.getDigit(j, i);
        buckets.get(digit).add(j);
      }

      int n = 0;
      for (List<Integer> b : buckets) {
        for (int j : b) {
          v.set(n++, j);
        }
      }
    }
  }

  public void bucketSort(List<Integer> v) {
    MaxMin ret = Utils.getMaxMin(v);

    int size = ret.max - ret.min + 1;
    List<List<Integer>> buckets = new ArrayList<List<Integer>>(size);

    for (int i = 0; i < size; ++i) {
      buckets.add(new ArrayList<Integer>());
    }

    for (int i : v) {
      buckets.get(i - ret.min).add(i);
    }

    int n = 0;
    for (List<Integer> i : buckets) {
      for (int j : i) {
        v.set(n++, j);
      }
    }
  }

  public void bubbleSort(List<Integer> v) {
    final int sizeV = v.size();
    int t;
    for (int i = 0; i < sizeV; ++i) {
      for (int j = i + 1; j < sizeV; ++j) {
        if (v.get(j) < v.get(i)) {
          t = v.get(i);
          v.set(i, v.get(j));
          v.set(j, t);
        }
      }
    }
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
    for (int m = 0; m < sizeT; ++m) {
      v.set(lo + m, t.get(m));
    }
  }


  public void mergeSort(List<Integer> v, int lo, int hi) {
    if (hi - lo <= 1) {
      return;
    }

    int mid = (lo + hi) / 2;
    mergeSort(v, lo, mid);
    mergeSort(v, mid, hi);
    merge(v, lo, mid, hi);
  }

  private int partition(List<Integer> v, int lo, int hi) {
    int pivot = v.get((lo + hi - 1)/2);
    
    int i = lo - 1;
    int j = hi;
    int t;
    while (true) {
      do {
        i++;
      } while (v.get(i) < pivot);

      do {
        j--;
      } while (v.get(j) > pivot);

      if (j <= i) {
        return j;
      }

      if (v.get(j) < v.get(i)) {
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

  private static class Utils {
    static void printV(final List<Integer> v) {
      for (int i : v) {
	System.out.print(i + " ");
      }
      System.out.println();
      System.out.println();
    }
    
    static List<Integer> readData(final String path) {
      List<Integer> data = new ArrayList<Integer>();

      Scanner scanner = null;
      try {
	scanner = new Scanner(new File(path));
	while (scanner.hasNextInt()) {
	  data.add(scanner.nextInt());
	}
      } catch (IOException e) {
	e.printStackTrace();
      } finally {
	if (scanner != null) {
	  scanner.close();
	}
      }

      return data;
    }

    static MaxMin getMaxMin(List<Integer> v) {
      MaxMin ret = new MaxMin();

      ret.max = v.get(0);
      ret.min = v.get(0);
      for (int i : v) {
	if (ret.max < i) {
	  ret.max = i;
	}
	if (ret.min > i) {
	  ret.min = i;
	}
      }

      return ret;
    }

    static int getNumDigits(int i) {
      int num = 0;
      do {
        i = i / 10;
        num++;
      } while (i > 0);
      return num;
    }

    static int getDigit(int i, int n) {
      return i % POW10[n] / POW10[n - 1];
    }

    static int[] POW10 = {1, 10, 100, 1000, 10000, 100000, 100000, 1000000, 10000000, 100000000, 1000000000};
  }

  static private class MaxMin {
    int max;
    int min;
  }

  public static void main(String[] args) {
    Sorting instance = new Sorting();
    List<Integer> v = Utils.readData("data1");
    Utils.printV(v);

    List<Integer> v1 = new ArrayList<Integer>(v);
    instance.quickSort(v1, 0, v1.size());
    Utils.printV(v1);

    List<Integer> v2 = new ArrayList<Integer>(v);
    instance.mergeSort(v2, 0, v2.size());
    Utils.printV(v2);

    List<Integer> v3 = new ArrayList<Integer>(v);
    instance.bubbleSort(v3);
    Utils.printV(v3);

    List<Integer> v4 = new ArrayList<Integer>(v);
    instance.bucketSort(v4);
    Utils.printV(v4);

    List<Integer> v5 = new ArrayList<Integer>(v);
    instance.radixSort(v5);
    Utils.printV(v5);
  }
}
