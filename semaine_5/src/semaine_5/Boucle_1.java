package semaine_5;

import javax.swing.JOptionPane;

public class Boucle_1 {
	public static void main(String[] args) {
		final int SOMME1MIN =   0;
		final int SOMME1MAX =  20;
		final int SOMME2MIN =  21;
		final int SOMME2MAX =  50;
		final int SOMME3MIN =  51;
		final int SOMME3MAX = 100;
		
		int iSomme[] = new int[3];
		int i;
		
		//summation des entiers en [0, 20]
		for(i = SOMME1MIN, iSomme[0] = 0; i <= SOMME1MAX; i++){
			System.out.print(i+"\n");
			iSomme[0] += i;
		}
		JOptionPane.showMessageDialog(null, "Somme de "+SOMME1MIN+" à "+SOMME1MAX+" = "+iSomme[0]);
		
		//summation des entiers pairs en [21, 50]
		for(i = SOMME2MIN, iSomme[1] = 0; i <= SOMME2MAX; i++){
			if(i%2 == 0) {
				System.out.print(i+"\n");
				iSomme[1] += i;
			}
		}
		JOptionPane.showMessageDialog(null, "Somme pair de "+SOMME2MIN+" à "+SOMME2MAX+" = "+iSomme[1]);
		
		//summation des entiers impairs en [51, 100]
		for(i = SOMME3MIN, iSomme[2] = 0; i <= SOMME3MAX; i++){
			if(i%2 == 1) {
				System.out.print(i+"\n");
				iSomme[2] += i;
			}
		}
		JOptionPane.showMessageDialog(null, "Somme impair de "+SOMME3MIN+" à "+SOMME3MAX+" = "+iSomme[2]);
		
		System.exit(0);
	}
}
