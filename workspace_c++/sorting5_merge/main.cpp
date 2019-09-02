#include <iostream>
#include <vector>
#include <forward_list>
#include <chrono>
#include <limits.h>

using namespace std;


void merge(vector<int>& v, size_t lo, size_t mid, size_t hi) {
  if (mid <= lo && hi <= mid) {
    return;
  }

  size_t il = lo;
  size_t ir = mid;
  vector<int> t;

  while(il < mid && ir < hi) {
    if (v[il] < v[ir]) {
      t.push_back(v[il++]);
    } else {
      t.push_back(v[ir++]);
    }
  }

  while(il < mid) {
    t.push_back(v[il++]);
  }

  while(ir < hi) {
    t.push_back(v[ir++]);
  }


  for (int i = 0; i < t.size(); ++i) {
    v[lo + i] = t[i];
  }
}

void mergeSort(vector<int>& v, size_t lo, size_t hi) {
 if (hi - lo <= 1) {
    return;
  }

  size_t mid = (lo + hi) / 2;
  mergeSort(v, lo, mid);
  mergeSort(v, mid, hi);


  merge(v, lo, mid, hi);
}

size_t partition(vector<int>& v, size_t lo, size_t hi) {
  int pivot = v[(lo + hi) / 2];

  size_t i = lo - 1;
  size_t j = hi + 1;
  
  while(true) {
    do {
      i++;
    } while(v[i] < pivot);
    
    do {
      j--;
    } while(v[j] > pivot);
    
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

void quickSort(vector<int>& v, size_t lo, size_t hi) {
  if (hi <= lo) {
    return;
  }

  size_t p = partition(v, lo, hi);
  quickSort(v, lo, p);
  quickSort(v, p + 1, hi);
}

void bubbleSort(vector<int>& v) {
  int t;
  size_t vSize = v.size();
  for (int i = 0; i < vSize; ++i) {
    for (int j = i + 1; j < vSize; ++j) {
      if (v[i] > v[j]) {
        t = v[i];
        v[i] = v[j];
        v[j] = t;
      }
    }
  }
}

void sort(vector<int>& v) {
  // mergeSort(v, 0, v.size());
  quickSort(v, 0, v.size() - 1);
  // bubbleSort(v);
}

template <class T>
void print(const T& v) {
  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    cout << *i << ' ';
  }
  cout << endl;
}

int randomInt(int r = 100) {
  static int seed = 0;
  static int i = 0;

  ++i;
  auto duration = chrono::system_clock::now().time_since_epoch();
  auto millis = chrono::duration_cast<chrono::milliseconds>(duration).count();
  if (seed == 0) {
    seed = div((int) abs(((millis / 3 + 222) * 3 ) - INT_MAX + r), r).rem;
  } else {
    seed = div(div((int) (seed / 3 + i + 222) * 3 + i, r).rem, r).rem;
  }

  return seed;
}

void generateArray(vector<int>& v, size_t n, int r) {
  for (size_t i = 0; i < n; ++i) {
    int n = randomInt(r);
    v.push_back(n);
  }
}

int main() {
  vector<int> sample = {213, 1, 333, -2, 0, 23, 87, 87, 99, 12, 0, -11, -9, 27, 37};
  vector<int> v;
  generateArray(v, 10000, 1000);
  print<vector<int>>(v);
  sort(v);
  print<vector<int>>(v);
}
