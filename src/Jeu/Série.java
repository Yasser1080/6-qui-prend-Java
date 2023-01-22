package Jeu;
import java.util.ArrayList;

public class S�rie {
	private ArrayList<Carte> s�rie_cartes = new ArrayList<Carte>();
	private int num�ro_de_s�rie;
	private static int numerocpt = 1;
	
	public S�rie() {
		this.num�ro_de_s�rie = numerocpt++;
	}

	public ArrayList<Carte> getS�rie_cartes() {
		return s�rie_cartes;
	}
	
	public void setS�rie_cartes(ArrayList<Carte> carte_s�rie) {
		this.s�rie_cartes = carte_s�rie;
	}

	@Override
	public String toString() {
		String chaine = " - S�rie n� "+num�ro_de_s�rie+" : ";
		for (int i = 0; i < s�rie_cartes.size(); i++) {
			chaine += s�rie_cartes.get(i);
		}
		return chaine;
	}
}