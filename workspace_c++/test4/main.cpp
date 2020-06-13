#include <iostream>
#include <limits.h>

using namespace std;

constexpr unsigned long long int productRecur(unsigned long long int a) {
  unsigned long long int r = 1;
  for (int i = 0; i < a; i++) {
    r = r + a;
  }
  return r;
}

constexpr int productRecurIntC(int a) {
  int r = 0;
  for (int i = 0; i < a; i++) {
    r = r + a;
  }
  return r;
}

int productRecurInt(int a) {
  int r = 0;
  for (int i = 0; i < a; i++) {
    r = r + a;
  }
  return r;
}

// test with constexpr
void test1() {
  // const unsigned long long int r = 40000000001;
  // const unsigned long long int r = productRecur(20000000);
  const int r = productRecurInt(20);
  cout << r << endl;
}

void printA(int* a) {
  cout << a[0] << endl;
  cout << sizeof(a)/sizeof(int) << endl;
}

void test2() {
  int a[] = {1, 2, 3, 4, 5, 6};
  cout << a[0] << endl;
  cout << sizeof(a)/sizeof(int) << endl;
  printA(a);
}

void test3() {
  cout << sizeof(int) << endl;
  cout << sizeof(int*) << endl;
  cout << CHAR_BIT << endl;
  cout << INT_MAX << endl;
  cout << INT_MIN << endl;
  int* x = (int*) 0xFFFFFFFFFFFFFFFF;
}

int main() {
  test3();

  return 0;
}
