package semaine_9;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.text.NumberFormat;

/*
 * Fichier     : Tableau_4.java
 * Project     : Laboratoires sur les tableaux
 * Objectifs   : Gestion des dossiers étudiants
 * Logiciel    : Vim, OpenJDK 1.8
 * Plateforme  : Archlinux, Linux 3.18.0-rc4+ x86_64 GNU/Linux
 * Auteur      : Gabriel-Andrew Pollo Guilbert
 * Création    : 11 Novembre 2014
 */

public class Tableau_5 {
    final static String NOM  = "Élèves";  // constante du nom de l'application
    final static String ERR  = "Annuler"; // constante du code d'erreur si l'utilisateur annule
    final static int INACTIF =  999;

    static int no[]     = { 123,              456,            789,            928,          INACTIF     }; // matricule
    static String nom[] = {"Alice",          "Benoit",       "Claude",       "Diane",      "Emile"      }; // nom
    static String adr[] = {"123 rue Albert", "456 Bellevue", "789 Cloutier", "928 Duclos", "894 Emilien"}; // adresse
    static int notel[]  = { 88,               65,             95,             79,           89          }; // logique
    static int notep[]  = { 86,               60,             90,             78,           89          }; // programmation

    public static void main(String[] args) {
        final String menu[] = {"Quitter", "Visualiser", "Supprimer", "Modifier", "Ajouter"};

        int choix; // contient le choix de l'utilisateur dans le menu

        //boucler tant et aussi longtemps que l'utilisateur n'a pas quitté
        do {
            choix = JOptionPane.showOptionDialog(
                    null, "Quelle action voulez-vous faire?", NOM,
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    menu, menu[0]);

            switch(choix) {
            default:
            case 0: break;
            case 1: view();   break;
            case 2: delete(); break;
            case 3: modify(); break;
            case 4: add();    break;
            }
        } while(choix != 0);

        // quitter le programme
        quit(0);
    }

    /*
     * Cette fonction permet à l'utilisateur de visualier des données.
     */
    private static int view() {
        final String menu[] = {"Precédent", "Moyenne des cours", "Moyenne", "Borne", "Tous", "Étudiant"};

        int choix;      // contient le choix de l'utilisateur dans le menu
        int somme;      // contient la somme pour la moyenne
        int min;        // contient l'index de la pire note logique
        int max;        // contient l'index de la meilleur note logique
        int index;      // contient l'index d'un élève
        int i, j;       // contient des compteurs
        double moyenne; // contient des moyennes

        String input;   // contient la valeur renvoyé par la fonction getNumber()
        String output;  // contient des caractères à afficher
        NumberFormat percent = NumberFormat.getPercentInstance();

        // s'il n'y a pas d'élève, il n'y a rien à voir
        if(isEmpty() == true) return 1;

        //boucler tant et aussi longtemps que l'utilisateur n'a pas fait un choix
        do {
            choix = JOptionPane.showOptionDialog(
                    null, "Que voulez-vous voir?", "Visualiser",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    menu, menu[0]);

            switch(choix) {
            default: // précédent
            case 0: break;

            case 1: // moyenne de tout les étudiants actifs en logique et programmation
                    for(i = j = somme = 0; i < no.length; i++)
                        if(no[i] != INACTIF) {
                            somme += notel[i] + notep[i];
                            j++;
                        }
                    moyenne = (double)somme/(j*2);

                    JOptionPane.showMessageDialog(null, "La moyennes des cours est de "+percent.format((float)moyenne/100)+".");
                    break;

            case 2: // moyenne de tout les étudiants actifs pour les deux cours
                    for(i = j = somme = 0; i < no.length; i++)
                        if(no[i] != INACTIF) {
                            somme += notep[i];
                            j++;
                        }
                    moyenne = (double)somme/j;
                    output = "La moyenne du cours de programmation est de "+percent.format(moyenne/100)+" et ";

                    for(i = j = somme = 0; i < no.length; i++)
                        if(no[i] != INACTIF) {
                            somme += notel[i];
                            j++;
                        }
                    moyenne = (double)somme/j;
                    output += "celle du cours de logique est de "+percent.format(moyenne/100)+".";

                    JOptionPane.showMessageDialog(null, output);
                    break;

            case 3: // meilleur et pire note en programmation
                    for(i = 0, min = max = -1; i < no.length; i++) {
                        if(no[i] != INACTIF) {
                            if(min == -1) min = i;
                            if(max == -1) max = i;

                            if(notel[i] < notel[min])
                                min = i;
                            if(notel[i] > notel[max])
                                max = i;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "En programmation logique, "+nom[min]+" à la plus base note "
                                                       +"avec "+percent.format((float)notel[min]/100)+" et "+nom[max]+" à la meilleur note "
                                                       +"avec "+percent.format((float)notel[max]/100)+".");
                    break;

            case 4: // nom, matricule et notes de tout les étudiants
                    showAll();
                    break;

            case 5: // info d'un étudiant
                    input = getNumber("Entrez le numéro de l'élève:", false, 0, 0);
                    if(input == ERR) break;
                    index = getStudent(Integer.parseInt(input), true);

                    if(index != -1) {
                        output  = "Nom:\t"+nom[index]+"\n";
                        output += "Address:\t"+adr[index]+"\n";
                        output += "Logique:\t"+percent.format((float)notel[index]/100)+"\n";
                        output += "Prog.:\t"+percent.format((float)notep[index]/100);

                        JOptionPane.showMessageDialog(null, new JTextArea(output));
                    }
                    break;
            }
        } while(choix != 0);

        return 0;
    }

    /*
     * Cette fonction permet à l'utilisateur de supprimer un élève.
     */
    private static int delete() {
        int index; // contient l'index d'un élève

        String input; // contient la valeur renvoyé par la fonction getNumber()

        // s'il n'y a pas d'élève, il n'y a rien à enlever
        if(isEmpty() == true) return 1;
        showAll();

        input = getNumber("Veuillez entrer le numéro de l'utilisateur à supprimer:", false, 0, 0);
        if(input == ERR) return 1;
        index = getStudent(Integer.parseInt(input), true);

        if(index != -1)
            if(confirm("Êtes-vous sûre de supprimer "+nom[index]+"?") == true)
                no[index] = INACTIF;

        return 0;
    }

    /*
     * Cette fonction permet à l'utilisateur de modifier des données d'un élève.
     */
    private static int modify() {
        final String menu[] = {"Precédent", "Note Programmation", "Note Logique", "Adresse"};

        int index; // contient l'index d'un élève
        int choix; // contient le choix de l'utilisateur dans le menu

        String input; // contient la valeur renvoyé par la fonction getNumber()

        // s'il n'y a pas d'élève, il n'y a rien à modifier
        if(isEmpty() == true) return 1;
        showAll();

        input = getNumber("Veuillez entrer le numéro de l'utilisateur à modifier:", false, 0, 0);
        if(input == ERR) return 1;
        index = getStudent(Integer.parseInt(input), true);
        if(index == -1) return 1;

        //boucler tant et aussi longtemps que l'utilisateur n'a pas fait un choix
        do {
            choix = JOptionPane.showOptionDialog(
                    null, "Que voulez-vous modifier?", "Modification",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    menu, menu[0]);

            switch(choix) {
            default: // précédent
            case 0: break;

            case 1: // modifier la note de programmation
                input = getNumber("Veuillez entrer la nouvelle note de programmation:", true, 0, 100);
                if(input == ERR) break;

                notep[index] = Integer.parseInt(input);
                JOptionPane.showMessageDialog(null, "La note de programmation a été changée.");
                break;

            case 2: // modifier la note de logique
                input = getNumber("Veuillez entrer la nouvelle note de logique:", true, 0, 100);
                if(input == ERR) break;

                notel[index] = Integer.parseInt(input);
                JOptionPane.showMessageDialog(null, "La note de logique a été changée.");
                break;

            case 3: // modifier l'adresse
                adr[index] = JOptionPane.showInputDialog("veuillez entrer la nouvelle adresse:");
                if(adr[index] == null) break;
                JOptionPane.showMessageDialog(null, "L'address a été changée.");
                break;
            }
        } while(choix != 0);

        return 0;
    }

    /*
     * Cette fonction permet à l'utilisateur d'ajouter à élève, s'il y de la place.
     */
    private static int add() {
        int index;     // contient l'index d'un élève
        int matricule; // contient la matricule du nouvelle élève

        String input; // contient la valeur renvoyé par la fonction getNumber()

        // trouver de la place libre dans le tableau
        index = getStudent(999, false);
        if(index == -1) {
            JOptionPane.showMessageDialog(null, "Il n'y a plus de place.");
            return 1;
        }

        // demander le nom
        nom[index] = JOptionPane.showInputDialog("Veuillez entrer le nom de l'élève:");
        if(nom[index] == null) return 1;

        // demander un numéro de matricule disponible
        do {
            input = getNumber("Veuillez entrer un numéro de matricule pour l'élève:", true, 0, INACTIF-1);
            if(input == ERR) return 1;
            matricule = Integer.parseInt(input);
            if(getStudent(matricule, false) != -1)
                JOptionPane.showMessageDialog(null, "Le numéro #"+matricule+" n'est pas disponible.");
        } while(getStudent(matricule, false) != -1);
        no[index]  = Integer.parseInt(input);

        // demander l'adresse de l'élève
        adr[index] = JOptionPane.showInputDialog("Veuillez entrer l'adresse de l'élève:");
        if(adr[index] == null) return 1;

        // demander la note de programmation
        input = getNumber("Veuillez entrer la note de programmation de l'élève:", true, 0, 100);
        if(input == ERR) return 1;
        notep[index] = Integer.parseInt(input);

        // demander la note de logique
        input = getNumber("Veuillez entrer la note de logique de l'élève:", true, 0, 100);
        if(input == ERR) return 1;
        notel[index] = Integer.parseInt(input);

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
     * Cette fonction retourne l'index d'un étudiant avec la
     * matricule donnée. Si l'étudiant n'existe pas, -1 est
     * renvoyé.
     */
    private static int getStudent(int matricule, boolean msg) {
        int index;
        int i;

        for(i = index = 0; i < no.length; i++)
            if(no[i] == matricule) {
                index = i;
                i = no.length;
            }

        if(i == no.length+1)
            return index;

        if(msg)
            JOptionPane.showMessageDialog(null, "L'élève #"+matricule+" n'existe pas.");
        return -1;
    }

    /*
     * Cette fonction demande à l'utilisateur s'il
     * est sûre son choix.
     */
    private static boolean confirm(String text) {
        final String menu[] = {"Oui", "Non"};

        int choix;

        choix = JOptionPane.showOptionDialog(
                null, text, NOM,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                menu, menu[0]);

        switch(choix) {
        default:
        case 0: return true;
        case 1: return false;
        }
    }

    private static int showAll() {
        int i;

        String output;
        NumberFormat percent = NumberFormat.getPercentInstance();

        output = "Nom\tMatricule\tProg.\tLogique\n";
        for(i = 0; i < no.length; i++)
            if(no[i] != INACTIF) {
                output += nom[i]+"\t#"+no[i]+"\t"+percent.format((float)notep[i]/100)+"\t"+percent.format((float)notel[i]/100);
                if(i < no.length-1)
                    output += "\n";
            }

        JOptionPane.showMessageDialog(null, new JTextArea(output));
        return 0;
    }

    /*
     * Cette fonction regarde si le tableau est vide.
     */
    private static boolean isEmpty() {
        int i;

        for(i = 0; i < no.length; i++)
            if(no[i] != INACTIF)
                i = no.length+1;
        if(i == no.length) {
            JOptionPane.showMessageDialog(null, "Il n'y a pas d'élève.");
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
