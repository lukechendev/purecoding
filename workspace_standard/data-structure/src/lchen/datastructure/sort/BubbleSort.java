package lchen.datastructure.sort;

public class BubbleSort {
    public static void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; ++i) {
            for (int j = i; j < data.length; ++j) {
                if (data[i] > data[j]) {
                    int t = data[i];
                    data[i] = data[j];
                    data[j] = t;
                }
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

        bubbleSort(data);

        print(data);
    }
}
