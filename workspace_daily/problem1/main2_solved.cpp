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

bool addUpTo(const vector<int>& v, int k) {
  unordered_set<int> s;
  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    int r = k - *i;
    auto search = s.find(r);
    if (search != s.end()) {
      // found
      cout << k << " = " << *i << " + " << r << endl;
      return true;
    }
    s.insert(*i);
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
