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
| `1` | Neues Spiel – stellt beide Flotten zufällig auf, zeigt dein Spielfeld und das des Gegners und startet den Angriff (siehe unten) |
| `2` | Die Spielregeln werden angezeigt, danach erscheint wieder das Menü |
| `3` | Das Programm verabschiedet sich und endet |

Jede andere Eingabe (auch nur Enter) wird abgewiesen: Es erscheint ein Hinweis mit Beispiel, dann dieselbe Frage noch einmal.

## Spielfeld

Links steht dein Spielfeld, rechts das des Gegners. Spalten heißen A–J, Zeilen 1–10; ein Feld wird mit Buchstabe und Zahl angegeben, z. B. `C5`.

Beide Flotten (je 10 Schiffe) werden bei jedem neuen Spiel zufällig aufgestellt, waagerecht oder senkrecht; Schiffe berühren sich nicht, auch nicht diagonal. Deine Schiffe siehst du als `#`, die des Gegners bleiben verdeckt.

```
     Deine Flotte               Gegner
     A B C D E F G H I J        A B C D E F G H I J
  1  # # ~ # # ~ ~ ~ ~ ~     1  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
  2  ~ ~ ~ ~ ~ ~ # ~ ~ ~     2  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
 ...
 10  ~ ~ # ~ # ~ ~ ~ ~ ~    10  ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
```

| Symbol | Bedeutung |
|---|---|
| `#` | dein Schiff (nur auf deinem Feld sichtbar) |
| `~` | Wasser bzw. noch nicht beschossen |
| `o` | Schuss daneben |
| `X` | Treffer (auch versenkte Schiffe) |

## Angriff

Nach der Aufstellung fragt das Spiel nach deinem Schuss:

```
Dein Schuss (z. B. C5, x = Spiel abbrechen):
```

- Gib ein Feld des Gegners ein: Buchstabe `A`–`J` (groß oder klein) und Zahl `1`–`10`, ohne Leerzeichen dazwischen, z. B. `C5`, `c5` oder `J10`.
- Danach werden beide Spielfelder neu angezeigt, darunter die Antwort:

| Antwort | Bedeutung |
|---|---|
| „Vorbei!“ oder „Daneben!“ | Wasser (welche der beiden Meldungen kommt, ist Zufall) |
| „Treffer!“ | Ein Schiff wurde getroffen |
| „Treffer, versenkt!“ | Das letzte Feld eines Schiffs wurde getroffen – das Schiff ist versenkt |

- Ungültige Eingaben (z. B. `K5`, `C0`, `C 5`) und Felder, auf die du schon geschossen hast, werden mit einem Hinweis abgewiesen; du verlierst dadurch keinen Zug.
- Mit `x` brichst du das Spiel ab und kommst zurück ins Startmenü.

Zurzeit schießt nur du: Die Züge des Computers und das Spielende folgen mit den nächsten Features.

## Beenden

- Im Menü `3` eingeben (ein laufendes Spiel vorher mit `x` abbrechen), oder
- die Eingabe beenden mit **Strg+Z** und danach **Enter** – auch mitten im Spiel: Das Programm meldet „Eingabe beendet.“ und endet geordnet.

Beim Start über `start.bat` bleibt das Fenster danach offen, bis du eine beliebige Taste drückst.
