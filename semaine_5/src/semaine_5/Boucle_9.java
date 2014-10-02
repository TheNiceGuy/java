package semaine_5;

import javax.swing.JOptionPane;

public class Boucle_9 {
	final static private int CHANCE = 5;
	final static private int PARTIE = 3;
	final static private int RANGE[] = {0, 10};
	
	public static void main(String[] args) {
		//entrez dans la boucle principale
		loop();
		
		System.exit(0);
	}
	
	private static void loop() {
		final String menu[] = {"Quitter", "Soustraction", "Addition"};
		
		int choix;
		boolean quit;
		
		//boucler tant et aussi longtemps que le joueur n'a pas quitté
		quit = false;
		while(!quit) {
			choix = JOptionPane.showOptionDialog(
						null, "Que voulez vou faire?", "Opération arithmétique",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, 
						menu, menu[2]);
			
			//jouer au jeu selon le mode choisie
			switch(choix) {
			case 0: quit = true; break;
			case 1: jeu(mode.SOUSTRACTION); break;
			case 2: jeu(mode.ADDITION); break;
			}
		}
	}
	
	private static void jeu(mode type) {
		int i;
		int erreur;
		int faute;
		int resultat;
		
		erreur = 0;
		faute  = 0;
		for(i=0; i<PARTIE; i++) {
			//jouer une partie et récupérer le nombre d'erreur
			resultat = partie(type);
			faute += resultat;
			if(resultat == CHANCE)
				 erreur++;
		}
		JOptionPane.showMessageDialog(null,   "Vous avez "+(PARTIE-erreur)+" "+(PARTIE-erreur>1?"bonnes réponses":"bonne réponse")
											+ " ainsi que "+erreur+" "+(erreur>1?"mauvaises réponses":"mauvaise réponse")
											+ " parmi les "+PARTIE+" expressions générées. Vous avez eu "+faute+" "
											+ (faute>1?"fautes":"faute")+" en tout.");
	}
	
	private static int partie(mode type) {
		int a, b;
		int i;
		int rep[] = new int[2];
		int faute;
		
		//générer des nombre au hasard
		a = generate();
		b = generate();
		faute = 0;
		
		//calculer la réponse attendu
		switch(type) {
		case     ADDITION: rep[0] = a+b; break;
		case SOUSTRACTION: rep[0] = a-b; break;
		}
		
		//demander la réponse, le joueur à plusieurs chance
		for(i = 0; i<CHANCE; i++) {
			rep[1] = Integer.parseInt(JOptionPane.showInputDialog(a+(type==mode.ADDITION?"+":"-")+b+"="));
			//quitter la boucle si la bonne réponse est entré		
			if(rep[0] == rep[1]) {
				JOptionPane.showMessageDialog(null, "Félicitations, vous avez la bonne réponse à l'expression arithmétique.");
				i = CHANCE;
			}
			//augmenter le nombre de faute si une mauvaise réponse est entré
			else {
				JOptionPane.showMessageDialog(null, "Désolé, vous n'avez pas la bonne réponse");
				faute++;
			}
		}
		
		//retourner le nombre de faute durant la partie
		return faute;
	}
	
	private static int generate() {
		return RANGE[0]+(int)(Math.random()*RANGE[1]);
	}
	
	private enum mode {
		ADDITION,
		SOUSTRACTION
	}
}
