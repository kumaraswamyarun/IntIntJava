package students;

import java.util.List;

public class Student {
  private final String name;
  private final double gpa;
  private final List<String> courses;

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
    return courses;
  }

  // Fix Mina's IDE
  // Make this immutable again :)

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
