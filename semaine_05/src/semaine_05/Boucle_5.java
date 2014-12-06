package semaine_05;

import javax.swing.JOptionPane;

public class Boucle_5 {
	public static void main(String[] args) {
		final int MIN =  0;
		final int MAX = 10;
		
		int i, j;
		int factoriel;
		String str;
		
		//calculer les factoriels en [0,10]
		for(i = MIN; i<=MAX; i++) {
			//le 0! est égal à 1
			if(i == 0)
				JOptionPane.showMessageDialog(null, "0!=1");
			else {
				str = "";
				factoriel = 1;
				for(j=i; j>1; j--) {
					str+=j+"*";
					factoriel*=j;
				}
				str+="1";
				JOptionPane.showMessageDialog(null, i+"!="+str+"="+factoriel);
			}
		}
				
		System.exit(0);
	}
}
