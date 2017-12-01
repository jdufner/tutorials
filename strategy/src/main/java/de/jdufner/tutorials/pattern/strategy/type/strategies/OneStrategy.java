package de.jdufner.tutorials.pattern.strategy.type.strategies;

import de.jdufner.tutorials.pattern.strategy.type.types.OneType;
import de.jdufner.tutorials.pattern.strategy.type.types.Type;
import org.springframework.stereotype.Component;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@Component
public class OneStrategy implements Strategy {

  public static final String NAME = "a simple strategy";

  @Override
  public Type getType() {
    return new OneType();
  }

  @Override
  public String executeStrategy() {
    return NAME;
  }

}