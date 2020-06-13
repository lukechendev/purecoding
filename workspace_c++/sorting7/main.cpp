#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

enum SortType {
  QUICK,
  MERGE,
  BUBBLE
};

template <class T>
void bubbleSort(T& v) {
  int t;
  const size_t vsize = v.size();
  for (size_t i = 0; i < vsize; ++i) {
    for (size_t j = i + 1; j < vsize; ++j) {
      if (v[j] < v[i]) {
        t = v[i];
        v[i] = v[j];
        v[j] = t;
      }
    }
  }
}

template <class T>
void merge(T& v, size_t lo, size_t mid, size_t hi) {
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

  for (size_t n = 0; n < t.size(); ++n) {
    v[lo + n] = t[n];
  }
}

template <class T>
void mergeSort(T& v, size_t lo, size_t hi) {
  if (hi - lo <= 1) {
    return;
  }

  size_t mid = (lo + hi) / 2;
  mergeSort(v, lo, mid);
  mergeSort(v, mid, hi);
  merge(v, lo, mid, hi);
}

template <class T>
size_t partition(T& v, size_t lo, size_t hi) {
  int pivot = v[(lo + hi) / 2];

  size_t i = lo - 1;
  size_t j = hi + 1;
  
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

    if (v[j] < v[i]) {
      int t = v[i];
      v[i] = v[j];
      v[j] = t;
    }
  }
}

template <class T>
void quickSort(T& v, size_t lo, size_t hi) {
  if (hi <= lo) {
    return;
  }

  size_t p = partition(v, lo, hi);
  quickSort(v, lo, p);
  quickSort(v, p + 1, hi);
}

template <class T>
T sort(const T& v, const SortType type) {
  T t(v);
  switch (type) {
    case BUBBLE: {
      bubbleSort(t);
      break;
    }
    case MERGE: {
      mergeSort(t, 0, t.size());
      break;
    }
    default: {
      quickSort(t, 0, t.size() - 1);
      break;
    }
  }

  return t;
}

template <class T>
void readData(T& v, const string& dataPath) {
  ifstream ifs;
  ifs.open(dataPath);

  int value;
  while (!ifs.eof()) {
    ifs >> value;
    v.push_back(value);
  }
  ifs.close();
}

template <class T>
void printV(const T& v, bool console=true) {
  if (console) {
    for (auto i = v.cbegin(); i != v.cend(); ++i) {
      cout << *i << ' ';
    }
    cout << endl << endl;
  }
}

int main() {
  vector<int> v;
  string dataPath("data1");
  readData(v, dataPath);
  printV(v, 0);

  vector<int> t;
  t = sort(v, QUICK);
  printV(t, 1);

  t = sort(v, MERGE);
  printV(t, 0);

  t = sort(v, BUBBLE);
  printV(t, 0);

  return 0;
}
