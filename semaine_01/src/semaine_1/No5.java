// Calcule le prix total

package semaine_1;

import javax.swing.JOptionPane;

public class No5 {
	public static void main(String[] args) {
		String strBike;
		String strSkate;
		int iBike;
		int iSkate;
		
		strBike  = JOptionPane.showInputDialog("Nombre de bike: \n");
		strSkate = JOptionPane.showInputDialog("Nombre de skate: \n");

		iBike  = Integer.parseInt(strBike);
		iSkate = Integer.parseInt(strSkate);
		
		JOptionPane.showMessageDialog(null, "Prix total: "+((iBike*100)+(iSkate*80))+"$\n");
		
		System.exit(0);
	}
}
