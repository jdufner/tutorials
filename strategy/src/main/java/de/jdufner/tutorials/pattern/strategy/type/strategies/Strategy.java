package de.jdufner.tutorials.pattern.strategy.type.strategies;

import de.jdufner.tutorials.pattern.strategy.type.types.Type;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public interface Strategy {

  /**
   * A strategy must know to which type it belongs.
   *
   * @return
   */
  Type getType();

  String executeStrategy();

}