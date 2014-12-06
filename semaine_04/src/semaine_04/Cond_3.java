package semaine_04;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Cond_3 {
	public static void main(String[] args) {
		final double TARIF[] = {0.05, 0.04, 0.03};
		final double BROCHER =  0.02;
		final double TROUER  =  0.03;
		final double MEMBRE  =  5.00;
		final double DELAI   = 10.00;
		
		double dPrixFeuille;
		double dPrix;
		int iFeuille;
		int iCopie;
		int i;
		
		//brocher, trouer, membre et délai
		Boolean bChoix[]  = new Boolean[4];
		String strChoix[] = new String[4];
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		//ramasser les données
		iFeuille = Integer.parseInt(JOptionPane.showInputDialog("Nombre de feuilles:"));
		iCopie   = Integer.parseInt(JOptionPane.showInputDialog("Nombre de copies:"));
		strChoix[0] = JOptionPane.showInputDialog("Voulez-vous vos copies brochées?");
		strChoix[1] = JOptionPane.showInputDialog("Voulez-vous vos copies trouées?");
		strChoix[2] = JOptionPane.showInputDialog("Êtes-vous membre?");
		strChoix[3] = JOptionPane.showInputDialog("Voulez-vous la commande livré dans moins de 24 heures?");
		
		//convertir les réponse en Bool
		for(i=0; i<4; i++) {
			switch(strChoix[i].charAt(0)) {
				case 'o':
				case 'O':
					bChoix[i] = true;  break;
				case 'n':
				case 'N':
					bChoix[i] = false; break;
			}
		}
		
		//nombre de feuille total
		iFeuille *= iCopie;
		
		//calculer le prix des feuilles
		if(iFeuille<500)
			dPrix = dPrixFeuille = iFeuille*TARIF[0];
		else if(iFeuille<1000)
			dPrix = dPrixFeuille = iFeuille*TARIF[1];
		else
			dPrix = dPrixFeuille = iFeuille*TARIF[2];
		
		//calculer le prix des extras
		if(bChoix[0])
			dPrix += (iCopie*BROCHER);
		if(bChoix[1])
			dPrix += (iFeuille*TROUER);
		if(bChoix[2])
			dPrix -= MEMBRE;
		if(bChoix[3])
			dPrix += DELAI;
		
		//afficher le coût
		JOptionPane.showMessageDialog(null, 
				  "Feuilles: "+iFeuille+"\n"
				+ "Prix: "+argent.format(dPrixFeuille)+"\n"
				+ "Brochée: "+(bChoix[0]?"Oui, "+argent.format(iCopie*BROCHER):"Non")+"\n"
				+ "Trouée: "+(bChoix[1]?"Oui, "+argent.format(iFeuille*TROUER):"Non")+"\n"
				+ "Membre: "+(bChoix[2]?"Oui, "+argent.format(-MEMBRE):"Non")+"\n"
				+ "Express: "+(bChoix[3]?"Oui, "+argent.format(DELAI):"Non")+"\n"
				+ "Coût total:"+argent.format(dPrix)+"\n");
		
		System.exit(0);
	}
}
