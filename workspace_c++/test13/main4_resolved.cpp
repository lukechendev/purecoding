#include <iostream>
#include <sstream>
#include <fstream>
#include <vector>
#include <climits>

using namespace std;

long resolveBribes(const vector<int>& v) {
    long count = 0;

    // Stores the previous min 3 from min, mid to max
    vector<int> mins = {INT_MAX, INT_MAX, INT_MAX};
    size_t msize = 3;
    size_t vsize = v.size();

    for (size_t i = vsize - 1; i < vsize; --i) {
      int tc = 0;

      for (size_t j = 0; j < msize; ++j) {
        if (v[i] < mins[j]) {
          int tp = v[i];
          int tex;
          for (size_t m = j; m < msize; ++m) {
            tex = mins[m];
            mins[m] = tp;
            tp = tex;
          }
          break;

        } else if (v[i] > mins[j]) {
          tc++;
        }
      }

      if (tc > 2) {
        count = -1;
        break;
      } else {
        count += tc;
      }
    }

    return count;
}

void minimumBribes(vector<int> q) {
  long count = resolveBribes(q);
  if (count < 0) {
      cout << "Too chaotic" << endl;
  } else {
      cout << count << endl;
  }
}

void readData(vector<int>& v) {
  ifstream ifs("data1", ifstream::in);
  int t;
  while(ifs >> t) {
    v.push_back(t);
  }
}

int main() {
  //vector<int> v = {2, 5, 1, 3, 4};
  //vector<int> v = {2, 1, 5, 3, 4};
  //vector<int> v = {5,1,2,3,7,8,6,4};
  //vector<int> v = {1,2,5,3,7,8,6,4};
  // vector<int> v = {2, 1, 5, 4, 3};
  vector<int> v;
  readData(v);
  minimumBribes(v);
}
