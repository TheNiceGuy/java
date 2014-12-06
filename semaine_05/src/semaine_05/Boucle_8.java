package semaine_05;

import javax.swing.JOptionPane;

public class Boucle_8 {
	public static void main(String[] args) {
		String str;
		int somme;
		int a, b, c;
		int i;		
		
		//ramasser les données
		a = Integer.parseInt(JOptionPane.showInputDialog("Premier nombre:"));
		b = Integer.parseInt(JOptionPane.showInputDialog("Deuxième nombre:"));
		
		//swap les deux nombre pour optimiser le calcul
		if(a>b) {
			c=a;
			a=b;
			b=c;
		}
		
		//calculer la première somme basé sur la première valeur
		str = ""+b;
		somme = b;
		for(i=a; i>1; i--) {
			str+="+"+b;
			somme+=b;
		}
		JOptionPane.showMessageDialog(null, a+"*"+b+"="+str+"="+somme);
		
		System.exit(0);
	}
}
