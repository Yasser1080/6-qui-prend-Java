package Appli;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Jeu.Jeu;
import Jeu.Joueur;
import Jeu.Paquet;
import Jeu.Série;

import static Jeu.util.Console.clearScreen;
import static Jeu.util.Console.pause;

public class Application {
	public static void main(String[] args) {
		Jeu Jeu = new Jeu();
		Jeu.lire();
		if (Jeu.verif_nbjoueur(Jeu.getTab_j()) == true) {
			System.out.print("Les " + Jeu.getTab_j().size() + " joueurs sont");
			int i = 0;
			for (Joueur Joueur1 : Jeu.getTab_j()) {
				System.out.print(" " + Joueur1.getPrénom());
				if (i == Jeu.getTab_j().size()-2) {
					System.out.print(" et");
					++i;
				}
				else if(i < Jeu.getTab_j().size()-2) {
					System.out.print(",");
					++i;
				}
				//affichage de la premiere ligne (qui sont les joueurs)
			}	
			System.out.println(". Merci de jouer à 6 qui prend ! ");

			Paquet Paquet = new Paquet();
			Paquet.melanger();
			Paquet.ajouter(Jeu.getTab_j().get(0));
			Jeu.distribuer(Paquet);
			Jeu.creer_et_distrib_série(Paquet);
			for (int k=0; k<Jeu.getTab_j().size();++k) {//affichage du joueur à qui c'est le tour de jouer
				System.out.println("A " + Jeu.getTab_j().get(k).getPrénom() + " de jouer."); 
				pause();
				for (Série Serie : Jeu.getTab_série()) { // affichage des séries
					System.out.println(Serie);
				}
				
				System.out.print("Vos cartes : ");
				System.out.println(Jeu.getTab_j().get(k)); //affichage des cartes du joueur qui doit jouer
				Scanner carte_a_jouer = new Scanner(System.in); //entrée clavier de la carte que le joueur veut poser
				System.out.println("Choisissez votre carte : ");

				clearScreen();
			}
		}
		else if(Jeu.verif_nbjoueur(Jeu.getTab_j()) == false){ //vérification du nombre de joueurs
			System.out.println("Problème de nombre de joueurs, il y a trop ou il n'y a pas assez de joueurs");
		}
	}
}
