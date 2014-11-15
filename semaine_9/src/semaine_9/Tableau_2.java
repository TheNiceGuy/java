package semaine_9;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.text.NumberFormat;

/*
 * Fichier     : Tableau_2.java
 * Project     : Laboratoires sur les tableaux
 * Objectifs   : Histogramme des notes d'examen
 * Logiciel    : Eclipse Mars, OpenJDK 1.8
 * Plateforme  : Archlinux, Linux 3.18.0-rc2+ x86_64 GNU/Linux
 * Auteur      : Gabriel-Andrew Pollo Guilbert
 * Création    : 30 Octobre 2014
 */

public class Tableau_2 {
    final static String NOM = "Gestionnaire de journées de maladie";
    final static String ERR = "Annuler";

    final static int MAX  = 72; // constante du maximum d'une note
    final static int MIN  = 0;  // constante du minimum d'une note

    public static void main(String[] args) {
        final String menu[] = {"Oui", "Non"};

        int choix;

        //boucler tant et aussi longtemps que l'utilisateur n'a pas quitté
        session();
        do {
            choix = JOptionPane.showOptionDialog(
                    null, "Voulez-vous quitter?", NOM,
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    menu, menu[0]);

            switch(choix) {
            case 0:  break;
            default: session();
            }
        } while(choix != 0);

        // quitter le programme
        quit(0);
    }

    /*
     * Cette fonction est utilisé lorsque l'utilisateur
     * veut faire un histogramme sur les notes.
     */
    private static int session() {
        final char SYM = '*'; // constante contenant le symbole utilisé par l'histogramme
        final int NOTE = 20;  // constante du nombre de note à demander

        int classe[]  = new int[10];      // tableau contenant les classes de note
        double note[] = new double[NOTE]; // tableau contenant les notes

        int i;              // contient un compteur
        int j;              // contient un compteur
        int min      = 0;   // contient l'index de la note minimal
        int max      = 0;   // contient l'index de la note maximal
        double etendue;     // contient l'étendue des résultats
        double somme = 0;   // contient somme utilié pour calculer la moyenne

        String histogramme; // contient la chaîne de charactères contenant l'histogramme
        String input;       // contient la valeur renvoyé par getNumber()
        NumberFormat percent = NumberFormat.getPercentInstance();

        for(i = 0; i < NOTE; i++) {
            // demander une note, si l'utilisateur annule, le programme se termine
            input = getNumber("Veuillez entrer la note #"+(i+1)+":");
            if(input == ERR) return 1;

            note[i] = Integer.parseInt(input);

            // convertir la note comme un pourcentage
            note[i] *= (100.0/MAX);

            // déterminer si la note entré est la plus petite ou la plus grande jusqu'à ici
            if(note[i] < note[min])
                min = i;
            else if(note[i] > note[max])
                max = i;

            // ajouter la note entré à la somme pour la moyenne
            somme += note[i];

            // classer la note
            switch((int)note[i]/10) {
            case  0: classe[0]++; break;
            case  1: classe[1]++; break;
            case  2: classe[2]++; break;
            case  3: classe[3]++; break;
            case  4: classe[4]++; break;
            case  5: classe[5]++; break;
            case  6: classe[6]++; break;
            case  7: classe[7]++; break;
            case  8: classe[8]++; break;
            case  9:
            case 10: classe[9]++; break;
            default: break;
            }
        }
        etendue = note[max]-note[min]; // calculer l'étendue
        somme  /= NOTE;    // calculer la moyenne

        // création de l'histogramme
        histogramme = "Indice\tFréquence\tSymboles\n";
        for(i = 0; i < 10; i++) {
            histogramme += i+"\t"+classe[i]+"\t";
            // ajouter les symboles
            for(j = classe[i]; j > 0; j--) {
                histogramme += SYM;
            }
            histogramme += "\n";
        }

        // finaliser et afficher l'histogramme avec la moyenne et l'étendue
        histogramme += "\nMoyenne: "+percent.format(somme/100)+"\nÉtendue: "+percent.format(etendue/100);

        JOptionPane.showMessageDialog(null, new JTextArea(histogramme));
        return 0;
    }

    /*
     * Cette fonction va demandé une note entre la borne mininal
     * et maximal. Elle s'assure que le chiffre est valide.
     */
    private static String getNumber(String text) {
        int nombre   = 0;
        String choix = ""; // contient le texte entré par l'utilisateur

        do {
            choix = JOptionPane.showInputDialog(text);

            // s'assurer que la réponse entrée est correcte
            if(choix == null)
                choix = ERR;
            else
                try {
                    nombre = Integer.parseInt(choix);

                    // le nombre doit être dans les bornes
                    if(nombre >= MIN && nombre <= MAX)
                        choix = null;
                } catch(NumberFormatException except) {}
        } while(choix != ERR && choix != null);

        if(choix != ERR)
            choix = ""+nombre;

        return choix;
    }

    /*
     * Si le programme doit se terminer en renvoyant une erreur
     * et sans qu'il plante, cette fonction est utilisé.
     */
    private static void quit(int code) {
        System.exit(code);
    }
}
