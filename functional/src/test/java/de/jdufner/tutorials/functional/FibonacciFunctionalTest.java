package de.jdufner.tutorials.functional;

import org.junit.Test;

import static de.jdufner.tutorials.functional.FibonacciFunctional.fibonacci;
import static org.junit.Assert.assertEquals;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class FibonacciFunctionalTest {

  @Test
  public void testFibonacci_when0_expect0() {

    // act
    int result = fibonacci(0);

    // assert
    assertEquals(0, result);
  }

  @Test
  public void testFibonacci_when1_expect1() {

    // act
    int result = fibonacci(1);

    // assert
    assertEquals(1, result);
  }

  @Test
  public void testFibonacci_when2_expect1() {

    // act
    int result = fibonacci(2);

    // assert
    assertEquals(1, result);
  }

  @Test
  public void testFibonacci_when3_expect2() {

    // act
    int result = fibonacci(3);

    // assert
    assertEquals(2, result);
  }

  @Test
  public void testFibonacci_when4_expect3() {

    // act
    int result = fibonacci(4);

    // assert
    assertEquals(3, result);
  }

  @Test
  public void testFibonacci_when5_expect5() {

    // act
    int result = fibonacci(5);

    // assert
    assertEquals(5, result);
  }

  @Test
  public void testFibonacci_when6_expect8() {

    // act
    int result = fibonacci(6);

    // assert
    assertEquals(8, result);
  }
}