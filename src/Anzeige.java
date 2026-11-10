// Gibt Menü und Texte auf der Konsole aus.
public class Anzeige {

    // Zeigt den Titel und das Startmenü.
    static void zeigeMenue() {
        System.out.println();
        System.out.println("==============================");
        System.out.println("       SCHIFFE VERSENKEN");
        System.out.println("==============================");
        System.out.println("  1  Neues Spiel");
        System.out.println("  2  Spielregeln");
        System.out.println("  3  Beenden");
        System.out.println("------------------------------");
    }

    // Zeigt die Spielregeln (wie in readme.md beschrieben).
    static void zeigeSpielregeln() {
        System.out.println();
        System.out.println("SPIELREGELN");
        System.out.println();
        System.out.println("Du spielst gegen den Computer (drei Schwierigkeitsstufen).");
        System.out.println("Ziel: die gegnerische Flotte komplett zerstören.");
        System.out.println();
        System.out.println("Spielfeld: 10 x 10 Kästchen (Spalten A-J, Zeilen 1-10)");
        System.out.println();
        System.out.println("Flotte je Spieler (10 Schiffe):");
        System.out.printf("  %-16s %6s %6s%n", "Schiff", "Anzahl", "Größe");
        System.out.printf("  %-16s %6d %6d%n", "Schlachtschiff", 1, 5);
        System.out.printf("  %-16s %6d %6d%n", "Kreuzer", 2, 4);
        System.out.printf("  %-16s %6d %6d%n", "Zerstörer", 3, 3);
        System.out.printf("  %-16s %6d %6d%n", "U-Boot", 4, 2);
        System.out.println();
        System.out.println("Aufstellung: nach den klassischen Regeln, waagerecht oder senkrecht -");
        System.out.println("zufällig oder selbst per Texteingabe.");
        if (!Aufstellung.BERUEHREN_ERLAUBT) {
            System.out.println("Schiffe berühren sich nicht, auch nicht diagonal.");
        }
        System.out.println("Angriff: Feld eingeben, z. B. C5");
        System.out.println("Antwort: \"Vorbei!\" oder \"Daneben!\" bei Wasser, \"Treffer!\" bei einem Treffer,");
        System.out.println("\"Treffer, versenkt!\", wenn ein Schiff versenkt ist.");
    }

    // Zeigt das eigene und das gegnerische Spielfeld nebeneinander, danach eine Trennlinie.
    static void zeigeBretter(Brett eigenes, Brett gegner) {
        System.out.println();
        System.out.println("     Deine Flotte               Gegner");
        System.out.println("     A B C D E F G H I J        A B C D E F G H I J");
        for (int zeile = 0; zeile < Spielfeld.GROESSE; zeile++) {
            System.out.printf("%3d  ", zeile + 1);
            zeigeZeile(eigenes, zeile, true);
            System.out.printf("  %3d  ", zeile + 1);
            zeigeZeile(gegner, zeile, false);
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
    }

    // Gibt eine Zeile eines Spielfelds aus: 10 Symbole, jeweils mit Leerzeichen danach.
    // schiffeZeigen = true nur für das eigene Feld, die gegnerischen Schiffe bleiben verdeckt.
    static void zeigeZeile(Brett brett, int zeile, boolean schiffeZeigen) {
        for (int spalte = 0; spalte < Spielfeld.GROESSE; spalte++) {
            int i = Spielfeld.index(zeile, spalte);
            System.out.print(symbol(brett, i, schiffeZeigen) + " ");
        }
    }

    // Liefert das Symbol für Feld i: X Treffer oder versenkt, o daneben,
    // # Schiff (nur wenn schiffeZeigen), sonst ~ Wasser bzw. unbekannt.
    static String symbol(Brett brett, int i, boolean schiffeZeigen) {
        int code = brett.felder[i];
        String zeichen = "~";
        if (code == Spielfeld.DANEBEN) {
            zeichen = "o";
        } else if (code == Spielfeld.TREFFER || code == Spielfeld.VERSENKT) {
            zeichen = "X";
        } else if (schiffeZeigen && brett.schiffAuf[i] != Spielfeld.KEIN_SCHIFF) {
            zeichen = "#";
        }
        return zeichen;
    }
}
