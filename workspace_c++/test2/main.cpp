#include <vector>
#include <iostream>
using namespace std;

size_t partition(vector<int>& v, size_t lo, size_t hi) {
    int pivot = v[(lo + hi) / 2];
    size_t i = lo - 1;
    size_t j = hi + 1;

    while (true) {
        do {
            i++;
        } while (v[i] < pivot);

        do {
            j--;
        } while (v[j] > pivot);

        if (i >= j) {
            return j;
        }

        // swap i and j
        int t = v[i];
        v[i] = v[j];
        v[j] = t;
    }
}

void quickSort(vector<int>& v, size_t lo, size_t hi) {
    if (lo >= hi) {
        return;
    }

    size_t p = partition(v, lo, hi);
    quickSort(v, lo, p);
    quickSort(v, p + 1, hi);
}

void test1() {
    vector<int> testData[] = {
        {32, 24, 2, 1, 3, 9, 21, 121, 3, 1, 33},
        {32, 233, 342, 2 ,3232, 23, 33, 22, 1, 20},
        {1, 2, 3, 4, 5, 6, 7, 8, 8, 8}
    };

    int num = sizeof(testData) / sizeof(testData[0]);
    for (int i = 0; i < num; i++) {
        quickSort(testData[i], 0, testData[i].size() - 1);
        for (auto j = testData[i].begin(); j != testData[i].end(); j++) {
            cout << *j << ' ';
        }
        cout << endl;
    }

    for (auto v: testData) {
        for (auto i : v) {
            cout << i << ' ';
        }
        cout << endl;
    }
}

int main() {
    test1();

    return 0;
}
