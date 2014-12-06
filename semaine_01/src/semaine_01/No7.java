// Calcule un pourcentage-25

package semaine_01;

import javax.swing.JOptionPane;

public class No7 {
	public static void main(String[] args) {
		String strNote[] = new String[2];
		double iNote[] = new double[2];
		double pourcentage;

		strNote[0] = JOptionPane.showInputDialog("Note acquis: \n");
		strNote[1] = JOptionPane.showInputDialog("Note maximum: \n");

		iNote[0] = Double.parseDouble(strNote[0]);
		iNote[1] = Double.parseDouble(strNote[1]);

		pourcentage = (iNote[0]*100/iNote[1])-25;

		JOptionPane.showMessageDialog(null, "Note finale: "+pourcentage+"%\n");
		System.exit(0);
	}
}
