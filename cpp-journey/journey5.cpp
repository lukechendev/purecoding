/*
 * journey5.cpp
 *
 *  Created on: Jun 30, 2020
 *      Author: lchen154
 */

#include <iostream>
#include <vector>
#include <map>

using namespace std;

int checkSum(int a[]) {
	a[0] = 100;
	return a[0] + a[1] + a[2] + a[3] + a[4];
}

int main(int argc, char **argv) {
	cout << "Let's start" << endl;

	vector<int> v( { 1, 2, 3, 4, 5 });
	auto ite = v.end();
	ite--;
	cout << *ite << endl;
	auto its = v.begin();
	its += 3;
	cout << *its << endl;
	cout << "its < ite: " << (its < ite) << endl;

	map<int, int> smap;
	smap.insert( { 2, 12 });
	smap.insert( { 1, 11 });
	smap.insert( { 3, 13 });
	smap.insert( { 4, 14 });
	smap.insert( { 5, 15 });

	auto l = smap.begin();
	auto r = smap.end();
	r--;

	cout << l->first << "," << l->second << endl;
	cout << r->first << "," << r->second << endl;
	cout << "l == r" << (l == r ? "yes" : "no") << endl;
	l++;
	cout << l->first << "," << l->second << endl;
	cout << "l == r" << (l == r ? "yes" : "no") << endl;
	l++;
	cout << l->first << "," << l->second << endl;
	cout << "l == r" << (l == r ? "yes" : "no") << endl;
	l++;
	cout << l->first << "," << l->second << endl;
	cout << "l == r" << (l == r ? "yes" : "no") << endl;
	l++;
	cout << l->first << "," << l->second << endl;
	cout << "l == r" << (l == r ? "yes" : "no") << endl;

	cout << v.size() << endl;
	int a[v.size()];
	a[4] = 111;
	cout << a[4] << endl;

	a[0] = 0;
	a[1] = 1;
	a[2] = 2;
	a[3] = 3;

	int sum = checkSum(a);
	cout << sum << endl;
	cout << a[0] << endl;
}

