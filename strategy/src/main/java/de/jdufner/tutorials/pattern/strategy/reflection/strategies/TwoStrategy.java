package de.jdufner.tutorials.pattern.strategy.reflection.strategies;

import de.jdufner.tutorials.pattern.strategy.reflection.types.TwoType;
import org.springframework.stereotype.Component;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@Component
public class TwoStrategy implements Strategy<TwoType> {

  public static final String NAME = "another strategy";

  @Override
  public String executeStrategy() {
    return NAME;
  }

}
