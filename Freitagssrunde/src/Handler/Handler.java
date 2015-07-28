package Handler;

import java.util.ArrayList;
import java.util.List;
import Hangman.*;

public class Handler {

	List<Character> buchstaben = new ArrayList<Character>();
	
	public void setNewBuchstabe(char buchstabe){
		if(buchstaben.contains(buchstaben))
			return;
		else
			buchstaben.add(buchstabe);
		
		return;
	}
	
	public List getBuchstaben(){
		return buchstaben;
	}
	
	public boolean buchstabeVorhanden(char buchstabe){
		if(buchstaben.contains(buchstabe))
			return true;
		else
			return false;
	}
}
