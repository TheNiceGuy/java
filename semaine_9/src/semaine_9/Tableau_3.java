package semaine_9;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.text.NumberFormat;

/*
 * Fichier     : Tableau_3.java
 * Project     : Laboratoires sur les tableaux
 * Objectifs   : Compilation de votes pour une municipalité
 * Logiciel    : Eclipse Mars, OpenJDK 1.8
 * Plateforme  : Archlinux, Linux 3.18.0-rc2+ x86_64 GNU/Linux
 * Auteur      : Gabriel-Andrew Pollo Guilbert
 * Création    : 2 Novembre 2014
 */

public class Tableau_3 {
    final static String NOM   = "Vote";    // constante du nom de l'application
    final static String ERR   = "Annuler"; // constante du code d'erreur si l'utilisateur annule
                                           // constante du nom des candidats de l'élection
    final static String CAN[] = {"Monique Lagacé", "Myriam Laposte",  "Julien Lafrenière",
                                 "Alex Beaubien",  "Jules Laliberté", "Diana Montplaisir"};
    final static int BUREAU   =  5;        // constante du nombre de bureau


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
     * veut faire compiler des votes.
     */
    private static int session()  {
        int    resul[] = new int[CAN.length];    // tableau contenant les résultats de chaque personne
        double pourc[] = new double[CAN.length]; // tableau contenant les résultats sous un pourcentage

        int somme;       // contient le nombre total de vote
        int vote;        // contient le nombre de vote entré par l'utilisateur
        int gagnant = 0; // contient l'index du gagnant
        int i;           // contient un compteur
        int j;           // contient un compteur

        String resultat; // contient la chaîne de charactères contenant les résultats
        String input;    // contient la valeur renvoyé par getNumber()
        NumberFormat percent = NumberFormat.getPercentInstance();

        // pour chaque bureaux, demander le nombre de vote pour chaque personnes
        for(i = somme = 0; i < BUREAU; i++)
            for(j = 0; j < CAN.length; j++) {
                // demander le nombre de vote pour X bureau et Y personne
                // si l'utilisateur annule, le programme se termine
                input = getVote(i, j);
                if(input == ERR) return 1;
                vote = Integer.parseInt(input);

                // classer ces votes et les ajouter à la somme total de vote
                resul[j] += vote;
                somme    += vote;
            }

        // création des résultats
        resultat = "Résultat des élections municipales.\n\n";
        for(i = 0; i < CAN.length; i++) {
            // en même temps, déterminer la gagnant des élections
            if(resul[i] > resul[gagnant])
                gagnant = i;

            // en même temps, convertir le nombre de vote en pourcentage
            pourc[i] = (double)resul[i]/somme;

            // ajouter la ligne d'un député dans le résultat
            resultat += (CAN[i]+":     \t"+resul[i]+" "+(resul[i]>1?"votes":"vote")
                     +" ("+percent.format(pourc[i])+")\n");
        }

        // finaliser et afficher les résultats avec le gagnant
        resultat += ("\nLe gagnant des élections municipales est "
                    +CAN[gagnant]+" avec "+resul[gagnant]+" "
                    +(resul[gagnant]>1?"votes":"vote")+".");

        JOptionPane.showMessageDialog(null, new JTextArea(resultat));
        return 0;
    }

    /*
    * Cette fonction va demandé une nombre de vote entre la borne mininal
    * Elle s'assure que le chiffre est valide.
    */
    private static String getVote(int bureau, int index) {
        int nombre   = 0;  // contient le nombre entré
        String choix = ""; // contient le texte entré par l'utilisateur

        do {
            choix = JOptionPane.showInputDialog("Concernant le bureau de scrutin numéro "+(bureau+1)+", "+
                                                "le nombre de votes pour "+CAN[index]+" est:");

            // s'assurer que la réponse entrée est correcte
            if(choix == null)
                choix = ERR;
            else
                try {
                    nombre = Integer.parseInt(choix);

                    // le nombre doit être positif
                    if(nombre >= 0)
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
