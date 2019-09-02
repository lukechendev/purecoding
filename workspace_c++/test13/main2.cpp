#include <iostream>
#include <sstream>
#include <fstream>
#include <vector>
#include <limits.h>

using namespace std;

void minimumBribes(vector<int> q) {
  int count = 0 ;

  //always keep track of min three vlaues observed
  //Compare currently seeing value with this three values.
  int midOfThree = INT_MAX;
  int maxOfThree = INT_MAX;
  int minOfThree = INT_MAX;
  
  //iterating from left to right
  size_t qsize = q.size();
  for(int i=qsize - 1 ; i >= 0 ; i--){
      //person has no way to move more than two positions -> wrong
      if((q[i]-i) > 3 ) {
	  cout << "Too chaotic";
	  return;
      }
      else{
	  //means current value has passed at least 3 values -> wrong
	  if(q[i] > maxOfThree){
	       cout << "Too chaotic";
	       return;
	  }
	  else if(q[i] > midOfThree){ //means -> current value has bribed 2 ppl
	      count=count+2;
	  }
	  else if(q[i] > minOfThree){ //means-> current value has bribed 1 person.
	      count=count+1;
	  }
	  
	  //Now adjust minThree values comparing, taking the current vlaue to account
	  if(q[i]<minOfThree){
	      maxOfThree=midOfThree;
	      midOfThree=minOfThree;
	      minOfThree = q[i];
	  }
	  else if(q[i]<midOfThree){
	      maxOfThree=midOfThree;
	      midOfThree = q[i];
	  }
	  else if(q[i]<maxOfThree){
	      maxOfThree = q[i];
	  }
      }
  }
  cout << count << endl;
}

void readData(vector<int>& v) {
  ifstream ifs("data1");
  while(!ifs.eof()) {
    int t;
    ifs >> t;
    v.push_back(t);
  }
}

int main() {
  //vector<int> v = {2, 5, 1, 3, 4};
  //vector<int> v = {2, 1, 5, 3, 4};
  //vector<int> v = {5,1,2,3,7,8,6,4};
  //vector<int> v = {1,2,5,3,7,8,6,4};
  vector<int> v;
  readData(v);
  minimumBribes(v);
}
