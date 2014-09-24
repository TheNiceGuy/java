package semaine_5;

import javax.swing.JOptionPane;

public class Boucle_4 {
	public static void main(String[] args) {
		int iNbr1;
		int iNbr2;
		int iDiviseur;
		int i;
		
		iNbr1 = Integer.parseInt(JOptionPane.showInputDialog("Nombre #1:"));
		iNbr2 = Integer.parseInt(JOptionPane.showInputDialog("Nombre #2:"));
		
		for(i = 1, iDiviseur = 0; i<=iNbr1 && i<=iNbr2; i++) {
			if(iNbr1%i == 0 && iNbr2%i == 0) {
				iDiviseur = i;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Le plus grand diviseur commun de "+iNbr1+" et "+iNbr2+" est "+iDiviseur+".");
	}
}
