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

  public void fuehreEinenZugDurch() {
    int stapelIndex = gibStapelIndexMitKleinsterMuenze();
    int muenze = stapel[stapelIndex].getObersteMuenze();
  }

  private int gibStapelIndexMitKleinsterMuenze() {
    int index = 0;
    for (int i = 0; i < stapel.length; i++) {
      if (stapel[i].getGroesseVonMuenze() < stapel[index].getGroesseVonMuenze()) {
        index = i;
      }
    }
    return index;
  }

}
