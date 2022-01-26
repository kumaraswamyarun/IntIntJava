package usestreams;

import java.util.List;
import java.util.stream.Stream;

public class UseAStream {
  public static void main(String[] args) {
    List<String> ls = List.of("Fred", "Jim", "Sheila");

    Stream<String> ss = ls.stream();
    ss.filter(s -> {
          System.out.println("filter processing string: " + s);
          return s.length() > 3;
        })
        .map(s -> {
          System.out.println("map processing string: " + s);
          return s.toUpperCase();
        })
        .forEach(s -> System.out.println(">> " + s));
    ;
    System.out.println("ls is: " + ls);
    ss.forEach(s -> System.out.println(s));
    System.out.println("Finished");
  }
}


