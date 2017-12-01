package de.jdufner.tutorials.pattern.strategy.enumeration.strategies;

import de.jdufner.tutorials.pattern.strategy.enumeration.enums.Art;
import org.springframework.stereotype.Component;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@Component
public class OneStrategy implements Strategy {

  public static final String NAME = "a simple strategy";

  @Override
  public Art getArt() {
    return Art.ONE;
  }

  @Override
  public String executeStrategy() {
    return NAME;
  }

}