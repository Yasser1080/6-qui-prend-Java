package Jeu;
import java.util.ArrayList;

public class Joueur {
	private String pr�nom;
	private static ArrayList<Carte> cartes_joueur = new ArrayList<Carte>();
	
	public Joueur() {
		
	}

	public Joueur(String string) {
		this.pr�nom = string;
	}
	
	public String getPr�nom() {
		return pr�nom;
	}

	public void setPr�nom(String pr�nom) {
		this.pr�nom = pr�nom;
	}

	@Override
	public String toString() {
		for(int i = 0; i < cartes_joueur.size(); ++i) {
			if(i < cartes_joueur.size()-1)
				System.out.print(cartes_joueur.get(i)+", ");
			else
				System.out.print(cartes_joueur.get(i));
		}
		return "";
	}
	

	public void setCartes_joueur(ArrayList<Carte> deck) {
		this.cartes_joueur = deck;
	}

	public static ArrayList<Carte> getCarte_joueur() {
		return cartes_joueur;
	}

}