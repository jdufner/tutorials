package de.jdufner.tutorials.tupel;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jürgen Dufner
 * @since 0.3
 */
public class TupelBuilderTest {

  @Test
  public void whenTupelGroesse8ExpectAnzahlElement57() {
    // arrange
    // act + assert
    assertThat(TupelBuilder.getAnzahlElements(8)).isEqualTo(57);
  }

  @Test
  public void whenTupelGroesse4ExceptFeld() {
    // arrange
    // act
    int[][] feld = TupelBuilder.initializeFeld(4);
    // assert
    assertThat(feld[0][0]).isEqualTo(1);
    assertThat(feld[0][3]).isEqualTo(4);
    assertThat(feld[3][0]).isEqualTo(1);
    assertThat(feld[3][3]).isEqualTo(13);
  }

  @Test
  public void whenStringOfExpectContainsAllTupels() {
    // arrange
    // act
    int[][] feld = TupelBuilder.initializeFeld(4);
    // assert
    assertThat(TupelBuilder.stringOf(feld)).contains("1").contains("13");
  }

  @Test
  public void whenBuildExpectAllTupels() {
    // arrange
    int size = 8;
    // act
    int[][] feld = TupelBuilder.build(size);
    // assert
    assertThat(feld).isNotNull();
    assertThat(feld.length).isEqualTo(TupelBuilder.getAnzahlElements(size)); // Anzahl Zeilen = 57
    assertThat(feld[0].length).isEqualTo(size); // Anzahl Spalten = 8
    assertThat(TupelBuilder.isValid(feld)).isTrue();
    assertThat(TupelBuilder.stringOf(feld)).contains("  1  2  3  4  5  6  7  8").contains
        ("  1 51 52 53 54 55 56 57").contains("  8 15 21 27 33 39 45 51");
  }

  @Test
  @Ignore
  public void test() {
    System.out.println(TupelBuilder.stringOf(TupelBuilder.build(3)));
  }

}