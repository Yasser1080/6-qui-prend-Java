package Jeu;
import java.util.ArrayList;
import java.util.Collections;

public class Paquet {
	private ArrayList<Carte> paquet = new ArrayList<Carte>();
	
	public Paquet() {
		for(int i = 1; i < 105; ++i) {
			Carte c = new Carte();
			paquet.add(c);
		}
	}
	
	public void melanger() {// mélange les cartes du paquet au hasard
        Collections.shuffle(paquet);
    }
	
	public void ajouter(Joueur j) { // ajoute 10 cartes à chaque joueur
		ArrayList<Carte> deck = new ArrayList<Carte>();
		for(int i = 0; i < 10; ++i)
			deck.add(retirer());
		j.setCartes_joueur(deck);
	}
	
	public Carte retirer() {//retire une carte du paquet
		Carte c = new Carte();
		c = paquet.get(0);
		paquet.remove(0);
		return c ;
	}
	
	public void ajouter_série(Série s) {// ajoute une carte à la série
		ArrayList<Carte> carte_série = new ArrayList<Carte>();
		carte_série.add(retirer());
		s.setSérie_cartes(carte_série);
	}

	@Override
	public String toString() {
		return "" + paquet;
	}

	public ArrayList<Carte> getPaquet() {
		return paquet;
	}
}
