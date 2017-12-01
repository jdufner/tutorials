package de.jdufner.tutorials.pattern.strategy.reflection.strategies;

import de.jdufner.tutorials.pattern.strategy.reflection.types.Type;

import java.lang.reflect.ParameterizedType;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public interface Strategy<T extends Type> {

  String executeStrategy();

  default Class getTypeOf(final Strategy<? extends Type> strategy) {
    final java.lang.reflect.Type[] genericInterfaces = strategy.getClass().getGenericInterfaces();
    for (java.lang.reflect.Type genericInterface : genericInterfaces) {
      if (genericInterface instanceof ParameterizedType) {
        final ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
        if (parameterizedType.getRawType().equals(Strategy.class)) {
          return (Class) parameterizedType.getActualTypeArguments()[0];
        }
      } else {
        throw new RuntimeException(
            "Implements " + getClass().getSimpleName() + " a generic interface ?");
      }
    }
    return null;
  }

}
