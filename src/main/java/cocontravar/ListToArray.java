package cocontravar;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ListToArray {

  public static <F, E extends F> F[] getAsArray(List<E> le, Class<F> cl) {
    // type erasure again! There is no "E" at runtime
//    E[] result = new E[le.size()];
//    E[] result = (E[])Array.newInstance(cl, le.size());
    F[] result = (F[])Array.newInstance(cl, le.size());
    int i = 0;
    for (E e : le) {
      result[i++] = e;
    }
    return result;
  }
  public static void main(String[] args) {
    List<String> ls = List.of("Fred", "Jim", "Sheila");

    System.out.println("ls is " + ls);
    System.out.println("type of ls is " + ls.getClass());

    CharSequence[] sa = getAsArray(ls, CharSequence.class);
    System.out.println("sa is " + Arrays.toString(sa));
    System.out.println("type of ls is " + sa.getClass());

  }
}
