package semaine_6;

import javax.swing.JOptionPane;

public class Banque {
	private double solde;

	public Banque(int montant) {
		solde = montant;
	}
	
	public void depot() {
		solde += getMontant("DÉPOT", 0);
	}
	
	public void retrait() {
		solde -= getMontant("RETRAIT", solde);
	}
	
	public void paiement() {
		solde -= getMontant("PAIEMENT", solde);
	}
	
	public double getSolde(){
		return solde;
	}
	
	private double getMontant(String type, double max) {
		String choix;
		double montant;
		
		choix   = "";
		montant = 0;
		while(choix != null) {
			choix = JOptionPane.showInputDialog("["+type+"] Veuillez entrez le montant:");
			if(choix == null)
				montant = 0;
			else {
				try {
					montant = Double.parseDouble(choix);
					choix = null;
					
					if(montant<0) {
						JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre positif!", "Banque",
													  JOptionPane.ERROR_MESSAGE, null);
						choix = "";
					} else if(max==0?false:montant>max) {
						JOptionPane.showMessageDialog(null, "Vous n'avez pas assez d'argent dans votre compte!", "Banque",
								  JOptionPane.ERROR_MESSAGE, null);
						choix = "";
					}
				} catch(NumberFormatException except) {
					JOptionPane.showMessageDialog(null, "Ceci n'est pas un nombre!", "Banque",
												  JOptionPane.ERROR_MESSAGE, null);
				}
			}
		}
		
		return montant;
	}
}
