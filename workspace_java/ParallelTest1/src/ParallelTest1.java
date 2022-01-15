import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class ParallelTest1 {
    private static final List<String> names = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh",
            "iii", "jjj", "kkk", "lll", "mmm", "nnn", "ooo", "ppp", "qqq", "rrr", "sss", "ttt", "uuu", "vvv", "www",
            "xxx", "yyy", "zzz");

    private static final long NANO_2_MILLIS = 1000000L;

    private static long start = 0;
    private static long end = 0;

    private static void startTimer() {
        start = System.nanoTime();
    }

    private static void endTimer() {
        end = System.nanoTime();
    }

    private void resetTimer() {
        start = 0;
        end = 0;
    }

    private static long getTime() {
        return (end - start) / NANO_2_MILLIS;
    }

    private static void delay(long delayMilliSeconds) {
        try {
            sleep(delayMilliSeconds); // so it's not CPU intensive, so the thread pool should be >> number of processors
        } catch (Exception e) {
            System.out.println("Exception is :" + e.getMessage());
        }
    }

    public void handleName(List<String> names, boolean isParallel) {
        startTimer();

        Stream<String> stream = names.stream();
        if (isParallel) {
            stream.parallel();
        } else {
            stream.sequential();
        }
//        List<String> results = names.parallelStream().map(this::compose).collect(Collectors.toList());
        List<String> results = stream.map(this::compose).collect(Collectors.toList());
        System.out.println(results);

        endTimer();
        System.out.println("****** isParallel:" + isParallel + "; time:" + getTime() + " ******");
    }

    private String compose(String name) {
        delay(100);
        return name + "-" + name.length();
    }

    public static void main(String[] args) {
        ParallelTest1 ptest1 = new ParallelTest1();
        ptest1.handleName(names, false);
        ptest1.handleName(names, true);
    }
}
