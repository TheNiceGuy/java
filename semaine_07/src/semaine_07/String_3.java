package semaine_07;

public class String_3 {
	public static void main(String[] args) {
		final int MIN =   0;
		final int MAX = 999;
		
		int i;
		
		for(i = MIN; i <= MAX; i++)
			System.out.print(isArmstrong(""+i)==true?i+"\n":"");

		System.exit(0);
	}
	
	private static boolean isArmstrong(String arm) {
		int taille;
		int somme;
		int i;
		
		taille = arm.length();
		somme  = 0;
		for(i = 0; i < taille; i++)
			somme += Math.pow(Character.getNumericValue(arm.charAt(i)), taille);
		
		if(somme != Integer.parseInt(arm))
			i = -1;
		
		return (i != -1?true:false);
	}
}
