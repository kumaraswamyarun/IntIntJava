package closure;

import builder.Student;

import java.util.List;
import java.util.function.Predicate;

public class UseClosure {
  public static <T> Predicate<T> negate(Predicate<T> test) {
    return t -> !test.test(t);
  }

  public static <T> Predicate<T> and(Predicate<T> first, Predicate<T> second) {
    return t -> first.test(t) && second.test(t);
  }

  public static <T> Predicate<T> or(Predicate<T> first, Predicate<T> second) {
    return t -> first.test(t) || second.test(t);
  }

  // create "and", and "or"

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

    Predicate<Student> smart = Student.getSmartnessPredicate(3);

    System.out.println("-------------");
    school.stream().filter(smart).forEach(System.out::println);
    System.out.println("-------------");
    school.stream().filter(negate(smart)).forEach(System.out::println);
    System.out.println("-------------");
    Predicate nsamtoc = and(negate(Student.getSmartnessPredicate(3.3)),
        s -> s.getCourses().size() > 1);
    school.stream().filter(nsamtoc).forEach(System.out::println);
    System.out.println("-------------");
    school.stream().filter(
        Student.getSmartnessPredicate(3.3)
            .negate()
            .and(s -> s.getCourses().size() > 1)
    ).forEach(System.out::println);
  }
}
