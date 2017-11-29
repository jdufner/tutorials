package de.jdufner.tutorials.pattern.strategy.client;

import de.jdufner.tutorials.pattern.strategy.enums.Art;
import de.jdufner.tutorials.pattern.strategy.strategies.OneStrategy;
import de.jdufner.tutorials.pattern.strategy.strategies.ThreeStrategy;
import de.jdufner.tutorials.pattern.strategy.strategies.TwoStrategy;
import de.jdufner.tutorials.pattern.strategy.types.OneType;
import de.jdufner.tutorials.pattern.strategy.types.ThreeType;
import de.jdufner.tutorials.pattern.strategy.types.TwoType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

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

  @Test
  public void whenArtOneExecuteStrategyOne() {
    assertEquals(OneStrategy.NAME, client.executeStrategy(Art.ONE));
  }

  @Test
  public void whenArtTwoExecuteStrategyTwo() {
    assertEquals(TwoStrategy.NAME, client.executeStrategy(Art.TWO));
  }

  @Test
  public void whenArtThreeExecuteStrategyThree() {
    assertEquals(ThreeStrategy.NAME, client.executeStrategy(Art.THREE));
  }

  @Configuration
  @ComponentScan(basePackages = "de.jdufner.tutorials.pattern.strategy")
  static class StrategyClientTestConfiguration {
  }

}
