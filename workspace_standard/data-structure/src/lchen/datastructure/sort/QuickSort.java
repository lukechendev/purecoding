package lchen.datastructure.sort;

public class QuickSort {

    private static int partition(int[] data, int lo, int hi) {
        int pivot = data[(lo + hi) / 2];

        int i = lo - 1;
        int j = hi + 1;

        while (true) {
            do {
                ++i;
            } while (data[i] < pivot);

            do {
                --j;
            } while (data[j] > pivot);

            if (j <= i) {
                return j;
            }

            if (data[i] > data[j]) {
                int t = data[i];
                data[i] = data[j];
                data[j] = t;
            }
        }
    }

    public static void quickSort(int[] data, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int p = partition(data, lo, hi);
        quickSort(data, lo, p);
        quickSort(data, p + 1, hi);
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

        quickSort(data, 0, data.length - 1);

        print(data);
    }
}
