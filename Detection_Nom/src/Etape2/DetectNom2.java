package Etape2;

import Etape2.Personne2;

public interface DetectNom2 {

	public Personne2 PersonFromTxt (String txt);
	
	public int nameDistance (String chaine1,String chaine2);
	
	public int nameDistance(String chaine1, Personne2 refPerson);
	
}
