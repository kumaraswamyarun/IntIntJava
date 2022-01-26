package reduction;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

// this would make a great 'record' if you're using
// Java 16 or newer :)
class Average {
  private double sum = 0.0;
  private long count = 0;

  public Average() {}
  public Average(double sum, long count) {
    this.sum = sum;
    this.count = count;
  }

  public Average include(double d) {
    return new Average(this.sum + d, this.count + 1);
  }

  public Average merge(Average other) {
    return new Average(this.sum + other.sum, this.count + other.count);
  }

  public Optional<Double> get() {
    if (count > 0) return Optional.of(sum/count);
    else return Optional.empty();
  }
}

public class ReducingAvererager {
  public static void main(String[] args) {
//    BiFunction<Average, Double, Average> bfada = (a, d) -> a.include(d);

    ThreadLocalRandom.current().doubles(10_000, -Math.PI, +Math.PI)
        .boxed()
        .reduce(new Average(),
            (a, d) -> a.include(d),
            (a1, a2) -> a1.merge(a2))
        .get()
        .map(r -> "The average is " + r)
        .ifPresent(System.out::println);


  }
}
