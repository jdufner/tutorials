package de.jdufner.tutorials.junit4;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class FooSuite {

  @Test(timeout = 1000)
  public void test() {
    Class<?>[] cls = {FooTest.class};

    //Parallel among classes
    // JUnitCore.runClasses(ParallelComputer.classes(), cls);

    //Parallel among methods in a class
    // JUnitCore.runClasses(ParallelComputer.methods(), cls);

    //Parallel all methods in all classes
    JUnitCore.runClasses(new ParallelComputer(true, true), cls);
  }

}
