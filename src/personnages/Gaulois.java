package personnages;

import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans lamâchoire de " + romain.getNom());
		Equipement[] newTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; newTrophees != null && i < newTrophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = newTrophees[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}
	
	public void faireUneDonnation(Musee musee) {
		String text="Je donne au musee tous mes trophees :";
		for (int i=0;i<nbTrophees;i++) {
			text+="\n- "+trophees[i];
			musee.donnerTrophees(this, trophees[i]);
			trophees[i]=null;
		}
		nbTrophees=0;
		parler(text);
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.parler("Bonjour !");
		asterix.boirePotion(10);
		Romain romain = new Romain("Romain", 8);
		asterix.frapper(romain);
	}
}
