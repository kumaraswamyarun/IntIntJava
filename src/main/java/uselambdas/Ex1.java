package uselambdas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Ex1 {

  // this method is normally called "map"
  public static <A, R> List<R> transform(
      Iterable<A> in, Function<A, R> op) {
    List<R> results = new ArrayList<>();
    for (A s : in) {
      R val = op.apply(s);
      results.add(val);
    }
    return results;
  }

  public static <A, R> List<R> flatMap(
      Iterable<A> in, Function<A, Iterable<R>> op) {
    List<R> results = new ArrayList<>();
    for (A s : in) {
      Iterable<R> manyR = op.apply(s);
      for (R r : manyR) {
        results.add(r);
      }
    }
    return results;
  }

  // think about a function... It takes a list
  // and produces a new list containing *some*
  // of the items from the original list.
  // Q1) How will we specify how the function
  // decides whether any one item is copied to
  // the output list, or not? -- Predicate<ListContentType>
  // Q2) What will the function's declaration
  // (signature, if you prefer) look like?
  public static <A> List<A> filter(
      Iterable<A> in, Predicate<A> op) {
    List<A> results = new ArrayList<>();
    for (A a : in) {
      if (op.test(a)) results.add(a);
    }
    return results;
  }

  public static <A> List<A> distinct(Iterable<A> in) {
    Set<A> results = new HashSet<>();
    for (A a : in) {
      results.add(a);
    }
    return List.copyOf(new ArrayList<>(results));
  }

  public static void main(String[] args) {
    List<String> ls = new ArrayList<>(List.of(
        "Alice", "Tony", "Bill", "William", "Franklin", "Michael"
    ));

    System.out.println(ls);
    ls.replaceAll((String s) -> { return s.toUpperCase(); });
//    ls.replaceAll((String s) -> s.toUpperCase() );
//    ls.replaceAll((s) -> { return s.toUpperCase(); });
//    ls.replaceAll((var s) -> { return s.toUpperCase(); });
//    ls.replaceAll((var s) -> s.toUpperCase() );
//    ls.replaceAll(s -> { return s.toUpperCase(); });
    System.out.println(ls);
    ls.sort(
//        (String s1, String s2) -> s1.length() - s2.length()
//        (var s1, var s2) -> s1.length() - s2.length()
//        (s1, s2) -> s1.length() - s2.length()
//        (s1, s2) -> {
//          if (s1.length() > s2.length()) return 1;
//          if (s1.length() < s2.length()) return -1;
//          return 0;
//        }
//        (s1, s2) -> Integer.compare(s1.length(), s2.length())
//        (s1, s2) -> -Integer.compare(s1.length(), s2.length())
        (s1, s2) -> Integer.compare(s2.length(), s1.length())
    );
    System.out.println(ls);
    ls.sort((s1, s2) -> s1.compareTo(s2));
    System.out.println(ls);

    List<String> results = transform(ls, (String s) -> s.toLowerCase());
    System.out.println(results);

    System.out.println(
        transform(List.of(1, 2, 3, 4, 5), (Integer i) -> i + 10));

    List<Integer> lengths = transform(ls, (String s) -> s.length());
    System.out.println(lengths);

  }
}

// Starting with your list of Students
// and never changing that original list
// create these lists:
// - student names
// - student grades
// - lengths of the students names
// - Nicely formatted student info e.g.
//     "Fred takes 2 courses and has a gpa of 3.2"
//
// What I'm expecting this to "look like"
// List<Student> myStudentList = ...
// s.o.p.(transform(myStudentList, ... some lambda ...)

// for example (and try this one, it should work... what
// does it do?)
// s.o.p.(transform(myStudentList, s -> s.getCourses())
