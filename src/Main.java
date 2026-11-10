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

    // Startet ein neues Spiel. Vorerst nur ein Hinweis:
    // das Spiel selbst kommt mit den Features 2-8 aus features.md.
    static void neuesSpiel() {
        System.out.println();
        System.out.println("Das Spiel ist noch in Arbeit (Features 2-8).");
    }
}
