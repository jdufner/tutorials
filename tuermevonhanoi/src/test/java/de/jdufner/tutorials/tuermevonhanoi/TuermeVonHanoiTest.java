package de.jdufner.tutorials.tuermevonhanoi;

import org.junit.Assert;
import org.junit.Test;

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
    Assert.assertEquals(hoehe, stand[0].getHoehe());
    Assert.assertEquals(0, stand[1].getHoehe());
    Assert.assertEquals(0, stand[2].getHoehe());
  }

  @Test
  public void testInitGameUndFuehreEinenZugDurch() {
    // arrange
    int hoehe = 5;
    TuermeVonHanoi tuermeVonHanoi = new TuermeVonHanoi(hoehe);

    // act
    tuermeVonHanoi.fuehreEinenZugDurch();


    // assert
    Assert.assertEquals(4, tuermeVonHanoi.getStapel()[0].getHoehe());
    Assert.assertEquals(1, tuermeVonHanoi.getStapel()[1].getHoehe());
    Assert.assertEquals(0, tuermeVonHanoi.getStapel()[2].getHoehe());
  }

  @Test
  public void testInitGameUndFuehreZweiZuegeDurch() {
    // arrange
    int hoehe = 5;
    TuermeVonHanoi tuermeVonHanoi = new TuermeVonHanoi(hoehe);

    // act
    tuermeVonHanoi.fuehreEinenZugDurch();
    tuermeVonHanoi.fuehreEinenZugDurch();


    // assert
    Assert.assertEquals(3, tuermeVonHanoi.getStapel()[0].getHoehe());
    Assert.assertEquals(1, tuermeVonHanoi.getStapel()[1].getHoehe());
    Assert.assertEquals(1, tuermeVonHanoi.getStapel()[2].getHoehe());
  }

}
