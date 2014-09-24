package semaine_2;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Enchainement_1 {
	public static void main(String[] args) {
		final double COUT_PUB = 10;
		final double COUT_ENTRETIENT = 2;
		final double PROFIT = 15;
		final double TAXE_FIX = 2;
		final double TAXE_TPS = 5;
		final double TAXE_TVQ = 9.5;
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		String strCout;
		double dCout;
		double dPourcentage;
		
		strCout = JOptionPane.showInputDialog("Entrez le coût de base du billet:");
		dCout = Double.parseDouble(strCout);
		
		dPourcentage = COUT_PUB+COUT_ENTRETIENT+PROFIT;
		dCout *= dPourcentage/100+1;
		dCout += TAXE_FIX;
		dCout *= TAXE_TPS/100+1;
		dCout *= TAXE_TVQ/100+1;
		
		JOptionPane.showMessageDialog(null, argent.format(dCout));
		
		System.exit(0);
	}
}
