// Schiffe versenken - Startpunkt des Programms mit dem Startmenü.
public class Main {

    // Zeigt das Startmenü, bis "Beenden" gewählt wird oder die Eingabe endet.
    public static void main(String[] args) {
        boolean beenden = false;
        while (!beenden && !Eingabe.eingabeEnde) {
            Anzeige.zeigeMenue();
            String wahl = Eingabe.leseMenueWahl();
            switch (wahl) {
                case "1":
                    neuesSpiel();
                    break;
                case "2":
                    Anzeige.zeigeSpielregeln();
                    break;
                case "3":
                    beenden = true;
                    break;
                default:
                    // nur bei "" (Eingabe beendet) - die Schleife endet dann
                    break;
            }
        }
        if (Eingabe.eingabeEnde) {
            System.out.println("Eingabe beendet.");
        }
        System.out.println("Auf Wiedersehen!");
    }

    // Startet ein neues Spiel: legt beide Spielfelder an, stellt beide Flotten
    // zufällig auf, zeigt die Felder und startet die Schussschleife.
    static void neuesSpiel() {
        Brett eigenes = Spielfeld.neuesBrett();
        Brett gegner = Spielfeld.neuesBrett();
        Aufstellung.stelleZufaelligAuf(eigenes);
        Aufstellung.stelleZufaelligAuf(gegner);
        Anzeige.zeigeBretter(eigenes, gegner);
        spieleRunden(eigenes, gegner);
    }

    // Schussschleife: Der Spieler schießt, bis er mit x abbricht oder die Eingabe endet.
    // Computerzüge und Spielende kommen mit den Features 7 und 8 aus features.md.
    static void spieleRunden(Brett eigenes, Brett gegner) {
        boolean abgebrochen = false;
        while (!abgebrochen && !Eingabe.eingabeEnde) {
            int ziel = Eingabe.leseZiel(gegner);
            if (ziel == Eingabe.ABBRUCH) {
                abgebrochen = true;
                System.out.println("Spiel abgebrochen.");
            } else if (ziel != Eingabe.KEIN_FELD) {
                int code = Spielfeld.schiesse(gegner, ziel);
                Anzeige.zeigeBretter(eigenes, gegner);
                Anzeige.zeigeMeldung(code);
            }
        }
    }
}
