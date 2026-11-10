// Ein Schiff auf dem Spielfeld. Records sind unveränderlich: die Position steht beim Anlegen fest.
// start = Index des ersten Feldes (ganz links bzw. ganz oben),
// waagerecht = true: das Schiff liegt nach rechts, false: nach unten.
public record Schiff(String name, int laenge, int start, boolean waagerecht) {
}
