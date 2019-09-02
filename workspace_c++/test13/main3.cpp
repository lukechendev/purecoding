#include <iostream>
#include <sstream>
#include <fstream>
#include <vector>

using namespace std;

struct ST {
  int v;
  int c;
  ST(int v, int c) {
    this->v = v;
    this->c = c;
  }
};

void printV(const vector<ST>& v, size_t lo, size_t hi) {
  for (size_t i = 0; i < v.size(); ++i) {
    stringstream ss;
    if (i >= lo && i < hi) {
      ss << "printf '\e[38;5;196m " << v[i].v << " '";
    } else {
      ss << "printf '\e[38;5;255m " << v[i].v << " '";
    }
    system(ss.str().c_str());
  }
  cout << endl;
}

void merge(vector<ST>& v, size_t lo, size_t mid, size_t hi, long& count) {
    //printV(v, lo, hi);
    if (mid <= lo && hi <= mid) {
        return;
    }

    size_t i = lo;
    size_t j = mid;
    vector<ST> t;

    while (i < mid && j < hi) {
        if (v[j].v < v[i].v) {
            int delta = j - lo - t.size();
	    v[j].c = v[j].c + delta;
	    if (v[j].c > 2) {
              count = -1;
	      return;
	    }
	    count += delta;
            t.push_back(v[j++]);
        } else {
            t.push_back(v[i++]);
        }
    }

    while (i < mid) {
        t.push_back(v[i++]);
    }

    while (j < hi) {
        int delta = j - lo - t.size();
	v[j].c = v[j].c + delta;
	if (v[j].c > 2) {
	  count = -1;
	  return;
	}
        count += delta;
        t.push_back(v[j++]);
    }

    size_t tsize = t.size();
    for (int i = 0; i < tsize; ++i) {
        v[lo + i] = t[i];
    }
    //printV(v, lo, hi);
}

void mergeSort(vector<ST>& v, size_t lo, size_t hi, long& count) {
    if (hi - lo <= 1) {
        return;
    }

    size_t mid = (lo + hi) / 2;
    mergeSort(v, lo, mid, count);
    mergeSort(v, mid, hi, count);
    merge(v, lo, mid, hi, count);
}

long resolveBribes(const vector<int>& v) {
    long count = 0;
    vector<ST> stv;
    for (auto i = v.cbegin(); i != v.cend(); ++i) {
      stv.push_back(ST(*i, 0));
    }
    
    mergeSort(stv, 0, stv.size(), count);
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
  ifstream ifs("data1");
  while(!ifs.eof()) {
    int t;
    ifs >> t;
    v.push_back(t);
  }
}

int main() {
  //vector<int> v = {2, 5, 1, 3, 4};
  //vector<int> v = {2, 1, 5, 3, 4};
  //vector<int> v = {5,1,2,3,7,8,6,4};
  //vector<int> v = {1,2,5,3,7,8,6,4};
  vector<int> v;
  readData(v);
  minimumBribes(v);
}
