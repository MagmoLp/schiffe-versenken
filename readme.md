# Schiffe versenken

Klassisches Schiffe versenken als Konsolenspiel in Java. Gespielt wird gegen den Computer in drei Schwierigkeitsstufen. Ziel des Spiels ist es, die gegnerische Flotte komplett zu zerstören.

## Spielregeln

- Spielfeld: 10 × 10 Kästchen (Spalten A–J, Zeilen 1–10)
- Standardflotte je Spieler, 10 Schiffe:

  | Schiff | Anzahl | Größe |
  |---|---|---|
  | Schlachtschiff | 1 | 5 Kästchen |
  | Kreuzer | 2 | 4 Kästchen |
  | Zerstörer | 3 | 3 Kästchen |
  | U-Boot | 4 | 2 Kästchen |

- Aufstellung nach den klassischen Regeln, waagerecht oder senkrecht – zufällig oder selbst per Texteingabe
- Angriff durch Eingabe eines Feldes, z. B. `C5`
- Antwort des Gegners: „Vorbei!“ oder „Daneben!“ (zufällig) bei Wasser, „Treffer!“ bei einem Treffer, „Treffer, versenkt!“, wenn ein Schiff versenkt ist

## Projekt

Semesterprojekt für Strukturierte Programmierung (STPRO), umgesetzt mit KI-Agenten. Geplante Features: [features.md](features.md) · Regeln für den Agenten: [agents.md](agents.md)

---

Autor: Paul Hübner
