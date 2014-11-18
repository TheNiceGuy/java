// Calcule le salaire de base, supplémentaire et total

package semaine_1;

import javax.swing.JOptionPane;

public class No2 {
	public static void main(String[] args) {
		String strSalaire;
		String strHeure;
		String strHeureSup;
		String strTaux;
		double dSalaire;
		double dHeure;
		double dHeureSup;
		double dTaux;
		
		strSalaire  = JOptionPane.showInputDialog("Salaire: \n");
		strHeure    = JOptionPane.showInputDialog("Nombre d'heures: \n");
		strHeureSup = JOptionPane.showInputDialog("Nombre d'heures supplémentaires: \n");
		strTaux     = JOptionPane.showInputDialog("Taux supplémentaire: \n");
		
		dSalaire  = Double.parseDouble(strSalaire);
		dHeure    = Double.parseDouble(strHeure);
		dHeureSup = Double.parseDouble(strHeureSup);
		dTaux     = Double.parseDouble(strTaux);
		
		JOptionPane.showMessageDialog(null, 
				  "Salaire de base: "+(dSalaire*dHeure)+"\n"
				+ "Salaire supplémentaire: "+(dTaux*dSalaire*dHeureSup)+"\n"
				+ "Salaire total: "+((dSalaire*dHeure)+(dTaux*dSalaire*dHeureSup))+"\n");
		
		System.exit(0);
	}
}
