package de.jdufner.tutorials.pattern.strategy.reflection.strategies;

import de.jdufner.tutorials.pattern.strategy.reflection.types.ThreeType;
import org.springframework.stereotype.Component;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@Component
public class ThreeStrategy implements Strategy<ThreeType> {

  public static final String NAME = "a complex strategy";

  @Override
  public String executeStrategy() {
    return NAME;
  }

}
