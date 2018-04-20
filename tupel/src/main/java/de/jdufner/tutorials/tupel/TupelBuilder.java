package de.jdufner.tutorials.tupel;

/**
 * Diese Klasse erzeugt ein Feld in dem jede Zeile mit jeder anderen Zeile genau
 * ein gemeinsames Element hat. Weiter stellt Methoden zur Prüfung und Ausgabe
 * des Felds zur Verfügung.
 *
 * @author Jürgen Dufner
 * @since 1.0
 */
public class TupelBuilder {

  private TupelBuilder() {
  }

  /**
   * Erzeugt das Feld. Beispiel für Tupelgröße 4:
   *
   * <pre>
   *  1  2  3  4
   *  1  5  6  7
   *  1  8  9 10
   *  1 11 12 13
   *  2  5  8 11
   *  2  6 10 11
   *  2  7  8 12
   *  3  5 10 12
   *  3  6  8 13
   *  3  7  9 11
   *  4  5 10 12
   *  4  6  8 13
   *  4  7  9 11
   * </pre>
   *
   * @param size
   * @return Liefert das erzeugte und vollständig befüllt Feld zurück.
   */
  public static int[][] build(final int size) {
    int[][] feld = initializeFeld(size);
    iteriereZeilenweiseUeberAlleFelder(feld);
    return feld;
  }

  private static void iteriereZeilenweiseUeberAlleFelder(final int[][] feld) {
    for (int i = 0; i < feld[0].length - 1; i++) {
      for (int j = 0; j < feld[0].length - 1; j++) {
        for (int k = 0; k < feld[0].length; k++) {
          setzeZelle(feld, i, j, k);
        }
      }
    }
  }

  private static void setzeZelle(final int[][] feld, final int i, final int j, final int k) {
    int zielZeile = feld[0].length + i * (feld[0].length - 1) + j;
    int zielSpalte = k;
    int quellZeile = k;
    int quellSpalte;
    if (zielSpalte == 0) {
      quellSpalte = i + 1;
    } else {
      quellSpalte = 1 + (j + i * (k - 1)) % (feld[0].length - 1);
    }
    feld[zielZeile][zielSpalte] = feld[quellZeile][quellSpalte];
  }

  /**
   * Erzeugt ein initialisiertes Feld mit folgender Befüllung:
   *
   * <pre>
   * 1            2     3     4  .  .          n
   * 1          n+1   n+2   n+3  .  .       2n-1
   * 1           2n  2n+1  2n+2  .  .       3n-2
   * 1         3n-1    3n  3n-1  .  .       4n-3
   * 1         4n-2  4n-1    4n  .  .       5n-4
   * .
   * .
   * 1 (n-1)n-(n-3)                     n*n-(n-1)
   * 2            0     0     0  .  .           0
   * .
   * .
   * n            0     0     0  .  .           0
   * </pre>
   *
   * Beispiel für n=8:
   *
   * <pre>
   * 1  2  3  4  5  6  7  8
   * 1  9 10 11 12 13 14 15
   * 1 16 17 18 19 20 21 22
   * 1 23 24 25 26 27 28 29
   * 1 30 31 32 33 34 35 36
   * 1 37 38 39 40 41 42 43
   * 1 44 45 46 47 48 49 50
   * 1 51 52 53 54 55 56 57
   * 2  0  0  0  0  0  0  0
   * .
   * .
   * 8  0  0  0  0  0  0  0
   * </pre>
   *
   * @param size
   * @return Ein zweidimensionales Array, erster Index ist die Zeile, zweiter
   * Index ist die Spalte.
   */
  static int[][] initializeFeld(final int size) {
    int k = 2;
    int[][] feld = new int[getAnzahlElements(size)][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (j == 0) {
          feld[i][j] = 1;
        } else {
          feld[i][j] = k;
          k++;
        }
      }
    }
    return feld;
  }

  /**
   * Berechnet die Anzahl der verschiedenen Elemente, die für die Konstruktion
   * der Tupel benötigt werden. Es ist damit die größte Zahl in
   * {@link #initializeFeld(int)}
   *
   * @param size
   * @return Anzahl der Elemente n+(n-1)<sup>2</sup>
   */
  static int getAnzahlElements(final int size) {
    return size + (size - 1) * (size - 1);
  }

  /**
   * @param feld
   * @return Liefert <code>true</code>, wenn jede Zeile jeweils ein
   * übereinstimmendes Element mit einer anderer Zeile hat, ansonsten
   * <code>false</code>.
   */
  public static boolean isValid(final int[][] feld) {
    // feld.length -> Anzahl der Zeilen
    // feld[0].length -> Anzahl der Spalten
    for (int i = 0; i < feld.length; i++) {
      int[] verbundeneZeilen = new int[feld.length];
      for (int j = 0; j < feld[i].length; j++) {
        for (int k = 0; k < feld.length; k++) {
          zaehleVerbundeneZeilen(feld, i, j, k, verbundeneZeilen);
        }
      }
      if (istEineZeileFehlendOderDoppelt(verbundeneZeilen, i)) {
        return false;
      }
    }
    return true;
  }

  private static void zaehleVerbundeneZeilen(final int[][] feld, final int i, final int j, final int k,
                                             final int[] verbundeneZeilen) {
    if (i == k) {
      return;
    }
    int anzahl = wieOftIstWertInZeileEnthalten(feld[i][j], feld[k]);
    verbundeneZeilen[k] += anzahl;
  }

  private static boolean istEineZeileFehlendOderDoppelt(final int[] verbundeneZeilen, final int ueberspringeZeile) {
    for (int i = 0; i < verbundeneZeilen.length; i++) {
      if (i == ueberspringeZeile) {
        continue;
      }
      if (verbundeneZeilen[i] != 1) {
        return true;
      }
    }
    return false;
  }

  private static int wieOftIstWertInZeileEnthalten(final int wert, final int[] zeile) {
    int anzahl = 0;
    for (int i = 0; i < zeile.length; i++) {
      if (zeile[i] == wert) {
        anzahl++;
      }
    }
    return anzahl;
  }

  /**
   * @param feld
   * @return Erzeugt einen String, der das Feld zeilenweise formatiert.
   */
  public static String stringOf(final int[][] feld) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < feld.length; i++) {
      for (int j = 0; j < feld[0].length; j++) {
        sb.append(String.format("%3d", feld[i][j]));
      }
      sb.append('\n');
    }
    return sb.toString();
  }

}
