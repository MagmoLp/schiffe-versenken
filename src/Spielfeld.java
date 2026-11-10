// Konstanten und Hilfsmethoden für das Spielfeld (10 x 10 Felder in einem int[100]).
public class Spielfeld {

    // Breite und Höhe des Spielfelds
    static final int GROESSE = 10;

    // Feldcodes: was über ein Feld bekannt ist
    static final int UNBEKANNT = 0;
    static final int DANEBEN = 1;
    static final int TREFFER = 2;
    static final int VERSENKT = 3;

    // Rechnet Zeile und Spalte (je 0-9) in den Index im Array um (0-99).
    static int index(int zeile, int spalte) {
        return zeile * GROESSE + spalte;
    }
}
