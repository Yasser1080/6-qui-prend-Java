package Jeu;

public class Carte {
	private int num�ro_de_carte;
	private int tetes_de_boeuf;
	private static int numerocpt = 1;

	public Carte() {
		this.num�ro_de_carte = numerocpt++;
		this.tetes_de_boeuf = initialisation_tete_de_boeuf(this.num�ro_de_carte);
	}

	public int initialisation_tete_de_boeuf(int num�ro_de_carte) {// initialise la valeur des tetes de boeuf de chaque carte
		int val_tetes_de_boeuf = 0;

		if (num�ro_de_carte==55)
			val_tetes_de_boeuf = 7;

		else if (num�ro_de_carte%10 == 5)
			val_tetes_de_boeuf = 2;

		else if (num�ro_de_carte%10 == 0)
			val_tetes_de_boeuf = 3;

		else if (num�ro_de_carte%11 == 0)
			val_tetes_de_boeuf = 5;

		else
			val_tetes_de_boeuf = 1;

		return val_tetes_de_boeuf;
	}

	public int getTetes_de_boeuf() {
		return tetes_de_boeuf;
	}

	@Override
	public String toString() {
		if (tetes_de_boeuf != 1) {
			return num�ro_de_carte + " (" + tetes_de_boeuf+")";
		}
		else {
			return num�ro_de_carte+"";
		}
	}
}
