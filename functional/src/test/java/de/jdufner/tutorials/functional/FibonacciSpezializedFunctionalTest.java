package de.jdufner.tutorials.functional;

import org.junit.Test;

import static de.jdufner.tutorials.functional.FibonacciSpezializedFunctional.FIB_FKT;
import static org.junit.Assert.assertEquals;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class FibonacciSpezializedFunctionalTest {

  @Test
  public void testFibonacci_when0_expect0() {
    // act
    int result = FIB_FKT.fibonacci(0);

    // assert
    assertEquals(0, result);
  }

  @Test
  public void testFibonacci_when1_expect1() {
    // act
    int result = FIB_FKT.fibonacci(1);

    // assert
    assertEquals(1, result);
  }

  @Test
  public void testFibonacci_when2_expect1() {
    // act
    int result = FIB_FKT.fibonacci(2);

    // assert
    assertEquals(1, result);
  }

  @Test
  public void testFibonacci_when3_expect2() {
    // act
    int result = FIB_FKT.fibonacci(3);

    // assert
    assertEquals(2, result);
  }

  @Test
  public void testFibonacci_when4_expect3() {
    // act
    int result = FIB_FKT.fibonacci(4);

    // assert
    assertEquals(3, result);
  }

  @Test
  public void testFibonacci_when5_expect5() {
    // act
    int result = FIB_FKT.fibonacci(5);

    // assert
    assertEquals(5, result);
  }

  @Test
  public void testFibonacci_when6_expect8() {
    // act
    int result = FIB_FKT.fibonacci(6);

    // assert
    assertEquals(8, result);
  }

  @Test
  public void testFibonacci_when7_expect13() {
    // act
    int result = FIB_FKT.fibonacci(7);

    // assert
    assertEquals(13, result);
  }

  @Test
  public void testFibonacci_when8_expect21() {
    // act
    int result = FIB_FKT.fibonacci(8);

    // assert
    assertEquals(21, result);
  }

  @Test
  public void testFibonacci_when9_expect34() {
    // act
    int result = FIB_FKT.fibonacci(9);

    // assert
    assertEquals(34, result);
  }

  @Test
  public void testFibonacci_when10_expect55() {
    // act
    int result = FIB_FKT.fibonacci(10);

    // assert
    assertEquals(55, result);
  }

}