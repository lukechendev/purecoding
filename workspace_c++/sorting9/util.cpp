#include <iostream>
#include <fstream>

#include "util.h"

using std::ifstream;
using std::cout;
using std::endl;

void Util::readData(vector<int>& v, const string& path) {
  ifstream ifs(path);

  int r;
  while (ifs >> r) {
    v.push_back(r);
  }
}

void Util::printV(const vector<int>& v, const string& msg) {
  cout << msg << endl;
  for (auto i : v) {
    cout << i << " ";
  }
  cout << endl;
  cout << endl;
}
