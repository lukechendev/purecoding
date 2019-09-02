#include <iostream>
#include <vector>
#include <fstream>

using namespace std;

enum SortType {
  QUICK = 0,
  MERGE,
  BUBBLE
};

void printV(const vector<int>& v, bool newRun = true) {
  ofstream ofs("output", newRun ? ios::trunc : ios::app);
  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    ofs << *i << ' ';
  }
  ofs << endl;
  ofs.close();
}

// Bubble Sort
// 57'

void bubbleSort(vector<int>& v) {
  size_t sizeT = v.size();
  int t;
  
  for (size_t i = 0; i < sizeT; ++i) {
    for (size_t j = i + 1; j < sizeT; ++j) {
      if (v[i] > v[j]) {
        t = v[i];
        v[i] = v[j];
        v[j] = t;
      }
    }
  }
}

// Merge Sort
// 52'

void merge(vector<int>& v, size_t lo, size_t mid, size_t hi) {
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

  size_t sizeT = t.size();
  for (size_t i = 0; i < sizeT; ++i) {
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

// Quick Sort
// 36'

size_t partition(vector<int>& v, size_t lo, size_t hi) {
  int pivot = v[(lo + hi)/2];

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
  if (hi <= lo) {
    return;
  }

  size_t p = partition(v, lo, hi);
  quickSort(v, lo, p);
  quickSort(v, p + 1, hi);
}

void sort(vector<int> v, SortType t = QUICK) {
  switch(t) {
    case MERGE: {
      cout << endl << "To merge sort:" << endl; 
      mergeSort(v, 0, v.size());
      break;
    }
    case BUBBLE: {
      cout << endl << "To bubble sort:" << endl; 
      bubbleSort(v);
      break;
    }
    default: {
      cout << endl <<  "To quick sort:" << endl; 
      quickSort(v, 0, v.size() - 1);
      break;
    }
  }
  printV(v, false);
}

vector<int> loadData() {
  vector<int> v;

  int data;
  ifstream dataFile("data");
  while (!dataFile.eof()) {
    dataFile >> data;
    v.push_back(data);
  }
  dataFile.close();

  return v;
}

int main() { 
  const vector<int> v = loadData();
  printV(v);

  sort(v, QUICK);
  sort(v, MERGE);
  sort(v, BUBBLE);
}
