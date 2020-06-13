#include <iostream>

using namespace std;

int recur2(int n) {
  cout << "recur2(" << n << ")" << endl;
  if (n > 100) {
    return n - 10;
  } else {
    int r = recur2(n + 11);
    return recur2(r);
  }
}

int recur(int n) {
  cout << "recur(" << n << ")" << endl;
  if (n > 100) {
    return n - 10;
  } else {
    return recur(recur(n + 11));
  }
}

int main() {
  cout << recur2(95) << endl;
}
