package de.jdufner.tutorials.pattern.strategy.type.client;

import de.jdufner.tutorials.pattern.strategy.type.strategies.Strategy;
import de.jdufner.tutorials.pattern.strategy.type.types.Type;
import org.springframework.stereotype.Component;

import java.util.Collection;


/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@Component
public class StrategyClient {

  private final Collection<Strategy> strategies;

  public StrategyClient(final Collection<Strategy> strategies) {
    this.strategies = strategies;
  }

  public String executeStrategy(final Type type) {
    return getStrategy(type).executeStrategy();
  }

  private Strategy getStrategy(final Type type) {
    return strategies.stream()
        .filter(s -> s.getType().getName() == type.getName())
        .findFirst()
        .get();
  }

}