/*
Aug 22, 2019

45 mins

#2 Given a device with the maximum memory size, a list of foreground apps (id, memory needed) and a list of background apps (id, memory needed). Find out the pairs of a foreground app 
and a background app that have maximum (optimal) memory usage that can be loaded in the device. 

vector<pair<int, int>> getOptimalApps(int maxDeviceMem, vector<pair<int, int>> foregroundApps, vector<pair<int, int>> backgroundApps);

Input:
10, 
{{1, 3}, {2, 4}, {3, 7}, {4, 5}},
{{1, 7}, {2, 2}, {3, 6}, {4, 4}},

Output:
{{1, 1}, {2, 3}}
*/

#include <iostream>
#include <vector>
#include <utility>
#include <sstream>

#include <benchmark/benchmark.h>

using namespace std;

typedef vector<pair<int, int>> vpair;

string toString(vpair v) {
  string result;

  stringstream ss;
  ss << "{";
  for (auto i = v.cbegin(); i != v.cend(); ++i) {
    ss << "{" << get<0>(*i) << ", " << get<1>(*i) << "}, ";
  }
  long pos = ss.tellp();
  ss.seekp(pos - 2);
  ss << "}";

  return ss.str();
}

vpair getOptimalApps_op1(int maxDeviceMem, vpair& foregroundApps, vpair& backgroundApps) {
  vpair apps;
  
  int maxUsage = 0;
  for (auto i = foregroundApps.begin(); i !=  foregroundApps.end(); ++i) {
    for (auto j = backgroundApps.begin(); j != backgroundApps.end(); ++j) {
      int mem = get<1>(*i) + get<1>(*j);
      if (mem <= maxDeviceMem && mem >= maxUsage) {
	if (mem > maxUsage) {
          maxUsage = mem;
	  apps.clear();
	}
        apps.push_back(make_pair(get<0>(*i), get<0>(*j)));
      }
    }
  }
  
  return apps;
}

// O(n^2)
int partition(vpair& v, int lo, int hi) {
  int pivot = get<1>(v[(lo + hi) / 2]);

  int i = lo - 1;
  int j = hi + 1;
  while (true) {
    do {
      i++;
    } while (get<1>(v[i]) < pivot);

    do {
      j--;
    } while (get<1>(v[j]) > pivot);

    if (j <= i) {
      return j;
    }

    if (get<1>(v[j]) < get<1>(v[i])) {
      pair<int, int> t = v[i];
      v[i] = v[j];
      v[j] = t;
    }
  }
}

void quickSort(vpair& v, int lo, int hi) {
  if (hi <= lo) {
    return;
  }

  int p = partition(v, lo, hi);
  quickSort(v, lo, p);
  quickSort(v, p + 1, hi);
}

// Find the pair in the sorted list that has the maximum value below or equals to the "maxLimit" value
vpair findInApps(const int maxLimit, const vpair& v, int /*lo*/, int /*hi*/) {
  vpair apps;

  int curMax = 0;
  for (auto i = v.rbegin(); i != v.rend(); ++i) {
    int cur = get<1>(*i);
    if (cur <= maxLimit && cur >= curMax) {
      // Found one 
      curMax = cur;
      apps.push_back(*i);
      
    } else if (cur < curMax) {
      // Found the first one less than the current max, give up
      break; // Good! Saved time
    }
  }

  return apps;
}

// O(nlog(n))
vpair getOptimalApps_op2(int maxDeviceMem, vpair& foregroundApps, vpair& backgroundApps) {
  vpair apps;

  quickSort(foregroundApps, 0, foregroundApps.size() - 1);
  quickSort(backgroundApps, 0, backgroundApps.size() - 1);

  int maxUsage = 0;
  for (auto i = foregroundApps.rbegin(); i != foregroundApps.rend(); ++i) {
    int maxLimitB = maxDeviceMem - get<1>(*i);

    vpair curMaxBList = findInApps(maxLimitB, backgroundApps, 0, backgroundApps.size() - 1);
    if (curMaxBList.empty()) {
      continue;
    }

    pair<int, int> curMaxB = curMaxBList[0];
    int curMaxValue = get<1>(curMaxB) + get<1>(*i);
    if (curMaxValue >= maxUsage) {
      if (curMaxValue > maxUsage) {
        maxUsage = curMaxValue;
        apps.clear();
      }

      for (auto j = curMaxBList.begin(); j != curMaxBList.end(); ++j) {
        apps.push_back(make_pair(get<0>(*i), get<0>(*j)));
      }
    }
  }
  
  return apps;
}

void ASSERT_EQ(vpair result, vpair expected) {
  quickSort(result, 0, result.size() - 1);
  quickSort(expected, 0, expected.size() - 1);
  if (result == expected) {
    cout << "PASSED" << endl;
  } else {
    cout << "FAILED " << "expected: " << toString(expected) << " but got " << toString(result) << endl;
  }
}

void test1_op1() {
  const int deviceMem = 10;
  vpair foregroundApps = {{1, 3}, {2, 4}, {3, 7}, {4, 5}};
  vpair backgroundApps = {{1, 7}, {2, 2}, {3, 6}, {4, 4}};
  vpair expected = {{1, 1}, {2, 3}};

  vpair result = getOptimalApps_op1(deviceMem, foregroundApps, backgroundApps);

  ASSERT_EQ(result, expected);
}

void test1_op2() {
  const int deviceMem = 10;
  vpair foregroundApps = {{1, 3}, {2, 4}, {3, 7}, {4, 5}};
  vpair backgroundApps = {{1, 7}, {2, 2}, {3, 6}, {4, 4}};
  vpair expected = {{1, 1}, {2, 3}};

  vpair result = getOptimalApps_op2(deviceMem, foregroundApps, backgroundApps);

  ASSERT_EQ(result, expected);
}

void test2_op1() {
  const int deviceMem = 20;
  vpair foregroundApps = {{1, 3}, {2, 4}, {3, 7}, {4, 5}, {5, 9}, {6, 2}, {7, 8}, {9, 11}, {10, 18}};
  vpair backgroundApps = {{1, 7}, {2, 2}, {3, 6}, {4, 4}, {6, 1}, {7, 12}, {8, 2}, {9, 3}, {10, 11}};

  vpair result = getOptimalApps_op1(deviceMem, foregroundApps, backgroundApps);

  //vpair expected = {{5, 10}, {7, 7}, {10, 2}, {10, 8}};
  //ASSERT_EQ(result, expected);
}

void test2_op2() {
  const int deviceMem = 20;
  vpair foregroundApps = {{1, 3}, {2, 4}, {3, 7}, {4, 5}, {5, 9}, {6, 2}, {7, 8}, {9, 11}, {10, 18}};
  vpair backgroundApps = {{1, 7}, {2, 2}, {3, 6}, {4, 4}, {6, 1}, {7, 12}, {8, 2}, {9, 3}, {10, 11}};

  vpair result = getOptimalApps_op2(deviceMem, foregroundApps, backgroundApps);

  //vpair expected = {{5, 10}, {7, 7}, {10, 2}, {10, 8}};
  //ASSERT_EQ(result, expected);
}

static void BM_OPTION1(benchmark::State& state) {
  for (auto _ : state) {
    test2_op1();
  }
}
BENCHMARK(BM_OPTION1);

static void BM_OPTION2(benchmark::State& state) {
  for (auto _ : state) {
    test2_op2();
  }
}
BENCHMARK(BM_OPTION2);

BENCHMARK_MAIN();

/*
int main() {
  test1_op1();
  test1_op2();

  test2_op1();
  test2_op2();
  return 0;
}

*/
