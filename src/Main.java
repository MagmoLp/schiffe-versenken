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
    // zufällig auf und zeigt die Felder. Der Angriff kommt mit den Features 5-8 aus features.md.
    static void neuesSpiel() {
        Brett eigenes = Spielfeld.neuesBrett();
        Brett gegner = Spielfeld.neuesBrett();
        Aufstellung.stelleZufaelligAuf(eigenes);
        Aufstellung.stelleZufaelligAuf(gegner);
        Anzeige.zeigeBretter(eigenes, gegner);
        System.out.println("Angriff folgt (Features 5-8).");
    }
}
