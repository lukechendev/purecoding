#ifndef SORTING_H
#define SORTING_H

#include <vector>

using std::vector;

class Sorting {
  public:
    static void quickSort(vector<int>& v, const int lo, const int hi);
    static void mergeSort(vector<int>& v, const int lo, const int hi);
    static void bubbleSort(vector<int>& v);
    static void selectionSort(vector<int>& v);
    static void insertionSort(vector<int>& v);
    static void bucketSort(vector<int>& v);
    static void radixSort(vector<int>& v);
    static void heapSort(vector<int>& v);

  private:
    static int partition(vector<int>& v, const int lo, const int hi);
    static void merge(vector<int>& v, const int lo, const int mid, const int hi);
};

#endif // SORTING_H
