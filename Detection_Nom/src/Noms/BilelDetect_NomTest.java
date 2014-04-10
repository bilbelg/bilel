package Noms;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BilelDetect_NomTest {
	
	private static Personne underTest= new Personne();
	
	String txt="Bilel travaille dans la société Dynamease chez Mr.Yves Nicolas";
	String txt2="Jean-francois Helion de Jean de la Batie";
	
	@Test
	public void test() {
		underTest = underTest.PersonFromTxt("Jean-francois Helion de Jean de la Batie");
		System.out.println(underTest.getFirstName());
		System.out.println(underTest.getLastName());
		assertEquals("Jean-francois",underTest.getFirstName());
		assertEquals("Helion de Jean de la Batie",underTest.getLastName());
	}

}
