package pile;

import pile.CPile;
import javax.swing.JOptionPane;

public class Pile {
    public static void main(String[] args) {
        final String menu[] = {"Quitter", "Réinitialiser", "Visualiser", "Taille", "Supprimer", "Ajouter"};

        char input;
        int choix;
        int taille;

        CPile pile = new CPile();

        do {
            choix = JOptionPane.showOptionDialog(
                    null, "Quelle action voulez-vous faire?", "Pile",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    menu, menu[0]);

            switch(choix) {
            case 1:
                // réinitialiser la pile
                pile.reset();
                log("La pile vient d'être réinitialisée.");
                break;
            case 2:
                // écrire la pile
                log("La pile contient:\n"+pile.print());
                break;
            case 3:
                // écrire la taille de la pile
                taille = pile.size();
                log("Il y a "+taille+" "+(taille>1?"éléments":"élément")+" dans la pile.");
                break;
            case 4:
                // supprimer le prochain caractère de la pile
                if(pile.isEmpty()) {
                    log("La pile est vide.");
                    break;
                }

                input = pile.next();

                log("Le caractère '"+input+"' vient d'être supprimé à la pile.");
                break;
            case 5:
                // ajouter un caractère à la pile
                if(pile.isFull()) {
                    log("La pile est pleine.");
                    break;
                }

                input = getChar();
                if(input == CPile.CERR) {
                    log("Aucun caractère n'a été ajouté.");
                    break;
                }

                pile.add(input);

                log("Le caractère '"+input+"' vient d'être ajouté à la pile.");
                break;
            default:
                choix = 0;
            }
        } while(choix != 0);

        System.exit(0);
    }

    // fonction qui obtient un caractère de l'utilisateur
    // une erreur est renvoyé s'il annule la saisie
    public static char getChar() {
        String input;

        do {
            input = JOptionPane.showInputDialog("Veillez entrer une lettre:");
            if(input == null)
                return CPile.CERR;
            else if(input.length() > 0 &&
                    input.charAt(0) == ' ')
                input = "  ";
        } while(input.length() != 1);

        return input.charAt(0);
    }

    // fonction qui simplifie l'écriture
    public static void log(String input) {
        JOptionPane.showMessageDialog(null, input);
    }
}
