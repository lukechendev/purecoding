#ifndef UTIL_H
#define UTIL_H

#include <string>
#include <vector>

using std::string;
using std::vector;

class Util {
  public:
    static void readData(vector<int>& v, const string& path);
    static void printV(const vector<int>& v, const string& msg);
    static void median(const vector<int>& v, const int lo, const int hi);
};

#endif
