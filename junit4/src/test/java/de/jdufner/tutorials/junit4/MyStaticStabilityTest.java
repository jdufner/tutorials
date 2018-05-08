package de.jdufner.tutorials.junit4;

import de.jdufner.tutorials.functional.StabilityTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@Category(StabilityTest.class)
public class MyStaticStabilityTest {

  @Test
  public void arbitraryTest() {
    Assert.assertTrue(true);
  }

}
