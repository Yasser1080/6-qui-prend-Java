package Jeu;
import java.util.ArrayList;

public class Série {
	private ArrayList<Carte> série_cartes = new ArrayList<Carte>();
	private int numéro_de_série;
	private static int numerocpt = 1;
	
	public Série() {
		this.numéro_de_série = numerocpt++;
	}

	public ArrayList<Carte> getSérie_cartes() {
		return série_cartes;
	}
	
	public void setSérie_cartes(ArrayList<Carte> carte_série) {
		this.série_cartes = carte_série;
	}

	@Override
	public String toString() {
		String chaine = " - Série n° "+numéro_de_série+" : ";
		for (int i = 0; i < série_cartes.size(); i++) {
			chaine += série_cartes.get(i);
		}
		return chaine;
	}
}