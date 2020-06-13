#include <iostream>
#include <vector>

using namespace std;

void quickSort(vector<int> v, size_t lo, size_t hi) {
}

void printV(const vector<int>& v) {
  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    cout << *i << " ";
  }
  cout << endl;
}

int main() {
  vector<int> a = {32, 1, 3, 99, 223, 1, 9, 9, 23, 1334, 9193, 9, 38, 7, 123, 321, 222, -38822, 0};
  printV(a);
  quickSort(a, 0, a.size() - 1);
  printV(a);
}
