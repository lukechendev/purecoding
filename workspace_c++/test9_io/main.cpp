#include <fstream>
#include <iostream>

using namespace std;

class Anataka {
  public:
    int creation;
    string name;
    int numCal;
    double amountQi;

    friend ostream& operator<<(ostream &ofs, Anataka &a);
};

ostream& operator<<(ostream &ofs, Anataka &a) {
  ofs << a.name << endl << a.creation << endl << a.numCal << ':' << a.amountQi << endl << endl;
  return ofs;
}

int main() {
  Anataka a1;
  a1.creation = 1222;
  a1.name = "anacika 1222";
  a1.numCal = 23223;
  a1.amountQi = 3233.44442;

  ofstream ofs("output", ofstream::trunc);
  ofs << a1;
  ofs.close();

  cout << a1;
}
