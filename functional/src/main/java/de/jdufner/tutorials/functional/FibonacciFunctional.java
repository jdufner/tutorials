package de.jdufner.tutorials.functional;

import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class FibonacciFunctional {

  static final IntSupplier nullFkt = () -> 0;

  static final IntSupplier oneFkt = () -> 1;

  static final IntUnaryOperator fkt = i -> {
    if (i == 0) {
      return FibonacciFunctional.nullFkt.getAsInt();
    }
    if (i == 1) {
      return FibonacciFunctional.oneFkt.getAsInt();
    }
    return FibonacciFunctional.fkt.applyAsInt(i - 1) + FibonacciFunctional.fkt.applyAsInt(i - 2);
  };

  public static int fibonacci(final int x) {
    return fkt.applyAsInt(x);
  }

}
