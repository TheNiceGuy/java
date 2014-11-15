package semaine_9;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.text.NumberFormat;

/*
 * Fichier     : Tableau_1.java
 * Project     : Laboratoires sur les tableaux
 * Objectifs   : Gestion du nombre de journées de maladie accumulées du personel
 * Logiciel    : Eclipse Mars, OpenJDK 1.8
 * Plateforme  : Archlinux, Linux 3.18.0-rc2+ x86_64 GNU/Linux
 * Auteur      : Gabriel-Andrew Pollo Guilbert
 * Création    : 28 Octobre 2014
 */

public class Tableau_6 {
    public static void main(String[] args) {



    }

private static String getNumber(String text, boolean borne, int min, int max) {
    int nombre   = 0;
    String choix = ""; // contient le texte entré par l'utilisateur

    while(choix != null && choix != ERR) {
        // demander un nombre à l'utilisateur
        choix = JOptionPane.showInputDialog(text);

        // quitter si annuler est cliqué
        if(choix == null)
            choix = ERR;
        else {
            try {
                nombre = Integer.parseInt(choix);
                choix = null;

                if(borne == true && (nombre < min || nombre > max)) {
                    JOptionPane.showMessageDialog(null, "Le chiffre est hors des limites possibles. ["+min+","+max+"]");
                    choix = "";
                }
            // erreur si ce n'est pas un nombre
            } catch(NumberFormatException except) {
            }
        }
    }

    if(choix != ERR)
        choix = ""+nombre;

    return choix;
    }
}
