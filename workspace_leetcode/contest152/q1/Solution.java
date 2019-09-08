import java.math.BigInteger;

class Solution {
  private static int[] primes100 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

  public int numPrimeArrangements(int n) {
    final int mod = (int) Math.pow(10, 9) + 7;
    BigInteger modBig = new BigInteger(Integer.toString(mod));
    
    int numP = 0;
    for (int i = 0; i < primes100.length; ++i) {
      if (primes100[i] > n) {
	break;  
      }
      numP++;
    }
    int numNonP = n - numP; 

    BigInteger total = new BigInteger("1");
    for (int i = 1; i <= numP; ++i) {
      BigInteger iBig = new BigInteger(Integer.toString(i));
      total = total.multiply(iBig);
    }

    for (int i = 1; i <= numNonP; ++i) {
      BigInteger iBig = new BigInteger(Integer.toString(i));
      total = total.multiply(iBig);
    }

    total = total.mod(modBig);

    return total.intValue();
  }

  public int numPrimeArrangements2(int n) {
    final int mod = (int) Math.pow(10, 9) + 7;
    
    int numP = 0;
    for (int i = 0; i < primes100.length; ++i) {
      if (primes100[i] > n) {
	break;  
      }
      numP++;
    }
    int numNonP = n - numP; 

   long total = 1;
    for (int i = 1; i <= numP; ++i) {
      total = total * i % mod;
    }

    for (int i = 1; i <= numNonP; ++i) {
      total = total * i % mod;
    }

    return (int) total;
  }

  public static void test(int input, int expected) {
    Solution s = new Solution();
    long ts = System.nanoTime();
    int ret = s.numPrimeArrangements2(input);
    System.out.println("------------------------>>> " + (System.nanoTime() - ts));
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    test(5, 12);
    test(100, 682289015);
  }
}
