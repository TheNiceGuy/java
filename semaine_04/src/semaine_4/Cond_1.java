package semaine_4;

import javax.swing.JOptionPane;

public class Cond_1 {
	public static void main(String[] args) {
		String strMonth = null;
		int iMonth;
		int iYear;
		int iJour;
		
		//ramasser les données
		iMonth = Integer.parseInt(JOptionPane.showInputDialog("Entrez le mois: "));
		if(iMonth > 12) {
			JOptionPane.showMessageDialog(null, "Mois invalid!");
			System.exit(1);
		}
		iYear  = Integer.parseInt(JOptionPane.showInputDialog("Entrez l'année: "));
		iJour  = 0;
		
		//convertir le nombre en mois écrit
		switch(iMonth) {
			case  1: strMonth = "Janvier"  ; break;
			case  2: strMonth = "Février"  ; break;
			case  3: strMonth = "Mars"     ; break;
			case  4: strMonth = "Avril"    ; break;
			case  5: strMonth = "Mai"      ; break;
			case  6: strMonth = "Juin"     ; break;
			case  7: strMonth = "Juillet"  ; break;
			case  8: strMonth = "Août"     ; break;
			case  9: strMonth = "Septembre"; break;
			case 10: strMonth = "Octobre"  ; break;
			case 11: strMonth = "Novembre" ; break;
			case 12: strMonth = "Décembre" ; break;
		}
		
		//si le mois est Février, déterminer si c'est une année bissextile
		if(iMonth == 2) {
			if((iYear%400 == 0) || 
			   (iYear%4   == 0) && (iYear%100 != 0))
				iJour = 29;
			else
				iJour = 28;
		}
		//si le mois est pair,   il y a 31 jours
		//si le mois est impair, il y a 30 jours
		else switch((iMonth-1)%2) {
			case 0: iJour = 31;
			case 1: iJour = 30;
		}
		
		//afficher le résultat
		JOptionPane.showMessageDialog(null, "Il y a "+iJour+" jours en "+strMonth+" "+iYear+".");
		
		System.exit(0);
	}
}
