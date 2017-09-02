package de.jdufner.tutorials.tuermevonhanoi;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author Jürgen Dufner
 * @author Martin Beyer
 * @since 1.0
 */
public class TuermeVonHanoi {

  private Stapel[] stapel = new Stapel[3];

  public TuermeVonHanoi(int hoehe) {
    stapel[0] = new Stapel(hoehe, hoehe);
    stapel[1] = new Stapel(0, hoehe);
    stapel[2] = new Stapel(0, hoehe);
    System.out.println(toString());
  }

  public void setStapel(final Stapel[] stapel) {
    this.stapel = stapel;
  }

  public Stapel[] getStapel() {
    return stapel;
  }

  public void verschiebeMuenzenVonStartAufZielStapel(int hoehe, int startStapel, int zielStapel, int zwischenStapel) {
    if (hoehe > 1) {
      verschiebeMuenzenVonStartAufZielStapel(hoehe - 1, startStapel, zwischenStapel, zielStapel);
      verschiebeMuenzeVonNach(startStapel, zielStapel);
      verschiebeMuenzenVonStartAufZielStapel(hoehe - 1, zwischenStapel, zielStapel, startStapel);
    } else {
      verschiebeMuenzeVonNach(startStapel, zielStapel);
    }
  }

  private void verschiebeMuenzeVonNach(final int startStapel, final int zielStapel) {
    verschiebeMuenzeVonNach(stapel[startStapel], stapel[zielStapel]);
  }

  private void verschiebeMuenzeVonNach(final Stapel startStapel, final Stapel zielStapel) {
    zielStapel.setObersteMuenze(startStapel.getObersteMuenze());
    System.out.println();
    System.out.println(toString());
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(stapel, ToStringStyle.SIMPLE_STYLE);
  }
}
