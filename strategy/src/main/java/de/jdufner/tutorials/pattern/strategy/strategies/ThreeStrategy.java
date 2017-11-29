package de.jdufner.tutorials.pattern.strategy.strategies;

import de.jdufner.tutorials.pattern.strategy.enums.Art;
import de.jdufner.tutorials.pattern.strategy.types.ThreeType;
import de.jdufner.tutorials.pattern.strategy.types.Type;
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
  public Art getArt() {
    return Art.THREE;
  }

  @Override
  public String executeStrategy() {
    return NAME;
  }

}