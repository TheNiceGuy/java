package semaine_6;

import javax.swing.JOptionPane;

public class Jeu {
	final private int BORNE_MIN[] = { 1,  1,  1};
	final private int BORNE_MAX[] = {10, 20, 40};
	final private int BORNE_PRE[] = { 1, 10};
	
	private int erreur[] = {0, 0, 0};
	private int game = 0;
	
	public void stats() {
		int low;
		int i;
		
		low = erreur[1];
		for(i = 0; i < 3; i++)
			if(erreur[i] <= low)
				low = erreur[i]; 

		JOptionPane.showMessageDialog(null,
				"Niveau prédéfini: "+erreur[0]+" "+(erreur[0]>1?"erreurs":"erreur")+"\n"+
				"Niveau personnalisé: "+erreur[1]+" "+(erreur[1]>1?"erreurs":"erreur")+"\n"+
				"Niveau supérieur: "+erreur[2]+" "+(erreur[2]>1?"erreurs":"erreur")+"\n\n"+
				"Votre meilleur record à "+low+" "+(low>1?"erreurs":"erreur"));
	}
	
	public int getGame() {
		return game;
	}
	
	public void predefini() {
		int number;
		
		number = generate(BORNE_PRE[0], BORNE_PRE[1]);
		game(0, number, BORNE_PRE[0], BORNE_PRE[1], clue.HARD);
	}

	public void perso() {
		int min, max;
		int number;
		
		min = getNumber("Borne inférieur:");
		max = getNumber("Borne supérieur:");
		while(min >= max) {
			JOptionPane.showMessageDialog(null, "La borne inférieur doit être plus petite que la borne supérieur!",
                    "Jeu", JOptionPane.ERROR_MESSAGE, null);
			min = getNumber("Borne inférieur:");
			max = getNumber("Borne supérieur:");
		}
		number = generate(min, max);

		game(1, number, min, max, clue.EASY);
	}
	
	public void superieur() {
		int number;
		
		number = generate(BORNE_MIN[0], BORNE_MAX[0]);
		game(2, number, BORNE_MIN[0], BORNE_MAX[0], clue.HARD);
		
		number = generate(BORNE_MIN[1], BORNE_MAX[1]);
		game(2, number, BORNE_MIN[1], BORNE_MAX[1], clue.HARD);
		
		number = generate(BORNE_MIN[2], BORNE_MAX[2]);
		game(2, number, BORNE_MIN[2], BORNE_MAX[2], clue.HARD);
	}
	
	private int game(int niveau, int answer, int min, int max, clue type) {
		int number;
		boolean success;
		
		game++;
		success = true;
		number = getNumber("Devinez le nombre:");
		while(number != answer) {
			erreur[niveau]++;
			
			switch(type) {
			case EASY:
				if(number < answer)
					min = (number<min)?min:number+1;
				else
					max = (number>max)?max:number-1;
				
				if(min != max) {
					JOptionPane.showMessageDialog(null, "Le nombre généré est "
								+(number < answer?"plus grand":"plus petit")
								+", soit entre "+min+" et "+max+" inclusivement.");
				} else {
					number  = answer;
					success = false;
				} break;
			case HARD:
				if(number < answer)
					JOptionPane.showMessageDialog(null, "Le nombre généré est plus grand.");
				else
					JOptionPane.showMessageDialog(null, "Le nombre généré est plus petit.");
				break;
			}
			if(number != answer)
				number = getNumber("Devinez le nombre:");
		}
		
		if(success)
			JOptionPane.showMessageDialog(null, "Félicitations, vous avez trouvé le nombre généré.");
		else
			JOptionPane.showMessageDialog(null, "Le nombre était "+number+".");
		
		return 0;
	}
	
	private int getNumber(String msg) {
		int iNumber;
		boolean done;
		
		iNumber = 0;
		done = false;
		do {
			
			try { 
		    	iNumber = Integer.parseInt(JOptionPane.showInputDialog(msg));
		    	done = true;
		    } catch(NumberFormatException except) {
		    	JOptionPane.showMessageDialog(null, "Ceci n'est pas un nombre!", "Jeu",
		    								  JOptionPane.ERROR_MESSAGE, null);
		    	done = false;
		    }
		} while(done != true);
		    
		return iNumber;
	}
	
	private static int generate(int min, int max) {
		return  min+(int)(Math.random()*(max-min)+1);
	}
	
	private enum clue {
		EASY,
		HARD
	}
}