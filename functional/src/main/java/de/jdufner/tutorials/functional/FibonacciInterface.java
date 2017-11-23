package de.jdufner.tutorials.functional;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public interface FibonacciInterface {

  default int fibonacci(final int i) {
    if (i == 0) {
      return 0;
    }
    if (i == 1) {
      return 1;
    }
    return fibonacci(i - 1) + fibonacci(i - 2);
  }

}
