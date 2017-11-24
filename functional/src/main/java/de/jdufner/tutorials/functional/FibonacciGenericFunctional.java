package de.jdufner.tutorials.functional;

import java.util.function.IntUnaryOperator;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class FibonacciGenericFunctional {

  static final IntUnaryOperator FKT = i -> {
    if (i == 0) {
      return 0;
    }
    if (i == 1) {
      return 1;
    }
    return FibonacciGenericFunctional.FKT.applyAsInt(i - 1) +
        FibonacciGenericFunctional.FKT.applyAsInt(i - 2);
  };

}
