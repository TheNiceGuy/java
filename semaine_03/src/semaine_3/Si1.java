package semaine_3;

import javax.swing.JOptionPane;

public class Si1 {
	public static void main(String[] args) {
		int iNbr1;
		int iNbr2;
		int iChoix;
		
		//ramasser les données
		iNbr1  = Integer.parseInt(JOptionPane.showInputDialog("Nombre 1:"));
		iNbr2  = Integer.parseInt(JOptionPane.showInputDialog("Nombre 2:"));
		iChoix = Integer.parseInt(JOptionPane.showInputDialog("Addition(1) ou Multiplication(2):"));
		
		//afficher le résultat
		switch(iChoix) {
			case 1:
				JOptionPane.showMessageDialog(null, iNbr1+" + "+iNbr2+" = "+(iNbr1+iNbr2)); break;
			case 2:
				JOptionPane.showMessageDialog(null, iNbr1+" * "+iNbr2+" = "+(iNbr1*iNbr2)); break;
			default:
				JOptionPane.showMessageDialog(null, "Choix invalide!");
		}

		System.exit(0);
	}
}
