package semaine_5;

import javax.swing.JOptionPane;

public class Boucle_7 {
	public static void main(String[] args) {
		final int DEBUT[] = {1,1};
		final int FIN = 20;
		
		int i;
		int fib[] = {DEBUT[0], DEBUT[1]};
		String str;
		
		//initialiser les deux premiers nombre de la séquence à 1
		str = DEBUT[0]+", "+DEBUT[1];
		for(i=3; i<=FIN; i++) {
			//seulement que deux emplacements de mémoire sont requient si je 
			//change le premier, ensuite je vais changer le deuxième ensuite
			//je retourne au premier tout en ajoutant le résultat à la suite
			if(i%2==1) {
				fib[0] = fib[0]+fib[1];
				str+=", "+fib[0];
			}
			else {
				fib[1] = fib[0]+fib[1];
				str+=", "+fib[1];
			}
		}
		JOptionPane.showMessageDialog(null, str);
		
		System.exit(0);
	}
}
