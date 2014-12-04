package file;

import file.CFile;
import javax.swing.JOptionPane;

public class File {
    public static void main(String[] args) {
        final String menu[] = {"Quitter", "Réinitialiser", "Visualiser", "Taille", "Supprimer", "Ajouter"};

        char input;
        int choix;
        int taille;

        CFile file = new CFile();

        do {
            choix = JOptionPane.showOptionDialog(
                    null, "Quelle action voulez-vous faire?", "File",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    menu, menu[0]);

            switch(choix) {
            case 1:
                // réinitialiser la file
                file.reset();
                log("La file vient d'être réinitialisée.");
                break;
            case 2:
                // écrire la file
                log("La file contient:\n"+file.print());
                break;
            case 3:
                // écrire la taille de la file
                taille = file.size();
                log("Il y a "+taille+" "+(taille>1?"éléments":"élément")+" dans la file.");
                break;
            case 4:
                // supprimer le prochain caractère de la file
                if(file.isEmpty()) {
                    log("La file est vide.");
                    break;
                }

                input = file.next();

                log("Le caractère '"+input+"' vient d'être supprimé à la file.");
                break;
            case 5:
                // ajouter un caractère à la file
                if(file.isFull()) {
                    log("La file est pleine.");
                    break;
                }

                input = getChar();
                if(input == CFile.CERR) {
                    log("Aucun caractère n'a été ajouté.");
                    break;
                }

                file.add(input);

                log("Le caractère '"+input+"' vient d'être ajouté à la file.");
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
                return CFile.CERR;
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
