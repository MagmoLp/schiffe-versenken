import java.util.Scanner;

// Liest alle Eingaben des Spielers über die Tastatur.
public class Eingabe {

    // Der einzige Scanner im ganzen Programm
    static Scanner scanner = new Scanner(System.in);

    // Wird true, sobald die Eingabe endet (Strg+Z, dann Enter)
    static boolean eingabeEnde = false;

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
}
