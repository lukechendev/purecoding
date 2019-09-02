#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

template<class T>
int partition(T& v, size_t lo, size_t hi) {
    int pivot = v[(lo + hi) / 2];

    int i = lo - 1;
    int j = hi + 1;

    int t;
    while (true) {
        do {
            i++;
        } while (v[i] < pivot);

        do {
            j--;
        } while (v[j] > pivot);

        if (j <= i) {
            return j;
        }

        if (v[i] > v[j]) {
            t = v[i];
            v[i] = v[j];
            v[j] = t;
        }
    }
}

template<class T>
void quickSort(T& v, size_t lo, size_t hi) {
    if (hi <= lo) {
        return;
    }

    int p = partition(v, lo, hi);
    quickSort(v, lo, p);
    quickSort(v, p + 1, hi);
}

template<class T>
void sort(T& v) {
    quickSort(v, 0, v.size() - 1);
}

template<class T>
void replaceInOrder(T& v, int toRemove, int toAdd) {
    if (toRemove == toAdd) {
        // Same, no need to replace 
        return;
    }

    int iToRemove = -1;
    int iToAdd = -1;
    for (size_t i = 0; i < v.size(); ++i) {
        if (iToRemove < 0 && v[i] == toRemove) {
            iToRemove = i;
        }
        if (iToAdd < 0 && v[i] >= toAdd) {
            iToAdd = i;
        }
        if (iToRemove >= 0 && iToAdd >= 0) {
            break;
        }
    }
    if (iToAdd == -1) {
      iToAdd = v.size();
    }
    if (iToAdd == iToRemove) {
        v[iToRemove] = toAdd;
    } else if (iToAdd > iToRemove) {
        for (size_t i = iToRemove; i < iToAdd - 1; ++i) {
            v[i] = v[i + 1];
        }
        v[iToAdd - 1] = toAdd;
    } else {
        // iToAdd < iToRemove
        for (size_t i = iToRemove; i > iToAdd; --i) {
            v[i] = v[i - 1];
        }
        v[iToAdd] = toAdd;
    }
}

template<class T>
void printV(const T& v) {
  for(auto i = v.cbegin(); i != v.cend(); ++i) {
    cout << i->first << ':' << i->second << endl;
  }
  cout << endl;
}

// Complete the activityNotifications function below.
int activityNotifications(vector<int> expenditure, int d) {
    int num = 0;
    const size_t size = expenditure.size();

    // No notification if the totoal number of days is less or equal than the number of the trailing days.
    if (d >= size) {
        return 0;
    }

    int iMedian1 = 0;
    int iMedian2 = 0;
    if (d/2*2 == d) {
        // even
        iMedian1 = d/2;
        iMedian2 = iMedian1 + 1;
    } else {
        // odd
        iMedian1 = d/2 + 1;
        iMedian2 = iMedian1;
    }

    // unordered_map<size_t, int> trail(expenditure.begin(), expenditure.begin() + d);
    unordered_map<size_t, int> trail;
    int n = 0;
    for (auto i = expenditure.begin(); i != expenditure.begin() + d + 1; ++i) {
      trail[n++] = *i;
    } 

    sort(trail);

    for (int i = d; i < size; ++i) {
        if (i > d) {
            replaceInOrder(trail, expenditure[i - d - 1], expenditure[i - 1]);
        }
        int median2Times = trail[iMedian1 - 1] + trail[iMedian2 - 1];
        if (expenditure[i] >= median2Times) {
            num++;
        }
    }

    return num;
}

int main()
{
    ofstream fout("output");
    ifstream fin("data2");

    string nd_temp;
    getline(fin, nd_temp);

    vector<string> nd = split_string(nd_temp);

    int n = stoi(nd[0]);

    int d = stoi(nd[1]);

    string expenditure_temp_temp;
    getline(fin, expenditure_temp_temp);

    vector<string> expenditure_temp = split_string(expenditure_temp_temp);

    vector<int> expenditure(n);

    for (int i = 0; i < n; i++) {
        int expenditure_item = stoi(expenditure_temp[i]);

        expenditure[i] = expenditure_item;
    }

    int result = activityNotifications(expenditure, d);

    cout << result << "\n";

    fout.close();

    return 0;
}

vector<string> split_string(string input_string) {
    string::iterator new_end = unique(input_string.begin(), input_string.end(), [] (const char &x, const char &y) {
        return x == y and x == ' ';
    });

    input_string.erase(new_end, input_string.end());

    while (input_string[input_string.length() - 1] == ' ') {
        input_string.pop_back();
    }

    vector<string> splits;
    char delimiter = ' ';

    size_t i = 0;
    size_t pos = input_string.find(delimiter);

    while (pos != string::npos) {
        splits.push_back(input_string.substr(i, pos - i));

        i = pos + 1;
        pos = input_string.find(delimiter, i);
    }

    splits.push_back(input_string.substr(i, min(pos, input_string.length()) - i + 1));

    return splits;
}

