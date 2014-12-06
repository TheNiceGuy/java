package semaine_06;

import javax.swing.JOptionPane;

public class Boucle_2 {
	public static void main(String[] args) {
		loop();
		
		System.exit(0);
	}
	
	private static void loop() {
		int quit;
		
		quit = 0;
		while(quit != 1) {
			JOptionPane.showMessageDialog(null, "Note: Ne tenez pas compte de la priorité des opérations\n"+calcul());
			
			quit = JOptionPane.showConfirmDialog(
				   null, "Voulez-vous faire un autre calcul?", "Calculatrice",
				   JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
		}
	}
	
	private static String calcul() {
		//cette fonction crée une équation et le calcul
		String calcul;
		double nombre;
		double resultat = 0;
		boolean quit;
		
		operation op;
		
		//demander le premier opérande
		calcul = ""+(resultat = getOperande(""));
		//boucler tant et aussi longtemps que l'équation n'est pas fini
		//ou s'il n'y a pas de division par zéro
		quit = false;
		op = operation.FIN;
		while(!quit?(op = getOperateur(calcul)) != operation.FIN:!quit) {
			//déterminer la prochaine opération
			switch(op) {
			case FIN: break;
			case ADDITION: calcul += "+"; break;
			case SOUSTRACTION: calcul += "-"; break;
			case MULTIPLICATION: calcul += "*"; break;
			case DIVISION: calcul += "/"; break;
			}
			
			//demander la prochain opérande
			nombre = getOperande(calcul);
			
			//ajouter le nouvel opérande dans l'équation
			switch(op) {
			case FIN: break;
			case ADDITION: 
				calcul += nombre;
				resultat += nombre; break;
			case SOUSTRACTION: 
				calcul += nombre;
				resultat -= nombre; break;
			case MULTIPLICATION: 
				calcul += nombre;
				resultat *= nombre; break;
			case DIVISION:
				//s'il y a une division par zéro, quitter
				if(nombre != 0) {
					calcul += nombre;
					resultat /= nombre;
				} else {
					calcul += "0 n'existe pas";
					quit = true;
				}
			}
		}
		//s'il n'y a pas eu de division par zéro, finaliser l'équation
		if(!quit)
			calcul += "="+resultat;
		
		return calcul;
	}
	
	private static double getOperande(String equation) {
		//cette fonction retourne une opérande (nombre) et affiche l'équation actuelle
		double op;
		boolean quit;
		
		op = 0;
		quit = false;
		while(quit != true)
		    try { 
		    	op = Double.parseDouble(JOptionPane.showInputDialog("Veuillez entrer une opérande:\n"+equation));
		    	quit = true;
		    } catch(NumberFormatException except) {
		    	JOptionPane.showMessageDialog(null, "Ceci n'est pas un nombre!", "Calculatrice",
		    								  JOptionPane.ERROR_MESSAGE, null);
		        quit = false;
		    }
		
		return op;
	}
	
	private static operation getOperateur(String equation) {
		//cette fonction retourne un opérateur et affiche l'équation actuelle
		final String menu[] = {"=", "/", "*", "-", "+"};
		int choix;
		
		operation op;
		
		choix = JOptionPane.showOptionDialog(
				null, "Quelle opéranteur voulez-vous ajouter?\n"+equation, "Calculatrice",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				menu, menu[0]);
		
		switch(choix) {
		default:
		case  0: op = operation.FIN; break;
		case  1: op = operation.DIVISION; break;
		case  2: op = operation.MULTIPLICATION; break;
		case  3: op = operation.SOUSTRACTION; break;
		case  4: op = operation.ADDITION; break;
		}
		
		return op;
	}
	
	private enum operation {
		ADDITION,
		SOUSTRACTION,
		MULTIPLICATION,
		DIVISION,
		FIN
	}
}
