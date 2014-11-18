// Calcule le profit

package semaine_1;

import javax.swing.JOptionPane;

public class No6 {
	public static void main(String[] args) {
		String strBike;
		String strSkate;
		int iBike;
		int iSkate;
		
		strBike  = JOptionPane.showInputDialog("Nombre de bike: \n");
		strSkate = JOptionPane.showInputDialog("Nombre de skate: \n");

		iBike  = Integer.parseInt(strBike);
		iSkate = Integer.parseInt(strSkate);
		
		JOptionPane.showMessageDialog(null, 
				  "Prix initial: "+((iBike*100)+(iSkate*80))+"$\n"
				+ "Prix revente: "+((iBike*140)+(iSkate*100))+"$\n"
				+ "Profit: "+(((iBike*140)+(iSkate*100))-((iBike*100)+(iSkate*80)))+"$\n");
		
		System.exit(0);
	}
}
