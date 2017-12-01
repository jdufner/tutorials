package de.jdufner.tutorials.pattern.strategy.reflection.strategies;

import de.jdufner.tutorials.pattern.strategy.reflection.types.OneType;
import org.springframework.stereotype.Component;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@Component
public class OneStrategy implements Strategy<OneType> {

  public static final String NAME = "a simple strategy";

  @Override
  public String executeStrategy() {
    return NAME;
  }

}