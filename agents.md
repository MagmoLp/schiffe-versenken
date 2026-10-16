# agents.md

Anweisungen für den Coding-Agenten. Projekt: Schiffe versenken als Konsolenspiel in Java 17 (siehe readme.md). Umfang und Reihenfolge stehen in features.md.

Ich (Paul) lerne gerade programmieren und muss jeden Schritt mit meinem aktuellen Wissen nachvollziehen können: Was ein Anfänger noch nicht kennt, erklärst du beim ersten Einsatz kurz mit Beispiel. Einfach und stabil geht vor elegant.

## Vorgabe der Lehrveranstaltung (verbindlich)

> The project should use structured programming in Java including records or simple classes. No abstractions, inheritance, Collections or other higher level Java features may be used.

Was hier nicht ausdrücklich erlaubt ist, ist verboten. Im Zweifel nicht verwenden, sondern mich fragen.

## Erlaubt

- Datentypen `int`, `long`, `double`, `boolean`, `char`, `String`; Konstanten als `static final`
- Grundlagen: Rechenoperatoren inkl. `/` und `%`, Vergleiche, `&&` `||` `!`, `+` für Strings, Rechnen mit `char` (`c - 'A'`), Cast `(int)`, `new`, Array-Initialisierer `{…}`, Array-Länge `.length`, `return`
- `if`/`else`, klassisches `switch` (`case …:` mit `break`), `while`, `do`-`while`, `for`
- Statische Methoden mit Parametern und Rückgabewert
- Eindimensionale Arrays, auch Arrays von Records
- Records und einfache Klassen nur als Datenbehälter (Attribute, keine Methoden); die Logik steht in statischen Methoden
- Eingabe: genau ein `Scanner` (einziger Import: `java.util.Scanner`), nur `hasNextLine()` und `nextLine()`
- String: `length`, `charAt`, `trim`, `equals`; Ausgabe mit `print`, `println`, `printf`
- `Math.random()`, `System.currentTimeMillis()`

## Verboten

- `extends`, `implements`, `interface`, `abstract`, `@Override`, innere oder anonyme Klassen
- `List`, `ArrayList`, `Map`, `Set`, `Queue`, `Arrays`, `Collections`, `Optional`, Streams
- Generics (`<T>`, `<>`), Lambdas (`->`), Methodenreferenzen (`::`), `var`, `switch` mit `->`
- `try`, `catch`, `throw`, `throws` – deshalb kein `Integer.parseInt` und kein `nextInt`; Eingaben Zeichen für Zeichen prüfen
- Rekursion, Threads, `Timer`
- Regex (`split`, `matches`, `replaceAll`), `Character.isDigit`/`isLetter`, `toUpperCase`/`toLowerCase`
- `ProcessBuilder`, `Runtime.exec`, `System.console()`, externe Bibliotheken, JNI/JNA, `jdk.internal`/`jdk.incubator`
- Bildschirm löschen, Cursor-Steuerung, Pfeiltasten- oder Maussteuerung

## Erst nach Freigabe durch die Lektorin

2D-Arrays, `enum`, `java.util.Random`, `Thread.sleep` mit `try`/`catch`, `System.in.available()`, `?:`, `System.exit`, `break`/`continue` in Schleifen.
Bis dahin ist das Spielfeld ein `int[100]` mit Index `zeile * 10 + spalte`. Umgerechnet wird nur mit `index(zeile, spalte)`, `zeileVon(i)` und `spalteVon(i)`; Nachbarn nie mit `i + 1` (sonst springt Spalte J in die nächste Zeile).

## Arbeitsweise

1. Immer nur ein Feature, in der Reihenfolge von features.md; nichts aus „Ungeklärt“ ohne mein OK.
2. Erst planen: Beschreibe vor dem Code in wenigen Sätzen, welche Methoden und Daten du brauchst und wie der Ablauf ist. Umsetzen erst nach meinem OK.
3. Kleine Methoden (Richtwert 30 Zeilen) mit sprechendem Namen und einem Kommentar, was sie tut.
4. Kein Overengineering: nur, was in features.md steht. Keine Vorsorge-Strukturen.
5. Nach jedem Schritt: Code kompiliert; neuen Code mit „Erlaubt“ abgleichen und jede Abweichung melden (Schnellsuche: `import`, `[][]`, `enum`, `Random`, `Thread`, `try`, `catch`, `?`, `exit`, `continue`, `extends`, `->`, `::`); kurze Erklärung (was und warum); dann teste ich über `start.bat` (du siehst keine Farben).
6. readme.md, features.md und agents.md nur nach meinem OK ändern; ein Feature erst abhaken, wenn es getestet ist.

## Aufbau

- Wenige Dateien nach Thema, z. B. `Main` (Menü, Spielablauf), `Anzeige`, `Eingabe`, `Aufstellung`, `Computer`
- Datentypen: `Schiff` (record) und `Brett` (einfache Klasse mit den Arrays eines Spielers); Trefferzähler nicht im Record, Records sind unveränderlich
- Ein `Brett` pro Spieler, Methoden bekommen es als Parameter – keine doppelten Methoden für Spieler und Computer
- `static`-Variablen nur für Konstanten, den Scanner, den Farbschalter und `eingabeEnde`; alles andere als Parameter
- Feldcodes als Konstanten: `UNBEKANNT = 0`, `DANEBEN = 1`, `TREFFER = 2`, `VERSENKT = 3`
- Spielregeln, die ich im Spieltest ausprobiere, als Konstanten: Zeitlimit pro Zug und ob Schiffe sich berühren dürfen (Standard: nein)
- `start.bat` gleich mit dem ersten Feature anlegen: `javac -encoding UTF-8 *.java && java Main`, danach `pause` (bei Kompilierfehler startet nichts)

## Stabilität

- Alle Eingaben laufen über eine Lesemethode: `hasNextLine()` vor `nextLine()`. Endet die Eingabe (Strg+Z, dann Enter), setzt sie `eingabeEnde = true`; alle Eingabeschleifen und die Spielschleife in `main` prüfen das und enden geordnet – ohne Absturz und ohne Endlosschleife.
- Ungültige Eingabe: Meldung mit Beispiel, dieselbe Frage erneut, kein Zugverlust. Schon beschossene Felder werden vor dem Schuss abgewiesen.
- Koordinaten: Spalte `A`–`J` oder `a`–`j`, Zeile `1`–`10`, per Zeichenvergleich geprüft (`c >= 'A' && c <= 'J'`).
- Zeile und Spalte prüfen, bevor ein Array-Index gebildet wird.
- Jede Zufallsschleife hat einen Versuchszähler. Aufstellung: größtes Schiff zuerst, nach 100 Fehlversuchen die Flotte neu beginnen; auch die Neustarts sind begrenzt (z. B. 1000), danach eine feste gültige Aufstellung als Rückfall – den Rückfall einmal erzwungen testen.
- Eigene Aufstellung: Schiffe vom größten zum kleinsten; jederzeit `zufall` (Rest zufällig) oder `neu` möglich, denn wenn sich Schiffe nicht berühren dürfen, kann für das letzte Schiff kein Platz mehr frei sein.
- Zufällige Auswahl: passende Felder zählen, dann das k-te nehmen; bei 0 Kandidaten `-1` zurückgeben, der Aufrufer prüft das mit `if`.
- Zeitlimit: Startzeit einmal zu Zugbeginn mit `System.currentTimeMillis()` nehmen, nicht bei jeder wiederholten Frage; nach jeder Eingabe zuerst die Zeit prüfen, dann die Gültigkeit.

## Computergegner

- Eine Methode `schiesse(...)` liefert den neuen Feldcode `DANEBEN`, `TREFFER` oder `VERSENKT` – für Mensch und Computer. Die Meldungen entstehen nur aus diesem Wert.
- Nach „versenkt“ werden alle Felder des Schiffs auf `VERSENKT` gesetzt.
- leicht: zufällig ein unbekanntes Feld. Dieselbe Methode liefert auch den automatischen Zufallsschuss bei Zeitüberschreitung.
- mittel: jeden Zug neu entscheiden, ohne gespeicherte Richtung: Liegen zwei oder mehr nicht versenkte Treffer direkt nebeneinander, die Linie verlängern; sonst ein unbekanntes Nachbarfeld eines Treffers; sonst wie leicht.
- schwer: wie mittel, aber ohne offene Treffer nur Felder mit gerader Summe `zeile + spalte` (Schachbrettmuster). Felder neben versenkten Schiffen (dieselbe 8er-Nachbarprüfung wie bei der Aufstellung) lässt er aus, ohne das Brett zu ändern – das gilt nur, solange sich Schiffe nicht berühren dürfen.
- Jede Stufe ist eine eigene Methode, jeder Schritt (Ziel suchen, Linie verlängern, Nachbarn prüfen) eine eigene Hilfsmethode.

## Darstellung

- Spielfeld nur mit ASCII-Zeichen: `~` Wasser bzw. unbekannt, `#` Schiff, `X` Treffer, `o` daneben. Die Symbole tragen die Information, Farbe ist nur Zusatz.
- Farben nur über Konstanten und eine Hilfsmethode `farbig(farbe, text)`: `ROT = "\033[91m"`, `BLAU = "\033[94m"`, `GRUEN = "\033[32m"`, `RESET = "\033[0m"`.
- Farbschalter: Beim Start ein rotes Testwort zeigen und fragen „Ist das Wort rot? (j/n)“; bei `n` ohne Farben spielen.
- `printf`-Breiten (z. B. `%2d`) nur für ungefärbten Text, denn `printf` zählt Farbcodes mit; gefärbt werden nur Teile fester Breite wie ein Feldsymbol.
- Spielfeld nach jedem Zug neu ausgeben, mit Trennlinie.
