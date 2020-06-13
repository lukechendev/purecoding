#include <iostream>

using namespace std;

class Base {
  public:
    Base() {
      cout << "base con" << endl;
    }

    virtual ~Base() {
      cout << "base des" << endl;
    }
};

class Derive : public Base {
  private:
    int a = 0;
  public:
    Derive(int a) {
      this->a = a;
      cout << "derive con " << this->a << endl;
    }

    ~Derive() {
      cout << "derive des" << this->a << endl;
    }
};

class DeriveB : public Base {
  public:
    DeriveB(int a) {
      cout << "derive B con " << endl;
    }

    ~DeriveB() {
      cout << "derive B des" << endl;
    }
};

int main() {
  cout << "start1" << endl;
  //DeriveB d1(1);
  //Derive d0(1);
  //cout << "start2:" << endl;
  //Derive* d1 = new Derive(2);
  //delete d1;
  Base* d2 = new Derive(3);
  delete d2;
}
