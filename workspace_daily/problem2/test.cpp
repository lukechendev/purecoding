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
#include <climits>

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

template<class Tv>
void product(const vector<Tv>& v) {
  unsigned long long int r = 1;
  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    r = r * *i;
    cout << "* " << *i << "= " << r << endl;
  }
  cout << " / " << r / 7 << endl;
}

int main(int argc, char* argv[]) {
  vector<unsigned long long int> v;

  string dataPath = "data1";
  if (argc > 1 && strlen(argv[1]) > 0) {
    dataPath = argv[1];
  }

  loadData(v, dataPath);
  printV(v);

  // product(v);
  
/*
  unsigned long long int m = (unsigned long long int) 4284893570466316288U;
  unsigned long long int n = (unsigned long long int) 11547510919554662400U;
  unsigned long long int ret = (unsigned long long int) m * 7;
  unsigned long long int ret2 = (unsigned long long int) n / 7;
  cout << ret << endl;
  cout << ret2 << endl;
  
  cout << m * 7 / 7 << endl;
  cout << ULLONG_MAX << endl;

  cout << (unsigned long long int) (12627350085286494208U * 4) << endl;
  if (12627350085286494208U < ULLONG_MAX) {
    cout << "yes" << endl;
  }
  if (12627350085286494208U * 4 < ULLONG_MAX) {
    cout << "yes" << endl;
  }


  // 1649644417079237485


*/
  unsigned long long int m = (unsigned long long int) 4284893570466316288U;
  for (int i = 1; i <= 7; ++i) {
    cout << "* " << i << " = " << m * i << endl;
    cout << "- " << i << " = " << ULLONG_MAX - m * i << endl;
  }
  return 0;
}
