/*
https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

Tree: Height of a Binary Tree

The height of a binary tree is the number of edges between the tree's root and its furthest leaf. For example, the following binary tree is of height :

image 
Function Description

Complete the getHeight or height function in the editor. It must return the height of a binary tree as an integer.

getHeight or height has the following parameter(s):

root: a reference to the root of a binary tree.
Note -The Height of binary tree with single node is taken as zero.

Input Format

The first line contains an integer , the number of nodes in the tree. 
Next line contains  space separated integer where th integer denotes node[i].data.

Note: Node values are inserted into a binary search tree before a reference to the tree's root node is passed to your function. In a binary search tree, all nodes on the left branch of a node are less than the node value. All values on the right branch are greater than the node value.

Constraints
1 <= node.data[i] <= 20
1 <= n <= 20 

Output Format
Your function should return a single integer denoting the height of the binary tree.

Input example
7
3 2 1 5 4 6 7

Output example
3
*/

#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

struct WidthInfo {
  int width = 0;
  int leftWidth = 0;
  int rightWidth = 0;
};

struct Node {
  int data;
  Node* left;
  Node* right;
  int index; // Horizontal distance to root, root is 0, root->left is -1 and root->right is 1, etc.

  Node(const int data, const int index) {
    this->data = data;
    this->index = index;
    left = nullptr;
    right = nullptr;
  }
};

struct Tree {
  Node* root = nullptr;
  WidthInfo widthInfo;

  Node* insert(Node* root, const int data, const int index) {
    if (root == nullptr) {
      if (widthInfo.leftWidth > index) {
	widthInfo.leftWidth = index;
      }
      if (widthInfo.rightWidth < index) {
	widthInfo.rightWidth = index;
      }

      return new Node(data, index);
    }

    Node* child = nullptr;
    if (data < root->data) {
      child = insert(root->left, data, index - 1);
      root->left = child;
    } else {
      child = insert(root->right, data, index + 1);
      root->right = child;
    }

    return root;
  }
};

Tree* readData(const string path) {
  Tree* tree = new Tree();

  ifstream ifs(path);
  int n = 0;
  ifs >> n;

  int d = 0;
  while(n-- > 0) {
    ifs >> d;
    tree->root = tree->insert(tree->root, d, 0);
  }
  tree->widthInfo.width = (tree->widthInfo.rightWidth - tree->widthInfo.leftWidth) * 2 + 1;

  return tree;
}

void printTree(const Node* root) {
  if (root == nullptr) {
    return;
  }

  printTree(root->left);
  cout << root->data << " ";
  printTree(root->right);
}

void printTree(const Tree* tree) {
  if (tree == nullptr) {
    return;
  }

  printTree(tree->root);
}

void drawNodes(const vector<const Node*> nodes, const WidthInfo& widthInfo) {
  if (nodes.size() == 0) {
    return;
  }

  int lMargin = (nodes[0]->index - widthInfo.leftWidth) * 2;
  while (lMargin-- > 0) {
    cout << " ";
  }

  vector<const Node*> children;
  for (auto i = nodes.cbegin(); i != nodes.cend(); ++i) {
    if (i != nodes.cbegin()) {
      int lMargin = ((*i)->index - (*(i-1))->index) * 2 - 1;
      while (lMargin-- > 0) {
	cout << " ";
      }
    }
    cout << (*i)->data;

    if ((*i)->left != nullptr) {
      children.push_back((*i)->left);
    }

    if ((*i)->right != nullptr) {
      children.push_back((*i)->right);
    }
  }
  cout << endl;

  drawNodes(children, widthInfo);
}

void drawTree(const Tree* tree) {
  if (tree == nullptr) {
    return;
  }

  vector<const Node*> nodes;
  nodes.push_back(tree->root);
  drawNodes(nodes, tree->widthInfo);
}

int height(Node* root, int curHeight, int maxHeight) {
  if (root == nullptr) {
    return maxHeight;
  }

  if (maxHeight < curHeight) {
    maxHeight = curHeight;
  }

  int leftMaxHeight = height(root->left, curHeight + 1, maxHeight);
  int rightMaxHeight = height(root->right, curHeight + 1, maxHeight);
  
  if (maxHeight < leftMaxHeight) {
    maxHeight = leftMaxHeight;
  }

  if (maxHeight < rightMaxHeight) {
    maxHeight = rightMaxHeight;
  }

  return maxHeight;
}

int height(Node* root) {
  return height(root, 0, 0);
}

int main(int /*argc*/, char* /*argv*/[]) {
  string path;

  getline(cin, path);
  if (path.empty()) {
    path = "data";
  }

  Tree* tree = readData(path); 
  printTree(tree);
  cout << endl;

  drawTree(tree);
  cout << endl;

  const int h= height(tree->root);
  cout << "Tree height: " << h << endl;

  return 0;
}
