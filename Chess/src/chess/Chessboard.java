package chess;

/**
 * 
 * @author Sebastian
 *
 * @Erklaerung
 * Diese Klasse repraesentiert ein Schachbrett, auf dem sich Figuren
 * befinden. Diese Figuren duerfen durch entsprechende Befehle
 * bewegt werden.
 **/

public class Chessboard {
	
	/** In diesem Array wird die aktuelle Belegung des Schachbretts 
	 * gespeichert
	 * 
	 **/
	
	protected Chessman[] [] content;
	
	/** Konstruktor
	 * @param rows die Anzahl der Zeilen
	 * @param cols die Anzahl der Spalten
	 **/
	
	public Chessboard(int rows, int cols){
		content = new Chessman[rows] [cols];
	}
	
	public boolean isValid(int row, int col) {
		return row >=0 && col >= 0 &&
				row < content.length && col < content[0].length;
	}
	
	/** Gibt die Anzahl der Spalten des Schachbretts zurueck */
	public int getNumOfColumns() {
		return content[0].length;
	}
	
	/**Gibt die Anzahl der Zeilen des Schachbretts zuerueck */
	public int getNumOfRows() {
		return content.length;
	}
	
	/** Gibt den Inhalt des Bretts an einer gegebenen Position an.
	 * @param row der Zeilenindex, gezaehlt ab Index 0
	 * @param col der Spaltenindex, gezaehlt ab Index 0
	 * @return den Inhalt des Bretts an der gegebenen Position,
	 * 	null, wenn dort keine Figur steht
	 **/
	
	public Chessman getContent(int row, int col) {
		return content[row][col];
	}
	
	/** Besetzt ein Feld mit einer Spielfigur. Diese Methode ueberprueft
	 * nicht, ob der Zug gemaess den Schachregeln erlaubt ist.
	 * @param chessman die zu setzende Spielfigur oder null
	 * @param row der Zeilenindex, gezaehlt ab Index 0
	 * @param col der Spaltenindex, gezaehlt ab Index 0
	 * @return den Inhalt, der zuvor auf diesem Feld war.
	 **/
	
	public Chessman getContent(int row, int col, Chessman chessman) {
		Chessman result = content[row][col];
		content[row][col] = chessman;
		return result;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Chessboard) {
			Chessboard board = (Chessboard) o;
			//Vergleiche die Dimensionen der Felder
			if(board.content.length != content.length ||
				board.content[0].length != content[0].length){
					return false;
				}
			//Ueberpruefe die Feldinhalte
			for(int i = 0; i < content.length; i++){
				for(int j= 0; j < board.content[i].length; j++){
					Chessman man1 = content[i][j];
					Chessman man2 = board.content[i][j];
					if(man1 == null && man2 == null)
						continue;
					if(man1 != null && man2 != null && man1.equals(man2))
						continue;
					return false;
				}
			}
			return true;
			}
		return false;
		}
	
	/**
	 * Gibt den Hashcoe dieses Objektes zurueck. Wer die
	 * equels-Methode ueberschreibt, muss auch immer die
	 * hashCode-Methode anpassen!
	 */
	public int hashCode() {
		int res = 0;
		for(int i = 0; i < content.length; i++)
			for(int j = 0; j < content[i].length; j++)
				if(content[i][j] != null)
					res += content[i][j].hashCode();
		return res;
	}
	
	
	}
