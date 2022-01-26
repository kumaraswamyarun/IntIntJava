package shopping;

import java.util.function.BiPredicate;

// in the generics syntax:
// "extends" means "is assignment compatible with"
public class Pair<E> {
  protected E left;
  protected E right;
//  private Class<E> targetType;

//  public Pair(E left, E right, Class<E> targetType) {
  public Pair(E left, E right) {
    this.left = left;
    this.right = right;
//    this.targetType = targetType;
  }

  public E getLeft() {
    return left;
  }

  public void setLeft(E left) {
//    if (!targetType.isInstance(left)){
//      throw new IllegalArgumentException(left + " is not a " + targetType);
//    }
    this.left = left;
  }

  public E getRight() {
    return right;
  }

  public void setRight(E right) {
//    if (!targetType.isInstance(right)){
//      throw new IllegalArgumentException(right + " is not a " + targetType);
//    }
    this.right = right;
  }

  // would we even bother to define this?
  // let the caller use the predicate directly
  public boolean isMatchedByPredicate(BiPredicate<E, E> test) {
    return test.test(left, right);
  }

//  public boolean isMatched() {
////    return left.getColor() == right.getColor();
//    return left.getColor().equals(right.getColor());
//  }

  @Override
  public String toString() {
    return "Pair{" +
        "left=" + left +
        ", right=" + right +
        '}';
  }
}
