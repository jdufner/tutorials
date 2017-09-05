package de.jdufner.tutorials.tin;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class TinTest {

  @Test
  public void testCreate() {
    // arrange
    long l = 12345678901L;

    // act
    Tin tin = new Tin(l);

    // assert
    assertThat(tin.toString()).isEqualTo(String.valueOf(l));
  }

  @Test
  public void whenEinPaarInNummer_expectValid() {
    // arrange

    // act
    Tin tin = new Tin(11234567890L);

    // assert
    assertThat(tin.isValid()).isTrue();
  }

  @Test
  public void whenEinPaarAuseinanderstehendInNummer_expectValid() {
    // arrange

    // act
    Tin tin = new Tin(12345678911L);

    // assert
    assertThat(tin.isValid()).isTrue();
  }

  @Test
  public void whenZweiPaareInNummer_expectNotValid() {
    // arrange

    // act
    Tin tin = new Tin(11223456789L);

    // assert
    assertThat(tin.isValid()).isFalse();
  }

  @Test
  public void whenEinTripleInNummer_expectNotValid() {
    // arrange

    // act
    Tin tin = new Tin(11123456789L);

    // assert
    assertThat(tin.isValid()).isFalse();
  }

  @Test
  public void whenEinTripleAuseinanderstehendInNummer_expectValid() {
    // arrange

    // act
    Tin tin = new Tin(11234567816L);

    // assert
    assertThat(tin.isValid()).isTrue();
  }

  @Test
  public void whenEinQuartettInNummer_expectNotValid() {
    // arrange

    // act
    Tin tin = new Tin(12131415678L);

    // assert
    assertThat(tin.isValid()).isFalse();
  }

  @Test
  public void whenKleinsteMoeglicheNummer_expectValid() {
    assertThat(new Tin(10020345677L).isValid()).isTrue();
  }

  @Test
  public void whenStetigSteigendeNummer_expectValid() {
    assertThat(new Tin(12345678903L).isValid()).isTrue();
  }

  @Test
  @Ignore
  public void generator() {
    for (long l = 10020345670L; l < 10123456789L; l++) {
      Tin tin = new Tin(l);
      if (tin.isValid()) {
        System.out.println(tin);
      }
    }
  }

}
