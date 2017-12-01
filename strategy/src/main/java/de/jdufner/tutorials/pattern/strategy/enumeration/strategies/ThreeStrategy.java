package de.jdufner.tutorials.pattern.strategy.enumeration.strategies;

import de.jdufner.tutorials.pattern.strategy.enumeration.enums.Art;
import org.springframework.stereotype.Component;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@Component
public class ThreeStrategy implements Strategy {

  public static final String NAME = "a complex strategy";

  @Override
  public Art getArt() {
    return Art.THREE;
  }

  @Override
  public String executeStrategy() {
    return NAME;
  }

}