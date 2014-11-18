package semaine_3;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Si5 {
	public static void main(String[] args) {
		final int PRIXM50 = 15;
		final int PRIXP50 = 12;
		
		int iNbPersonne;
		double dPrix;
		double dCout;
		double dVente;
		double dProfit;
		String strConclusion;
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		//ramasser les données
		iNbPersonne = Integer.parseInt(JOptionPane.showInputDialog("Nombre de personne: "));
		dPrix       = Double.parseDouble(JOptionPane.showInputDialog("Prix d'un billet: "));
		
		//déterminer le coût du traiteur
		if(iNbPersonne<=50)
			dCout=iNbPersonne*PRIXM50 ;
		else
			dCout=50*PRIXM50 + (iNbPersonne-50)*PRIXP50;
		dVente = dPrix*iNbPersonne;
		dProfit = dVente-dCout;
		
		//déterminer s'il y a un profit ou une perte
		if(dProfit>=0)
			strConclusion = "Le comité a donc réalisé un profit de "+argent.format(dProfit)
					      + " pour cette belle activité. Félicitations.";
		else
			strConclusion = "Le comité a donc réalisé une perte de "+argent.format(-dProfit)
						  + " pour le souper. On se reprend.";
		
		//afficher la conclusion
		JOptionPane.showMessageDialog(null, 
				  "Concernant le souper de la rentré pour les étudiants d'informatique\n"
				+ "Merci pour les "+iNbPersonne+" personnes qui ont participé au souper.\n"
				+ "Le prix du billet était de "+argent.format(dPrix)+".\n"
				+ "Le coût pour le traiteur était de "+argent.format(dCout)+".\n"
				+ "Le total des ventes pour le souper a été de "+argent.format(dVente)+".\n"
				+ strConclusion);

		System.exit(0);
	}
}
