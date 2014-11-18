package semaine_5;

import javax.swing.JOptionPane;

public class Boucle_6 {
	public static void main(String[] args) {
		final int MIN =  1;
		final int MAX = 10;
		
		int somme;
		int produit;
		int i;
		
		somme   = 0;
		produit = 1;
		for(i=MIN; i<=MAX; i++) {
			//faire le produit de tout les nombres pairs
			if(i%2==0)
				produit*=i;
			//faire la somme de tout les nombres impairs
			else
				somme+=i;
		}
		JOptionPane.showMessageDialog(null, "Produit des nombres pairs ["+MIN+","+MAX+"]: "+produit);
		JOptionPane.showMessageDialog(null, "Somme des nombres impairs ["+MIN+","+MAX+"]: "+somme);
		
		System.exit(0);
	}
}
