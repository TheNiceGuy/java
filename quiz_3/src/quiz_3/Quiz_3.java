package quiz_3;

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Quiz_3 {
	public static void main(String[] args) {
		final double NOTE1 = 0.25;
		final double NOTE2 = 0.35;
		final double NOTE3 = 0.40;
		final int NBETUDIANT = 5;
		
		NumberFormat percent = NumberFormat.getPercentInstance();
		
		String strNom[] = new String[NBETUDIANT];
		double dNote1[] = new double[NBETUDIANT];
		double dNote2[] = new double[NBETUDIANT];
		double dNote3[] = new double[NBETUDIANT];
		double dMoyenne[] = new double[NBETUDIANT];
		double dMoyG;
		double max;
		double min;
		int i;
		int echec;
		int ctr[] = new int[4];
		
		dMoyG =   0;
		min   = 100;
		max   =   0;
		echec =   0;
		for(i=0; i<NBETUDIANT; i++) {
			strNom[i] = JOptionPane.showInputDialog("Le numéro de matricule de l'étudiant:");
			dNote1[i] = Double.parseDouble(JOptionPane.showInputDialog("Le note de l'examen mi-session:"));
			dNote2[i] = Double.parseDouble(JOptionPane.showInputDialog("Le note de l'examen de fin session:"));
			dNote3[i] = Double.parseDouble(JOptionPane.showInputDialog("Le note des travaux pratiques:"));
			
			dMoyenne[i] = (dNote1[i]*NOTE1)+(dNote2[i]*NOTE2)+(dNote3[i]*NOTE3);
			dMoyG += dMoyenne[i];
			if(dMoyenne[i]<min)
				min = dMoyenne[i];
			if(dMoyenne[i]>max)
				max = dMoyenne[i];
			
			if(dMoyenne[i] < 60)
				echec++;
			if(dMoyenne[i]<25)
				ctr[0]++;
			else if(dMoyenne[i]<50)
				ctr[1]++;
			else if(dMoyenne[i]<75)
				ctr[2]++;
			else
				ctr[3]++;
		}
		
		dMoyG /= NBETUDIANT;
		
		for(i=0; i<NBETUDIANT; i++) {
			System.out.print("L'étudiant ayant le numéro de matricule "+strNom[i]+" a comme note "+percent.format(dMoyenne[i]/100)+"\n");
		}
		System.out.print("\n");
		System.out.print("Le groupe comporte "+NBETUDIANT+" "+(NBETUDIANT>1?"étudiants":"étudiant")+".\n");
		System.out.print("La moyenne du groupe est de "+percent.format(dMoyG/100)+".\n");
		System.out.print("\n");
		System.out.print("La note la plus haute du groupe est de: "+percent.format(max/100)+".\n");
		System.out.print("La note la plus basse du groupe est de: "+percent.format(min/100)+".\n");
		System.out.print("\n");
		System.out.print("Le nombre d'échecs pour est de "+echec+" étudiants.\n");
		System.out.print("");
		System.out.print("Entre les notes  0 et  25%, il y a "+ctr[0]+" "+(ctr[0]>1?"étudiants":"étudiant")+".\n");
		System.out.print("Entre les notes 26 et  50%, il y a "+ctr[1]+" "+(ctr[1]>1?"étudiants":"étudiant")+".\n");
		System.out.print("Entre les notes 51 et  75%, il y a "+ctr[2]+" "+(ctr[2]>1?"étudiants":"étudiant")+".\n");
		System.out.print("Entre les notes 76 et 100%, il y a "+ctr[3]+" "+(ctr[3]>1?"étudiants":"étudiant")+".\n");
		
		System.exit(0);
	}
}
