/*
 * valid-palindrome.cpp
 *
 *  Created on: Jul 16, 2020
 *      Author: lchen
 *
 * https://leetcode.com/problems/valid-palindrome/
 */

#include <string>
#include <iostream>

using namespace std;

class Solution {
public:
	bool isPalindrome(string s) {
		// write your code here
		int n = s.size();

		if (n <= 1) {
			return true;
		}

		int l = 0;
		int r = n - 1;

		while (l < r) {
			while (l < r && !isValid(s[l])) {
				l++;
			}

			while (l < r && !isValid(s[r])) {
				r--;
			}

			if (l < r && !isEqual(s[l], s[r])) {
				return false;
			}

			l++;
			r--;
		}

		return true;
	}

	bool isEqual(char c1, char c2) {
		if (c1 >= 'A' && c1 <= 'Z') {
			c1 = c1 - 'A' + 'a';
		}

		if (c2 >= 'A' && c2 <= 'Z') {
			c2 = c2 - 'A' + 'a';
		}

		return c1 == c2;
	}

	bool isValid(const char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
				|| (c >= '0' && c <= '9');
	}
};

int main(int argc, char **argv) {
	cout << "Valid Palindrome" << endl;

	Solution s;
	cout << "aba: " << (s.isPalindrome("aba") ? "yes" : "no") << endl;
	cout << "abac: " << (s.isPalindrome("abac") ? "yes" : "no") << endl;
	cout << "aba23323: " << (s.isPalindrome("aba23323") ? "yes" : "no") << endl;
	cout << "^&*%*&%*&*a&(&(*a . : " << (s.isPalindrome("^&*%*&%*&*a&(&(*a . ") ? "yes" : "no") << endl;
}
