package Test;

public class CharTest {
	public static void main(String[] args) {
	String wort = "HallLO hdlwD";
	char[] wortC = wort.toCharArray();
	
	for(int i = 0; i < wortC.length; ++i){
		wortC[i] = Character.toUpperCase(wortC[i]);
	}
	wort = wortC.toString();
	System.out.println(wortC);
	}
}
