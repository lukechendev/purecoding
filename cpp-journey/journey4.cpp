/*
 * journey4.cpp
 *
 *  Created on: Mar 21, 2020
 *      Author: lchen154
 */

#include <iostream>

struct T1 {
	int m; // not ok
public:
	T1() {}
};

int ng;

class Taste {
public:
	void checkTaste(bool good) {
		const bool isGood = good;

		std::cout << "is good? " << isGood << std::endl;
	}
};

int main(int argc, char** argv) {
	auto myInt{2011};

	std::cout << myInt << std::endl;

	auto myDouble{1.0};
	std::cout << myDouble << std::endl;

	auto myInt2= {2012};
//	std::cout << myInt2 << std::endl; // error: no match for ‘operator<<’ (operand types are ‘std::ostream {aka std::basic_ostream<char>}’ and ‘std::initializer_list<int>’) std::cout << myInt2 << std::endl;

	int nl; // not ok
	auto nla = 0; // ok
	T1 t1;
	auto t1a = T1();

	std::cout << "::ng " << ::ng << std::endl;
	std::cout << "nl " << nl << std::endl;
	std::cout << "t1.m " << t1.m << std::endl;
	std::cout << "nla " << nla << std::endl;
	std::cout << "t1a.m " << t1a.m << std::endl;
	std::cout << "is good? " << std::endl;

	Taste taste;
	taste.checkTaste(true);
	taste.checkTaste(false);

	return 0;
}


