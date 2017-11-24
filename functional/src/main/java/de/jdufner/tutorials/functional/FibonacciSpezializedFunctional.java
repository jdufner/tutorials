package de.jdufner.tutorials.functional;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class FibonacciSpezializedFunctional {

  static final FibonacciFunctionalInterface FIB_FKT = (int i) -> {
    if (i == 0) {
      return 0;
    }
    if (i == 1) {
      return 1;
    }
    return FibonacciSpezializedFunctional.FIB_FKT.fibonacci(i - 1) +
        FibonacciSpezializedFunctional.FIB_FKT.fibonacci(i - 2);
  };

}
