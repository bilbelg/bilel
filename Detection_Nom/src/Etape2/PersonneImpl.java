package Etape2;

import java.awt.color.CMMException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class PersonneImpl implements DetectNom2 {
	
public Personne2 PersonFromTxt (String phrase) {
		
		String nomConcat="";
		String prenom="";
		Personne2 pers=new Personne2();
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
public int nameDistance (String nom1,String nom2){
	
	String 	Nom1MinusculeEspace=nom1.toLowerCase();
	String 	Nom1Minuscule=Nom1MinusculeEspace.replaceAll("\\s","");
			
			int nbDistance=0;
			
			String Compar1[] = null ;
			String Compar2[]=null;
			String compar_Mr_Nom_Prenom[]=null;
	
	if(nom1.equals(nom2)){
		System.out.println("les deux string sont compatible 100%");
		return 0;
	}
	else{
		
		String NomPrenom ="";
		String Mr_Nom="";
		List<String> liste = new ArrayList<String>() ;
		StringTokenizer st=new StringTokenizer(nom2, ". ");
		
		while (st.hasMoreTokens()){
			String mot=st.nextToken();
			 liste.add(mot);
									}
		
		for(String Mot1 :liste){
			
				if(! Mot1.equals("Mr")){
					
					Mr_Nom=Mr_Nom.concat(Mot1);
					
					NomPrenom=NomPrenom.concat(Mot1);
				}		
			}
		
			NomPrenom=NomPrenom.toLowerCase();
			
			
			Compar1=Nom1Minuscule.split("");
			Compar2=NomPrenom.split("");
			
			int a=Nom1Minuscule.length();
			int b=NomPrenom.length();
				
				if(a==b){
					int nbCarcDiff=0;
						for(int i=0;i<Nom1Minuscule.length();i++){
							if(!Compar1[i].equals(Compar2[i])){
								nbCarcDiff++;
							
							}
							}
						
						if (nbCarcDiff !=0){
							nbDistance=nbCarcDiff;
							return nbDistance;
						}
						else
						return 0;
				}
				//si les 2 chaines n'ont pas le meme longueur Prenom Nom et Mr.Nom
				else if(a!=b){
					Mr_Nom=Mr_Nom.toLowerCase();
					compar_Mr_Nom_Prenom=Nom1MinusculeEspace.split(" ");
					int nbCarcDiff=0;
					
					String NomRef="";
					String PrenomRef;
					PrenomRef=compar_Mr_Nom_Prenom[0];
					
					for (int i=1;i<compar_Mr_Nom_Prenom.length;i++){
						
							NomRef=NomRef.concat(compar_Mr_Nom_Prenom[i]);
						}
						
						NomRef=NomRef.replaceAll("\\s","");
						Mr_Nom=Mr_Nom.replaceAll("\\s","");
						String NomReference[]=NomRef.split("");
						String MrNom[]=Mr_Nom.split("");
						
						for (int i=0;i<NomReference.length;i++){
							if (!NomReference[i].equals(MrNom[i])){
								nbCarcDiff++;
							}
							
						}
				return (-1*10)-nbCarcDiff;
					}
				else return -10;	
				}
			
			
		
	//return 0;
}
 
public int nameDistance(String nom, Personne2 refPerson){
	
	
	return 0;
}
}
