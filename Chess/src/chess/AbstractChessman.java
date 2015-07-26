package chess;
/**
 * Die abstrakte Implementierung der Schachfigur fuegt dem
 * urspruenglichen Interface eine Farbe (Schwarz oder Weiss)
 * hinzu und implementiert die canTake und toChar-Methoden.
 * @author Sebastian
 *
 */


public abstract class AbstractChessman {

	/** Dieses Zeichen wird zur Darstellung der figur verwendet.
	 * 
	 **/
	private char description;
	
	/** Dieser Boolesche Wert besagt, ob es sich um eine schwarze Figur
	 * handelt.
	 **/
	
	private boolean isBlack;
	
	/** Konstruktor.
	 * @param isBlack ist true genau dann, wenn die Figur schwarz ist.
	 * @param description eine Darstellung der Figur als Zeichen.
	 * Dieser Wert muss ein Grossbuchstabe (zwischen A und Z) sein.
	 **/
	public AbstractChessman(boolean isBlack, char description) {
		this.description = description;
		this.isBlack = isBlack;
	}
	
	/** Gibt true genau dann zurueck,
	 * wenn die Schachfigur schwarz ist.
	 **/
	public boolean isBlack() {
		return this.isBlack;
	}
	
	/** Liefert ein einzelnes Zeichen, das die Figur reprasentiert.
	 * 
	 * @return
	 **/
	public char toChar() {
		return (char) (description + ((isBlack ? ('a' - 'A') :0)));
	}
	
	/** Testet, ob diese Figur eine andere Figur theoretisch zu schlagen
	 * in der Lage ist. Dies ist immer daer Fall, wenn die andere Figur
	 * nicht dieselbe Farbe hat.
	 **/
	public boolean canTake(Chessman chessman) {
		if(!(chessman instanceof AbstractChessman))
			return false;
		return isBlack != ((AbstractChessman)chessman).isBlack;
	}
	
	/** Vergleicht zwei Schachfiguren auf Typ-Gleichheit. Zwei
	 * Schachfiguren gelten hierbei als gleich vom gleichen Typ,
	 * wenn sie dieselbe Zeichendarstellung (toChar) haben.
	 **/
	public boolean equals(Object o) {
		if(o instanceof Chessman)
			return ((Chessman)o).toChar() == toChar();
		return false;
	}
	
	/** Da wir die equals-Methode ueberschrieben haben, muessen
	 * wir auch die hashCode-Methode ueberschreiben.
	 **/
	public int hashCode() {
		return toChar();
	}
}
