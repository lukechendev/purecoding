#include <iostream>
#include <vector>

using namespace std;

class Test {
public:
  Test() {
    cout << "Test()" << endl;
  }

  Test(const Test&) {
    cout << "Test(const Test&)" << endl;
  }


  Test(Test&&) {
    cout << "Test(&&)" << endl;
  }

  ~Test() {
    cout << "~Test" << endl;
  }

};

int main() {
  vector<Test> v;
  v.reserve(10);
  Test t0;

  // v.push_back(t0);

  // v.push_back(move(t0));

  v.push_back(Test{});

  return 0;
}
