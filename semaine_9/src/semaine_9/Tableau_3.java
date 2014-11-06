package semaine_9;

import java.text.NumberFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/* 
 * Fichier     : Tableau_3.java
 * Project     : Laboratoires sur les tableaux
 * Objectifs   : Compilation de votes pour une municipalité
 * Logiciel    : Eclipse Mars, OpenJDK 1.8
 * Plateforme  : Archlinux, Linux 3.18.0-rc2+ x86_64 GNU/Linux
 * Auteur      : Gabriel-Andrew Pollo Guilbert
 * Création    : 2 Novembre 2014
 */

public class Tableau_3 {
	final static int ERR    = -1; // constante du code d'erreur si l'utilisateur annule
	final static int BUREAU =  5; // constante du nombre de bureau
	final static String nom[] = {"Monique Lagacé", "Myriam Laposte",  "Julien Lafrenière", 
	                             "Alex Beaubien",  "Jules Laliberté", "Diana Montplaisir"};
	
	public static void main(String[] args) {
		final String menu[] = {"Quitter", "Nouvelle compilation"};
		int choix;
		boolean quit;
		
		//boucler tant et aussi longtemps que l'utilisateur n'a pas quitté
		quit = false;
		while(!quit) {
			choix = JOptionPane.showOptionDialog(
					null, "Quelle action voulez-vous faire?", "Vote",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					menu, menu[0]);
			
			switch(choix) {
			case 0:  quit = true; break;
			default: compilation();
			}
		}
		
		// quitter le programme
		quit(0);
	}
	
	private static void compilation()  {
		int    resul[] = new int[nom.length];
		double pourc[] = new double[nom.length];
		
		NumberFormat percent = NumberFormat.getPercentInstance();
		
		String resultat ;
		int somme;
		int vote;
		int gagnant = 0;
		int i;
		int j;
		
		for(i = somme = 0; i < BUREAU; i++)
			for(j = 0; j < nom.length; j++) {
				vote = getVote(i, j);
				resul[j] += vote;
				somme    += vote;
				if(resul[j] == ERR)
					quit(1);
			}
		
		resultat = "Résultat des élections municipales.\n\n";
		for(i = 0; i < nom.length; i++) {
			if(resul[i] > resul[gagnant]) 
				gagnant = i;
			
			pourc[i] = (double)resul[i]/somme;

			resultat += (nom[i]+":     \t"+resul[i]+" "+(resul[i]>1?"votes":"vote")
			         +" ("+percent.format(pourc[i])+")\n");
		}
		resultat += ("\nLe gagnant des élections municipales est "
		            +nom[gagnant]+" avec "+resul[gagnant]+" "
		            +(resul[gagnant]>1?"votes":"vote")+".");
		JOptionPane.showMessageDialog(null, new JTextArea(resultat));
	}
	
	/*
	 * Cette fonction va demandé un nombre de votes.
	 * Elle s'assure que le chiffre est valide.
	 */
	private static int getVote(int bureau, int index) {
		String choix = ""; // contient le texte entré par l'utilisateur
		int vote     = 0;  // contient la note entré par l'utilisateur

		while(choix != null) {
			// demander un nombre à l'utilisateur
			choix = JOptionPane.showInputDialog("Concernant le bureau de scrutin numéro "+(bureau+1)+", "+
			                                    "le nombre de votes pour "+nom[index]+" est:");
			
			// quitter si annuler est cliqué
			if(choix == null)
				vote = ERR;
			else {
				try {
					vote = Integer.parseInt(choix);
					choix = null;
					
					// erreur si le nombre est négatif
					if(vote < 0) 
						choix = "";
				// erreur si ce n'est pas un nombre
				} catch(NumberFormatException except) {}
			}
		}
		
		return vote;
	}
	
	/*
	 * Si le programme doit se terminer en renvoyant 
	 * une erreur et sans qu'il plante, cette fonction
	 * est utilisé.
	 */
	private static void quit(int code) {
		System.exit(code);
	}
}