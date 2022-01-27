package annotations;

import java.lang.reflect.Method;

public class TestHarness {
  public static void main(String[] args) throws Throwable {
    String classToTest = "annotations.TestClass";
//    Class<? extends Object>
    Class<?> cl = Class.forName(classToTest);
    System.out.println(cl);
    Object obj = cl.getConstructor().newInstance();
    System.out.println(obj);

    Method[] ma = cl.getDeclaredMethods();
    for (Method m : ma) {
      System.out.println(m);
      RunMe annot = m.getAnnotation(RunMe.class);
      if (annot != null) {
        System.out.println("***** RunMe found!");
        m.setAccessible(true); // if running in a module system
        // access overriding is disabled between modules by default,
        // in fact reflection between modules is disabled by default
        m.invoke(obj);
      }
    }
  }
}
