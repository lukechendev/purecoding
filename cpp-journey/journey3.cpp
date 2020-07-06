#include <iostream>

int addOne(int& x) {
	x += 1;
	return x;
}

struct X {
	int data;
};

int main(int argc, char **argv) {
	int* a = nullptr;
//	std::cout << *a << std::endl;

	a = new int(1);
	std::cout << *a << std::endl;

	int* bp = nullptr;
	bool b = bp;
	std::cout << "b: " << b << std::endl;

	if (bp) {
		std::cout << "passed" << std::endl;
	} else {
		std::cout << "failed" << std::endl;
	}

	auto val = 5;
	std::cout << "&val: " << &val << std::endl;
	if (bp < &val) {
		std::cout << "passed" << std::endl;
	}

    int (*func1)(int&) = addOne;
    int ret = func1(val);
    std::cout << "ret: " << ret << std::endl;
    std::cout << "val: " << val << std::endl;



    int X::*p = &X::data;

    X* objptr = new X;
    objptr->*p = 2014;

    std::cout << "objptr->*p: " << objptr->*p << std::endl;
    std::cout << "objptr->data: " << objptr->data << std::endl;

    X* objptr2 = new X;
	objptr2->*p = 2020;

	std::cout << "objptr2->*p: " << objptr2->*p << std::endl;
	std::cout << "objptr2->data: " << objptr2->data << std::endl;


	// **** reference
	int aa = 1;
	int& aar = aa;
	int& aar2 = aar;

	std::cout << aa << std::endl;
	std::cout << aar << std::endl;
	std::cout << aar2 << std::endl;

	int bb = 2;
	int& bbr = bb;
	aar = bb; // changed the value but not reference
	aar2 = bbr; // changed the value but not reference
	std::cout << aa << std::endl;
	std::cout << aar << std::endl;
	std::cout << aar2 << std::endl;

	return 0;
}
