package de.jdufner.tutorials.pattern.strategy.strategies;

import de.jdufner.tutorials.pattern.strategy.enums.Art;
import de.jdufner.tutorials.pattern.strategy.types.Type;

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

  /**
   * A strategy must know to which enum {@link Art} it belongs.
   *
   * @return
   */
  Art getArt();

  String executeStrategy();

}