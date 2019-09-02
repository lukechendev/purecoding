/*
Tree: Level Order Traversal

https://www.hackerrank.com/challenges/tree-level-order-traversal

You are given a pointer to the root of a binary tree. You need to print the level order traversal of this tree. In level order traversal, we visit the nodes level by level from left to right. You only have to complete the function. For example:

     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4  
For the above tree, the level order traversal is 1 -> 2 -> 5 -> 3 -> 6 -> 4.

Input Format

You are given a function,

void levelOrder(Node * root) {

}
Constraints

1 Nodes in the tree  500

Output Format

Print the values in a single line separated by a space.

Sample Input

     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4  
Sample Output

1 2 5 3 6 4

Explanation

We need to print the nodes level by level. We process each level from left to right. 
Level Order Traversal: 1 -> 2 -> 5 -> 3 -> 6 -> 4.
*/

#include <iostream>
#include <fstream>
#include <string>
#include <queue>

using namespace std;

class Node {
  public:
    int data;
    Node* left;
    Node* right;
    Node(int d) {
      this->data = d;
      this->left = nullptr;
      this->right = nullptr;
    }
};

class Tree {
  public:
    Node* root;
    Node* insert(Node* root, int data) {
      if (root == nullptr) {
        return new Node(data);
      }

      Node* child = nullptr;
      if (data < root->data) {
        child = insert(root->left, data);
        root->left = child;
      } else {
        child = insert(root->right, data);
        root->right = child;
      }

      return root;
    }
};

void printTree(Node* node) {
  if (node == nullptr) {
    return;
  }

  printTree(node->left);
  cout << node->data << " ";
  printTree(node->right);
}

void printTree(Tree* tree) {
  if (tree == nullptr) {
    return;
  }

  printTree(tree->root);
  cout << endl;
}

Tree* readData(string path) {
  Tree* tree = new Tree();
  ifstream ifs(path);

  int n = 0;
  ifs >> n;

  Node* root = nullptr;
  int d = 0;
  while (n-- > 0) {
    ifs >> d;
    root = tree->insert(root, d);
  }
  tree->root = root;

  return tree;
}

void printLevelNodes(queue<Node*>& q) {
  if (q.empty()) {
    return;
  }

  queue<Node*> qc;
  while (!q.empty()) {
    cout << q.front()->data << " ";

    if (q.front()->left != nullptr) {
      qc.push(q.front()->left);
    }
    if (q.front()->right != nullptr) {
      qc.push(q.front()->right);
    }
    q.pop();
  }

  printLevelNodes(qc);
}

void levelOrder(Node* root) {
  queue<Node*> q;
  q.push(root);
  printLevelNodes(q);
  cout << endl;
}

int main() {
  string path;

  getline(cin, path);
  if (path.empty()) {
    path = "data";
  }

  Tree* tree = readData(path);
  printTree(tree);

  levelOrder(tree->root);
}
