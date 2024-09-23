package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert invForcePositive();
	}


	public String getNom() {
		return nom;
	}


	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force>=0;
		int ancienneForce=force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert ancienneForce>force;
	}
	
	public boolean invForcePositive() {
		return force>=0;
	}
	
	public static void main(String[] args) {
		Romain romain = new Romain("Minus",6);
		romain.parler("Bonjour !");
		romain.recevoirCoup(5);
		romain.recevoirCoup(5);
	}
	
}
