package semaine_03;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Si4 {
	public static void main(String[] args) {
		final double AUGMENTATION[] = {1.05,1.08,1.015,1.040};

		int iNbrAccident = -1;
		double dPrime; 
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		//ramasser les données
		while(iNbrAccident<0)
			iNbrAccident = Integer.parseInt(JOptionPane.showInputDialog("Nombre d'accident:"));
			if(iNbrAccident<0)
				JOptionPane.showMessageDialog(null, "Veuillez entrez un bon nombre!");
		dPrime = Double.parseDouble(JOptionPane.showInputDialog("Prime actuelle:"));

		//afficher la conclusion
		if(iNbrAccident < 4) {
			dPrime *= AUGMENTATION[iNbrAccident];
			JOptionPane.showMessageDialog(null, "Nouvelle prime: "+argent.format(dPrime));
		} else
			JOptionPane.showMessageDialog(null, "Vous n'avez plus d'assurance");
		
		System.exit(0);
	}
}
