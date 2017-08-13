package de.jdufner.tutorials.tuermevonhanoi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Jürgen Dufner
 * @author Martin Beyer
 * @since 1.0
 */
public class StapelTest {

  @Test
  public void testConstructor() {
    // arrange
    Stapel s = new Stapel(5, 5);

    // act
    int muenze = s.getObersteMuenze();

    // assert
    assertEquals(1, muenze);
    assertEquals(4, s.getHoehe());
  }

  @Test
  public void testConstructorTeilbefuellt() {
    // arrange
    Stapel s = new Stapel(1, 5);

    // act
    s.setObersteMuenze(s.getObersteMuenze());

    // assert
    assertEquals(1, s.getHoehe());
  }

  @Test
  public void testGetObersteMuenzeEntferntEineMuenze() {
    // arrange
    Stapel s = new Stapel(5, 5);

    // act
    int muenze1 = s.getObersteMuenze();
    int muenze2 = s.getObersteMuenze();

    // assert
    assertEquals(1, muenze1);
    assertEquals(2, muenze2);
    assertEquals(3, s.getHoehe());
  }

  @Test
  public void testGetZweiObersteMuenzeBeiHoeheEins() {
    // arrange
    Stapel s = new Stapel(1, 5);

    // act
    int muenze1 = s.getObersteMuenze();
    int muenze0 = s.getObersteMuenze();

    // assert
    assertEquals(1, muenze1);
    assertEquals(0, muenze0);
    assertEquals(0, s.getHoehe());
  }

  @Test
  public void testLegeMuenzeVonEinemTeilbefuelltenStapelAufEinenAnderen() {
    // arrange
    Stapel s1 = new Stapel(1, 5);
    Stapel s2 = new Stapel(0, 5);

    // act
    s2.setObersteMuenze(s1.getObersteMuenze());

    // assert
    assertEquals(0, s1.getHoehe());
    assertEquals(1, s2.getHoehe());
  }

  @Test
  public void testLegeMuenzeVonEinemVollbefuelltenStapelAufEinenAnderen() {
    // arrange
    Stapel s1 = new Stapel(5, 5);
    Stapel s2 = new Stapel(0, 5);

    // act
    s2.setObersteMuenze(s1.getObersteMuenze());

    // assert
    assertEquals(4, s1.getHoehe());
    assertEquals(1, s2.getHoehe());
  }

}