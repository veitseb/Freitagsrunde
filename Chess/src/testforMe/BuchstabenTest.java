package testforMe;

public class BuchstabenTest {

	private static char a = 'a';
	private static char aA = 'A';
	private static char bauer = 'b';
	private static char bauerB = 'B';
	private static boolean farbeT = true;
	private static boolean farbeF = false;
	
	public static void main(String[] args) {
	
		System.out.println((char)(bauerB + (farbeT ? ('a'-'A') : 0)));
		System.out.println((char)(bauerB + (farbeF ? ('a'-'A') : 0)));
	}
}
