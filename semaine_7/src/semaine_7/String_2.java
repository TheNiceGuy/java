package semaine_7;

public class String_2 {
	public static void main(String[] args) {
		final int MIN =   1;
		final int MAX = 999;
		
		int i;
		
		for(i = MIN; i <= MAX; i++)
			System.out.print((isPalindrome(""+i)==true?i+"\n":""));
		
		System.exit(0);
	}
	
	private static boolean isPalindrome(String pal) {
		int taille;
		int i;
		
		taille = pal.length()-1;
		i = 0;
		
		do {
			if(pal.charAt(i) != pal.charAt(taille-i))
				i = -2;
			i++;
		} while(i <= taille/2 && i != -1);
		
		return (i != -1?true:false);
	}
}
