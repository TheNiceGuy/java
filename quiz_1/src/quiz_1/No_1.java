package quiz_1;

import javax.swing.JOptionPane;
import java.text.NumberFormat; 

public class No_1 {
	public static void main(String[] args) {
		final double TAUXMIN    = 1.50;
		final double TAUXMAX    = 2.00;
		final double FRAISINTER = 2.00;
		final int MINUTEMIN = 20;
		
		String strNom;
		String strMois;
		int iMinute;
		int iInter;
		double dCout;
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		//ramasser les données
		strNom  = JOptionPane.showInputDialog("Nom du client: ");
		strMois = JOptionPane.showInputDialog("Mois actuel: ");
		iMinute = Integer.parseInt(JOptionPane.showInputDialog("Nombre de minutes: "));
		iInter  = Integer.parseInt(JOptionPane.showInputDialog("Nombre de d'appels interurbains: "));
		
		//calculer le cout pour les minutes
		if(iMinute > MINUTEMIN)
			dCout = (MINUTEMIN*TAUXMIN)+((iMinute-20)*TAUXMAX);
		else
			dCout = (iMinute*TAUXMIN);
		
		//ajouter les appels interurbains
		dCout += (FRAISINTER*iInter);
		
		//afficher le résultat
		JOptionPane.showMessageDialog(null, "Pour le mois de "+strMois+", les frais mensuels de "
												+strNom+" s'élèvent à "+argent.format(dCout)+".");
		System.exit(0);
	}
}
