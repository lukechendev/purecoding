#include <iostream>
#include <vector>

#include "util.h"
#include "sorting.h"

int main(int /* argc */, char* /* argv */ []) {
  vector<int> v;
  Util::readData(v, "data1");
  Util::printV(v, "origin");

  vector<int> v1(v);
  Sorting::quickSort(v1, 0, v1.size() - 1);
  Util::printV(v1, "quick sort");

  vector<int> v2(v);
  Sorting::mergeSort(v2, 0, v2.size());
  Util::printV(v2, "merge sort");

  vector<int> v3(v);
  Sorting::bubbleSort(v3);
  Util::printV(v3, "bubbleSort");

  return 0;
}
