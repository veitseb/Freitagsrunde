package chess;

/**
 * 
 * @author Sebastian
 *
 * @Erklaerung
 * Dieses Interface repraesentiert eine beliebige Figur,
 * die auf ein Schachbrett gestellt werden kann. Das Interface
 * beinhaltet hierbei keine Positionsangabe auf dem Brett, d.h.
 * Instanzen dieseses Interfaces koennen mehrmals auf demselben
 * Brett bzw. auf mehreren Brettern zugleich verwendet werden. Sie
 * repraesentieren somit lediglich den Typ einer Schafigur
 * (also Laeufer, Springer usw).
 */

public interface Chessman {
	
	/** Liefert ein einzelnes Zeichen, das den Figurentyp
	 * repraesentiert. Diese Methode kann fuer einfache textuelle
	 * Darstellungen verwedent werden.
	 **/
	public char toChar();
	
	/** Testet, ob diese Figur eine andere Figur theoretisch zu schlagen
	 * in der Lage ist.
	 * @param die Schachfigur, die es zu ueberpruefen gilt
	 * @return true genau dann, wenn die Figur geschlagen werden kann
	 **/
	
	public boolean canTake(Chessman chessman);
	
	/** Ueberprueft, auf welche Figur sich die Fugr im naechsten Zug
	 * theoretisch bewegen kann.
	 * @return ein Booleschen Feld in der Dimension des Schachbretts.
	 * Ein Eintrag ist genau dann true wenn die Figur auf dieses Feld
	 * ziehen darf.
	 * @param board das Schachbrett, auf dem agiert wird
	 * @param row die Nummer der Zeile , in der sich die Figur befindet.
	 * 		Die Methode muss nicht ueberpruefen, ob unter der angegebenen
	 * 		Position wirklich eine entsprechende Figur steht. Die Nummer
	 * 		wird von 0 an gezaehlt
	 * @param col die Nummer der Spalte, in der sich die Figur
	 * 		befindet.
	 * 		Die Methode muss nicht ueberpruefen, ob unter der angegebenen
	 * 		Position wirklich eine entsprechende Figur steht. Die Nummer
	 * 		wird von 0 an gezaehlt
	 **/
	
	public boolean[] [] getDestinations
		(Chessboard board, int row, int col);
	
	/** Ueberprueft, ob es sich bei zwei Schachfiguren um dieselbe Figur
	 * handelt.
	 * @return true genau dann, wenn es sich um dieselbe Figur handelt
	 **/
	
	public boolean equals(Object o);
}
