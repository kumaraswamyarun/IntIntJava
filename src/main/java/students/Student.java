package students;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Java has 8 builtin primitive types:
// boolean, byte, short, char, int, long, float, double
// EVERYTHING ELSE is a "reference type" (i.e. an object)
// they ALWAYS (unless someone massively breaks the conventions)
// start with an upper case letter.

// immutability can be bypassed if you have non-final classes!!!
public final class Student {
  // final fields must be definitely initialized exactly once
  // via any / all paths through the constructors, by the time
  // constructions are complete
  private final List<String> courses;
  private final String name;
  private final double gpa;

  // if caller calls with comma separated Strings, compiler builds an array
  // and this does not leak.
  // BUT call could call this with an actual array!!!!
  private Student(String name, double gpa, String ... courses) {
    // Arrays.asList makes a *view* NOT a truly immutable list
    List<String> courseNames = Arrays.asList(courses);
    if (! isValid(name, gpa, courseNames)){
      throw new IllegalArgumentException("Bad values for a Student");
    }
    this.name = name;
    this.gpa = gpa;
    this.courses = courseNames;
  }

  // never use directly caller-provided mutable data in our own structure
  // if we want to be immutable!
  private Student(String name, double gpa, List<String> courses) {
//    if (! isValid(name, gpa, courses)){
//      throw new IllegalArgumentException("Bad values for a Student");
//    }
    this.name = name;
    this.gpa = gpa;
    this.courses = courses;
  }

  // calling a constructor can ONLY result in:
  // A BRAND NEW Object of EXACTLY THE SPECFIED TYPE
  // OR an exception

  // a FACTORY by contrast can:
  // do the above :) AND
  // create a new object of ANY ASSIGNMENT COMPATIBLE TYPE

  // from today forward :)
  // do not write public constructors...
  // create private or protected (if you demand subclasses) constructors
  // and accessible factories that delegate to those constructors
  public static Student of(String name, double gpa, String ... courses) {
    if (! isValid(name, gpa)){
      throw new IllegalArgumentException("Bad values for a Student");
    }

    // this change does NOT BREAK THE CALLER
    // "Limit the consequences of change"
//    if (student parents are rich) {
//      return new VIPStudent(); // VIPStudent must be subtype of Student
//    }

    // if we find an IMMUTABLE object of the right values
    // has already been created... we could reuse it!!!
    // pooling :)
//    if (lookup this object's state) {
//      return looked up object
//    }
    // Gang of four pattern called "Flyweight" is essentially
    // pool the immutable parts of large objects, if those
    // immutable parts have frequent recurrence.

    // List.of -- Java 9. Creates a structurally unmodifiable list
    // with a copy of every element's reference
    // if the data items are immutable (like String), we have a truly
    // immutable list
    List<String> courseList = List.of(courses);
    return new Student(name, gpa, courseList);
  }

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }

  public List<String> getCourses() {
    // return a defensive copy?
    // is there an immutable list

    // return a proxy that rejects changes
//    return Collections.unmodifiableList(courses);
    return courses; // ONLY IF we used List.of to create this!!!
  }

  public Student withName(String newName) {
    if (!isValid(newName, this.gpa, this.courses)) {
      throw new IllegalArgumentException("Bad Values");
    }
    return new Student(newName, this.gpa, this.courses);
  }

//  public void setName(String newName) {
////    if (newName == null) {
////      throw new IllegalArgumentException("can't have null name");
////    }
//    // do not duplicate your validations!
//    if (!isValid(newName, this.gpa, this.courses)) {
//      throw new IllegalArgumentException("Bad Values");
//    }
//    this.name = newName;
//  }
//
  public static boolean isValid(String name, double gpa, List<String> courses) {
    return isValid(name, gpa) && courses != null;
  }
  private static boolean isValid(String name, double gpa) {
    return name != null && gpa >= 0 && gpa <= 5;
  }

  public void doStuff() {}
//  public void doStuff(int x) {}
//  public void doStuff(int y) {}
//  public void doStuff(int [] x) {}
//  public void doStuff(int ... x) {}
  public void doStuff(long x) {}
//  public void doStuff(List<String> x) {}
//  public void doStuff(List<StringBuilder> x) {}
}
