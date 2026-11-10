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
        System.out.println("Angriff: Feld eingeben, z. B. C5");
        System.out.println("Antwort: \"Vorbei!\" oder \"Daneben!\" bei Wasser, \"Treffer!\" bei einem Treffer,");
        System.out.println("\"Treffer, versenkt!\", wenn ein Schiff versenkt ist.");
    }
}
