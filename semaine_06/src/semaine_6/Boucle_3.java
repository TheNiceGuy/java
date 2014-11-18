package semaine_6;

import javax.swing.JOptionPane;
import semaine_6.Jeu;

public class Boucle_3 {
	public static void main(String[] args) {
		loop();
		
		System.exit(0);
	}
	
	private static void loop() {
		String menu[] = {"Quitter", "Statistiques", "Personnalisée", "Supérieur", "Prédéfini"};
		int choix;
		int quit;
		
		Jeu jeu = new Jeu();
		
		quit = -1;
		do {
			choix = JOptionPane.showOptionDialog(
					null, "Quelle action voulez-vous faire?", "Banque",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					menu, menu[0]);
			
			switch(choix) {
			case 0: quit = jeu.getGame(); break;
			case 1: jeu.stats();          break;
			case 2: jeu.perso();          break;
			case 3: jeu.superieur();      break;
			case 4: jeu.predefini();      break;
			}
		} while(quit == -1);
		
		JOptionPane.showMessageDialog(null, "Vous avez faites "+quit+" "+(quit>1?"parties":"partie")+".");
	}
}
