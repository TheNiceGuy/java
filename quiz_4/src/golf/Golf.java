package golf;

import javax.swing.JOptionPane;

public class Golf {
    final static String SERR = "";
    final static int    IERR = -1;
    final static int    IAGE = 12;
    final static int    AMIN = 12;
    final static int    AMAX = 17;

                            // age = 12 13 14 15 16 17
    final static int[][] NORMALES = {{6, 5, 5, 4, 4, 4},  // trou 1
                                     {5, 4, 4, 4, 4, 4},  // trou 2
                                     {6, 5, 5, 4, 4, 4},  // trou 3
                                     {5, 4, 5, 4, 3, 3},  // trou 4
                                     {4, 3, 3, 3, 3, 3},  // trou 5
                                     {6, 6, 5, 4, 3, 2},  // trou 6
                                     {5, 4, 4, 4, 4, 3},  // trou 7
                                     {4, 3, 3, 3, 3, 3},  // trou 8
                                     {5, 4, 4, 3, 3, 3}}; // trou 9

    public static void main(String[] args) {
        int i, j;
        int age;
        int nombre = 0;

        String nom;
        String output;

        do {
            while((nom = getString("Veuillez entrer le nom du golfeur:")) == SERR) {
                if(confirm("Voulez-vous quitter?"))
                    break;
            }
            if(nom == SERR) break;

            while((age = getInt("Veuillez entrer l'âge du golfeur:", true)) == IERR) {
                if(confirm("Voulez-vous quitter?"))
                    break;
            }
            if(age == IERR) break;

            output = nom+" a "+age+" ans.\n";

            for(i = 0; i < NORMALES.length; i++) {
                while((nombre = getInt("Veuillez entrer le score du trou "+(i+1)+":", false)) == IERR) {
                    if(confirm("Voulez-vous quitter?"))
                        break;
                }
                if(nombre == IERR) break;

                output += "Trou "+(i+1)+" Score "+nombre+" ";
                if(nombre < NORMALES[i][age-IAGE])
                    output += "sous la normale\n";
                else if(nombre == NORMALES[i][age-IAGE])
                    output += "normale\n";
                else
                    output += "au-dessus de la normale\n";
            }
            if(nombre == IERR) break;

            log(output);

        } while(confirm("Voulez-vous comparer le score d'un autre golfeur?"));

        System.exit(0);
    }

    // fonction qui demande un String, retourne SERR si la saisie est annuler
    public static String getString(String message) {
        String input;

        while((input = JOptionPane.showInputDialog(message)) != null)
            if(input != SERR)
                return input;

        return SERR;
    }

    // fonction qui demande un integer, retourne IERR si la saisie est annuler
    public static int getInt(String message, boolean borne) {
        int nombre;
        String input;

        while((input = JOptionPane.showInputDialog(message)) != null) {
            try {
                nombre = Integer.parseInt(input);
                if(borne) {
                    if(nombre >= AMIN && nombre <= AMAX)
                        return nombre;
                    else
                        log("La personne ne fait pas partie des âges analysées.");
                } else if(nombre >= 0)
                    return nombre;
            } catch(NumberFormatException err) {}
        }

        return IERR;
    }

    // fonction qui demande une question oui ou non
    public static boolean confirm(String message) {
        final String menu[] = {"Non", "Oui"};

        int choix = JOptionPane.showOptionDialog(
                    null, message, "Golf",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);

        switch(choix) {
        default:
        case 0:
            return false;
        case 1:
            return true;
        }
    }

    // fonction qui simplifie l'écriture
    public static void log(String input) {
        JOptionPane.showMessageDialog(null, input);
    }
}
