import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Test {
  private void printV(Set<Integer> s) {
    System.out.println(s.toString());
    System.out.println();

    for (int i : s) {
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println();

    Iterator<Integer> it = s.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    System.out.println();
    System.out.println();

    s.stream().forEach(i -> System.out.print(i + " "));
    System.out.println();
    System.out.println();
  }

  public void test1() {
    Set<Integer> set = new HashSet<Integer>();
    set.add(3);
    set.add(100);
    set.add(1);
    set.add(10000);
    set.add(99);

    printV(set);
  }

  public static final void main(String[] args) {
    Test test = new Test();
    test.test1();
  }
}
