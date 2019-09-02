#include "sorting.h"

int Sorting::partition(vector<int>& v, const int lo, const int hi) {
  int pivot = v[(lo + hi)/2];

  int i = lo - 1;
  int j = hi + 1;
  int t = 0;
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

void Sorting::quickSort(vector<int>& v, const int lo, const int hi) {
  if (hi <= lo) {
    return;
  }

  int p = partition(v, lo, hi);
  quickSort(v, lo, p);
  quickSort(v, p + 1, hi);
}

void Sorting::merge(vector<int>& v, const int lo, const int mid, const int hi) {
  if (mid <= lo && hi <= mid) {
    return;
  }

  int i = lo;
  int j = mid;
  vector<int> t;
  
  while (i < mid && j < hi) {
    if (v[i] < v[j]) {
      t.push_back(v[i++]);
    } else {
      t.push_back(v[j++]);
    }
  }

  while (i < mid) {
    t.push_back(v[i++]);
  }

  while (j < hi) {
    t.push_back(v[j++]);
  }

  int tsize = t.size();
  for (int n = 0; n < tsize; ++n) {
    v[lo + n] = t[n];
  }
}

void Sorting::mergeSort(vector<int>& v, const int lo, const int hi) {
  if (hi - lo <= 1) {
    return;
  }

  int mid = (hi + lo) / 2;
  mergeSort(v, lo, mid);
  mergeSort(v, mid, hi);
  merge(v, lo, mid, hi);
}

void Sorting::bubbleSort(vector<int>& v) {
  int vsize = v.size();
  int t;
  for (int i = 0; i < vsize; ++i) {
    for (int j = i + 1; j < vsize; ++j) {
      if (v[j] < v[i]) {
        t = v[i];
        v[i] = v[j];
        v[j] = t;
      }
    }
  }
}

void Sorting::selectionSort(vector<int>& /*v*/) {
}

void Sorting::insertionSort(vector<int>& /*v*/) {
}

void Sorting::bucketSort(vector<int>& /*v*/) {
}

void Sorting::radixSort(vector<int>& /*v*/) {
}

void Sorting::heapSort(vector<int>& /*v*/) {
}

