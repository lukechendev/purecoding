/*
#1 Given a list of files with their sizes, a process is to merge the files into one. The time spent to merge each file equals to the file size. Every time, it can only merge two files and the merged file size equals to the sum of two file's sizes. Find the minimum size of the final file.

Input:
4, [4, 8, 6, 12]
Output:
4 + 6 = 10 ==> [10, 8, 12]
10 + 8 = 18 ==> [18, 12]
18 + 12 = 30

The total = 10 + 18 + 30 = 58, which happens to be the minimum size of the final merged file.

int minimumTotal(int* files, int numOfTotalFiles);
*/

#include <iostream>
#include <list>

using namespace std;

void printV(int* v, int s) {
  for (int i = 0; i < s; ++i) {
    cout << v[i] << " ";
  }
  cout << endl;
  cout << endl;
}

void printV(const list<int>& l) {
  for (auto i = l.cbegin(); i != l.cend(); ++i) {
    cout << *i << " ";
  }
  cout << endl;
  cout << endl;
}

int partition(int* v, int lo, int hi) {
  int pivot = v[(lo + hi)/2];

  int i = lo - 1;
  int j = hi + 1;
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

void quickSort(int* v, int lo, int hi) {
  if (hi <= lo) {
    return;
  }

  int p = partition(v, lo, hi);
  quickSort(v, lo, p);
  quickSort(v, p + 1, hi);
}

list<int> construct(const int* v, int size) {
  list<int> l;
  for (int i = 0; i < size; ++i) {
    l.push_back(v[i]);
  }

  return l;
}

void insertInOrder(list<int>& l, const int d) {
  bool inserted = false;
  for (auto i = l.begin(); i != l.end(); ++i) {
    if (*i > d) {
      l.insert(i, d);
      inserted = true;
      break;
    }
  }

  if (!inserted) {
    l.push_back(d);
  }
}

int calMinimumTotal(list<int>& l) {
  int total = 0;

  if (l.size() <= 1) {
    return total;
  }

  int first = l.front();
  l.pop_front();

  int second = l.front();
  l.pop_front();

  total = first + second;
  insertInOrder(l, total);
  total += calMinimumTotal(l);
  
  return total;
}

int minimumTotal(int* files, int numOfTotalFiles) {
  printV(files, numOfTotalFiles);

  quickSort(files, 0, numOfTotalFiles - 1);
  list<int> l = construct(files, numOfTotalFiles); 

  return calMinimumTotal(l);
}

void assertEqual(int result, int expected) {
  if (result == expected) {
    cout << "PASSED" << endl;
  } else {
    cout << "FAILED: expected " << expected << " | result " << result << endl;
  }
}

void testCase2() {
  int files[] = {4, 8, 6, 12};
  int expected = 58;
  int result = minimumTotal(files, 4);

  assertEqual(result, expected);
}

void testCase1() {
  int files[] = {4, 8, 9, 6, 12};
  int expected = 88; // (4+6) + (8+9) + (10+12) + (17+22)
  int result = minimumTotal(files, 5);

  assertEqual(result, expected);
}

int main() {
  testCase1();
  testCase2();
  return 0;
}
