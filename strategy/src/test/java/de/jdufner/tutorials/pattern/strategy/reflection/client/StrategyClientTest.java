package de.jdufner.tutorials.pattern.strategy.reflection.client;

import static org.junit.Assert.assertEquals;

import de.jdufner.tutorials.pattern.strategy.reflection.strategies.OneStrategy;
import de.jdufner.tutorials.pattern.strategy.reflection.strategies.ThreeStrategy;
import de.jdufner.tutorials.pattern.strategy.reflection.strategies.TwoStrategy;
import de.jdufner.tutorials.pattern.strategy.reflection.types.OneType;
import de.jdufner.tutorials.pattern.strategy.reflection.types.ThreeType;
import de.jdufner.tutorials.pattern.strategy.reflection.types.TwoType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class StrategyClientTest {

  @Autowired
  private StrategyClient client;

  @Test
  public void whenTypeOneExecuteStrategyOne() {
    assertEquals(OneStrategy.NAME, client.executeStrategy(new OneType()));
  }

  @Test
  public void whenTypeTwoExecuteStrategyTwo() {
    assertEquals(TwoStrategy.NAME, client.executeStrategy(new TwoType()));
  }

  @Test
  public void whenTypeThreeExecuteStrategyThree() {
    assertEquals(ThreeStrategy.NAME, client.executeStrategy(new ThreeType()));
  }

  @Configuration
  @ComponentScan(basePackages = "de.jdufner.tutorials.pattern.strategy.reflection")
  static class StrategyClientTestConfiguration {
  }

}
