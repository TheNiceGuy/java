package semaine_2;

import javax.swing.JOptionPane;

public class Enchainement_4 {
	public static void main(String[] args) {
		String strMontant;
		double dMontant;
		int iNbr100;
		
		strMontant = JOptionPane.showInputDialog("Entrez le montant entré: ");
		dMontant = Double.parseDouble(strMontant);
		
		iNbr100 = (int)dMontant/100;
		
		System.out.print(iNbr100);
		
		System.exit(0);
	}
}
