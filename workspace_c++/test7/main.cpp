#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


template<typename T>
void printV(T& t) {
  for (auto i = t.cbegin(); i != t.cend(); ++i) {
    cout << *i << ' ';
  }
  cout << endl;
}

bool compare(int a, int b) {
  // sort in the descending order
  if (a > b) {
    return true;
  } else {
    return false;
  }
}

int main() {
  vector<int> v = {32, 1, 3, 33, 0, 24};
  printV(v);
  sort(v.begin(), v.end(), compare);
  printV(v);
}
