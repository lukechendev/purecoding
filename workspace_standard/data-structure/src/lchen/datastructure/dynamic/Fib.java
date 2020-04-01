package lchen.datastructure.dynamic;

public class Fib {

    // Time: O(n), Space: O(1)
    public static long fibn(int n) {
        long[] fib = new long[3];

        fib[0] = 0;
        fib[1] = 1;

        if (n == 0) {
            return fib[0];
        }

        if (n == 1) {
            return fib[1];
        }

        for (int i = 2; i < n; ++i) {
            fib[2] = fib[1] + fib[0];

            fib[0] = fib[1];
            fib[1] = fib[2];
        }

        return fib[2];
    }

    public static String fibns(int n) {
        String[] fib = new String[3];

        fib[0] = "0";
        fib[1] = "1";

        if (n == 0) {
            return fib[0];
        }

        if (n == 1) {
            return fib[1];
        }

        for (int i = 2; i < n; ++i) {
            fib[2] = plus(fib[1], fib[0]);
            fib[0] = fib[1];
            fib[1] = fib[2];

//            System.out.println(i + "(" + fib[2].length() + ")" + ": " + fib[2]);
//            System.out.println();
        }

        return fib[2];
    }

    private static String plus(String x, String y) {
        StringBuffer sumStr = new StringBuffer();

        final int xlen = x.length();
        final int ylen = y.length();

        if (xlen > ylen) {
            for (int i = 0; i < xlen - ylen; ++i) {
                y = "0" + y;
            }
        } else if (ylen > xlen) {
            for (int i = 0; i < ylen - xlen; ++i) {
                x += "0" + y;
            }
        }

        final int len = x.length();
        int add = 0;
        for (int i = len - 1; i >= 0; --i) {
            char xd = x.charAt(i);
            char yd = y.charAt(i);

            int sum = (xd - '0') + (yd - '0') + add;
            if (sum > 9) {
                add = 1;
                sum = sum - 10;
            } else {
                add = 0;
            }

            sumStr.insert(0, (char) (sum + '0'));
        }

        if (add > 0) {
            sumStr.insert(0, '1');
        }

        return sumStr.toString();
    }

    public static void main(String[] args) {
        System.out.println("fib(100)=" + fibn(50));
        System.out.println("fib(100)=" + fibns(50));
        System.out.println("fib(1000000000)=" + fibns(10000));
    }
}
