package shopping;

import java.time.LocalDate;

public class UsePair {
  public static void usePairWell(Pair<String> ps) {}

  public static void breakAPair(Pair/*<String>*/ p) {
    p.setRight(LocalDate.now());
  }

  public static void main(String[] args) {
//    Pair<String> p = new Pair<String>("Hello", LocalDate.now());
    Pair<String> p = new Pair<>("Hello", "Bonjour"/*, String.class*/);
    String l = p.getLeft();

//    breakAPair(p);
    String r = p.getRight();
    System.out.println(r);

    Class<?> cl = "".getClass();
    System.out.println(cl);
  }
}
