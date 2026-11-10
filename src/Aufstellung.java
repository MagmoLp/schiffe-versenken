// Stellt die Flotte eines Spielers auf sein Brett.
public class Aufstellung {

    // Spielregel für den Spieltest: Dürfen sich Schiffe berühren (auch diagonal)? Standard: nein
    static final boolean BERUEHREN_ERLAUBT = false;

    // Zufällige Versuche pro Schiff, bevor die ganze Flotte neu beginnt
    static final int MAX_VERSUCHE_SCHIFF = 100;

    // Durchgänge für die ganze Flotte, bevor die feste Aufstellung genommen wird
    static final int MAX_DURCHGAENGE = 1000;

    // Startfelder der festen Aufstellung (alle waagerecht, Reihenfolge wie FLOTTE_LAENGEN):
    // Zeile 1: A1-E1, G1-J1 | Zeile 3: A3-D3, F3-H3 | Zeile 5: A5-C5, E5-G5, I5-J5
    // Zeile 7: A7-B7, D7-E7, G7-H7 - kein Schiff berührt ein anderes
    static final int[] FESTE_STARTS = {0, 6, 20, 25, 40, 44, 48, 60, 63, 66};

    // Stellt die ganze Flotte zufällig auf, größtes Schiff zuerst.
    // Findet ein Schiff keinen Platz, beginnt die Flotte neu;
    // nach MAX_DURCHGAENGE Fehlschlägen gilt die feste Aufstellung.
    static void stelleZufaelligAuf(Brett brett) {
        boolean fertig = false;
        int durchgaenge = 0;
        while (!fertig && durchgaenge < MAX_DURCHGAENGE) {
            Spielfeld.leereSchiffe(brett);
            fertig = versucheFlotte(brett);
            durchgaenge++;
        }
        if (!fertig) {
            festeAufstellung(brett);
        }
    }

    // Ein Durchgang: setzt alle Schiffe nacheinander.
    // Liefert false, sobald ein Schiff keinen Platz findet.
    static boolean versucheFlotte(Brett brett) {
        boolean geklappt = true;
        int nr = 0;
        while (geklappt && nr < Spielfeld.FLOTTE_LAENGEN.length) {
            geklappt = versucheSchiff(brett, nr);
            nr++;
        }
        return geklappt;
    }

    // Sucht für Schiff Nr. nr mit bis zu MAX_VERSUCHE_SCHIFF zufälligen Versuchen einen Platz
    // und setzt es dort. Liefert true, wenn das Schiff gesetzt wurde.
    static boolean versucheSchiff(Brett brett, int nr) {
        int laenge = Spielfeld.FLOTTE_LAENGEN[nr];
        boolean gesetzt = false;
        int versuche = 0;
        while (!gesetzt && versuche < MAX_VERSUCHE_SCHIFF) {
            boolean waagerecht = Spielfeld.zufallsZahl(2) == 0;
            int start = Spielfeld.zufallsZahl(Spielfeld.GROESSE * Spielfeld.GROESSE);
            if (passt(brett, start, laenge, waagerecht)) {
                setzeSchiff(brett, nr, start, waagerecht);
                gesetzt = true;
            }
            versuche++;
        }
        return gesetzt;
    }

    // Prüft, ob ein Schiff mit dieser Lage aufs Brett passt: Es bleibt im Spielfeld,
    // und jedes seiner Felder ist frei (siehe feldFrei).
    static boolean passt(Brett brett, int start, int laenge, boolean waagerecht) {
        boolean ok = bleibtImSpielfeld(start, laenge, waagerecht);
        int k = 0;
        while (ok && k < laenge) {
            ok = feldFrei(brett, feldDesSchiffs(start, k, waagerecht));
            k++;
        }
        return ok;
    }

    // Prüft, ob das Schiff vom Startfeld aus nicht über den Rand ragt.
    static boolean bleibtImSpielfeld(int start, int laenge, boolean waagerecht) {
        boolean ok;
        if (waagerecht) {
            ok = Spielfeld.spalteVon(start) + laenge <= Spielfeld.GROESSE;
        } else {
            ok = Spielfeld.zeileVon(start) + laenge <= Spielfeld.GROESSE;
        }
        return ok;
    }

    // Liefert den Index des k-ten Feldes eines Schiffs (k = 0 ist das Startfeld).
    // Nur aufrufen, wenn bleibtImSpielfeld(...) true ist.
    static int feldDesSchiffs(int start, int k, boolean waagerecht) {
        int zeile = Spielfeld.zeileVon(start);
        int spalte = Spielfeld.spalteVon(start);
        if (waagerecht) {
            spalte = spalte + k;
        } else {
            zeile = zeile + k;
        }
        return Spielfeld.index(zeile, spalte);
    }

    // Prüft, ob auf Feld i kein Schiff liegt - und, wenn Berühren nicht erlaubt ist,
    // auch auf keinem der 8 Nachbarfelder.
    static boolean feldFrei(Brett brett, int i) {
        boolean frei = brett.schiffAuf[i] == Spielfeld.KEIN_SCHIFF;
        if (frei && !BERUEHREN_ERLAUBT) {
            frei = !schiffInNachbarschaft(brett, i);
        }
        return frei;
    }

    // Prüft, ob auf Feld i oder einem seiner 8 Nachbarfelder ein Schiff liegt.
    // Nachbarn über Zeile und Spalte mit Randprüfung, nie über i + 1.
    static boolean schiffInNachbarschaft(Brett brett, int i) {
        int zeile = Spielfeld.zeileVon(i);
        int spalte = Spielfeld.spalteVon(i);
        boolean gefunden = false;
        for (int dz = -1; dz <= 1; dz++) {
            for (int ds = -1; ds <= 1; ds++) {
                int z = zeile + dz;
                int s = spalte + ds;
                if (Spielfeld.imSpielfeld(z, s) && brett.schiffAuf[Spielfeld.index(z, s)] != Spielfeld.KEIN_SCHIFF) {
                    gefunden = true;
                }
            }
        }
        return gefunden;
    }

    // Legt Schiff Nr. nr als Record an, speichert es in der Flotte und trägt seine Felder ein.
    static void setzeSchiff(Brett brett, int nr, int start, boolean waagerecht) {
        int laenge = Spielfeld.FLOTTE_LAENGEN[nr];
        brett.flotte[nr] = new Schiff(Spielfeld.FLOTTE_NAMEN[nr], laenge, start, waagerecht);
        for (int k = 0; k < laenge; k++) {
            brett.schiffAuf[feldDesSchiffs(start, k, waagerecht)] = nr;
        }
    }

    // Rückfall: setzt die feste, gültige Aufstellung aus FESTE_STARTS.
    static void festeAufstellung(Brett brett) {
        Spielfeld.leereSchiffe(brett);
        for (int nr = 0; nr < FESTE_STARTS.length; nr++) {
            setzeSchiff(brett, nr, FESTE_STARTS[nr], true);
        }
    }
}
