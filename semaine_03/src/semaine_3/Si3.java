package semaine_3;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Si3 {
	public static void main(String[] args) {
		final double NOTEPASSAGE = 0.60;
		
		int iNote[] = new int[3];
		int i = 0;
		double dPercent = 0;
		
		NumberFormat percent = NumberFormat.getPercentInstance();

		// Ramasser les données, s'assurer qu'elles soient entre 0 et 25
		while(i<3) {
			iNote[i] = Integer.parseInt(JOptionPane.showInputDialog("Note #"+(i+1)+" (sur 25):"));
			if(iNote[i] <= 25 && iNote[i] >= 0) {
				dPercent += iNote[i];
				i++;
			} else
				JOptionPane.showMessageDialog(null, "La note doit être comprise entre 0 et 25!");
		}
		
		//calculer le pourcentage
		dPercent = (dPercent /= 100);
		
		//afficher la conclusion
		if(dPercent >= NOTEPASSAGE)
			JOptionPane.showMessageDialog(null, "Félicitations, vous êtes assurés de passer le cours.  ("+
			                                     percent.format(dPercent)+")");
		else
			JOptionPane.showMessageDialog(null, "Désolé, vous ne pouvez pas passer le cours. ("+
                    percent.format(dPercent)+")");
		
		System.exit(0);
	}
}