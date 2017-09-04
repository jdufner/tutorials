package de.jdufner.tutorials.tin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class Tin {

  private static final int LAENGE = 11;

  private final String tin;
  private String nummer;

  public Tin(final long l) {
    this.tin = String.valueOf(l);
  }

  public boolean isValid() {
    return has11Digits() && isNummerValid() && isPruefzifferValid();
  }

  /**
   * Prüft implizit: Regel 1: Die TIN besteht aus einer 11-stelligen Zahl. Regel 2: An der ersten Position steht keine
   * 0. (Ist eingehalten, wenn die Zahl aus einer Long erzeugt wurde.)
   */
  private boolean has11Digits() {
    return tin.length() == LAENGE;
  }

  /**
   * Regel 4: An den Positionen 2-10 stehen Ziffern der Menge {0, 1, 2, 3, 4, 5, 6, 7, 8, 9} Regel 5.0: Unter den
   * Positionen 1 bis 10 befindet sich immer (genau?) eine Ziffernwiederholung Regel 5.1: Entweder genau zwei Ziffern
   * oder genau drei Ziffern sind gleich. Regel 5.2: Es gibt niemals mehr als drei gleich Ziffern Regel 5.3: Existieren
   * zwei gleiche Ziffern an den ersten zehn Positionen, können diese an beliebigen Stellen stehen. Die restlichen acht
   * Ziffern treten jeweils einmal auf. Regel 5.4: Existieren drei gleiche Ziffern an den ersten zehn Positionen, dürfen
   * diese niemals an direkt aufeinander folgenden Stellen stehen.
   */
  private boolean isNummerValid() {
    this.nummer = tin.substring(0, LAENGE - 1);
    Map<Character, Integer> ziffernhaeufigkeit = zaehleZiffernhaeufigkeit();
    if (zaehleMehrfache(ziffernhaeufigkeit) > 1) {
      return false;
    }
    if (existsHaeufigereZiffernhaeufigkeit(ziffernhaeufigkeit)) {
      return false;
    }
    return !existsAufeinanderfolgendesTriple(ziffernhaeufigkeit);
  }

  private boolean existsAufeinanderfolgendesTriple(final Map<Character, Integer> ziffernhaeufigkeit) {
    for (Map.Entry<Character, Integer> entry : ziffernhaeufigkeit.entrySet()) {
      if (entry.getValue() == 3) {
        String triple = "" + entry.getKey() + entry.getKey() + entry.getKey();
        if (nummer.contains(triple)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean existsHaeufigereZiffernhaeufigkeit(final Map<Character, Integer> ziffernhaeufigkeit) {
    for (Integer vorhandeneHaufigkeit : ziffernhaeufigkeit.values()) {
      if (vorhandeneHaufigkeit > 3) {
        return true;
      }
    }
    return false;
  }

  private int zaehleMehrfache(final Map<Character, Integer> ziffernhaeufigkeit) {
    int anzahlMehrfache = 0;
    for (Map.Entry<Character, Integer> entry : ziffernhaeufigkeit.entrySet()) {
      if (entry.getValue() > 1) {
        anzahlMehrfache++;
      }
    }
    return anzahlMehrfache;
  }

  private Map<Character, Integer> zaehleZiffernhaeufigkeit() {
    Map<Character, Integer> ziffernHaeufigkeit = new HashMap<>(10);
    for (int i = 0; i < LAENGE - 1; i++) {
      ziffernHaeufigkeit.put(Character.forDigit(i, 10), 0);
    }
    for (Character c : nummer.toCharArray()) {
      ziffernHaeufigkeit.put(c, ziffernHaeufigkeit.get(c) + 1);
    }
    return ziffernHaeufigkeit;
  }

  /**
   * Regel 3: An der 11. Stelle steht die Prüfziffer.
   */
  private boolean isPruefzifferValid() {
    final String pruefziffer = tin.substring(LAENGE - 1, LAENGE);
    return Integer.parseInt(pruefziffer) == berechnePruefziffer();
  }

  private int berechnePruefziffer() {
    int summe;
    int produkt = 0;
    int ziffer;
    for (int i = 0; i < LAENGE - 1; i++) {
      ziffer = Integer.parseInt(nummer.substring(i, i + 1));
      summe = (ziffer + produkt) % 10;
      if (summe == 0) {
        summe = 10;
      }
      produkt = (2 * summe) % 11;
    }
    int pruefziffer = 11 - produkt;
    if (pruefziffer == 10) {
      pruefziffer = 0;
    }
    return pruefziffer;
  }

  @Override
  public String toString() {
    return tin;
  }
}
