package de.jdufner.tutorials.pattern.strategy.strategies;

import de.jdufner.tutorials.pattern.strategy.enums.Art;
import de.jdufner.tutorials.pattern.strategy.types.TwoType;
import de.jdufner.tutorials.pattern.strategy.types.Type;
import org.springframework.stereotype.Component;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@Component
public class TwoStrategy implements Strategy {

  public static final String NAME = "another strategy";

  @Override
  public Type getType() {
    return new TwoType();
  }

  @Override
  public Art getArt() {
    return Art.TWO;
  }

  @Override
  public String executeStrategy() {
    return NAME;
  }

}