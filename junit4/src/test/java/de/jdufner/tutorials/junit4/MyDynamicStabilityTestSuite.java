package de.jdufner.tutorials.junit4;

import de.jdufner.tutorial.mapreduce.model.GroupTest;
import de.jdufner.tutorial.mapreduce.model.PersonTest;
import de.jdufner.tutorials.functional.FibonacciGenericFunctionalTest;
import de.jdufner.tutorials.functional.FibonacciSpezializedFunctionalTest;
import de.jdufner.tutorials.functional.FibonacciTest;
import de.jdufner.tutorials.functional.StabilityTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(StabilityTest.class)
@Suite.SuiteClasses({MyStaticStabilityTest.class, GroupTest.class, PersonTest.class,
    FibonacciGenericFunctionalTest.class, FibonacciSpezializedFunctionalTest.class, FibonacciTest
    .class})

public class MyDynamicStabilityTestSuite {
}
