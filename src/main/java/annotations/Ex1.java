package annotations;

public class Ex1 {
  @Override // compiler looks at this "sticky note"
  // and decides "OK, I will check that this really
  // is an override :)"
  public String toString() {
    return "Hello, I'm an Ex1";
  }
}
