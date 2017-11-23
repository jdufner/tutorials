package de.jdufner.tutorials.functional;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class FibonacciClassTest {

  @Test
  public void testFibonacci_when0_expect0() {
    // arrange
    FibonacciClass fibonacci = new FibonacciClass();

    // act
    int result = fibonacci.fibonacci(0);

    // assert
    assertEquals(0, result);
  }

}