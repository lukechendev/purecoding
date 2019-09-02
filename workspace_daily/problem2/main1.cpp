/**
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
**/

#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <cstring>

using std::ifstream;
using std::cout;
using std::vector;
using std::string;
using std::endl;
using std::strlen;

void loadData(vector<unsigned long long int>& v, const string& path) {
  ifstream ifs(path);
  unsigned long long int r;
  while (ifs >> r) {
    v.push_back(r);
  }
}

template<class T>
void printV(const T& v) {
  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    cout << *i << " ";
  }
  cout << endl;
}

template<class Tv, class To>
void product(const vector<Tv>& v, vector<To>& o) {
  To r = 1;
  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    r = r * *i;
  }

  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    o.push_back(r / *i);
  }
}

int main(int argc, char* argv[]) {
  vector<unsigned long long int> v;
  vector<unsigned long long int> o;

  string dataPath = "data1";
  if (argc > 1 && strlen(argv[1]) > 0) {
    dataPath = argv[1];
  }

  loadData(v, dataPath);
  printV(v);

  product(v, o);
  printV(o);

  return 0;
}
