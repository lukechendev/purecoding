#include <iostream>
#include <vector>
#include <fstream>

using namespace std;

template<class T>
void readData(T& v, const string& path) {
  ifstream ifs(path);
  int c;
  while (ifs >> c) {
    v.push_back(c);
  }
}

template<class T>
void printV(const T& v) {
  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    cout << *i << ' ';
  }
  cout << endl << endl;
}

template<class T>
size_t partition(T& v, const size_t lo, const size_t hi) {
  auto pivot = v[(hi - 1 + lo) / 2];
  
  size_t i = lo - 1;
  size_t j = hi;

  auto t = pivot;
  while (true) {
    do {
      i++;
    } while(v[i] < pivot);

    do {
      j--;
    } while(v[j] > pivot);

    if (j <= i) {
      return j;
    }

    if (v[j] < v[i]) {
      t = v[j];
      v[j] = v[i];
      v[i] = t;
    }
  }
}

template<class T>
void quickSort(T& v, const size_t lo, const size_t hi) {
  if (hi - lo <= 1) {
    return;
  }

  size_t p = partition(v, lo, hi);
  quickSort(v, lo, p);
  quickSort(v, p + 1, hi);
}

template<class T>
void merge(T& v, const size_t lo, const size_t mid, const size_t hi) {
  if (mid <= lo && hi <= mid) {
    return;
  }

  size_t i = lo;
  size_t j = mid;

  T t;
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

  size_t tsize = t.size();
  for (size_t n = 0; n < tsize; ++n) {
    v[lo + n] = t[n];
  }
}

template<class T>
void mergeSort(T& v, const size_t lo, const size_t hi) {
  if (hi - lo <= 1) {
    return;
  }

  size_t mid = (lo + hi) / 2;
  mergeSort(v, lo, mid);
  mergeSort(v, mid, hi);
  merge(v, lo, mid, hi);
}

template<class T>
void bubbleSort(T& v) {
  const size_t vsize = v.size();

  if (vsize == 0) {
    return;
  }

  auto t = v[0];
  for (size_t i = 0; i < vsize; ++i) {
    for (size_t j = i + 1; j < vsize; ++j) {
      if (v[j] < v[i]) {
        t = v[j];
        v[j] = v[i];
        v[i] = t;
      }
    }
  }
}

int main(int argc, char* argv[]) {
  vector<int> v;

  readData(v, "data1");
  printV(v);

  vector<int> v1(v);
  quickSort(v1, 0, v1.size());
  printV(v1);

/*
  vector<int> v2(v);
  mergeSort(v2, 0, v2.size());
  printV(v2);

  vector<int> v3(v);
  bubbleSort(v3);
  printV(v3);
*/
  return 0;
}
