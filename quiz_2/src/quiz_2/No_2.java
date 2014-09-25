package quiz_2;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class No_2 {
	public static void main(String[] args) {
		final double PRIX[] = {20, 25, 30};
		
		String strNom;
		String strService[] = new String[3];
		boolean bChoix[] = new boolean[3];
		double dPrix;
		int i;
		
		strNom     = JOptionPane.showInputDialog("Nom de l'animal:");
		strService[0] = JOptionPane.showInputDialog("Bain?");
		strService[1] = JOptionPane.showInputDialog("Tonte?");
		strService[2] = JOptionPane.showInputDialog("Coupe?");
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		dPrix = 0;
		for(i = 0; i<3; i++) {
			switch(strService[i].charAt(0)) {
			case 'o':
			case 'O':
				bChoix[i] = true;
				dPrix += PRIX[i]; break;
			case 'n':
			case 'N':
				bChoix[i] = false; break;
			default:
				JOptionPane.showMessageDialog(null, "Mauvais choix");
				System.exit(0);
			}
		}
		
		JOptionPane.showMessageDialog(null, strNom+" a reçu les services suivant:\n"
				+ (bChoix[0]?"[x]":"[ ]")+" Bain: "+argent.format((bChoix[0]?PRIX[0]:0))+"\n"
				+ (bChoix[1]?"[x]":"[ ]")+" Tonte: "+argent.format((bChoix[1]?PRIX[1]:0))+"\n"
				+ (bChoix[2]?"[x]":"[ ]")+" Coupe: "+argent.format((bChoix[2]?PRIX[2]:0))+"\n"
				+ "Prix total: "+argent.format(dPrix));
	}
}