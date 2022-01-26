package shopping;

public class Sock implements Colored, Sized {
  private String color;
  private int size;

  public Sock(String color, int size) {
    this.color = color;
    this.size = size;
  }

  public String getColor() {
    return color;
  }

  public int getSize() {
    return size;
  }

  @Override
  public String toString() {
    return "Sock{" +
        "color='" + color + '\'' +
        ", size=" + size +
        '}';
  }
}
