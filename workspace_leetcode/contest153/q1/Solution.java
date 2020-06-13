/*
Distance Between Bus Stops

A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.

The bus goes along both directions i.e. clockwise and counterclockwise.

Return the shortest distance between the given start and destination stops.

Constraints:

1 <= n <= 10^4
distance.length == n
0 <= start, destination < n
0 <= distance[i] <= 10^4
*/

class Solution {
  
  public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    if (start == destination) {
      return 0;
    }

    if (start > destination) {
      int t = start;
      start = destination;
      destination = t;
    }

    int n = distance.length;
    int dist1 = 0;
    for (int i = start; i < destination; ++i) {
      dist1 += distance[i%n];
    }

    int dist2 = 0;
    int steps = n - (destination - start);
    int i = destination;
    while (steps-- > 0) {
      dist2 += distance[i%n];
      i++;
    }
    return dist1 < dist2 ? dist1 : dist2;
  }

  public static void test(int[] distance, int start, int destination, int expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    int ret = s.distanceBetweenBusStops(distance, start, destination);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    int[] distance1 = {1, 2, 3, 4};
    test(distance1, 0, 1, 1);
    test(distance1, 0, 2, 3);
    test(distance1, 0, 3, 4);
    test(distance1, 1, 0, 1);
    test(distance1, 2, 0, 3);
    test(distance1, 3, 0, 4);
  }
}
