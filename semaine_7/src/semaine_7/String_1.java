package semaine_7;

import javax.swing.JOptionPane;

public class String_1 {
	final static int TAILLE = 9;
	
	public static void main(String[] args) {
		final int NOMBRE =  500;
		
		String numero[] = new String[NOMBRE];
		String produit;
		int somme;
		int i, j;
		int tmp;
		
		for(i = 0; i < NOMBRE; i++) {
			numero[i] = "";
			produit   = "";
			somme     = 0;
			
			for(j = 0; j < TAILLE; j++) {
				if(j == TAILLE-1) {
					tmp = (sumString(""+(Integer.parseInt(produit)*2))+somme)%10;
					if(tmp != 0)
						tmp = 10-tmp;
					else
						tmp = 0;
				} else if(j%2 == 0) {
					tmp = generate(0, 9);
					somme += tmp;
				} else {
					tmp = generate(0, 9);
					produit += tmp;			
				}
				
				numero[i] += tmp;
			}
			
			System.out.print(numero[i]+"->"+(isNumero(numero[i])==true?"valide":"non-valide")+"\n");
		}
		
		System.exit(0);
	}
	
	private static boolean isNumero(String numero) {
		String temp   = "";
		int produit = 0;
		int somme   = 0;
		int i;
		
		for(i = 0; i < TAILLE; i++) {
			if(i%2 == 0)
				somme += Character.getNumericValue(numero.charAt(i));
			else
				temp += numero.charAt(i);
		}
		temp = ""+Integer.parseInt(temp)*2;
		
		produit = sumString(temp);
		
		return ((produit+somme)%10==0?true:false);
	}
	
	private static int sumString(String numero) {
		int i;
		int sum = 0;
		
		for(i = 0; i < numero.length(); i++)
			sum += Character.getNumericValue(numero.charAt(i));

		return sum;
	}
	
	private static int generate(int min, int max) {
		return  min+(int)(Math.random()*(max-min)+1);
	}
}
