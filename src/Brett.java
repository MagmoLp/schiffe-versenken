// Das Spielfeld eines Spielers. Nur Daten - die Logik steht in statischen Methoden.
public class Brett {

    // Feldcode für jedes der 100 Felder (Index = zeile * 10 + spalte),
    // am Anfang überall 0 = Spielfeld.UNBEKANNT
    int[] felder = new int[Spielfeld.GROESSE * Spielfeld.GROESSE];
}
