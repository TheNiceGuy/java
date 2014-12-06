// Calcule le nombre de rouleau de papier peint requis

package semaine_01;

import javax.swing.JOptionPane;
import java.lang.Math;

public class Test1 {
	public static void main(String[] args) {
		String strHauteur[] = new String[2];
		String strLargeur[] = new String[2];
		double dHauteur[] = new double[2];
		double dLargeur[] = new double[2];
		double dAire = 0.0;
		int iRouleau;
		int i;

		for(i=0; i<2; i++) {
			strHauteur[i] = JOptionPane.showInputDialog("Hauteur du mur "+(i+1)+" : \n");
			strLargeur[i] = JOptionPane.showInputDialog("Largeur du mur "+(i+1)+" : \n");

			dHauteur[i] = Double.parseDouble(strHauteur[i]);
			dLargeur[i] = Double.parseDouble(strLargeur[i]);

			dAire = dAire+(dHauteur[i]*dLargeur[i]);
		}

		iRouleau = (int)Math.ceil((2*dAire)/50);

		JOptionPane.showMessageDialog(null,
				 "Aire total: "+dAire+"pieds carrés\n"
				+"Nombre de rouleau: "+iRouleau+"\n");

		System.exit(0);
	}
}
