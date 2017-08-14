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
    tuermeVonHanoi.verschiebeObereMuenzenAufZwischenStapelUndUntersteMuenzeAufZielStapel(0, 1, 2);

    // assert
    assertEquals(0, tuermeVonHanoi.getStapel()[0].getHoehe());
    assertEquals(1, tuermeVonHanoi.getStapel()[1].getHoehe());
    assertEquals(1, tuermeVonHanoi.getStapel()[1].getGroesseVonMuenze());
    assertEquals(0, tuermeVonHanoi.getStapel()[2].getHoehe());
    assertEquals(0, tuermeVonHanoi.getStapel()[2].getGroesseVonMuenze());
  }

}
