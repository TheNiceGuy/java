// Calcule des depenses

package semaine_1;

import javax.swing.JOptionPane;

public class No8 {
	public static void main(String[] args) {
		String strArticle[] = {"d'hambourgeois", "de Pepsi", "de crème glacée"};
		String strEconomie;
		String strPrixArticle[] = new String[3];
		String strNombreArticle[] = new String[3];
		double dEconomie;
		double dDepense;
		double dPrixArticle[] = new double[3];
		int iNombreArticle[] = new int[3];
		int i;
		
		strEconomie = JOptionPane.showInputDialog("Économie: \n");
		dEconomie = Double.parseDouble(strEconomie);
		dDepense = 0;
		for(i=0; i<3; i++) {
			strPrixArticle[i]   = JOptionPane.showInputDialog("Prix "+strArticle[i]+": \n");
			strNombreArticle[i] = JOptionPane.showInputDialog("Nombre "+strArticle[i]+": \n");
			
			dPrixArticle[i]   = Double.parseDouble(strPrixArticle[i]);
			iNombreArticle[i] = Integer.parseInt(strNombreArticle[i]);
			
			dDepense = dDepense+(dPrixArticle[i]*iNombreArticle[i]);
		}
		
		JOptionPane.showMessageDialog(null, 
				  "Économie: "+dEconomie+"$\n"
				+ "Dépense:"+dDepense+"$\n"
				+ "Reste:"+(dEconomie-dDepense)+"$\n");
		
		System.exit(0);
	}
}
