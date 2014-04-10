package Noms;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import org.slf4j.getLogger(BilelDetect_Nom.Class);


public class Personne implements Detect_Nom {
	
	//String phrase;
	String LastName;
	String FirstName;

	public Personne(){
		
	}
	
	public Personne(String Nom,String Prenom){
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


	public Personne PersonFromTxt (String phrase) {
		
		String nomConcat="";
		String prenom="";
		Personne pers=new Personne();
		String tab[] = phrase.split(" ");
		prenom=tab[0];
		for (int i=1;i<tab.length;i++){
			if(i!=1){
			nomConcat=nomConcat.concat(" ");
			}
			nomConcat=nomConcat.concat(tab[i]);
			}
		pers.setFirstName(prenom);
		pers.setLastName(nomConcat);
		return pers;
		
	}


}
