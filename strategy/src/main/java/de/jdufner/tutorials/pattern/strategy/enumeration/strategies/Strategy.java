package de.jdufner.tutorials.pattern.strategy.enumeration.strategies;

import de.jdufner.tutorials.pattern.strategy.enumeration.enums.Art;
import de.jdufner.tutorials.pattern.strategy.enumeration.types.Type;

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
   * A strategy must know to which enumeration {@link Art} it belongs.
   *
   * @return
   */
  Art getArt();

  String executeStrategy();

}