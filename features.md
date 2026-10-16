# Features

Umsetzung in der Reihenfolge der Nummern. Ein Feature wird abgehakt (`[x]`), sobald es fertig und getestet ist.

## Grundspiel

- [ ] 1. Startmenü: Neues Spiel, Spielregeln, Beenden
- [ ] 2. Spielfeld 10 × 10 (A–J, 1–10): eigenes und gegnerisches Feld nebeneinander in der Konsole
- [ ] 3. Flotte je Spieler: 1 × Schlachtschiff (5), 2 × Kreuzer (4), 3 × Zerstörer (3), 4 × U-Boot (2)
- [ ] 4. Zufällige Aufstellung beider Flotten: waagerecht oder senkrecht, keine Überlappung, Schiffe berühren sich nicht, auch nicht diagonal (Standard; im Spieltest prüfen, ob der Computer dadurch zu stark wird)
- [ ] 5. Angriff per Koordinate (z. B. `C5`); ungültige und schon beschossene Felder werden abgewiesen
- [ ] 6. Meldungen: bei Wasser zufällig „Vorbei!“ oder „Daneben!“, sonst „Treffer!“ bzw. „Treffer, versenkt!“
- [ ] 7. Computergegner Stufe leicht: schießt zufällig auf noch unbeschossene Felder
- [ ] 8. Spielende, sobald eine Flotte komplett versenkt ist; der Sieger wird angezeigt
- [ ] 9. Start per Doppelklick auf `start.bat`

## Schwierigkeitsstufen

- [ ] 10. Stufe mittel: Nach einem Treffer werden die Nachbarfelder beschossen, bis das Schiff versenkt ist
- [ ] 11. Stufe schwer: wie mittel; sucht zusätzlich im Schachbrettmuster und lässt die Felder rund um versenkte Schiffe aus
- [ ] 12. Schwierigkeitsstufe im Startmenü wählbar

## Erweiterungen

- [ ] 13. Farben: Rot ist der Gegner, Blau der eigene Spieler; beim Start abschaltbar
- [ ] 14. Zeitlimit pro Zug (Dauer im Spieltest festlegen, z. B. 20–30 s; eventuell nur in Stufe schwer): Wer zu lange braucht, verliert den Zug oder es wird automatisch zufällig auf ein unbeschossenes Feld geschossen – Variante im Spieltest wählen (geprüft nach der Eingabe)
- [ ] 15. Beim neuen Spiel wählbar: Zufallsaufstellung oder eigene Aufstellung per Texteingabe (z. B. `C5 W` = ab C5 waagerecht, `C5 S` = senkrecht)

## Ungeklärt – festgehalten bis zur Rückmeldung der Lektorin

- [ ] 16. Mitlaufender Countdown in Grün während der Eingabe – ungeklärt: braucht Sprachmittel, die erst freigegeben werden müssen
- [ ] 17. Animationen durch Zeichenwechsel (z. B. bei einem Treffer) – ungeklärt: braucht Pausen im Programm
- [ ] 18. Mehrspieler über zwei Geräte (z. B. Bluetooth, WiFi Direct) – ungeklärt: technisch und laut Vorgabe
- [ ] 19. Grafische Oberfläche (GUI) – ungeklärt: ob erlaubt
