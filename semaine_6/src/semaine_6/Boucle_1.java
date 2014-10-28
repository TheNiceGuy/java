package semaine_6;

import javax.swing.JOptionPane;
import java.text.NumberFormat;
import semaine_6.Banque;

public class Boucle_1 {
	public static void main(String[] args) {
		final String menu[] = {"Quitter", "Solde", "Paiement", "Retrait", "Dépot"};
		int choix;
		boolean quit;
		
		Banque compte = new Banque(0);
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		//boucler tant et aussi longtemps que l'utilisateur n'a pas quitté
		quit = false;
		while(!quit) {
			choix = JOptionPane.showOptionDialog(
					null, "Quelle action voulez-vous faire?", "Banque",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					menu, menu[0]);
			
			switch(choix) {
			case 0: quit = true; break;
			case 1: JOptionPane.showMessageDialog(null, "Votre compte à "+argent.format(compte.getSolde())+"."); break;
			case 2: compte.paiement(); break;
			case 3: compte.retrait();  break;
			case 4: compte.depot();    break;
			}
		}
		
		System.exit(0);
	}
}
