package semaine_4;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Cond_2 {
	public static void main(String[] args) {
		final double PRIME[] = {1, 0.06, 0.04, 0.02};
		
		String strNom;
		int iNotation;
		double dSalaire;
		double dBonus = 0;
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		//ramasser les données
		strNom    = JOptionPane.showInputDialog("Nom de l'employé:");
		dSalaire  = Double.parseDouble(JOptionPane.showInputDialog("Salaire:"));
		iNotation = Integer.parseInt(JOptionPane.showInputDialog("Notation:"));
		
		//déterminer la prime
		if(iNotation < 4)
			dBonus = dSalaire*PRIME[iNotation];
		
		//afficher les résultats
		JOptionPane.showMessageDialog(null,
				  "Nom de l'employé: "+strNom+"\n"
				+ "Salaire:          "+argent.format(dSalaire)+"\n"
				+ "Notation:         "+iNotation+"\n"
				+ "Bonus:            "+argent.format(dBonus));
		
		System.exit(0);
	}
}
