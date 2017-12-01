package de.jdufner.tutorials.pattern.strategy.enumeration.client;

import de.jdufner.tutorials.pattern.strategy.enumeration.enums.Art;
import de.jdufner.tutorials.pattern.strategy.enumeration.strategies.Strategy;
import de.jdufner.tutorials.pattern.strategy.enumeration.types.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;


/**
 * @author Jürgen Dufner
 * @since 1.0
 */
@Component
public class StrategyClient {

  private Collection<Strategy> strategies;

  @Autowired
  public StrategyClient(Collection<Strategy> strategies) {
    this.strategies = strategies;
  }

  public String executeStrategy(Type type) {
    return getStrategy(type).executeStrategy();
  }

  private Strategy getStrategy(Type type) {
    return strategies.stream()
        .filter(s -> s.getType().getClass() == type.getClass())
        .findFirst()
        .get();
  }

  public String executeStrategy(Art art) {
    return getStrategy(art).executeStrategy();
  }

  private Strategy getStrategy(Art art) {
    return strategies.stream().filter(s -> s.getArt() == art).findFirst().get();
  }

}