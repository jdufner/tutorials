package de.jdufner.tutorials.tuermevonhanoi;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author Jürgen Dufner
 * @author Martin Beyer
 * @since 1.0
 */
public class Stapel implements Serializable {

  private int[] muenzen;

  public Stapel(final int muenzen, int hoehe) {
    this.muenzen = new int[hoehe];
    int counter = 1;
    for (int i = hoehe - muenzen; i < hoehe; i++) {
      this.muenzen[i] = counter;
      counter++;
    }
  }

  public int getHoehe() {
    int counter = 0;
    for (int i = 0; i < muenzen.length; i++) {
      if (muenzen[i] > 0) {
        counter++;
      }
    }
    return counter;
  }

  public int getObersteMuenze() {
    for (int i = 0; i < muenzen.length; i++) {
      if (muenzen[i] > 0) {
        int muenze = muenzen[i];
        muenzen[i] = 0;
        return muenze;
      }
    }
    return 0;
  }

  public void setObersteMuenze(final int obersteMuenze) {
    for (int i = muenzen.length - 1; i >= 0; i--) {
      if (muenzen[i] == 0) {
        muenzen[i] = obersteMuenze;
        return;
      }
    }
  }

  public int getGroesseVonMuenze() {
    for (int i = 0; i < muenzen.length; i++) {
      if (muenzen[i] > 0) {
        return muenzen[i];
      }
    }
    return 0;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(muenzen, ToStringStyle.SIMPLE_STYLE);
  }
}
