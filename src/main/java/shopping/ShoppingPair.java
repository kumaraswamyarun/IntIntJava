package shopping;

public class ShoppingPair<E extends Colored & Sized> extends Pair<E> {
  public ShoppingPair(E left, E right) {
    super(left, right);
  }

  public boolean isMatched() {
    return left.getColor().equals(right.getColor())
        && left.getSize() == right.getSize();
  }

  public static <E extends Sized & Colored> boolean match(E left, E right) {
    return left.getColor().equals(right.getColor())
        && left.getSize() == right.getSize();
  }
}
