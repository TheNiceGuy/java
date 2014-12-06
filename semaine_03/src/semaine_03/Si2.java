package semaine_03;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Si2 {
	public static void main(String[] args) {
		final int DEDUCTION  = 500;
		final int LIMSALAIRE = 65000;
		final double PBAS    = 0.15;
		final double PHAUT   = 0.10;
		
		String strNom;
		int iSalaire;
		int iNbrPersonne;
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		//ramasser les données
		strNom       = JOptionPane.showInputDialog("Nom:");
		iSalaire     = Integer.parseInt(JOptionPane.showInputDialog("Salaire:"));
		iNbrPersonne = Integer.parseInt(JOptionPane.showInputDialog("Nombre de personne en charge:"));
		
		//calculer le revenue
		if(iSalaire <= LIMSALAIRE) {
			iSalaire *= PBAS;
			iSalaire -= (DEDUCTION*iNbrPersonne);
		} else {
			iSalaire *= PHAUT;
			iSalaire -= (DEDUCTION*iNbrPersonne);
		}
		
		//afficher le résultat
		JOptionPane.showMessageDialog(null, strNom+" doit payer "+argent.format(iSalaire));
		
		System.exit(0);
	}
}
