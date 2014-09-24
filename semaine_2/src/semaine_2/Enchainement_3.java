package semaine_2;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Enchainement_3 {
	public static void main(String[] args) {
		final double VALEUR_EXAM[]    = {0.20, 0.20, 0.20};
		final double VALEUR_TRAVAIL[] = {0.10, 0.10, 0.10, 0.10};
		
		NumberFormat pourcentage = NumberFormat.getPercentInstance();
				
		String strNom;
		String strNote;
		double dNoteEntrer;
		double dNote;
		int i;
		
		dNote = 0;
		strNom = JOptionPane.showInputDialog("Entrez votre nom et prénom: ");
		for(i=0; i<3; i++) {
			strNote = JOptionPane.showInputDialog("Exam "+(i+1)+": ");
			dNoteEntrer = Integer.parseInt(strNote);
			dNote += VALEUR_EXAM[i]*dNoteEntrer;
		}
		
		for(i=0; i<4; i++) {
			strNote = JOptionPane.showInputDialog("Travail "+(i+1)+":");
			dNoteEntrer = Integer.parseInt(strNote);
			dNote += VALEUR_TRAVAIL[i]*dNoteEntrer;
		}
		
		JOptionPane.showMessageDialog(null, "Nom: "+strNom+"        La note obtenue pour le cours est: "+pourcentage.format((double)dNote/100)+"\n");
		
		System.exit(0);
	}
}
