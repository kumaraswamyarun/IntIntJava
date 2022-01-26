package shopping;

public class Store {
  public static void main(String[] args) {
    ShoppingPair<Sock> ps = new ShoppingPair<Sock>(
        new Sock("Red", 9), new Sock("Blue", 9));

    System.out.println("pair is " + ps);

    System.out.println("Pair is matched? " + ps.isMatchedByPredicate(
            (l, r) -> l.getColor().equals(r.getColor())));

    System.out.println("Pair is matched? " + ps.isMatched());
  }
}
