package builder;

import java.util.ArrayList;
import java.util.List;

public class Student {
  private String name;
  private double gpa;
  private List<String> courses; // maybe a Set??

  private Student() {}

  private Student(String name, double gpa, List<String> courses) {
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

  public Student withGpa(double gpa) {
    if (!isValid(this.name, gpa, this.courses)) {
      throw new IllegalArgumentException("Bad values for Student");
    }
    return new Student(this.name, gpa, this.courses);
  }

  public List<String> getCourses() {
    return courses;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private Student self = new Student();

    private Builder() {
      self.courses = new ArrayList<>();
    }

    public Builder name(String name) {
      self.name = name;
      return this;
    }

    public Builder gpa(double gpa) {
      self.gpa = gpa;
      return this;
    }

    public Builder course(String course) {
      self.courses.add(course);
      return this;
    }

    public Student build() {
      if (!isValid(self.name, self.gpa, self.courses)) {
        throw new IllegalArgumentException("Bad values");
      }
      // List.copyOf -- Java 10
      self.courses = List.copyOf(self.courses);
      Student rv = self;
      self = null; // don't allow the builder to corrupt an already-built object
      return rv;
    }
  }

  public static boolean isValid(String name, double gpa, List<String> courses) {
    return name != null && gpa >= 0 && gpa <= 5 && courses != null;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", gpa=" + gpa +
        ", courses=" + courses +
        '}';
  }

  public static void main(String[] args) {
    Student.Builder sb = Student.builder();
    Student s1 = sb.name("Fred")
        .gpa(3.2)
        .course("Math")
        .course("Physics")
        .build();
    System.out.println("s1 is " + s1);
//    sb.course("Astrophysics");
    sb.name("Alan");
    System.out.println("s1 is " + s1);

  }
}
