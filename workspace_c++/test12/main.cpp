#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

void printV(const vector<int>& v, size_t lo, size_t hi) {
  for (size_t i = 0; i < v.size(); ++i) {
    stringstream ss;
    if (i >= lo && i < hi) {
      ss << "printf '\e[38;5;196m " << v[i] << " '";
    } else {
      ss << "printf '\e[38;5;255m " << v[i] << " '";
    }
    system(ss.str().c_str());
  }
  cout << endl;
}

inline void swap(vector<int>& v, size_t i, size_t j, long& count) {
    int t = v[i];
    v[i] = v[j];
    v[j] = t;
    count++;
}

void merge(vector<int>& v, size_t lo, size_t mid, size_t hi, long& count) {
    printV(v, lo, hi);
    if (mid <= lo && hi <= mid) {
        return;
    }

    size_t i = lo;
    size_t j = mid;
    vector<int> t;

    while (i < mid && j < hi) {
        if (v[j] < v[i]) {
            t.push_back(v[j++]);
            int delta = j - 1 - lo - (t.size() - 1);
            count += delta;
            cout << "oindex" << j - 1 << "nindex" << t.size() - 1 << "d" << delta << endl;
        } else {
            t.push_back(v[i++]);
        }
    }

    while (i < mid) {
        t.push_back(v[i++]);
    }

    while (j < hi) {
        t.push_back(v[j++]);
    }

    size_t tsize = t.size();
    for (int i = 0; i < tsize; ++i) {
        v[lo +i] = t[i];
    }
    printV(v, lo, hi);
}

void mergeSort(vector<int>& v, size_t lo, size_t hi, long& count) {
    if (hi - lo <= 1) {
        return;
    }

    size_t mid = (lo + hi) / 2;
    mergeSort(v, lo, mid, count);
    mergeSort(v, mid, hi, count);
    merge(v, lo, mid, hi, count);
}

long countInversions(vector<int> arr) {
    long count = 0;
    // quickSort(arr, 0, arr.size() - 1, count);
    // bubbleSort(arr, 0, arr.size(), count);
    mergeSort(arr, 0, arr.size(), count);
    return count;
}

int main() {
  // vector<int> v = {2, 1, 3, 1, 2};
  vector<int> v = {7, 5, 3, 1};
  long count = countInversions(v);
  cout << count << endl;
}
