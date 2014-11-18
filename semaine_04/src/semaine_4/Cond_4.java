package semaine_4;

import javax.swing.JOptionPane;

public class Cond_4 {
	public static void main(String[] args) {
		//                         E    A    I
		final int MAXVOLUME[]  = { 15,  10,  5 };
		final int MAXJOUR[]    = { 45,  20,  30};
		
		String strNumero;
		char charCategorie;
		int iCategorie = 0;
		int iPossession;
		int iEmprunt;
		Boolean bResultat;
		
		//ramasser les données
		strNumero     = JOptionPane.showInputDialog("Numéro de l'abonné:");
		charCategorie = JOptionPane.showInputDialog("Code de la catégorie:").charAt(0);
		iPossession   = Integer.parseInt(JOptionPane.showInputDialog("Nombre de livre en possession:"));
		iEmprunt      = Integer.parseInt(JOptionPane.showInputDialog("Nombre de livre pour emprunter:"));
		
		//déterminer s'il peut prendre plus de livre
		switch(charCategorie) {
			case 'e':
			case 'E':
				iCategorie = 0; break;
			case 'a':
			case 'A':
				iCategorie = 1; break;
			case 'i':
			case 'I':
				iCategorie = 2; break;
			default:
				JOptionPane.showMessageDialog(null, "Mauvaise catégorie!");
				System.exit(1);
		}
		bResultat = (iPossession+iEmprunt)<=MAXVOLUME[iCategorie];
		
		//afficher la conclusion
		JOptionPane.showMessageDialog(null, 
				  "L'abonné #"+strNumero+" "+(bResultat
						?"peut emprunter les volumes pour "+MAXJOUR[iCategorie]+" jours."
						:"ne peut pas emprunter de volumes pour le moment."));
		
		System.exit(0);
	}
}
