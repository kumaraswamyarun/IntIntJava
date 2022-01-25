package uselambdas;

import builder.Student;

import java.util.List;

import static uselambdas.Ex1.*;

public class Lab2Solution {
  public static void main(String[] args) {
    List<Student> school = List.of(
        Student.builder().name("Fred").gpa(3.2)
            .course("Math").course("Physics").build(),
        Student.builder().name("Jim").gpa(2.2)
            .course("Journalism").build(),
        Student.builder().name("Sheila").gpa(3.9)
            .course("Math").course("Physics")
            .course("Quantum Mechainics").course("Astro-physics")
            .build()
    );

    System.out.println(transform(school, s -> s.getCourses()));
// - student names
    System.out.println(transform(school, s -> s.getName()));

// - student grades
    System.out.println(transform(school, s -> s.getGpa()));
// - lengths of the students names
    System.out.println(transform(school, s -> s.getName().length()));
// - Nicely formatted student info e.g.
//     "Fred takes 2 courses and has a gpa of 3.2"
    System.out.println(transform(school,
        s -> String.format("%s takes %d courses and has a gpa of %3.1f",
            s.getName(), s.getCourses().size(), s.getGpa())));

    System.out.println(transform(
        filter(school, s -> s.getGpa() < 3.5),
        s -> s.getName() + " is a smart student with gpa " + s.getGpa()));

//    mySpecialIterable
//        .filter(...)
//    .map(...)

    System.out.println(flatMap(filter(school, (Student s) -> s.getGpa() < 3.5),
        s -> s.getCourses()));
  }
}
