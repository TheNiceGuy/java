package semaine_9;

import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/* 
 * Fichier     : Tableau_2.java
 * Project     : Laboratoires sur les tableaux
 * Objectifs   : Histogramme des notes d'examen
 * Logiciel    : Eclipse Mars, OpenJDK 1.8
 * Plateforme  : Archlinux, Linux 3.18.0-rc2+ x86_64 GNU/Linux
 * Auteur      : Gabriel-Andrew Pollo Guilbert
 * Création    : 30 Octobre 2014
 */

public class Tableau_2 {
	final static int MAX  = 72;    // constante du maximum d'une note
	final static int MIN  = 0;     // constante du minimum d'une note
	final static int ERR  = MIN-1; // constante du code d'erreur si l'utilisateur annule

	public static void main(String[] args) {
		final String menu[] = {"Quitter", "Nouvelle Session"};
		int choix;
		boolean quit;
		
		//boucler tant et aussi longtemps que l'utilisateur n'a pas quitté
		quit = false;
		while(!quit) {
			choix = JOptionPane.showOptionDialog(
					null, "Quelle action voulez-vous faire?", "Note",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					menu, menu[0]);
			
			switch(choix) {
			case 0:  quit = true; break;
			default: session();
			}
		}
		
		// quitter le programme
		quit(0);
	}

	/*
	 * Cette fonction est utilisé lorsque l'utilisateur
	 * veut faire un histogramme sur les notes.
	 */
	private static void session() {
		final int NOTE = 20;  // constante du nombre de note à demander
		final char SYM = '*'; // constante contenant le symbole utilisé par l'histogramme 
		
		double note[] = new double[NOTE]; // tableau contenant les notes
		int classe[]  = new int[10];      // tableau contenant les classes de note
		
		NumberFormat percent = NumberFormat.getPercentInstance();
		
		String histogramme; // contient la chaîne de charactères contenant l'histogramme
		int min      = 0;   // contient l'index de la note minimal
		int max      = 0;   // contient l'index de la note maximal
		double etendue;     // contient l'étendue des résultats
		double somme = 0;   // contient somme utilié pour calculer la moyenne
		
		int i;
		int j;
		
		for(i = 0; i < NOTE; i++) {
			// demander une note, si l'utilisateur annule, le programme se termine
			note[i]  = getNote(i+1);
			if(note[i] == ERR)
				quit(1);
			
			// convertir la note comme un pourcentage
			note[i] *= (100.0/MAX);
			
			// déterminer si la note entré est la plus petite ou la plus grande jusqu'à ici
			if(note[i] < min)
				min = i;
			else if(note[i] > max)
				max = i;
			
			// ajouter la note entré à la somme pour la moyenne
			somme += note[i];
			
			// classer la note
			switch((int)note[i]/10) {
			case  0: classe[0]++; break;
			case  1: classe[1]++; break;
			case  2: classe[2]++; break;
			case  3: classe[3]++; break;
			case  4: classe[4]++; break;
			case  5: classe[5]++; break;
			case  6: classe[6]++; break;
			case  7: classe[7]++; break;
			case  8: classe[8]++; break;
			case  9:
			case 10: classe[9]++; break;
			default: break;
			}
		}
		etendue = max-min; // calculer l'étendue
		somme  /= NOTE;    // calculer la moyenne
		
		// création de l'histogramme
		histogramme = "Indice\tFréquence\tSymboles\n";
		for(i = 0; i < 10; i++) {
			histogramme += i+"\t"+classe[i]+"\t";
			// ajouter les symboles
			for(j = classe[i]; j > 0; j--) {
				histogramme += SYM;
			}
			histogramme += "\n";
		}

		// finaliser et afficher l'histogramme avec la moyenne et l'étendue
		histogramme += "\nMoyenne: "+percent.format(somme/100)+"\nÉtendue: "+percent.format(etendue/100);
		JOptionPane.showMessageDialog(null, new JTextArea(histogramme));
	}
	
	/*
	 * Cette fonction va demandé une note entre la borne
	 * mininal et maximal. Elle s'assure que le chiffre 
	 * est valide.
	 */
	private static double getNote(int index) {
		String choix = ""; // contient le texte entré par l'utilisateur
		double note  = 0;  // contient la note entré par l'utilisateur

		while(choix != null) {
			// demander un nombre à l'utilisateur
			choix = JOptionPane.showInputDialog("Veuillez entrer la note #"+index+":");
			
			// quitter si annuler est cliqué
			if(choix == null)
				note = ERR;
			else {
				try {
					note = Double.parseDouble(choix);
					choix = null;
					
					// erreur si le nombre n'est pas dans la borne possible
					if(note < MIN || note > MAX) 
						choix = "";
				// erreur si ce n'est pas un nombre
				} catch(NumberFormatException except) {}
			}
		}
		
		return note;
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