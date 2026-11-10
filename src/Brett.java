// Das Spielfeld eines Spielers. Nur Daten - die Logik steht in statischen Methoden.
// Ein neues Brett immer mit Spielfeld.neuesBrett() anlegen, nicht mit new Brett().
public class Brett {

    // Feldcode für jedes der 100 Felder (Index = zeile * 10 + spalte),
    // am Anfang überall 0 = Spielfeld.UNBEKANNT
    int[] felder = new int[Spielfeld.GROESSE * Spielfeld.GROESSE];

    // Nummer des Schiffs auf jedem Feld (Index in flotte), Spielfeld.KEIN_SCHIFF = Wasser
    int[] schiffAuf = new int[Spielfeld.GROESSE * Spielfeld.GROESSE];

    // Die 10 Schiffe dieses Spielers, in derselben Reihenfolge wie Spielfeld.FLOTTE_LAENGEN
    Schiff[] flotte = new Schiff[Spielfeld.FLOTTE_LAENGEN.length];
}
