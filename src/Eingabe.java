import java.util.Scanner;

// Liest alle Eingaben des Spielers über die Tastatur.
public class Eingabe {

    // Der einzige Scanner im ganzen Programm
    static Scanner scanner = new Scanner(System.in);

    // Wird true, sobald die Eingabe endet (Strg+Z, dann Enter)
    static boolean eingabeEnde = false;

    // Rückgabewerte statt eines Feldindex: kein gültiges Feld bzw. Spiel abbrechen (x)
    static final int KEIN_FELD = -1;
    static final int ABBRUCH = -2;

    // Zeigt die Frage an und liest eine Zeile ein.
    // Gibt die Zeile ohne Leerzeichen am Anfang und Ende zurück.
    // Endet die Eingabe, wird eingabeEnde gesetzt und "" zurückgegeben.
    static String leseZeile(String frage) {
        String zeile = "";
        System.out.print(frage);
        if (scanner.hasNextLine()) {
            zeile = scanner.nextLine().trim();
        } else {
            eingabeEnde = true;
            System.out.println();
        }
        return zeile;
    }

    // Fragt die Menüauswahl ab, bis 1, 2 oder 3 eingegeben wird.
    // Endet die Eingabe, wird "" zurückgegeben.
    static String leseMenueWahl() {
        String wahl = leseZeile("Deine Wahl (1-3): ");
        while (!eingabeEnde && !istMenueWahl(wahl)) {
            System.out.println("Ungültige Eingabe - bitte 1, 2 oder 3 eingeben, z. B. 2 für die Spielregeln.");
            wahl = leseZeile("Deine Wahl (1-3): ");
        }
        return wahl;
    }

    // Prüft, ob der Text eine der drei Menünummern ist.
    static boolean istMenueWahl(String wahl) {
        return wahl.equals("1") || wahl.equals("2") || wahl.equals("3");
    }

    // Fragt nach dem Feld für den nächsten Schuss, bis ein gültiges, noch nicht
    // beschossenes Feld kommt. Liefert den Feldindex (0-99), ABBRUCH bei "x"
    // oder KEIN_FELD, wenn die Eingabe endet. Abgewiesene Eingaben kosten keinen Zug.
    static int leseZiel(Brett gegner) {
        int ziel = KEIN_FELD;
        boolean fertig = false;
        while (!fertig) {
            String text = leseZeile("Dein Schuss (z. B. C5, x = Spiel abbrechen): ");
            if (eingabeEnde) {
                fertig = true;
            } else if (text.equals("x") || text.equals("X")) {
                ziel = ABBRUCH;
                fertig = true;
            } else {
                int feld = feldAusText(text);
                if (feld == KEIN_FELD) {
                    System.out.println("Ungültiges Feld - Spalte A-J und Zeile 1-10, z. B. C5.");
                } else if (gegner.felder[feld] != Spielfeld.UNBEKANNT) {
                    System.out.println(text + " hast du schon beschossen - bitte ein anderes Feld.");
                } else {
                    ziel = feld;
                    fertig = true;
                }
            }
        }
        return ziel;
    }

    // Wandelt eine Eingabe wie "C5", "c5" oder "J10" in den Feldindex um (0-99).
    // Liefert KEIN_FELD, wenn die Eingabe kein gültiges Feld ist.
    static int feldAusText(String text) {
        int feld = KEIN_FELD;
        if (text.length() == 2 || text.length() == 3) {
            int spalte = spalteAusZeichen(text.charAt(0));
            int zeile = zeileAusText(text);
            if (spalte != -1 && zeile != -1) {
                feld = Spielfeld.index(zeile, spalte);
            }
        }
        return feld;
    }

    // Liefert die Spalte (0-9) zum Buchstaben A-J bzw. a-j, sonst -1.
    static int spalteAusZeichen(char c) {
        int spalte = -1;
        if (c >= 'A' && c <= 'J') {
            spalte = c - 'A';
        } else if (c >= 'a' && c <= 'j') {
            spalte = c - 'a';
        }
        return spalte;
    }

    // Liefert die Zeile (0-9) zur Zahl hinter dem Buchstaben ("C5" ergibt 4, "C10" ergibt 9), sonst -1.
    // Nur für Texte mit 2 oder 3 Zeichen aufrufen.
    static int zeileAusText(String text) {
        int zeile = -1;
        char ziffer = text.charAt(1);
        if (text.length() == 2 && ziffer >= '1' && ziffer <= '9') {
            zeile = ziffer - '1';
        } else if (text.length() == 3 && ziffer == '1' && text.charAt(2) == '0') {
            zeile = 9;
        }
        return zeile;
    }
}
