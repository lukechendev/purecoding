/*
Balanced Brackets

https://www.hackerrank.com/challenges/balanced-brackets

A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.

Function Description

Complete the function isBalanced in the editor below. It must return a string: YES if the sequence is balanced or NO if it is not.

isBalanced has the following parameter(s):

s: a string of brackets
Input Format

The first line contains a single integer , the number of strings. 
Each of the next  lines contains a single string , a sequence of brackets.

Constraints

, where  is the length of the sequence.
All chracters in the sequences ∈ { {, }, (, ), [, ] }.
Output Format

For each string, return YES or NO.

Sample Input

3
{[()]}
{[(])}
{{[[(())]]}}
Sample Output

YES
NO
YES
Explanation

The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
*/

#include <limits>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <stack>

using namespace std;

static const string lb = "{[(";
static const string rb = "}])";

string isBalanced(const string& s) {
  stack<char> cache;
  for (auto c : s) {
    if (lb.find(c) != string::npos) {

      // Always stack left bracket
      cache.push(c);

    } else {

      size_t ir = rb.find(c);
      if (ir != string::npos && !cache.empty()) {
        char t = cache.top();
        if (lb[ir] != t) {
          // No matching to the right bracket
          return "NO";
        } else {
          // Matched, close and remove it from stack
          cache.pop();
          continue;
        }
        
      } else {
        // Unexpected char, or
        // Nothing to match the right bracket
        return "NO";
      }

    }
  }

  if (cache.empty()) {
    return "YES";	
  } else {
    return "NO";
  }
}

void readData(vector<string>& v, const string& path) {
  ifstream ifs(path);

  int n = 0;
  ifs >> n;

  ifs.ignore(numeric_limits<streamsize>::max(), '\n');

  string s;
  while (n-- > 0) {
    getline(ifs, s);
    v.push_back(s);
  }
}

int main() {
  string path;
  getline(cin, path);

  if (path.empty()) {
    path = "data";
  }

  vector<string> v;
  readData(v, path);

  for (auto i : v) {
    cout << isBalanced(i) << endl;
  }
}
