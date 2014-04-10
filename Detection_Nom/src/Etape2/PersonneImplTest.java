package Etape2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonneImplTest {
	
	PersonneImpl underTest= new PersonneImpl();
    String text="Bilel Belgacem";
    
    Personne2 pers;
    
    
    @Test
	public void test0() {
		
		String chaineProp=underTest.Transf("Mr.Bilel Belgacem");
		assertEquals("Bilel Belgacem",chaineProp);
	}
    
    @Test
	public void test1() {
		
		String chaineProp=underTest.Transf("Mme.Nada Belg");
		assertEquals("Nada Belg",chaineProp);
	}
	@Test
	public void test2() {
		
		String chaineProp=underTest.Transf("Mlle.Nada Belg");
		assertEquals("Nada Belg",chaineProp);
	}
    
	@Test
	public void test3() {
		
		pers=underTest.PersonFromTxt("Mr.Bilel Belgacem");
		assertEquals(pers.getFirstName(),"bilel");
		assertEquals(pers.getLastName(),"belgacem");
	}
	
	@Test
	public void test4() {
		
		pers=underTest.PersonFromTxt("Mr.Belgacem");
		assertEquals(pers.getFirstName(),"");
		assertEquals(pers.getLastName(),"belgacem");
	}
	
	@Test
	public void test5() {
		
		boolean pourcent=underTest.Inverse("bilel", "belgacem", "belgacem", "bilel");
		assertEquals(true,pourcent);
	}
	
	@Test
	public void test6() {
		
		boolean pourcent=underTest.Inverse("bilel", "belgacem", "belgakem", "bilel");
		assertEquals(false,pourcent);
	}
	
	@Test
	public void test7() {
		
		boolean pourcent=underTest.Inverse("bilel", "belgacem", "belgacem", "bilal");
		assertEquals(false,pourcent);
	}
	
	@Test
	public void test8() {
		
		int CaracDif=underTest.ComparPrenomNom("Bilel","Bilel");
		assertEquals(0,CaracDif);
	}
	
	@Test
	public void test9() {
		
		int CaracDif=underTest.ComparPrenomNom("Bilel","Bila");
		assertEquals(2,CaracDif);
	}
	
	@Test
	public void test10() {
		
		int CaracDif=underTest.ComparPrenomNom("Bilel","Bil");
		assertEquals(2,CaracDif);
	}

	@Test
	public void test11() {
		
		int pourcent=underTest.nameDistance("Bilel Belgacem","Bilel Belgacem");
		assertEquals(100,pourcent);
	}
	
	@Test
	public void test12() {
		Personne2 pers1=new Personne2("Bilel","belgacem");
		Personne2 pers2=new Personne2("B","belgacem");
		int pourcent=underTest.Compar(pers1,pers2);
		assertEquals(85,pourcent);
	}
	
	@Test
	public void test13() {
		Personne2 pers1=new Personne2("Bilel","belgacem");
		Personne2 pers2=new Personne2("","belgacem");
		int pourcent=underTest.Compar(pers1,pers2);
		assertEquals(75,pourcent);
	}
	
	
	
	@Test
	public void test14() {
		Personne2 pers1=new Personne2("Bilel","belgacem");
		Personne2 pers2=new Personne2("Bilel","belKacem");
		int pourcent=underTest.ComparMemLong(pers1,pers2);
		assertEquals(92,pourcent);
	}
	
	@Test
	public void test15() {
		Personne2 pers1=new Personne2("Bilel","belkasem");
		Personne2 pers2=new Personne2("Bilel","belgacem");
		int pourcent=underTest.ComparMemLong(pers1,pers2);
		assertEquals(85,pourcent);
	}
	
	@Test
	public void test16() {
		
		int pourcent=underTest.nameDistance("Bilel belgacem","Bilel belKacem");
		assertEquals(92,pourcent);
	}
	
	@Test
	public void test17() {
		
		int pourcent=underTest.nameDistance("Bilel belgacem","Mr.belgacem");
		assertEquals(75,pourcent);
	}
	
	@Test
	public void test18() {
		
		int pourcent=underTest.nameDistance("Bilel belgacem","Mr.B belgacem");
		assertEquals(85,pourcent);
	}
	
	@Test
	public void test19() {
		
		int pourcent=underTest.nameDistance("Bilel belgacem","Bilal belKacem");
		assertEquals(84,pourcent);
	}
	
	@Test
	public void test20() {
		
		int pourcent=underTest.nameDistance("Belal belkacem","Bilel belgacem");
		assertEquals(76,pourcent);
	}
	
	@Test
	public void test21() {
		
		int pourcent=underTest.nameDistance("Belal belkasem","Bilel belgacem");
		assertEquals(69,pourcent);
	}
	@Test
	public void test22() {
		
		int pourcent=underTest.nameDistance("Bilel belgacem","Etienne laplanne");
		assertEquals(13,pourcent);
	}
	
	@Test
	public void test23() {
		Personne2 pers1=new Personne2("Bilel","belkasem");
		Personne2 pers2=new Personne2("Bilel","belgacem");
		int pourcent=underTest.nameDistance(pers1,pers2);
		assertEquals(85,pourcent);
	}

	@Test
	public void test24() {
		Personne2 pers2=new Personne2("Bilel","belgacem");
		int pourcent=underTest.nameDistance("Bilal belgacem",pers2);
		assertEquals(92,pourcent);
	}

	@Test
	public void test25() {
		Personne2 pers2=new Personne2("Bilel","belgacem");
		int pourcent=underTest.nameDistance("Bilel belkacem",pers2);
		assertEquals(92,pourcent);
	}
	@Test
	public void test26() {
		Personne2 pers2=new Personne2("Bilel","belgacem");
		int pourcent=underTest.nameDistance("Bilal belkacem",pers2);
		assertEquals(84,pourcent);
	}
}
