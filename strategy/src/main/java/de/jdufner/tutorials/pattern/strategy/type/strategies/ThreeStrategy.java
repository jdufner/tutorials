package de.jdufner.tutorials.pattern.strategy.type.strategies;

import de.jdufner.tutorials.pattern.strategy.type.types.ThreeType;
import de.jdufner.tutorials.pattern.strategy.type.types.Type;
import org.springframework.stereotype.Component;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@Component
public class ThreeStrategy implements Strategy {

  public static final String NAME = "a complex strategy";

  @Override
  public Type getType() {
    return new ThreeType();
  }

  @Override
  public String executeStrategy() {
    return NAME;
  }

}