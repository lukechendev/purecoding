package lchen.datastructure.sort;

public class MergeSort {

    private static void merge(int[] data, int lo, int mid, int hi) {
        if (mid <= lo && hi <= mid) {
            return;
        }
        
        int i = lo;
        int j = mid;
        
        int[] t = new int[hi - lo];
        int n = 0;
        while (i < mid && j < hi) {
            if (data[i] <= data[j]) {
                t[n++] = data[i++];
            } else {
                t[n++] = data[j++];
            }
        }
        
        while (i < mid) {
            t[n++] = data[i++];
        }
        
        while (j < hi) {
            t[n++] = data[j++];
        }
        
        for (int p = 0; p < n; ++p) {
            data[lo + p] = t[p];
        }
    }

    public static void mergeSort(int[] data, int lo, int hi) {
        if (hi - lo <= 1) {
            return;
        }

        int mid = (lo + hi) / 2;
        mergeSort(data, lo, mid);
        mergeSort(data, mid, hi);
        merge(data, lo, mid, hi);
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

        mergeSort(data, 0, data.length);

        print(data);
    }
}
