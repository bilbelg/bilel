package Etape2;

import Etape2.Personne2;

public interface DetectNom2 {

	public Personne2 PersonFromTxt (String txt);
	
	public int nameDistance (String nom1,String nom2);
	
	public int nameDistance(String nom, Personne2 refPerson);
}
