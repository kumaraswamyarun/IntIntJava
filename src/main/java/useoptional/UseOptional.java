package useoptional;

import java.util.Map;
import java.util.Optional;

public class UseOptional {
  public static String getCustName() {
    return "Freddy";
  }

  public static void main(String[] args) {
    Map<String, String> names = Map.of("Fred", "Jones", "Alice", "Smith");

    String firstName = getCustName();
    String lastName = names.get(firstName);
    if (lastName != null) {
      String message = "Dear " + lastName.toUpperCase();
      System.out.println(message);
    }

    Optional<Map<String, String>> omss = Optional.of(names);

    omss.map(m -> m.get(firstName))
        .map(n -> n.toUpperCase())
        .map(u -> "Dear " + u)
        .ifPresent(System.out::println);
  }
}
