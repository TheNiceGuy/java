package semaine_2;

import java.text.NumberFormat;

import javax.swing.JOptionPane;

public class Enchainement_5 {
	public static void main(String[] args) {
		final int NBR_GALLON  = 1000;
		final int PRIX_GALLON = 2;
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		String strCoutFoyer;
		String strCoutBonbonne;
		String strFrais;
		
		double dCoutFoyer;
		double dCoutBonbonne;
		double dFrais;
		double dRemplissage;
		double dTotal;
		
		strCoutFoyer    = JOptionPane.showInputDialog("Coût foyer: ");
		strCoutBonbonne = JOptionPane.showInputDialog("Coût bonbonne: ");
		strFrais        = JOptionPane.showInputDialog("Frais d'installation: ");
		
		dCoutFoyer    = Double.parseDouble(strCoutFoyer);
		dCoutBonbonne = Double.parseDouble(strCoutBonbonne);
		dFrais        = Double.parseDouble(strFrais);
		
		dRemplissage = NBR_GALLON*PRIX_GALLON;
		dTotal = dCoutFoyer+dCoutBonbonne+dFrais+dRemplissage;
		
		JOptionPane.showMessageDialog(null, "Coût du foyer: "+argent.format(dCoutFoyer)+"\n"+
		                                    "Coût de la bonbonne: "+argent.format(dCoutBonbonne)+"\n"+
		                                    "Frais d'installation: "+argent.format(dFrais)+"\n"+
		                                    "Remplissage: "+argent.format(dRemplissage)+"\n"+
		                                    "Coût total du projet: "+argent.format(dTotal));
		
		System.exit(0);
	}
}