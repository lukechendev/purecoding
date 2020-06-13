#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int>& v, size_t lo, size_t mid, size_t hi) {
  if (mid <= lo && hi <= mid) {
    return;
  }

  size_t il = lo;
  size_t ir = mid;
  vector<int> t;
  while (il < mid && ir < hi) {
    if (v[il] < v[ir]) {
      t.push_back(v[il++]);
    } else {
      t.push_back(v[ir++]);
    }
  }

  while (il < mid) {
    t.push_back(v[il++]);
  }

  while (ir < hi) {
    t.push_back(v[ir++]);
  }


  for (size_t i = 0; i < t.size(); ++i) {
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

void printV(const vector<int>& v) {
  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    cout << *i << ' ';
  }
  cout << endl;
}

int main() {
  vector<int> a = {20, 0, 99, 9, 28, 11, -1, 27, 9, 33, 3};
  printV(a);
  mergeSort(a, 0, a.size());
  printV(a);
}
