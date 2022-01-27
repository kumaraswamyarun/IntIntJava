package shopping;

public class Store {
  public static void main(String[] args) {
    ShoppingPair<Sock> ps = new ShoppingPair<Sock>(
        new Sock("Red", 9), new Sock("Blue", 9));

    System.out.println("pair is " + ps);

    System.out.println("Pair is matched? " + ps.isMatchedByPredicate(
            (l, r) -> l.getColor().equals(r.getColor())));

    System.out.println("Pair is matched? " + ps.isMatched());

    ShoppingPair<Sock> ps2 = new ShoppingPair<Sock>(
        new Sock("Blue", 10), new Sock("Blue", 9));

    System.out.println("Pair is matched? " + ps2.isMatched());

    // NOPE can't use this for a variable's type in a declaration
//    Colored & Sized cns = new Sock("Black", 12);

    // could use Object x, but lose specificity
    var x =
        true ? "Hello" : 99;
//    x.compareTo(null);
  }
}
