package lchen.datastructure.sort;

public class BucketSort {
    public static void bucketSort(int[] data) {
        int min = data[0];
        int max = data[0];
        for (int i = 1; i < data.length; ++i) {
            if (min > data[i]) {
                min = data[i];
            } else if (max < data[i]) {
                max = data[i];
            }
        }

        int[] buckets = new int[max - min + 1];
        for (int i = 0; i < data.length; ++i) {
            buckets[data[i] - min]++;
        }

        int p = 0;
        for (int i = 0; i < buckets.length; ++i) {
            for (int j = 0; j < buckets[i]; ++j) {
                data[p++] = i + min;
            }
        }
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
        int[] data = { 15, 3, 9, -18, 8, 5, 2, 7, 1, 6, -1, 5, 1, 1, 2, 0, 0 };

        print(data);

        bucketSort(data);

        print(data);
    }
}
