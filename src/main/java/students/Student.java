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
  private final String name;
  private final double gpa;
  private final List<String> courses;

  // if caller calls with comma separated Strings, compiler builds an array
  // and this does not leak.
  // BUT call could call this with an actual array!!!!
  public Student(String name, double gpa, String ... courses) {
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
  public Student(String name, double gpa, List<String> courses) {
    if (! isValid(name, gpa, courses)){
      throw new IllegalArgumentException("Bad values for a Student");
    }
    this.name = name;
    this.gpa = gpa;
    this.courses = courses;
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
    return Collections.unmodifiableList(courses);
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
    return name != null && gpa >= 0 && gpa <= 5 && courses != null;
  }
}
