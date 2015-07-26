package _DDDText;

public class Main {
	
	private static DDDText text = new DDDText();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String hText = new String("HALLOWELT");
		
		char[] hTextA = hText.toCharArray();
		
		for(int i = 0; i < hTextA.length; i++){
//			System.out.println(hTextA[i] - ('A'));
			int wert = hTextA[i] - ('A');
			for(int j = 0; j < text.letters[wert].length; ++j){
				System.out.println(text.letters[wert][j]);
			}
		}
		
		for(int i = 0; i < text.letters.length; ++i){
			System.out.println("neuer letter i= " + i);
			for(int j = 0; j < text.letters[i].length; ++j){
				System.out.println(text.letters[i][j]);
			}
		}
		
		
	}

}
