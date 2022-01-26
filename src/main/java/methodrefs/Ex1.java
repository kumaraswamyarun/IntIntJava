package methodrefs;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Ex1 {
  static int nextId = 1;
  int id = nextId++;

  public static Ex1 getOne() {
    System.out.println("getting an Ex1");
    return new Ex1();
  }

  public String doEx1Stuff(String s) {
    return "Ex1 id " + id + " processed " + s;
  }

  public static void main(String[] args) {
//    UnaryOperator<String> uos = s -> Ex1.getOne().doEx1Stuff(s);
    final Ex1 target = Ex1.getOne();
    UnaryOperator<String> uos = s -> target.doEx1Stuff(s);
//    UnaryOperator<String> uos = Ex1.getOne()::doEx1Stuff;

    System.out.println(uos.apply("My message"));
    System.out.println(uos.apply("My message"));
    System.out.println(uos.apply("My message"));

//    Consumer<String> cos = s -> System.out.println(s);
    Consumer<String> cos = java.lang.System.out::println;

    cos.accept("Hello World");
  }
}
