package collection;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

class Average {
  private double sum = 0.0;
  private long count = 0;

  public Average() {}
  public Average(double sum, long count) {
    this.sum = sum;
    this.count = count;
  }

  public void include(double d) {
    this.sum += d;
    this.count++;
  }

  public void merge(Average other) {
    System.out.println("Running the merge!!!!");
    this.sum += other.sum;
    this.count += other.count;
  }

  public Optional<Double> get() {
    if (count > 0) return Optional.of(sum/count);
    else return Optional.empty();
  }
}

public class CollectingAverager {
  public static void main(String[] args) {
    long start = System.nanoTime();
    // use -XX:+PrintCompilation to see the JIT compiling your code...

    ThreadLocalRandom.current().doubles(8_000_000_000L, -Math.PI, +Math.PI)
        .parallel()
        .collect(() -> new Average(),
            (a, d) -> a.include(d),
            (a1, a2) -> a1.merge(a2))
        .get()
        .map(r -> "The average is " + r)
        .ifPresent(System.out::println);

    long time = System.nanoTime() - start;
    System.out.println("calculation took "
        + (time / 1_000_000_000.0) + " seconds");
  }
}
