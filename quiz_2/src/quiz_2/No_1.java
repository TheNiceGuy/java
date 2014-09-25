package quiz_2;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class No_1 {
	public static void main(String[] args) {
		final double PBAIN  = 20;
		final double PTONTE = 25;
		final double PCOUPE = 30;
		
		String strNom;
		String strService;
		
		strNom     = JOptionPane.showInputDialog("Nom de l'animal:");
		strService = JOptionPane.showInputDialog("Services [B] [T] [G]:");
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		switch(strService.charAt(0)) {
		case 'b':
		case 'B':
			JOptionPane.showMessageDialog(null, strNom+" a reçu un bain au montant de "+argent.format(PBAIN)); break;
		case 't':
		case 'T':
			JOptionPane.showMessageDialog(null, strNom+" a eu une tonte au montant de "+argent.format(PTONTE)); break;
		case 'g':
		case 'G':
			JOptionPane.showMessageDialog(null, strNom+" a eu une coupe au montant de "+argent.format(PCOUPE)); break;
		default:
			JOptionPane.showMessageDialog(null, "Mauvais choix");
		}
	}
}