// Calcule la moyenne de 5 notes

package semaine_01;

import javax.swing.JOptionPane;

public class No1 {
	public static void main(String[] args) {
		String strNote[] = new String[5];
		int iNote[] = new int[5];
		int i;
		double moyenne;

		moyenne = 0;

		for(i=0; i<5; i++) {
			strNote[i] = JOptionPane.showInputDialog("Note "+(i+1)+": \n");
			iNote[i] = Integer.parseInt(strNote[i]);

			moyenne = moyenne+iNote[i];
		}
		moyenne = moyenne/5;

		JOptionPane.showMessageDialog(null, "Moyenne: "+moyenne+"%.\n");

		System.exit(0);
	}
}
