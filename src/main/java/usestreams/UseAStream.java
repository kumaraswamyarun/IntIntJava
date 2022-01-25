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

// Lab 4:
// From your List<Student> school, all your solutions should start with:
// school.stream()
// and must end with:
// .forEach(s -> System.out.println(s));
//
// produce these results:
// a printout of all "smart" students
// a printout of the name and grade of all smart students
// a printout of all enthusiastic students in the form Name takes N courses
// a printout of all students who have mid-range grades
// a printout of all the courses taken by all students
// a printout of all the course names (i.e. no duplicates) of all courses taken
// a printout of "Name takes Course" for all student/course pairs


