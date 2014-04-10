package Etape2;

		public class PersonneImpl implements DetectNom2 {
		
		//supprimer le titre de civilité devant le Prenom
		public String Transf (String chaine1){
			
			String chProp;
			if(chaine1.matches("Mr.*")){
				chProp=chaine1.replaceAll("Mr.","");
				return chProp;
			}
			if(chaine1.matches("Mme.*")){
				chProp=chaine1.replaceAll("Mme.","");
				return chProp;
			}
			else if(chaine1.matches("Mlle.*")){
				chProp=chaine1.replaceAll("Mlle.","");
				return chProp;
				}
			return chaine1;
		}
	
		//construire une personne a travers une chaine des caracteres 
		public Personne2 PersonFromTxt (String phrase) {
			phrase=Transf(phrase);
			phrase=phrase.toLowerCase();
			//il faut utiliser une liste a la place de split pour traiter le cas B.Belgacem
			String tab[] = phrase.split(" ");
			if(tab.length>1){
		        return new Personne2(tab[0], phrase.substring(tab[0].length() + 1));	
			 }
			else
				 return new Personne2("",tab[0]);
			 }

	
	
			//verifier si les 2 chaines sont inversé
		public boolean Inverse(String Prenom1,String Nom1,String Prenom2,String Nom2){
				
			if ( (Prenom1.equals(Nom2)) && (Nom1.equals(Prenom2)) ) {
				return true;
				}
			else return false;
				}
	
		
	
		//nombres des fautes sur les 2 Prenoms et les 2 Noms
		public int ComparPrenomNom(String PN1,String PN2){
			int NbCaracDiffPN=0;
			System.out.println("chaine1 est "+PN1);
			System.out.println("chaine2 est "+PN2);
			int LongPN1=PN1.length();
			int LongPN2=PN2.length();
			int DiffPN=LongPN1-LongPN2;
			System.out.println("la diff entre le long des 2 chaine est "+DiffPN);
			
			//si la premiere chaine est plus courte que la 2iem 
			//on prend la chaine1 comme une chaine de refernce
			if(DiffPN <= 0){
				System.out.println("la chaine la plus courte  est  "+PN1);
				for (int i=0;i<PN1.length();i++){
					if(PN1.charAt(i)!= PN2.charAt(i)){
						NbCaracDiffPN++;	
					}
				}
				
				System.out.println("nb des carac diffrente entre chaine1 et chaine2 "+NbCaracDiffPN);
				NbCaracDiffPN= NbCaracDiffPN - DiffPN;
				System.out.println("nb des carac diffrente Total chaine1 et chaine2 "+NbCaracDiffPN);
				return NbCaracDiffPN;
			}
			else{
				System.out.println("le nom le plus courte  est  "+PN2);
			for (int i=0;i<PN2.length();i++){
				if(PN2.charAt(i)!= PN1.charAt(i)){
					NbCaracDiffPN++;
					
				}
			}
			System.out.println("nb des carac diffrente entre chaine2 et chaine1 "+NbCaracDiffPN);
			NbCaracDiffPN=NbCaracDiffPN +DiffPN;
			System.out.println("nb des carac diffrente Total chaine2 et chaine1 "+NbCaracDiffPN);
			return NbCaracDiffPN;
			}
			
		}
		
	

		//fixer la chaine la plus courte comme reference pour calculer la distance entre le 2 prenom 
		//et les 2 noms (retourne le nb des caracteres commun sur les 2 noms ou les 2 prenoms par apport )
		//le nb des caractere de chaine de reference
		public double CalculFautPrenomNom(String PN1,String PN2){
			int LongPN1=PN1.length();
			int LongPN2=PN2.length();
			int PNRef=LongPN1-LongPN2;
			int NbCaracDiffPN=ComparPrenomNom(PN1,PN2);

			if (PNRef>0){
				double nbFautePN=(LongPN2-NbCaracDiffPN);
				System.out.println("le nbFautPrenom =long chaine2 - NbCarDiffPren "+nbFautePN);
				nbFautePN=nbFautePN/LongPN2;
				return nbFautePN;
			}
			
			else {
				double nbFautePN=(LongPN1-NbCaracDiffPN);
				System.out.println("le nbFautPrenom =long chaine1 - NbCarDiffPN "+nbFautePN);
				nbFautePN=nbFautePN/LongPN1;
				return nbFautePN;
			}
			
		}
		
		
		//déterminer la distance en % si les 2 chaines ont le meme longueur
		public int ComparMemLong(Personne2 Pers1,Personne2 Pers2){
			
			String Prenom1=Pers1.getFirstName();
			String Nom1=Pers1.getLastName();
			
			String Prenom2=Pers2.getFirstName();
			String Nom2=Pers2.getLastName();
			
			Prenom1=Prenom1.toLowerCase();
			Prenom2=Prenom2.toLowerCase();
			Nom1=Nom1.toLowerCase();
			Nom2=Nom2.toLowerCase();
			
			int NbCaracDiffNom=0;
			int NbCaracDiffPrenom=0;
			int NbDistanceNom=0;
			int NbDistancePrenom=0;
			int NbDistance=0;
	
			NbCaracDiffPrenom=ComparPrenomNom(Prenom1,Prenom2);
			double nbFautePrenom=CalculFautPrenomNom(Prenom1,Prenom2);
				
			if(NbCaracDiffPrenom>2){
				NbDistancePrenom=(int) (nbFautePrenom*30);
				System.out.println("distance sur le prenom "+NbDistancePrenom);
				}
			else{
				NbDistancePrenom=(int) (nbFautePrenom*40);
				System.out.println("distance sur le prenom "+NbDistancePrenom);
				}
			//verifiction sur nom
			NbCaracDiffNom=ComparPrenomNom(Nom1,Nom2);
			double nbFauteNom=CalculFautPrenomNom(Nom1,Nom2);
			
			if(NbCaracDiffNom>2){
				NbDistanceNom=(int) (nbFauteNom*30);
				System.out.println("distance sur le nom "+NbDistanceNom);
				}
			else{
				NbDistanceNom=(int) (nbFauteNom*60);
				System.out.println("distance sur le nom "+NbDistanceNom);
				}
				NbDistance=NbDistancePrenom+NbDistanceNom;
				System.out.println("distance total est "+NbDistance );
				
			if (NbDistance <60){
				//on vérifie si les deux chaines sont inversé
				if(Inverse(Prenom1,Nom1, Prenom2, Nom2)==true){
						NbDistance=80;
						}		
				return NbDistance;
				}	
			else  return NbDistance;
			
		}
		
		//déterminer la distance si les 2 chaines n'ont pas le meme longueur
		public int Compar(Personne2 Pers1,Personne2 Pers2){
			
			String Prenom1=Pers1.getFirstName();
			String Nom1=Pers1.getLastName();
			
			String Prenom2=Pers2.getFirstName();
			String Nom2=Pers2.getLastName();
			
			Prenom1=Prenom1.toLowerCase();
			Prenom2=Prenom2.toLowerCase();
			Nom1=Nom1.toLowerCase();
			Nom2=Nom2.toLowerCase();
			
			int NbCaracDiffNom=0;
			int NbCaracDiffPrenom=0;
			int NbDistanceNom=0;
			int NbDistancePrenom=0;
			int NbDistance=0;
			
			NbCaracDiffPrenom=ComparPrenomNom(Prenom1, Prenom2);
			NbCaracDiffNom=ComparPrenomNom(Nom1, Nom2);
			
			double nbFautePrenom=CalculFautPrenomNom(Prenom1, Prenom2);
			double nbFauteNom=CalculFautPrenomNom(Nom1,Nom2);
			
			//traiter le cas Bilel Belgacem et Belgacem
			if((Prenom1=="")||(Prenom2=="")){
				System.out.println("manque de prenom");
				System.out.println("****verification sur le nom******");	
				if(NbCaracDiffNom>2){
					NbDistanceNom=(int) (nbFauteNom*50);
					System.out.println("distance sur le nom "+NbDistanceNom);
				}
				else{
					NbDistanceNom=(int) (nbFauteNom*75);
					System.out.println("distance sur le nom "+NbDistanceNom);
				}
				return NbDistanceNom;
			}
			
			//traiter le cas Bilel Belgacem et B Belgacem
			if(Prenom1.length()==1||Prenom2.length()==1){	
				System.out.println("****verification sur le nom******");
					if(NbCaracDiffNom>2){
						NbDistanceNom=(int) (nbFauteNom*35);
						System.out.println("distance sur le nom "+NbDistanceNom);
					}
					else{
					NbDistanceNom=(int) (nbFauteNom*50);
					System.out.println("distance sur le nom "+NbDistanceNom);
					}
				
					if (Prenom1.charAt(0)==Prenom2.charAt(0) && NbCaracDiffNom <2){
						NbDistancePrenom=35;
					}
					else{
					NbDistancePrenom=0;
					}
				
				NbDistance=NbDistanceNom+NbDistancePrenom;
				System.out.println("la distance de Total  est "+NbDistance);
				return NbDistance;
				}
				
				//traiter le cas si les 2 chaines ont pas le meme longueur Bilel belgacem Etienne laplanne
			else{
				
				if(NbCaracDiffNom>2){
					NbDistanceNom=(int) (nbFauteNom*35);
					System.out.println("distance sur le nom "+NbDistanceNom);
				}
				else{
				NbDistanceNom=(int) (nbFauteNom*50);
				System.out.println("distance sur le nom "+NbDistanceNom);
				}
				
				if(NbCaracDiffPrenom>2){
					NbDistancePrenom=(int) (nbFautePrenom*35);
					System.out.println("distance sur le prenom "+NbDistancePrenom);
				}
				else{
					NbDistancePrenom=(int) (nbFautePrenom*50);
				System.out.println("distance sur le prenom hhh "+NbDistancePrenom);
				}
				NbDistance=NbCaracDiffPrenom+NbCaracDiffNom;
				return NbDistance;
			}
			
			
		}
	
	
		public int nameDistance (String chaine1,String chaine2){
		
			chaine1=Transf(chaine1);
			chaine2=Transf(chaine2);
			chaine1=chaine1.toLowerCase();
			chaine2=chaine2.toLowerCase();
			
			if(chaine1.equals(chaine2)){
				System.out.println("les deux string sont compatible 100%");
				return 100;
			}
			
			//si les 2 chaines sont pas equivalent
			else{
				Personne2 Pers1=new Personne2();
				Pers1=PersonFromTxt(chaine1);
				Personne2 Pers2=new Personne2();
				Pers2=PersonFromTxt(chaine2);
				
				return nameDistance(Pers1, Pers2);
			}

		}
		
		public int nameDistance (Personne2 p1, Personne2 p2) {
			
			int LongCh1=p1.getFirstName().length()+p1.getLastName().length();
			int LongCh2=p2.getFirstName().length()+p2.getLastName().length();
			if (LongCh1==LongCh2){
				return ComparMemLong(p1, p2);
			}
			else{
				return Compar(p1, p2);
			}
					}

 

		public int nameDistance(String chaine1, Personne2 refPerson){
			
			return nameDistance(PersonFromTxt(chaine1), refPerson);
		}
		
		public int LevenshteinDistance (String s0, String s1) {
			int len0 = s0.length()+1;
			int len1 = s1.length()+1;
		 
			// the array of distances
			int[] cost = new int[len0];
			int[] newcost = new int[len0];
		 
			// initial cost of skipping prefix in String s0
			for(int i=0;i<len0;i++) cost[i]=i;
		 
			// dynamicaly computing the array of distances
		 
			// transformation cost for each letter in s1
			for(int j=1;j<len1;j++) {
		 
				// initial cost of skipping prefix in String s1
				newcost[0]=j-1;
		 
				// transformation cost for each letter in s0
				for(int i=1;i<len0;i++) {
		 
					// matching current letters in both strings
					int match = (s0.charAt(i-1)==s1.charAt(j-1))?0:1;
		 
					// computing cost for each transformation
					int cost_replace = cost[i-1]+match;
					int cost_insert  = cost[i]+1;
					int cost_delete  = newcost[i-1]+1;
		 
					// keep minimum cost
					newcost[i] = Math.min(Math.min(cost_insert, cost_delete),cost_replace );
				}
		 
				// swap cost/newcost arrays
				int[] swap=cost; cost=newcost; newcost=swap;
			}
		 
			// the distance is the cost for transforming all letters in both strings
			return cost[len0-1];
		}
		}
