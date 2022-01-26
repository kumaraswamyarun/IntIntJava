package closure;

import builder.Student;

import java.util.List;
import java.util.function.Predicate;

public class UseClosure {
  public static <T> Predicate<T> negate(Predicate<T> test) {
    return t -> !test.test(t);
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
  }
}
