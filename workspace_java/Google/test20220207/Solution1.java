class Node {
  int color; // 0: Green, 1: Red
  int r;
  int c;
}

class Solution {
  int getNumFlips(Node[][] grid) {
    int count = 0;

    int m = grid.length;
    int n = grid[0].length;

    Queue<Node> bfsQueue = new ArrayDeque<>();
    Queue<Node> neighborsQueue = new ArrayQueue<>();
    Map<Node, Integer> visited = new HashMap<>();

    queue.offer(grid[0][0]);
    visited.put(grid[0][0], 0);

    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      int level = visited.get(cur);

      Node left = getLeft(cur, grid);
      if (left != null && !visited.containsKey(left)) {
        if (left.color == cur.color) {
          bfsQueue.offer(left);
          visited.put(left, level);
        } else {
          neighborsQueue.offer(left);
          visited.put(left, level + 1);
          count = Math.max(count, level + 1);
        }
      }

      Node right = getRight(cur, grid);
      if (right != null && !visited.containsKey(right)) {
        if (right.color == cur.color) {
          bfsQueue.offer(right);
          visited.put(right, level);
        } else {
          neighborsQueue.offer(right);
          visited.put(right, level + 1);
          count = Math.max(count, level + 1);
        }
      }
      Node up = getUp(cur, grid);
      if (up != null && !visited.containsKey(up)) {
        if (up.color == cur.color) {
          bfsQueue.offer(up);
          visited.put(up, level);
        } else {
          neighborsQueue.offer(up);
          visited.put(up, level + 1);
          count = Math.max(count, level + 1);
        }
      }
      Node down = getDown(cur, grid);
      if (down != null && !visited.containsKey(down)) {
        if (down.color == cur.color) {
          bfsQueue.offer(down);
          visited.put(down, level);
        } else {
          neighborsQueue.offer(down);
          visited.put(down, level + 1);
          count = Math.max(count, level + 1);
        }
      }

      if (bfsQueue.isEmpty()) {
        queue = neighborsQueue;
        neighborsQueue = new ArrayDeque<>();
      }
    }

    return count;
  }

  private Node getLeft(Node cur, Node[][] grid) {
    int c = cur.c - 1;
    if (c >= 0) {
      return grid[cur.r][c];
    }

    return null;
  }

  private Node getRight(Node cur, Node[][] grid) {
    int c = cur.c + 1;
    if (c < grid[0].length) {
      return grid[cur.r][c];
    }

    return null;
  }

  private Node getUp(Node cur, Node[][] grid) {
    int r = cur.r - 1;
    if (r >= 0) {
      return grid[r][cur.c];
    }

    return null;
  }

  private Node getDown(Node cur, Node[][] grid) {
    int r = cur.r + 1;
    if (r < grid.length) {
      return grid[r][cur.c];
    }

    return null;
  }
}
