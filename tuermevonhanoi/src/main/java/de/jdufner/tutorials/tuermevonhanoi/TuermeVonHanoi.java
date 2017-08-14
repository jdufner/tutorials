package de.jdufner.tutorials.tuermevonhanoi;

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
  }

  public void setStapel(final Stapel[] stapel) {
    this.stapel = stapel;
  }

  public Stapel[] getStapel() {
    return stapel;
  }

  public void verschiebeObereMuenzenAufZwischenStapelUndUntersteMuenzeAufZielStapel(int startStapel, int zielStapel, int zwischenStapel) {
    if (stapel[startStapel].getHoehe() > 1) {
      verschiebeObersteMuenzeAufZwischenStapel(startStapel, zwischenStapel);
      verschiebeUntereMuenzenAufZielStapel(startStapel, zielStapel);
      verschiebeMuenzeVonZwischenStapelAufZielStapel(zwischenStapel, zielStapel);
    } else {
      verschiebeUntereMuenzenAufZielStapel(startStapel, zielStapel);
    }
  }

  private void verschiebeUntereMuenzenAufZielStapel(final int startStapel, final int zielStapel) {
    verschiebeMuenzeVonNach(stapel[startStapel], stapel[zielStapel]);
  }

  private void verschiebeMuenzeVonZwischenStapelAufZielStapel(final int zwischenStapel, final int zielStapel) {
    verschiebeMuenzeVonNach(stapel[zwischenStapel], stapel[zielStapel]);
  }

  private void verschiebeObersteMuenzeAufZwischenStapel(final int startStapel, final int zwischenStapel) {
    verschiebeMuenzeVonNach(stapel[startStapel], stapel[zwischenStapel]);
  }

  private void verschiebeMuenzeVonNach(final Stapel stapel, final Stapel stapel1) {
    stapel1.setObersteMuenze(stapel.getObersteMuenze());
  }

}
