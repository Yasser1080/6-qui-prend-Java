package Jeu;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Jeu {
	private static final int MAX = 10;
	private static final int MIN = 2;
	static Joueur[] tab = new Joueur[0];
	private ArrayList<Joueur> tab_j = new ArrayList<Joueur>(Arrays.asList(tab));
	private ArrayList<S�rie> tab_s�rie = new ArrayList<S�rie>();
	
	public Jeu() {
		
	}
	
	public ArrayList<Joueur> getTab_j() {
		return tab_j;
	}

	public void setTab_j(ArrayList<Joueur> tab_j) {
		this.tab_j = tab_j;
	}

	public ArrayList<S�rie> getTab_s�rie() {
		return tab_s�rie;
	}

	public void setTab_s�rie(ArrayList<S�rie> tab_s�rie) {
		this.tab_s�rie = tab_s�rie;
	}

	public ArrayList<Joueur> lire() { // lit et prend les joueurs du fichier config.txt pour cr�er des objets Joueurs
		try {
			Scanner a = new Scanner(new FileInputStream("config.txt"));
			while(a.hasNext()) {
				Joueur j = new Joueur(a.next());
				tab_j.add(j);
			}
		}
		catch (FileNotFoundException e) {
				System.out.println("le fichier est introuvable");	
		}
		return tab_j;

	}
	
	public void distribuer(Paquet p) { // distribue 10 cartes � chaque joueur � l'aide de la fonction ajouter
        for(Joueur j1 : tab_j) {
            p.ajouter(j1);
        }
    }
	
	public void creer_et_distrib_s�rie(Paquet p) {// cr�e 4 s�ries et ajoute � chacune 1 carte du paquet
		for(int i = 0; i < 4; ++i) {
			S�rie s = new S�rie();
			tab_s�rie.add(s);
			p.ajouter_s�rie(s);
		}
	}
	
	public boolean a_carte(Carte c, Joueur j) { //teste si le joueur poss�de la carte entr�e en argument
		boolean a_la_carte = false;
		for(Carte carte_j : j.getCarte_joueur()) {
			if(c == carte_j) {
				a_la_carte = true;
			}
			else {
				a_la_carte = false;
			}
		}
		return a_la_carte;
	}
	
	public boolean verif_nbjoueur(ArrayList<Joueur> tab) { // v�rifie que le nombre de joueurs est respect�
		if(tab.size()>=MIN && tab.size()<=MAX) {
			return true;
		}
		else
			return false;
	}
	
}