package semaine_02;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Enchainement_2 {
	public static void main(String[] args) {
		final double MONTANT_FIXE = 900;
		final double MONTANT_PC   = 50;
		final double COMMISSION   = 0.02; // 2% de commission
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		String strMois;
		String strNom;
		String strNbrVente;
		String strMontantVente;
		
		int iMois;
		int iNbrVente;
		double dMontantVente;
		double dSalaire;
		
		strMois         = JOptionPane.showInputDialog("Mois:");
		strNom          = JOptionPane.showInputDialog("Prénom et Nom:");
		strNbrVente     = JOptionPane.showInputDialog("Nombre de vente:");
		strMontantVente = JOptionPane.showInputDialog("Montant des ventes:");
		
		iMois         = Integer.parseInt(strMois);
		iNbrVente     = Integer.parseInt(strNbrVente);
		dMontantVente = Double.parseDouble(strMontantVente);
		
		dSalaire = MONTANT_FIXE+(iNbrVente*MONTANT_PC)+(dMontantVente*COMMISSION);
		
		JOptionPane.showMessageDialog(null, "Mois/Nom/Salaire:\n" 
		                                   +iMois+", "+strNom+", "+argent.format(dSalaire));
		
		System.exit(0);
	}
}
