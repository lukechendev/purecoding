#include <iostream>
#include <vector>

using namespace std;

static vector<int> v1 = {32, 1, 33, 13, 9, 29, 128, 99, 0, 1, 9, 7, 86, 69, 9, 8};

void printv(const vector<int>& v, const string& msg = "") {
  cout << msg << endl;
  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    if (i + 1 != v.cend()) {
      cout << *i << ", ";
    } else {
      cout << *i << endl;
    }
  }
}

void bubbleSort(vector<int>& v) {
}

void testBubbleSort(const vector<int>& v) {
  vector<int> testV = v;

  bubbleSort(testV);
  printv(testV, "bubble sorted:");
}

void quickSort(vector<int>& v) {
}

void testQuickSort(const vector<int>& v) {
  vector<int> testV = v;

  quickSort(testV);
  printv(testV, "quick sorted:");
}

void merge(vector<int>& v, size_t lo, size_t mid, size_t hi) {
  if ((mid - lo <= 0) && (hi - mid <= 0)) {
    return;
  }

  vector<int> t;
  size_t li = lo;
  size_t ri = mid;


  while ((mid - li > 0) && (hi - ri > 0)) {
    if (v[li] < v[ri]) {
      t.push_back(v[li++]);
    } else {
      t.push_back(v[ri++]);
    }
  }


  while (mid - li > 0) {
    t.push_back(v[li++]);
  }

  while (hi - ri > 0) {
    t.push_back(v[ri++]);
  }


  for (size_t i = 0 ; i < t.size(); ++i) {
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

void testMergeSort(const vector<int>& v) {
  vector<int> testV = v;

  mergeSort(testV, 0, testV.size());
  printv(testV, "merge sorted:");
}

int main() {
  printv(v1, "original:");

  testMergeSort(v1);
  testBubbleSort(v1);
  testQuickSort(v1);
}
