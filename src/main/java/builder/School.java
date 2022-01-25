package builder;

import java.lang.reflect.Method;
import java.util.List;


// This must have EXACTLY ONE abstract method
// if we want to make a lambda object from it
interface CriterionOfStudent {
  boolean test(Student s);
}

@FunctionalInterface
interface Odd {
  boolean reallyOdd(Student s);
//  void doStuff();
}

class SmartStudent implements CriterionOfStudent {
  @Override
  public boolean test(Student s) {
    return s.getGpa() > 3;
  }
}

class EnthusiasticStudent implements CriterionOfStudent {
  @Override
  public boolean test(Student s) {
    return s.getCourses().size() > 3;
  }
}

public class School {
//  private var x = 99; // NOT FOR FIELDS
  public static void showAll(List<Student> ls) {
    for (Student s : ls) {
      System.out.println("> " + s);
    }
    System.out.println("---------------------");
  }

  public static void showAllSmart(List<Student> ls, double threshold) {
//    ls.iterator() -- behavior in the ls object
    for (Student s : ls) {
      if (s.getGpa() > threshold) {
        System.out.println("> " + s);
      }
    }
    System.out.println("---------------------");
  }

  public static void showAllEnthusiastic(List<Student> ls, int threshold) {
    for (Student s : ls) {
      if (s.getCourses().size() > threshold) {
        System.out.println("> " + s);
      }
    }
    System.out.println("---------------------");
  }

  // when passing an argument object primarily for the BEHAVIOR it \
  // contains, we call this pattern "Command"
  // functional programming simply calls this (and other patterns)
  // "higher order function"
  public static void showAllByCriterion(List<Student> ls,
                                        CriterionOfStudent crit) {
    for (Student s : ls) {
      if (crit.test(s)) {
        System.out.println("> " + s);
      }
    }
    System.out.println("---------------------");
  }

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
    showAll(school);
    showAllSmart(school, 3.0);
    School.showAllEnthusiastic(school, 2);

    showAllByCriterion(school, new SmartStudent());
    showAllByCriterion(school, new EnthusiasticStudent());

    showAllByCriterion(school,
//        (Student s) -> { return s.getGpa() > 3; }
//        (@Deprecated var s) -> { return s.getGpa() > 3; }
//        (s) -> { return s.getGpa() > 3; }
//        s -> { return s.getGpa() > 3; }
        s -> s.getGpa() > 3
    );

    // lambda can ONLY be used where the compiler KNOWS
    // that it needs an OBJECT that implements an INTERFACE
    // AND that interface MUST declare EXACTLY ONE abstract method
    Odd obj = (Student s) -> {
      return s.getGpa() > 3;
    };

    Class<?> cl = obj.getClass();
    Method[] ma = cl.getMethods();
    for (Method m : ma) {
      System.out.println("-- " + m);
    }

//    obj = lambda s: s.getGpa() > 3;

//    short s = 99;
//    final long ninetynine = 99;
    final int ninetynine = 99;
    short s = ninetynine;
    var x = 4_000_000_000.;
//    var x;
//    x = 99;
//    x = "hello";
  }
}

// Exercise time:
// Write some lambdas!
// variety of forms (argument lists with/without types/using var)
// - body vs simple expression
// one argument, two arguments
// List.replaceAll, List.sort
// Comparator, takes 2 arguments 9, 3 and "does a subtraction"
// here 9 - 3 => 6 (positive)... that tells us that 9 "comes after" 3
// if we have arguments 7, 11 we get -4... negative says 7 "comes before" 11
