package semaine_09;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.text.DecimalFormat;

/*
 * Fichier     : Tableau_1.java
 * Project     : Laboratoires sur les tableaux
 * Objectifs   : Gestion du nombre de journées de maladie accumulées du personel
 * Logiciel    : Eclipse Mars, OpenJDK 1.8
 * Plateforme  : Archlinux, Linux 3.18.0-rc2+ x86_64 GNU/Linux
 * Auteur      : Gabriel-Andrew Pollo Guilbert
 * Création    : 28 Octobre 2014
 */

public class Tableau_1 {
    final static String NOM = "Journées de maladie"; // constante du nom de l'application
    final static String ERR  = "Annuler";            // constante du code d'erreur si l'utilisateur annule

    public static void main(String[] args) {
        final String menu[] = {"Oui", "Non"};

        JOptionPane.showMessageDialog(null, "BIENVENUE DANS MON PROGRAMME");

        int choix; // contient le choix de l'utilisateur dans le menu

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
     * veut regarder les journées de maladie.
     */
    public static int session() {
        final int PSUPNB  = 10; // nombre de journée précis supérieur
        final int EXACTNB =  8; // nombre de journée précis

        // tableau contenant les informations des employés
        String nom[] = {"Benoit", "Alice", "Daniel", "Emile", "Julien"};
        int numero[] = { 20,       10,      40,       50,      80     };
        int malade[] = { 18,        8,      10,       11,       8     };

        int i;               // contient un compteur
        int taille;          // contient le nombre d'employé
        int sommeP      = 0; // contient la somme des journées des employés avec plus de N jours
        int min         = 0; // contient l'index de l'employé avec le moins de jours
        int max         = 0; // contient l'index de l'employé avec le plus de jours
        int maladeE     = 0; // contient l'index de l'employé avec un nombre N de jours
        int nombre;          // contient un nombre entré par l'utilisateur
        int index       = 0; // contient l'index de l'employé demandé
        double moyenne  = 0; // contient la moyenne de jours de tous les employés
        double moyenneM = 0; // contient la moyenne de jours des employés avec plus de N jours

        String resultat; // contient le message final
        String input;    // contient la valeur renvoyé par getNumber()
        DecimalFormat decimal = new DecimalFormat("#0.0");

        for(i = 0, taille = nom.length; i < taille; i++) {
            // somme des journées des employés avec plus de N jours
            if(malade[i] >= PSUPNB)
                sommeP++;

            // somme de la moyenne des journées des employés avec moins de N jours
            if(malade[i] >= PSUPNB)
                moyenneM += malade[i];

            // somme de la moyenne des journées de tous les employées
            moyenne += malade[i];

            // trouver l'index de l'employé avec le moins de jours
            if(malade[i] < malade[min])
                min = i;

            // trouver l'index de l'employé avec le plus de jours
            if(malade[i] > malade[max])
                max = i;

            // trouver le premier index d'un employé avec un nombre N de jours
            if(maladeE == 0 && malade[i] == EXACTNB)
                maladeE = i;
        }
        // diviser les moyennes
        moyenne  /= taille;
        moyenneM /= taille;

        // demandé un numéro d'employé et trouver son index
        do {
            input = getNumber("Veuillez entrez le numéro d'un employé.");
            if(input == ERR) return 1;
            nombre = Integer.parseInt(input);

            for(i = 0; i < taille; i++)
                if(numero[i] == nombre) {
                    index = i;
                    i = taille;
                }

            // message d'erreur si le numéro n'existe pas
            if(i == taille)
                JOptionPane.showMessageDialog(null, "L'employé #"+nombre+" n'est pas dans votre compagnie.\n");
        }
        while(i == taille);

        // afficher les résultats
        resultat  = "Il y a "+sommeP+" "+(sommeP>1?"employés":"employé")+" ayant accumulé 10 journées de maladie ou plus.\n";
        resultat += "La moyenne est de "+decimal.format(moyenne)+" "+(moyenne>1?"journées":"journée")+" de la maladie par employé.\n";
        resultat += "La moyenne est de "+decimal.format(moyenneM)+" "+(moyenneM>1?"journées":"journée")+" de la maladie par employé ayant moins de 10 journées prises.\n";
        resultat +=  nom[max]+" (#"+numero[max]+") a le plus de journées de maladie avec "+malade[max]+" "+(malade[max]>1?"journées":"journée")+" d'accumulées.\n";
        resultat += "L'étendue du nombre de journée de maladie est de "+(malade[max]-malade[min])+".\n";
        resultat +=  nom[maladeE]+" (#"+numero[maladeE]+") a exactment "+malade[maladeE]+" "+(malade[maladeE]>1?"journées":"journée")+" de maladie.\n\n";
        resultat +=  nom[index]+" (#"+numero[index]+") a "+malade[index]+" "+(malade[index]>1?"journées":"journée")+" de maladie.";

        JOptionPane.showMessageDialog(null, new JTextArea(resultat));
        return 0;
    }

    /*
     * Cette fonction va demandé un nombre entre la borne mininal.
     * Elle s'assure que le chiffre est valide.
     */
    private static String getNumber(String text) {
        int nombre   = 0;  // contient le nombre entré
        String choix = ""; // contient le texte entré par l'utilisateur

        do {
            choix = JOptionPane.showInputDialog(text);

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
        JOptionPane.showMessageDialog(null, "MERCI D'AVOIR UTILISÉ MON PROGRAMME");

        System.exit(code);
    }
}
