package shopping;

public class ShoppingPair<E extends Colored> extends Pair<E> {
  public ShoppingPair(E left, E right) {
    super(left, right);
  }

  public boolean isMatched() {
    return left.getColor().equals(right.getColor());
  }
}
