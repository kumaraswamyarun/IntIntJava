package annotations;

//@RunMe
public class TestClass {
//  @RunMe
  String name = "Fred";

  public void dontRunThisTest() {
    System.out.println("this should not run");
  }

  @RunMe
  public void runThisTest() {
    System.out.println("Excellent this should execute");
  }

  @RunMe
  public void runThisTooPlease() {
    System.out.println("Another test :)");
  }

  @RunMe
  private void runThisTooIfYouCan() {
    System.out.println("A private test! :)");
  }

  @Override
  public String toString() {
    return "TestClass{" +
        "name='" + name + '\'' +
        '}';
  }
}
