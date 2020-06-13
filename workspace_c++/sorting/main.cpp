#include <iostream>
#include <vector>

using namespace std;

int partition(int a[], int lo, int hi) {
    int pivot = a[(lo + hi) / 2];

    int i = lo - 1;
    int j = hi + 1;

    while (true) {
        do {
            i++;
        } while (a[i] < pivot);

        do {
            j--;
        } while (a[j] > pivot);

        if (j <= i) {
            return j;
        }

        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

void quickSort(int a[], int lo, int hi) {
    if (lo >= hi) {
        return;
    }

    int p = partition(a, lo, hi);
    quickSort(a, lo, p);
    quickSort(a, p + 1, hi);
}

void print(int a[], int n) {
    for (int i = 0; i < n; ++i) {
        cout << a[i] << ' ';
    }
    cout << endl;
}

void testQuickSort() {
    int a[] = {3, 22, 9, 22, 38, 99, 13, 0, 38};
    const int n = sizeof(a)/sizeof(int);

    print(a, n);
    quickSort(a, 0, n - 1);
    print(a, n);
}

void print(int a[], int lo, int hi) {
    for (int i = lo; i < hi; ++i) {
        cout << a[i] << ' ';
    }
    cout << endl;
}

void merge(int a[], int lo, int mid, int hi) {
    if (mid - lo <= 0 && hi - mid <= 0) {
        return;
    }

    int li = lo;
    int ri = mid;
    vector<int> v;
    while (mid - li > 0 && hi - ri > 0) {
        if (a[li] < a[ri]) {
            v.push_back(a[li++]);
        } else {
            v.push_back(a[ri++]);
        }
    }

    while (mid - li > 0) {
        v.push_back(a[li++]);
    }

    while (hi - ri > 0) {
        v.push_back(a[ri++]);
    }

    for (size_t i = 0; i < v.size(); ++i) {
        a[lo + i] = v[i];
    }
}

void mergeSort(int a[], int lo, int hi) {
    if (hi - lo <= 1) {
        return;
    }

    const int mid = (lo + hi) / 2;
    mergeSort(a, lo, mid);
    mergeSort(a, mid, hi);

    merge(a, lo, mid, hi);
}

void testMergeSort() {
    int a[] = {22, 33, 22, 44, 2, 1, 33, 99, 0, 78, 27, 34, 100, 3, 17}; // 15
    int n = sizeof(a)/sizeof(int);

    print(a, n);
    mergeSort(a, 0, n);
    print(a, n);
}

int main() {
    testQuickSort();
    testMergeSort();
}
