// Calcule le salaire de base, supplémentaire et total

package semaine_1;

import javax.swing.JOptionPane;

public class No4 {
	public static void main(String[] args) {
		String strHeure;
		String strSalaire;
		String strQuille;
		String strExtra;
		double dHeure;
		double dSalaire;
		double dExtra;
		int iQuille;
		
		strHeure   = JOptionPane.showInputDialog("Nombre d'heure: ");
		strSalaire = JOptionPane.showInputDialog("Salaire: ");		
		strQuille  = JOptionPane.showInputDialog("Nombre de quille: ");
		strExtra   = JOptionPane.showInputDialog("Extra par quille: ");
		
		dHeure   = Double.parseDouble(strHeure);
		dSalaire = Double.parseDouble(strSalaire);
		iQuille  = Integer.parseInt(strQuille);
		dExtra   = Double.parseDouble(strExtra);
		
		JOptionPane.showMessageDialog(null, 
				  "Salaire de base: "+(dHeure*dSalaire)+"$\n"
				+ "Montant en extra: "+(iQuille*dExtra)+"$\n"
				+ "Salaire total est de "+((iQuille*dExtra)+(dHeure*dSalaire))+"$\n");	
		
		System.exit(0);
	}
}
