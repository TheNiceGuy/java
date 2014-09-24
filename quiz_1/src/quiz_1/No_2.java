package quiz_1;

import javax.swing.JOptionPane;
import java.text.NumberFormat; 

public class No_2 {
	public static void main(String[] args) {
		final double VMIN = 10000;
		final double VMAX = 50000;
		final double CMIN = 0.10;
		final double CMIL = 0.25;
		final double CMAX = 0.30;
		final double DMIN =  500;
		final double DMIL = 1500;
		final double DMAX = 2000;
		final double TRANCHE = 10000;
		
		String strNom;
		String strNumero;
		double dCommission;
		double dVente;
		double dDeplacement;
		double dPrime;
		double dSalaire;
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		//ramasser les données
		strNom    = JOptionPane.showInputDialog("Nom du vendeur:");
		strNumero = JOptionPane.showInputDialog("Numéro du vendeur:");
		dVente    = Double.parseDouble(JOptionPane.showInputDialog("Ventes mensuelles:"));
		
		//calculer son salaire
		if(dVente<=VMIN) {
			dDeplacement = DMIN;
			dCommission  = (dVente*CMIN);
			dPrime       = 0;
		}
		else if(dVente<=VMAX) {
			dDeplacement = DMIL;
			dCommission  = (dVente*CMIL);
			dPrime       = 0;
		}
		else {
			dDeplacement = DMAX;
			dCommission  = (dVente*CMAX);
			dPrime       = (int)(dVente/TRANCHE);
		}
			
		//afficher le salaire
		JOptionPane.showMessageDialog(null, strNom+" (#"+strNumero+") a vendu pour "+argent.format(dVente)
											+". Il a eu une commission de "+argent.format(dCommission)
											+". Ces frais de déplacement monte à "+argent.format(dDeplacement)
											+" et ");
		
		
		System.exit(0);
	}
}
