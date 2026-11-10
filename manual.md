# Bedienungsanleitung – Schiffe versenken

So startest und bedienst du das Spiel. Was schon umgesetzt ist, steht in [features.md](features.md) (abgehakte Features).

## Voraussetzungen

- Java 17 (JDK) ist installiert, `javac` und `java` funktionieren in der Eingabeaufforderung.

## Starten

**Per Doppelklick:** `start.bat` im Projektordner doppelklicken. Die Datei kompiliert den Code aus `src/` nach `out/` und startet danach das Spiel. Bei einem Kompilierfehler startet das Spiel nicht, die Fehlermeldung bleibt im Fenster stehen.

**In IntelliJ:** Projektordner öffnen, `src/Main.java` öffnen und auf den grünen Pfeil neben `main` klicken (Run).

**In der Eingabeaufforderung** (im Projektordner):

```
javac -encoding UTF-8 -d out src\*.java
java -cp out Main
```

## Startmenü

Nach dem Start erscheint das Menü:

```
==============================
       SCHIFFE VERSENKEN
==============================
  1  Neues Spiel
  2  Spielregeln
  3  Beenden
------------------------------
Deine Wahl (1-3):
```

Gib die Nummer ein und drücke Enter:

| Eingabe | Was passiert |
|---|---|
| `1` | Neues Spiel – zeigt dein Spielfeld und das des Gegners (siehe unten); Aufstellung und Angriff folgen mit den nächsten Features, danach erscheint wieder das Menü |
| `2` | Die Spielregeln werden angezeigt, danach erscheint wieder das Menü |
| `3` | Das Programm verabschiedet sich und endet |

Jede andere Eingabe (auch nur Enter) wird abgewiesen: Es erscheint ein Hinweis mit Beispiel, dann dieselbe Frage noch einmal.

## Spielfeld

Links steht dein Spielfeld, rechts das des Gegners. Spalten heißen A–J, Zeilen 1–10; ein Feld wird mit Buchstabe und Zahl angegeben, z. B. `C5`.

```
     Deine Flotte               Gegner
     A B C D E F G H I J        A B C D E F G H I J
  1  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~     1  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
  2  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~     2  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
 ...
 10  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~    10  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
```

| Symbol | Bedeutung |
|---|---|
| `~` | Wasser bzw. noch nicht beschossen |
| `o` | Schuss daneben |
| `X` | Treffer |

## Beenden

- Im Menü `3` eingeben, oder
- die Eingabe beenden mit **Strg+Z** und danach **Enter**: Das Programm meldet „Eingabe beendet.“ und endet geordnet.

Beim Start über `start.bat` bleibt das Fenster danach offen, bis du eine beliebige Taste drückst.
