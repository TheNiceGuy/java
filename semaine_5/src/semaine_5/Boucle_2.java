package semaine_5;

import javax.swing.JOptionPane;

public class Boucle_2 {
	public static void main(String[] args) {
		final int SOMMEMIN =   0;
		final int SOMMEMAX = 100;
		final int MULTIPLE = 3;
		
		int iSomme;
		int i;
		
		for(i = SOMMEMIN, iSomme = 0; i < SOMMEMAX; i++) {
			if(i%MULTIPLE == 0)
				iSomme += i;
		}
		JOptionPane.showMessageDialog(null, "Somme des multiples de "+MULTIPLE+" de "+SOMMEMIN+" à "+SOMMEMAX+" = "+iSomme);
	}
}
