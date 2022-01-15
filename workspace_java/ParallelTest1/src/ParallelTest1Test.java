import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParallelTest1Test {

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

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void handleName(boolean isParallel) {
        ParallelTest1 test = new ParallelTest1();
        test.handleName(names, isParallel);
    }
}