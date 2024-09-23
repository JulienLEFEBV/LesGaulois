package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
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
		assert force >= 0;
		int ancienneForce = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert ancienneForce > force;
	}

	private boolean invForcePositive() {
		return force >= 0;
	}

	public void sEquiper(Equipement equip) {
		switch(nbEquipements){
			case 2: System.out.println("Le soldat "+nom+" est déjà bien protégé !");
					break;
			case 1: if (equipements[0]==equip) {
						System.out.println("Le soldat "+nom+" possède déjà un "+equipements[0]+".");
					}
					else {
						ajouterEquipement(equip);
					}
					break;
			default: ajouterEquipement(equip);
		}
	}
	
	private void ajouterEquipement(Equipement equip) {
		System.out.println("Le soldat "+nom+" s’équipe avec un "+equip+".");
		equipements[nbEquipements]=equip;
		nbEquipements++;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.parler("Bonjour !");
		minus.recevoirCoup(5);
		minus.recevoirCoup(5);
		for (Equipement equip : Equipement.values()) {
			System.out.println(equip);
		}
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

}
