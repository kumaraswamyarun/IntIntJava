package tryaset;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UseSet {
  public static void main(String[] args) {
    // must be "comparable" or have a specific comparator
//    Set<Object> so = new TreeSet<>();

    // objects must implement equals and hashcode correctly
    Set<Object> so = new HashSet<>();
    so.add(new Object());
  }
}
