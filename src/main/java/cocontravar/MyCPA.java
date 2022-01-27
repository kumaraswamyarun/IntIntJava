package cocontravar;

import java.util.List;
import java.util.function.Predicate;

public class MyCPA {
  public static void prepareTaxes(Taxable t) {}

//  public static <T extends Taxable> void prepareBulkTaxes(List<T> lt, Predicate<T> pt) {
//  public static <T extends Taxable> void prepareBulkTaxes(List<T> lt) {
  public static void prepareBulkTaxes(List<? extends Taxable> lt) {
//    lt.add(new Corporation());
//    lt.add(new Taxable());
//    lt.add(new Individual());
//    T t1 = lt.get(0); // can only do this if we "captured" T
    for (Taxable t : lt) { // Taxable t = lt.get(index)...
      prepareTaxes(t);
    }
  }

// THESE FIRST THREE ARE CONCEPTUALLY GOOD, BUT SYNTACTICALLY BAD
//  public static <Individual extends T> void collectJoesClients(List<T> li) {
//  public static <T is assignable from Individual> void collectJoesClients(List<T> li) {
//  public static <T super Individual> void collectJoesClients(List<T> li) {
  public static void collectJoesClients(List<? super Individual> li) {
    li.add(new Individual());
//    Individual i = li.get(0);
  }

  public static void main(String[] args) {
    List<Taxable> clients = List.of(
        new Individual(),
        new Corporation(),
        new Corporation()
    );

    prepareBulkTaxes(clients);

    List<Individual> joesClients = List.of(
        new Individual(),
        new Individual(),
        new Individual()
    );

//    collectJoesClients(joesClients);
    collectJoesClients(clients);

    // Liskov substitution principle (is the L is SOLID)
    // if I think that a "is a" B then a must "substitute,
    // without causing surprises" for a B in all circumstances
    // BOTH syntax AND semantics...
    prepareBulkTaxes(joesClients);


  }
}
