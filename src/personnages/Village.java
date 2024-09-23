package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois new_hab){
		if (nbVillageois<villageois.length) {
			villageois[nbVillageois]=new_hab;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(int num) {
		if (num<villageois.length) {
			return villageois[num];
		}
		else {
			return null;
		}
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+chef+" vivent les légendaires gaulois :");
		for (int i=0;i<nbVillageois;i++) {
			System.out.println("- "+villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village= new Village("Village des Irréductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30);
		//On a une erreur car villageois est de taille 30 et commence à l'indice 0 donc 30 est hors du tableau
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.setChef(abraracourcix);
		Gaulois asterix=new Gaulois("Asterix",8);
		village.ajouterHabitant(asterix);
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		//null est afficher car il n'y a pas d'objet Gaulois à l'indice 1 car asterix et à l'indice 0
		Gaulois obelix = new Gaulois("Obelix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}	
}
