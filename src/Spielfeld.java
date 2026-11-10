// Konstanten und Hilfsmethoden für das Spielfeld (10 x 10 Felder in einem int[100]).
public class Spielfeld {

    // Breite und Höhe des Spielfelds
    static final int GROESSE = 10;

    // Feldcodes: was über ein Feld bekannt ist
    static final int UNBEKANNT = 0;
    static final int DANEBEN = 1;
    static final int TREFFER = 2;
    static final int VERSENKT = 3;

    // Markierung in Brett.schiffAuf für Felder ohne Schiff
    static final int KEIN_SCHIFF = -1;

    // Die Flotte je Spieler, größtes Schiff zuerst
    static final String[] FLOTTE_NAMEN = {"Schlachtschiff", "Kreuzer", "Kreuzer",
            "Zerstörer", "Zerstörer", "Zerstörer", "U-Boot", "U-Boot", "U-Boot", "U-Boot"};
    static final int[] FLOTTE_LAENGEN = {5, 4, 4, 3, 3, 3, 2, 2, 2, 2};

    // Rechnet Zeile und Spalte (je 0-9) in den Index im Array um (0-99).
    static int index(int zeile, int spalte) {
        return zeile * GROESSE + spalte;
    }

    // Liefert die Zeile (0-9) zum Index i.
    static int zeileVon(int i) {
        return i / GROESSE;
    }

    // Liefert die Spalte (0-9) zum Index i.
    static int spalteVon(int i) {
        return i % GROESSE;
    }

    // Prüft, ob Zeile und Spalte im Spielfeld liegen - vor jedem index(...) mit berechneten Werten.
    static boolean imSpielfeld(int zeile, int spalte) {
        return zeile >= 0 && zeile < GROESSE && spalte >= 0 && spalte < GROESSE;
    }

    // Legt ein neues, leeres Brett an: alle Felder unbekannt und ohne Schiff.
    static Brett neuesBrett() {
        Brett brett = new Brett();
        leereSchiffe(brett);
        return brett;
    }

    // Entfernt alle Schiffe vom Brett (jedes Feld wird KEIN_SCHIFF).
    static void leereSchiffe(Brett brett) {
        for (int i = 0; i < brett.schiffAuf.length; i++) {
            brett.schiffAuf[i] = KEIN_SCHIFF;
        }
    }

    // Schießt auf Feld i des Bretts und liefert den neuen Feldcode: DANEBEN, TREFFER oder VERSENKT.
    // Gilt für Mensch und Computer. Nur für noch unbeschossene Felder aufrufen.
    static int schiesse(Brett ziel, int i) {
        int nr = ziel.schiffAuf[i];
        int code = DANEBEN;
        if (nr != KEIN_SCHIFF) {
            ziel.treffer[nr]++;
            code = TREFFER;
            if (ziel.treffer[nr] == ziel.flotte[nr].laenge()) {
                code = VERSENKT;
            }
        }
        ziel.felder[i] = code;
        if (code == VERSENKT) {
            markiereVersenkt(ziel, nr);
        }
        return code;
    }

    // Setzt alle Felder von Schiff Nr. nr auf VERSENKT.
    static void markiereVersenkt(Brett brett, int nr) {
        for (int i = 0; i < brett.felder.length; i++) {
            if (brett.schiffAuf[i] == nr) {
                brett.felder[i] = VERSENKT;
            }
        }
    }

    // Liefert eine Zufallszahl von 0 bis n - 1.
    static int zufallsZahl(int n) {
        return (int) (Math.random() * n);
    }
}
