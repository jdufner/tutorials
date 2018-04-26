package de.jdufner.tutorials.junit4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jürgen Dufner
 * @since 0.3
 */
public class Foo {

  private static final Logger LOG = LoggerFactory.getLogger(Foo.class);

  public void bar(final int i) {
    LOG.info("Foo.bar(" + i + ")");
  }

  public void snafu(final int i) {
    LOG.info("Foo.snafu(" + i + ")");
  }

}
