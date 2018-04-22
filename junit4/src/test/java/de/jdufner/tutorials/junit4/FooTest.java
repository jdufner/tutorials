package de.jdufner.tutorials.junit4;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@RunWith(Parameterized.class)
public class FooTest {

  private int input;

  public FooTest(final int input) {
    this.input = input;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{{0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}});
  }

  @Test(timeout = 1000)
  public void testBar() {
    // arrange
    Foo foo = new Foo();

    // act
    foo.bar(input);

    // assert
  }

  @Test(timeout = 1000)
  public void testSnafu() {
    // arrange
    Foo foo = new Foo();

    // act
    foo.snafu(input);

    // assert
  }

}
