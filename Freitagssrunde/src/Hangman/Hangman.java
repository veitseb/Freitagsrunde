/* Tipps:
 * 
 * Der Typ char speichert einen einzelnen Buchstaben.
 * Einzelne Buchstaben weden in Java in einfache Anfuehrungszeichen gesetzt
 * char characterDemo = 'X';
 * 
 * Terminal.readString() liest ein Wort(String) von der Konsole
 * Terminal.readChar() liest einen Buchstaben(char) von der Konsole
 * 
 * Strings haben bei Java die Besonderheit, dass sie einige Methoden mitbringen
 * die den Umgang mit ihnen erleichtern.
 * 
 * "Text".contains("xt") liefert true wenn "xt" in "Text" enthalten ist, sonst false.
 * "Text".charAt(0) liefert den 0ten Buchstaben aus "Text", hier also das "T".
 * 
 * Mehr Methoden findest du Uebrigens unter http://java.sun.com/j2se/1.5.0/docs/api/java/lang/String.html
 * im Bereich "Method summary". Eine naehere Erklaerung dazu gibt es spaeter in LE6. 
 * 
 * Um dir die Arbeit ein wenig zu erleichtern haben wir dir eine Methode vorgegeben, die in einem String einen 
 * Buchstaben ersetzt (siehe unten) 
 *
 * Kompilieren tut ihr das gesammte Programm dann mit "javac *.java".
 */

package Hangman;

import java.util.ArrayList;
import java.util.List;

public class Hangman {
	
	private static final int VERSUCHE = 15;
	private static int lokVersuche;
	//private static char[] benutzteBuchstaben = new char[15];
	private static List<Character> list = new ArrayList<Character>();
	private static String suchWort;
	private static String gefundenesWort;

	public static void main(String[] arguments) {
		suchWort = Terminal.readString();
		System.out.println("zu suchendes Wort: " + suchWort);
		
		lokVersuche = VERSUCHE;
		gefundenesWort = setGefundenesWort(suchWort);
		
		System.out.println(gefundenesWort);
		
		while(wortFinden());
		
	}
	
	private static boolean wortFinden(){
		char buchstabe = Terminal.readChar();
		buchstabe = Character.toLowerCase(buchstabe);
		if(kontrolle(buchstabe))
			return true;
		else 
			list.add(buchstabe);
		
		lokVersuche--;
		
		wortTest(buchstabe);
		
		if(lokVersuche == 0){
			System.out.println("GAME OVER: Haengt ihn");
			return false;
		}
		return true;
	}
	
	private static void wortTest(char buchstabe){
		char[] gefundenesWortChar = gefundenesWort.toCharArray();
		char[] suchWortChar = suchWort.toCharArray();
		String suchWortL = suchWort.toLowerCase();
		char[] suchWortLCharLowerCase = suchWortL.toCharArray();
		buchstabe = Character.toLowerCase(buchstabe);
		for(int i = 0; i < suchWortLCharLowerCase.length; ++i){
			if(suchWortLCharLowerCase[i] == buchstabe)
				gefundenesWortChar[i] = suchWortChar[i];
			else
				continue;				
		}
		
		gefundenesWort = new String(gefundenesWortChar);
		
		System.out.println(gefundenesWort);
		System.out.println("Du hast noch " + lokVersuche + " Versuche");
		
		if(gefundenesWort.equals(suchWort))
			System.out.println("Yeah du hast Gewonnen mit noch überbleibenden: " + lokVersuche);
		
		return;
	}
	
	private static boolean kontrolle(char buchstabe){
		return list.contains(buchstabe);
		
//		for(int i = 0; i< benutzteBuchstaben.length; ++i){
//			if(benutzteBuchstaben[i] == buchstabe)
//				return false;
//			else
//				continue;
//		}
//			
//		return true;
	}
	
	private static String setGefundenesWort(String suchWort){
		String gefundenesWort = "";
		char[] suchWortChar = suchWort.toCharArray();
		
		for(int i = 0; i < suchWortChar.length; ++i){
			if(suchWortChar[i] == ' ')
				continue;
			else
				gefundenesWort = gefundenesWort + "_";
		}
		
		return gefundenesWort;
	}
	
	/**
	 * Ersetzt einen Buchstaben in word an position durch character
	 * Ergebnis dieser Ersetzung wird zurueckgeliefert.
	 */
	public static String replaceCharAtPosition(String word, char character, int position){
		// Fehlerbehandlung
		if(null == word) {
			System.out.println("Es wurde kein String Uebergeben.");
			return word;
		}
		if(word.length() <= position || position < 0){
			System.out.println("Die angegebene Position befindet sich auserhalb des Uebergebenen Strings.");
			return word;
		}
		// Ersetzung
		return word.substring(0, position) + character + word.substring(position +1);
	}	
}
