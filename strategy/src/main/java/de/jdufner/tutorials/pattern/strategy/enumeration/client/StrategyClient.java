package de.jdufner.tutorials.pattern.strategy.enumeration.client;

import de.jdufner.tutorials.pattern.strategy.enumeration.enums.Art;
import de.jdufner.tutorials.pattern.strategy.enumeration.strategies.Strategy;
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

  public String executeStrategy(final Art art) {
    return getStrategy(art).executeStrategy();
  }

  private Strategy getStrategy(final Art art) {
    return strategies.stream().filter(s -> s.getArt() == art).findFirst().get();
  }

}