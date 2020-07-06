#include <iostream>

int main(int argc, char **argv) {
	enum Color {
		red = 1,
		green = 3,
		blue = 5
	};

	enum struct NewColor {
		red = 2,
		green = 4,
		blue = 6
	};

	enum Color2: char {
		red2 = 'r',
		green2 = 'g',
		blue2 = 'b'
	};

	std::cout << "red: " << red << std::endl;
	std::cout << "blue: " << blue << std::endl;
	std::cout << "blue + green: " << blue + green << std::endl;

	std::cout << "red2: " << red2 << std::endl;
	std::cout << "blue2: " << blue2 << std::endl;
	std::cout << "blue2 + green2: " << blue2 + green2 << std::endl;

	std::cout << "red: " << static_cast<int>(NewColor::red) << std::endl;
	std::cout << "blue: " << static_cast<int>(NewColor::blue) << std::endl;
	std::cout << "blue + green: " << static_cast<int>(NewColor::blue) + static_cast<int>(NewColor::green) << std::endl;

	NewColor newColorGreen{NewColor::green};
	std::cout << "newColorGreen: " << static_cast<int>(newColorGreen) << std::endl;

	return 0;
}
