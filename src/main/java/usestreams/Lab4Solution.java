package usestreams;

// Lab 4:
// From your List<Student> school, all your solutions should start with:
// school.stream()
// and must end with:
// .forEach(s -> System.out.println(s));

import builder.Student;

import java.util.List;

public class Lab4Solution {
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
// a printout of all "smart" students
    System.out.println("smart");
    school.stream()
        .filter(s -> s.getGpa() > 3)
        .forEach(s -> System.out.println(s));

// a printout of the name and grade of all smart students
    System.out.println("name + grade of smart");
    school.stream()
        .filter(s -> s.getGpa() > 3)
        .map(s -> s.getName() + " has grade " + s.getGpa())
        .forEach(s -> System.out.println(s));

    // a printout of all enthusiastic students in the form Name takes N courses
    System.out.println("enthusistic");
    school.stream()
        .filter(s -> s.getCourses().size() > 3)
        .map(s -> s.getName() + " takes " + s.getCourses().size() + " courses")
        .forEach(s -> System.out.println(s));

// a printout of all students who have mid-range grades
    System.out.println("mid range grades");
    school.stream()
//        .filter(s -> s.getGpa() > 3)
//        .filter(s -> s.getGpa() < 3.6)
        .filter(s -> s.getGpa() > 3 & s.getGpa() < 3.6)
        .forEach(s -> System.out.println(s));

// a printout of all the courses taken by all students
    System.out.println("all courses");
    school.stream()
        .flatMap(s -> s.getCourses().stream())
        .forEach(s -> System.out.println(s));

// a printout of all the course names (i.e. no duplicates) of all courses taken
    System.out.println("all courses");
    school.stream()
        .flatMap(s -> s.getCourses().stream())
        .distinct()
        .forEach(s -> System.out.println(s));

// a printout of "Name takes Course" for all student/course pairs
    System.out.println("");
    school.stream()
//        .flatMap((Student s) -> {
//          return s.getCourses().stream().map(c -> s.getName() + " takes " + c)   ;
//        })
        .flatMap(s -> s.getCourses().stream()
                        .map(c -> s.getName() + " takes " + c))
        .forEach(s -> System.out.println(s));

    school.stream()
        .map(s -> {
          if (s.getCourses().size() > 1) {
            Student.Builder sb = Student.builder()
                .name(s.getName())
                .gpa(s.getGpa() + 0.5);
            List<String> courses = s.getCourses();
            for (String course : courses) {
              sb.course(course);
            }
            return sb.build();
          } else {
            return s;
          }
        })
        .forEach(System.out::println);
    school.stream()
        .map(s -> {
          if (s.getCourses().size() > 1) {
            return s.withGpa(s.getGpa() + 0.5);
          } else {
            return s;
          }
        })
        .forEach(System.out::println);
  }
}
