package exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class ExceptionInStream {
//  public static Stream<String> getLinesFromFile(String fn) {
//    try {
//      return Files.lines(Path.of(fn));
//    } catch (IOException ioe) {
//      throw new RuntimeException(ioe);
//    }
//  }

  public static Optional<Stream<String>> getLinesFromFile(String fn) {
    try {
      return Optional.of(Files.lines(Path.of(fn)));
    } catch (IOException ioe) {
      System.err.println("Broke on file " + fn);
      return Optional.empty();
    }
  }


  public static void main(String[] args) {
    Consumer<Optional<Stream<String>>> reportProblem = opt -> {
      if (opt.isEmpty()) {
        System.out.println("Houston we have a problem");
      }
    };
    Function<Optional<Stream<String>>, Optional<Stream<String>>> recovery =
        opt -> {
          if (opt.isPresent()) return opt;
          return getLinesFromFile("backup.txt");
        };
    Stream.of("a.txt", "b.txt", "c.txt")
        .map(fn -> getLinesFromFile(fn))
        .peek(reportProblem)
        .map(recovery)
        .filter(opt -> opt.isPresent())
        .flatMap(opt -> opt.get())
        .forEach(System.out::println);
  }
}
