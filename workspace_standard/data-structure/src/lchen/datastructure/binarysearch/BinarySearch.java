package lchen.datastructure.binarysearch;

public class BinarySearch {

    public static int binarySearchRecursive(int[] data, int v, int lo, int hi) {
        if (hi < lo) {
            return -1;
        }

        int mid = (lo + hi) / 2;
        if (data[mid] == v) {
            return mid;
        } else if (data[mid] > v) {
            // go to the left
            return binarySearchRecursive(data, v, lo, mid - 1);
        } else if (data[mid] < v) {
            // go to right
            return binarySearchRecursive(data, v, mid + 1, hi);
        }

        return -1;
    }

    public static int binarySearchIterative(int[] data, int v) {
        int lo = 0;
        int hi = data.length - 1;

        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            if (data[mid] == v) {
                return mid;
            } else if (data[mid] > v) {
                // go to the left
                hi = mid - 1;
            } else if (data[mid] < v) {
                // go to the right
                lo = mid + 1;
            }
        }

        return -1;
    }

    public static void print(int[] data) {
        StringBuffer sb = new StringBuffer();

        for (int v : data) {
            sb.append(v).append(",");
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] data = { -18, -1, 0, 0, 1, 1, 1, 2, 2, 3, 5, 5, 6, 7, 8, 9, 15 };
        print(data);

        for (int i = 0; i < data.length; ++i) {
            System.out.println("Looking for " + data[i] + " recursively: "
                    + binarySearchRecursive(data, data[i], 0, data.length - 1));
        }

        for (int i = 0; i < data.length; ++i) {
            System.out.println("Looking for " + data[i] + " iterative: " + binarySearchIterative(data, data[i]));
        }
    }
}
