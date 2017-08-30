package de.jdufner.tutorials.tuermevonhanoi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Jürgen Dufner
 * @author Martin Beyer
 * @since 1.0
 */
public class TuermeVonHanoiTest {

  @Test
  public void testInitGameMit3StapelUnd5Muenzen() {
    // arrange
    int hoehe = 5;
    TuermeVonHanoi tuermeVonHanoi = new TuermeVonHanoi(hoehe);

    // act
    Stapel[] stand = tuermeVonHanoi.getStapel();

    // assert
    assertEquals(hoehe, stand[0].getHoehe());
    assertEquals(0, stand[1].getHoehe());
    assertEquals(0, stand[2].getHoehe());
  }

  @Test
  public void testInitGameUndFuehreEinenZugDurch() {
    // arrange
    int hoehe = 1;
    TuermeVonHanoi tuermeVonHanoi = new TuermeVonHanoi(hoehe);

    // act
    tuermeVonHanoi.verschiebeMuenzenVonStartAufZielStapel(hoehe, 0, 1, 2);

    // assert
    assertEquals(0, tuermeVonHanoi.getStapel()[0].getHoehe());
    assertEquals(0, tuermeVonHanoi.getStapel()[0].getGroesseVonMuenze());
    assertEquals(1, tuermeVonHanoi.getStapel()[1].getHoehe());
    assertEquals(1, tuermeVonHanoi.getStapel()[1].getGroesseVonMuenze());
    assertEquals(0, tuermeVonHanoi.getStapel()[2].getHoehe());
    assertEquals(0, tuermeVonHanoi.getStapel()[2].getGroesseVonMuenze());
  }

  @Test
  public void testInitGameHoehe2UndFuehreEinenZugDurch() {
    // arrange
    int hoehe = 2;
    TuermeVonHanoi tuermeVonHanoi = new TuermeVonHanoi(hoehe);

    // act
    tuermeVonHanoi.verschiebeMuenzenVonStartAufZielStapel(hoehe, 0, 1, 2);

    // assert
    assertEquals(0, tuermeVonHanoi.getStapel()[0].getHoehe());
    assertEquals(0, tuermeVonHanoi.getStapel()[0].getGroesseVonMuenze());
    assertEquals(2, tuermeVonHanoi.getStapel()[1].getHoehe());
    assertEquals(1, tuermeVonHanoi.getStapel()[1].getGroesseVonMuenze());
    assertEquals(0, tuermeVonHanoi.getStapel()[2].getHoehe());
    assertEquals(0, tuermeVonHanoi.getStapel()[2].getGroesseVonMuenze());
  }

  @Test
  public void testInitGameHoehe3UndFuehreEinenZugDurch() {
    // arrange
    int hoehe = 3;
    TuermeVonHanoi tuermeVonHanoi = new TuermeVonHanoi(hoehe);

    // act
    tuermeVonHanoi.verschiebeMuenzenVonStartAufZielStapel(hoehe, 0, 1, 2);

    // assert
    assertEquals(0, tuermeVonHanoi.getStapel()[0].getHoehe());
    assertEquals(0, tuermeVonHanoi.getStapel()[0].getGroesseVonMuenze());
    assertEquals(3, tuermeVonHanoi.getStapel()[1].getHoehe());
    assertEquals(1, tuermeVonHanoi.getStapel()[1].getGroesseVonMuenze());
    assertEquals(0, tuermeVonHanoi.getStapel()[2].getHoehe());
    assertEquals(0, tuermeVonHanoi.getStapel()[2].getGroesseVonMuenze());
  }

  @Test
  public void testInitGameHoehe4UndFuehreEinenZugDurch() {
    // arrange
    int hoehe = 4;
    TuermeVonHanoi tuermeVonHanoi = new TuermeVonHanoi(hoehe);

    // act
    tuermeVonHanoi.verschiebeMuenzenVonStartAufZielStapel(hoehe, 0, 1, 2);

    // assert
    assertEquals(0, tuermeVonHanoi.getStapel()[0].getHoehe());
    assertEquals(0, tuermeVonHanoi.getStapel()[0].getGroesseVonMuenze());
    assertEquals(4, tuermeVonHanoi.getStapel()[1].getHoehe());
    assertEquals(1, tuermeVonHanoi.getStapel()[1].getGroesseVonMuenze());
    assertEquals(0, tuermeVonHanoi.getStapel()[2].getHoehe());
    assertEquals(0, tuermeVonHanoi.getStapel()[2].getGroesseVonMuenze());
  }

}
