package exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ExceptionInStream {
  public static Stream<String> getLinesFromFile(String fn) {
    try {
      return Files.lines(Path.of(fn));
    } catch (IOException ioe) {
      throw new RuntimeException(ioe);
    }
  }

  public static void main(String[] args) {
    Stream.of("a.txt", "b.txt", "c.txt")
        .flatMap(fn -> getLinesFromFile(fn))
        .forEach(System.out::println);
  }
}
