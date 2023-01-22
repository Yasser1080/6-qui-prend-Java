import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Jeu.Jeu;
import Jeu.Joueur;
import Jeu.Paquet;

public class Test6quiprend {

	@Test
	public void test() { //Test si le paquet contient bien 104 cartes
		Paquet test = new Paquet();
		assertEquals(104, test.getPaquet().size());
	}
	
	@Test
	public void test1() { // Test si il y a 4 séries
		Jeu test = new Jeu();
		Paquet p = new Paquet();
		test.creer_et_distrib_série(p);
		assertEquals(4, test.getTab_série().size());
	}
	
	@Test
	public void test2() { // Test si la fonction lire lit et crée bien les joueurs qui sont dans le fichier config.txt
		Jeu test = new Jeu();
		ArrayList<Joueur> lecture = test.lire();
		assertEquals(2, lecture.size());
	}
	
	@Test
	public void test3() { //Test si les joueurs ont bien 10 cartes
		Paquet p = new Paquet();
		Jeu jeu = new Jeu();
		jeu.lire();
		jeu.distribuer(p);
		assertEquals(10, jeu.getTab_j().get(0).getCarte_joueur().size());
	}
	
	@Test
	public void test4() { //Test si chaque série contient 1 carte à sa création à l'aide de la fonction ajouter_série
		Jeu test = new Jeu();
		Paquet p = new Paquet();
		test.creer_et_distrib_série(p);
		assertEquals(1, test.getTab_série().get(0).getSérie_cartes().size());
		assertEquals(1, test.getTab_série().get(1).getSérie_cartes().size());
		assertEquals(1, test.getTab_série().get(2).getSérie_cartes().size());
		assertEquals(1, test.getTab_série().get(3).getSérie_cartes().size());
	}
	
	@Test
	public void test5() { // Test si la fonction retirer peut retirer une carte du paquet
		Jeu jeu = new Jeu();
		Paquet p = new Paquet();
		p.retirer();
		assertEquals(103, p.getPaquet().size());
	}
	
	@Test
	public void test6() { // Test si la fonction ajouter ajoute bien 10 cartes aux joueurs
		Jeu jeu = new Jeu();
		Paquet p = new Paquet();
		jeu.lire();
		p.ajouter(jeu.getTab_j().get(0));
		assertEquals(10, jeu.getTab_j().get(0).getCarte_joueur().size());
	}
	
	@Test
	public void test7() { // Test si la fonction retirer peut retirer une carte du paquet
		Jeu jeu = new Jeu();
		Paquet p = new Paquet();
		p.retirer();
		assertEquals(103, p.getPaquet().size());
	}
	
	@Test
	public void test8() { // Test si la fonction verif_nbjoueur fonctionne
		Jeu jeu = new Jeu();
		jeu.lire();
		boolean nbjoueur = jeu.verif_nbjoueur(jeu.getTab_j());
		assertEquals(true, nbjoueur);
	}
}