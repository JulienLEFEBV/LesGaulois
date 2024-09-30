package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees= new Trophee[200];
	private int nbTrophee=0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee]= new Trophee(gaulois,equipement);
		nbTrophee++;
	}
	
	public String extraireInstructionsOCaml() {
		String res="let musee = [";
		for(int i=0;i<nbTrophee;i++) {
			res+="\n	\""+trophees[i].donnerNom()+"\", \""+trophees[i].getEquipement()+"\"";
			if (i<nbTrophee-1) res+=";";
		}
		res+="\n]";
		return res;
	}
}
