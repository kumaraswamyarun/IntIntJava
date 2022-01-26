package reduction;

import java.util.stream.IntStream;

public class MakeASum {
  public static void main(String[] args) {
    int sum = IntStream.range(1, 11)
        .reduce(0, (a, b) -> a + b);
    System.out.println("sum is " + sum);
//        .forEach(System.out::println);
  }
}
