#include <iostream>
#include <vector>

using namespace std;

void print(vector<int> v) {
	for (int i : v) {
		cout << i;
	}
	cout << endl;
}

class Solution {
public:
    /**
     * @param A: an integer array
     * @return: nothing
     */
    void sortIntegers2(vector<int> &A) {
        // write your code here
        int n = A.size();
        if (n <= 1) {
            return;
        }

        int t[n];
        mergeSort(A, 0, n, t);
    }

    void mergeSort(vector<int> &v, int lo, int hi, int t[]) {
        if (hi - lo <= 1) {
            return;
        }

        int mid = (lo + hi) / 2;
        mergeSort(v, lo, mid, t);
        mergeSort(v, mid, hi, t);
        merge(v, lo, mid, hi, t);
    }

    void merge(vector<int> &v, int lo, int mid, int hi, int t[]) {
        if (mid <= lo && hi <= mid) {
            return;
        }

        int i = lo;
        int j = mid;

        int indexT = lo;
        while (i < mid && j < hi) {
            if (v[i] < v[j]) {
                t[indexT++] = v[i++];
            } else {
                t[indexT++] = v[j++];
            }
        }

        while (i < mid) {
            t[indexT++] = v[i++];
        }

        while (j < hi) {
            t[indexT++] = v[j++];
        }

        for (indexT = lo; indexT < hi; indexT++) {
            v[indexT] = t[indexT];
        }
    }
};

int main(int argc, char **argv) {
	Solution s;
	vector<int> A = {3,2,1,4,5};

	print(A);
	s.sortIntegers2(A);
	print(A);
}
