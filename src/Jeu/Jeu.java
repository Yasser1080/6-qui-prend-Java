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
	private ArrayList<Série> tab_série = new ArrayList<Série>();
	
	public Jeu() {
		
	}
	
	public ArrayList<Joueur> getTab_j() {
		return tab_j;
	}

	public void setTab_j(ArrayList<Joueur> tab_j) {
		this.tab_j = tab_j;
	}

	public ArrayList<Série> getTab_série() {
		return tab_série;
	}

	public void setTab_série(ArrayList<Série> tab_série) {
		this.tab_série = tab_série;
	}

	public ArrayList<Joueur> lire() { // lit et prend les joueurs du fichier config.txt pour créer des objets Joueurs
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
	
	public void distribuer(Paquet p) { // distribue 10 cartes à chaque joueur à l'aide de la fonction ajouter
        for(Joueur j1 : tab_j) {
            p.ajouter(j1);
        }
    }
	
	public void creer_et_distrib_série(Paquet p) {// crée 4 séries et ajoute à chacune 1 carte du paquet
		for(int i = 0; i < 4; ++i) {
			Série s = new Série();
			tab_série.add(s);
			p.ajouter_série(s);
		}
	}
	
	public boolean a_carte(Carte c, Joueur j) { //teste si le joueur possède la carte entrée en argument
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
	
	public boolean verif_nbjoueur(ArrayList<Joueur> tab) { // vérifie que le nombre de joueurs est respecté
		if(tab.size()>=MIN && tab.size()<=MAX) {
			return true;
		}
		else
			return false;
	}
	
}