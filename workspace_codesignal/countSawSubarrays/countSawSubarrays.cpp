#include <initializer_list>
#include <iostream>
#include <unordered_map>
#include <utility>
#include <vector>

using namespace std;

/**
 * Given an integer array with integers go up and down.
 * A saw subarray means it goes up and down and up and down.
 * With minimum subarray length = 2, return the total number of saw subarrays.
 *
 * [1,2,1,2,1]
 * return 10
 *
 * [1,2,3,4,5]
 * return 4
 */

typedef std::pair<int, int> range;

struct range_hash {
    template<class T1, class T2>
    std::size_t operator()(const std::pair<T1, T2> &pair) const {
        return std::hash<T1>()(pair.first) ^ std::hash<T2>()(pair.second);
    }
};

long long getSawSubArrays(std::vector<int> arr) {
    int n = arr.size();

    if (n <= 1) {
        return 0;
    }

    long long count = 0;

    std::unordered_map<range, int, range_hash> map;

    int start = 0;
    int end = 0;
    while (start <= n - 2) {
        int k = 2;

        while (start + k <= n) {
            end = start + k;
            range key(start, end - 1);
            auto search = map.find(key);

            int trend = 0;
            if (search != map.end()) {
                int t = search->second;
                if (t == 1 && arr[end - 1] < arr[end - 2]) {
                    trend = -1;
                } else if (t == -1 && arr[end - 1] > arr[end - 2]) {
                    trend = 1;
                } else {
                    // Not a saw subarray and no worth to proceed
                    break;
                }
            } else {
                // A totally new subarray
                if (arr[start] < arr[start + 1]) {
                    trend = 1;
                } else if (arr[start] > arr[start + 1]) {
                    trend = -1;
                } else {
                    // Not a saw subarray and no worth to proceed
                    break;
                }

                for (int i = start + 2; i < end; ++i) {
                    if (trend == 1 && arr[i] < arr[i - 1]) {
                        trend = -1;
                    } else if (trend == -1 && arr[i] > arr[i - 1]) {
                        trend = 1;
                    } else {
                        // Not a saw subarray and no worth to proceed
                        break;
                    }
                }
            }

            // a valid saw subarray
            count++;
            map.insert( { range(start, end), trend });
            k++;
        }
        start++;
    }

    return count;
}

int main(int argc, char **argv) {
    std::vector<int> arr = { 1, 2, 1, 2, 1 };
    int expected = 10;
    if (expected == getSawSubArrays(arr)) {
        cout << "passed" << endl;
    } else {
        cout << "failed" << endl;
    }

    arr = { 1, 2, 3, 4, 5 };
    expected = 4;
    if (expected == getSawSubArrays(arr)) {
        cout << "passed" << endl;
    } else {
        cout << "failed" << endl;
    }

    arr = { 3, 2, 1 };
    expected = 2;
    if (expected == getSawSubArrays(arr)) {
        cout << "passed" << endl;
    } else {
        cout << "failed" << endl;
    }

    arr = { };
    expected = 0;
    if (expected == getSawSubArrays(arr)) {
        cout << "passed" << endl;
    } else {
        cout << "failed" << endl;
    }

    arr = { 2, 2, 2, 2, 2 };
    expected = 0;
    if (expected == getSawSubArrays(arr)) {
        cout << "passed" << endl;
    } else {
        cout << "failed" << endl;
    }

    return 0;
}
