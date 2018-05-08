package de.jdufner.tutorials.junit4;

import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class MySuiteRunner extends ParentRunner<FrameworkMethod> {

  public MySuiteRunner(final Class<?> testClass) throws InitializationError {
    super(testClass);
  }

  @Override
  protected List<FrameworkMethod> getChildren() {
    return null;
  }

  @Override
  protected Description describeChild(final FrameworkMethod frameworkMethod) {
    return null;
  }

  @Override
  protected void runChild(final FrameworkMethod frameworkMethod, final RunNotifier runNotifier) {

  }

}
