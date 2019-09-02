#include <iostream>
#include <vector>
#include <unordered_set>
#include <string>
#include <fstream>

using std::cout;
using std::endl;
using std::unordered_set;
using std::vector;
using std::string;
using std::ifstream;

/**
This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
*/

void printV(const vector<int>& v) {
  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    cout << *i << ' ';
  }
  cout << endl;
}

size_t partition(vector<int>& v, size_t lo, size_t hi) {
  int pivot = v[(lo + hi) / 2];

  size_t i = lo - 1;
  size_t j = hi + 1;
  int t;

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
      t = v[i];
      v[i] = v[j];
      v[j] = t;
    }
  }
}

void quickSort(vector<int>& v, size_t lo, size_t hi) {
  if (hi - lo <= 0) {
    return;
  }

  size_t p = partition(v, lo, hi);
  quickSort(v, lo, p);
  quickSort(v, p + 1, hi);
}

void sort(vector<int>& v) {
  quickSort(v, 0, v.size() - 1);
}

// Search a value in a sorted array
bool find(const vector<int> v, size_t lo, size_t hi, int r) {
  if (hi == lo) {
    return v[lo] == r;
  }

  size_t mid = (lo + hi) / 2;
  if (v[mid] == r) {
    return true;
  }

  if (r < v[mid]) {
    return find(v, lo, mid - 1, r);
  }

  if (r > v[mid]) {
    return find(v, mid + 1, hi, r);
  }
}

bool addUpTo(const vector<int>& v, int k) {
  vector<int> v1(v);
  sort(v1);
  printV(v1);

  for (auto i = v1.cbegin(); i != v1.cend(); ++i) {
    int r = k - *i;
    if (find(v1, 0, v1.size() - 1, r)) {
      cout << k << " = " << *i << " + " << r << endl;
      return true;
    }
  }

  return false;
}


void loadData(vector<int>& v, int&k, const string& path) { 
  ifstream ifs(path);

  ifs >> k;
  int r;  
  while (ifs >> r) { 
    v.push_back(r);
  }
}

int main() {
  vector<int> v;
  int k = 0;
  loadData(v, k, "data2");

  printV(v);
  bool r = addUpTo(v, k);

  if (r) {
    cout << "yes, can add up to " << k << endl;
  } else {
    cout << "no,  can not add up to " << k << endl;
  }
  return 0;
}

