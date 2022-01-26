package collection;

import builder.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsingCollectors {
  public static String getLetterGrade(Student s) {
    double gpa = s.getGpa();
    if (gpa > 3.5) return "A";
    if (gpa > 3.0) return "B";
    if (gpa > 2.5) return "C";
    return "D";
  }

  public static void main(String[] args) {
    List<Student> school = List.of(
        Student.builder().name("Fred").gpa(3.2)
            .course("Math").course("Physics").build(),
        Student.builder().name("Fred1").gpa(3.0)
            .course("Math").course("Physics").build(),
        Student.builder().name("Fred2").gpa(3.3)
            .course("Math").course("Physics").build(),
        Student.builder().name("Fred3").gpa(2.3)
            .course("Math").course("Physics").build(),
        Student.builder().name("Jim").gpa(2.2)
            .course("Journalism").build(),
        Student.builder().name("Sheila").gpa(3.9)
            .course("Math").course("Physics")
            .course("Quantum Mechainics").course("Astro-physics")
            .build()
    );

//    Map<String, List<Student>> map = school.stream()
////        .collect(Collectors.groupingBy(UsingCollectors::getLetterGrade))
//        .collect(Collectors.groupingBy(s -> getLetterGrade(s)));

//    Map<String, Long> map = school.stream()
//        .collect(Collectors.groupingBy(s -> getLetterGrade(s),
//            Collectors.counting()));

//    Map<String, List<String>> map = school.stream()
//        .collect(Collectors.groupingBy(s -> getLetterGrade(s),
//            Collectors.mapping(s -> s.getName(), Collectors.toList())));

    /*Map<String, String>*/
    var map = school.stream()
        .collect(Collectors.groupingBy(s -> getLetterGrade(s),
            Collectors.mapping(s -> s.getName(), Collectors.joining(", "))));

    map.entrySet().stream()
//        .map(e -> "Students with grade " + e.getKey() + " are " + e.getValue())
        .map(e -> "Key " + e.getKey() + " : " + e.getValue())
        .forEach(System.out::println);
  }
}
