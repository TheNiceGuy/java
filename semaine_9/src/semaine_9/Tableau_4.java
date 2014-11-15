package semaine_9;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.Arrays;

/*
 * Fichier     : Tableau_4.java
 * Project     : Laboratoires sur les tableaux
 * Objectifs   : Gestion d'un tableau
 * Logiciel    : Eclipse Mars, OpenJDK 1.8
 * Plateforme  : Archlinux, Linux 3.18.0-rc2+ x86_64 GNU/Linux
 * Auteur      : Gabriel-Andrew Pollo Guilbert
 * Création    : 6 Novembre 2014
 */

public class Tableau_4 {
    final static String NOM = "Tableau"; // constante du nom de l'application
    final static String ERR = "Annuler"; // constante du code d'erreur si l'utilisateur annule
    final static int MIN    = 1;         // constante du minimum de case
    final static int MAX    = 10;        // constante du maximum de case

    public static void main(String[] args) {
        final String menu[] = {"Quitter",     "Trier",    "Initialiser",
                               "Additionner", "Afficher", "Supprimer",
                               "Modifier",    "Ajouter"};

        int tableau[]; // contient le tableau pour faire de la gestion

        int choix;     // contient le choix de l'utilisateur dans le menu
        String input;  // contient la valeur renvoyé par la fonction getNumber()

        // demandé la taille du tableau
        input = getNumber("Veuillez entrer la taille du tableau:", true, MIN, MAX);
        if(input == ERR) quit(0);
        tableau = new int[Integer.parseInt(input)];

        //boucler tant et aussi longtemps que l'utilisateur n'a pas quitté
        do {
            choix = JOptionPane.showOptionDialog(
                    null, "Quelle action voulez-vous faire?", NOM,
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    menu, menu[0]);

            switch(choix) {
            default:
            case 0: break;
            case 1: trier(tableau);  break;
            case 2: init(tableau);   break;
            case 3: add(tableau);    break;
            case 4: show(tableau);   break;
            case 5: del(tableau);    break;
            case 6: modify(tableau); break;
            case 7: create(tableau); break;
            }
        } while(choix != 0);

        // quitter le programme
        quit(0);
    }

    /*
     * Cette fonction crée une case dans le
     * tableau.
     */
    private static int create(int t[]) {
        // constante des choix du menu
        final String menu[] = {"Début", "Fin", "Spécifier"};

        int choix;    // contient le choix de l'utilisateur dans le menu
        int index;    // contient l'index de la case à modifier
        String input; // contient la valeur renvoyé par la fonction getNumber()

        // tester si le tableau est plein
        if(isFull(t) == true)
            return 1;

        // demander quelle case à créer
        choix = JOptionPane.showOptionDialog(
                null, "Où voullez-vous ajouter un nombre?", NOM,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                menu, menu[0]);

        switch(choix) {
        default:
        case 0: index = 0;          break;
        case 1: index = t.length-1; break;
        case 2: input = getNumber("Où voulez-vous entrer le nombre?", true, 1, t.length);
                if(input == ERR) return 1;
                index = Integer.parseInt(input)-1;
        }

        // demander quelle nombre y mettre
        if(t[index] == 0) {
            input = getNumber("Veuillez entrer le nombre à ajouter:", false, 0, 0);
            if(input == ERR) return 1;
            t[index] = Integer.parseInt(input);
        }
        else {
            JOptionPane.showMessageDialog(null, "Un nombre existe déjà à la position "+(index+1)+".");
            return 1;
        }

        JOptionPane.showMessageDialog(null, "Le "+t[index]+" a été ajouté à la position "+(index+1)+".");
        return 0;
    }

    /*
     * Cette fonction va affecter une valeur
     * à un endroit dans le tableau
     */
    private static int modify(int t[]) {
        int index;    // contient l'index de la case à modifier
        int nombre;   // contient le nombre à affecter
        String input; // contient la valeur renvoyé par la fonction getNumber()

        // tester si le tableau est vide
        if(isEmpty(t) == true)
            return 1;

        // demander la position de la case
        input = getNumber("Veuillez entrer la position du nombre à modifier:", true, 1, t.length);
        if(input == ERR) return 1;
        index  = Integer.parseInt(input)-1;

        // tester si la case existe
        if(t[index] == 0) {
            JOptionPane.showMessageDialog(null, "Aucun nombre existe à la position "+(index+1)+".");
            return 1;
        }

        // demander le nombre à affecter
        input = getNumber("Veuillez entrer le nombre à affecter à la case:", false, 0, 0);
        if(input == ERR) return 1;
        nombre = Integer.parseInt(input);

        // affecter le nombre à la case
        t[index] = nombre;

        JOptionPane.showMessageDialog(null, "Le nombre "+nombre+" a été affecté à la position "+(index+1)+".");
        return 0;
    }

    /*
     * Cette fonction supprime une valeur
     * dans le tableau.
     */
    private static int del(int t[]) {
        int index;    // contient l'index de la case à supprimer
        String input; // contient la valeur renvoyé par la fonction getNumber()

        // tester si le tableau est vide
        if(isEmpty(t) == true)
            return 1;

        // demander la position à supprimer
        input = getNumber("Veuillez entrer la position où vous voullez supprimer un nombre:", true, 1, t.length);
        if(input == ERR) return 1;
        index = Integer.parseInt(input)-1;

        // tester si la case existe
        if(t[index] != 0)
            t[index] = 0;
        else {
            JOptionPane.showMessageDialog(null, "Il n'y a aucun nombre à supprimer à la position "+(index+1)+".");
            return 1;
        }

        JOptionPane.showMessageDialog(null, "La nombre à la position "+(index+1)+" a été supprimer.");
        return 0;
    }

    /*
     * Cette fonction affiche le tableau.
     */
    private static int show(int t[]) {
        final char VIDE = '*'; // constante du charactère lorsque la case est vide

        int i;              // contient un compteur
        String output = ""; // contient le tableau à être afficher

        // première ligne
        for(i = 0; i < t.length; i++) {
            output += "Case "+(i+1);
            if(i != t.length-1)
                output += "\t";
        }
        output += "\n";

        // deuxième ligne
        for(i = 0; i < t.length; i++) {
            if(t[i] == 0)
                output += "["+VIDE+"]";
            else
                output += "["+t[i]+"]";

            if(i != t.length-1)
                output += "\t";
        }

        JOptionPane.showMessageDialog(null, new JTextArea(output));
        return 0;
    }

    /*
     * Cette fonction ajoute un chiffre à
     * toute les cases existantes du tableau
     */
    private static int add(int t[]) {
        int nombre;
        int i;
        String input; // contient la valeur renvoyé par la fonction getNumber()

        if(isEmpty(t) == true)
            return 1;

        input = getNumber("Veuillez entrer le nombre à ajouter au tableau:", false, 0, 0);
        if(input == ERR) return 1;
        nombre = Integer.parseInt(input);

        for(i = 0; i < t.length; i++)
            if(t[i] != 0)
                t[i] += nombre;

        JOptionPane.showMessageDialog(null, "Le nombre "+nombre+" a été ajouté à tout le tableau.");
        return 0;
    }

    /*
     * Cette fonction va assigner un valeur à
     * tout le tableau.
     */
    private static int init(int t[]) {
        int nombre;
        int i;
        String input; // contient la valeur renvoyé par la fonction getNumber()

        do {
            input = getNumber("Veuillez choisir une valeur pour initialiser le tableau:", false, 0, 0);
            if(input == ERR) return 1;
            nombre = Integer.parseInt(input);

            if(nombre == 0)
                JOptionPane.showMessageDialog(null, "La valeur doit être différente de 0");
        } while(nombre == 0);

        for(i = 0; i < t.length; i++)
            t[i] = nombre;

        JOptionPane.showMessageDialog(null, "Le tableau a été initialiser avec "+nombre+".");
        return 0;
    }

    /*
     * Cette fonction va trier le tableau avec
     * l'algorithme de java.
     */
    private static int trier(int t[]) {
        if(isEmpty(t) == true)
            return 1;

        Arrays.sort(t);

        JOptionPane.showMessageDialog(null, "Le tableau a été trier.");
        return 0;
    }

    /*
     * Cette fonction demande un nombre. On peut préciser le
     * message ainsi que les bornes min et max. Elle renvoit
     * un message d'erreur si l'utilisateur annule la saisie.
     */
    private static String getNumber(String text, boolean borne, int min, int max) {
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

                    // le nombre doit être dans les bornes
                    if(borne == true && (nombre < min || nombre > max)) {
                        JOptionPane.showMessageDialog(null, "Le chiffre est hors des limites possibles. ["+min+","+max+"]");
                    } else
                        choix = null;
                } catch(NumberFormatException except) {}
        } while(choix != ERR && choix != null);

        if(choix != ERR)
            choix = ""+nombre;

        return choix;
    }

    /*
     * Cette fonction regarde si le tableau est plein
     */
    private static boolean isFull(int t[]) {
        int i;

        for(i = 0; i < t.length; i++)
            if(t[i] == 0)
                i = t.length+1;
        if(i == t.length) {
            JOptionPane.showMessageDialog(null, "Le tableau est plein.");
            return true;
        }

        return false;
    }

    /*
     * Cette fonction regarde si le tableau est vide.
     */
    private static boolean isEmpty(int t[]) {
        int i;

        for(i = 0; i < t.length; i++)
            if(t[i] != 0)
                i = t.length+1;
        if(i == t.length) {
            JOptionPane.showMessageDialog(null, "Le tableau est vide.");
            return true;
        }

        return false;
    }

    /*
    * Si le programme doit se terminer en renvoyant une erreur
    * et sans qu'il plante, cette fonction est utilisé.
    */
    private static void quit(int code) {
        System.exit(code);
    }
}
