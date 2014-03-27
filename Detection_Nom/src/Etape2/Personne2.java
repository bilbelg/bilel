package Etape2;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import org.slf4j.getLogger(BilelDetect_Nom.Class);


public class Personne2 {
	
	//String phrase;
	String LastName;
	String FirstName;

	public Personne2(){
		
	}
	
	public Personne2(String Nom,String Prenom){
		this.FirstName=Nom;
		this.LastName=Prenom;
	}
		
	
	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}


	


}
