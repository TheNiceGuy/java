package semaine_9;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.text.NumberFormat;

/*
 * Fichier     : Tableau_1.java
 * Project     : Laboratoires sur les tableaux
 * Objectifs   : Système de réservation de billets d'avion
 * Logiciel    : Github Atom, OpenJDK 1.8
 * Plateforme  : Archlinux, Linux 3.18.0-rc2+ x86_64 GNU/Linux
 * Auteur      : Gabriel-Andrew Pollo Guilbert
 * Création    : 15 Novembre 2014
 */

public class Tableau_6 {
    final static String NOM  = "Avion";   // constante du nom de l'application
    final static String ERR  = "Annuler"; // constante du code d'erreur si l'utilisateur annule
    final static int SIEGE   = 10;        // constante du nombre de sièges
    final static int FUMEUR  =  5;        // constante du nombre de sièges fumeurs partant de 0

    // tableau contenant l'état des réservations
    static boolean reservation[] = new boolean[SIEGE];

    public static void main(String[] args) {
        final String menu[] = {"Oui", "Non", "Recommencer"};

        int choix; // contient le choix de l'utilisateur dans le menu

        //boucler tant et aussi longtemps que l'utilisateur n'a pas quitté
        do {
            choix = JOptionPane.showOptionDialog(
                    null, "Voulez-vous reserver un siège?", NOM,
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    menu, menu[0]);

            switch(choix) {
            default: choix = 1; break;
            case 0: session(); break;
            case 1: break;
            case 2: reset(); break;
            }
        } while(choix != 1);

        // quitter le programme
        quit(0);
    }

    private static int session() {
        boolean reponse; // contient la réponse à une question oui/non
        int choix;       // contient la réponse à une boîte de dialog multiple

        String section[] = {"Non-fumeur", "Fumeur"}; // nom des sections disponibles

        // si l'avion est plein, il n'y a aucune réservation de libre
        if(isFull()  == true) return 1;

        // si la section fumeur est pleine, il faut demander pour la section non-fumeur
        else if(isFFull() == true) {
            reponse = ask("Tout les sièges pour fumeurs sont réservés, voulez-vous un siège pour non-fumeur?");
            if(reponse)
                section(false);
            else
                JOptionPane.showMessageDialog(null, "Le départ du prochain vol est dans 4 heures.");
        // si la section non-fumeur est pleine, il faut demander pour la section fumeur
        } else if(isNFull() == true) {
            reponse = ask("Tout les sièges pour non-fumeurs sont réservés, voulez-vous un siège pour fumeur?");
            if(reponse)
                section(true);
            else
                JOptionPane.showMessageDialog(null, "Le départ du prochain vol est dans 4 heures.");
        // si aucune section sont pleines, donner le choix de la section
        } else {
            choix = JOptionPane.showOptionDialog(
                    null, "Quelle section voulez-vous?", NOM,
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    section, section[0]);

            if(choix == 0)
                section(false);
            else
                section(true);
        }

        return 0;
    }

    /*
     * Cette fonction va recommencer la commande, elle affecte une
     * valeur false à tout le tableau.
     */
    private static int reset() {
        int i;

        // si l'avion est déjà vide, pas besoin de recommencer
        if(isEmpty() == true) return 1;

        // s'assurer que l'utilisateur veut recommencer
        if(ask("Êtes-vous sure de vouloir recommencer?") == false) return 1;

        // affecter false au tableau
        for(i = 0; i < reservation.length; i++)
            reservation[i] = false;

        JOptionPane.showMessageDialog(null, "Toute les réservations ont été annulées.");
        return 0;
    }

    /*
     * Cette fonction demande un siège dans la section demandée, soit
     * fumeur ou non-fumeur.
     */
    private static int section(boolean isF) {
        int numero; // contient le numéro du siège réservé

        // si c'est une section fumeur
        if(isF)
            numero = assignSeat(0, FUMEUR);
        // si c'est une section non-fumeur
        else
            numero = assignSeat(FUMEUR, SIEGE);

        // si l'utilisateur annule
        if(numero == -1) return 1;

        // reservé le siège
        reservation[numero-1] = true;
        JOptionPane.showMessageDialog(null, "Vous-avez le siège #"+numero+".");

        return 0;
    }


    /*
     * Cette fonction va créer une liste de siège disponible
     * basée sur une intervalle de siège donnée.
     */
    private static int assignSeat(int min, int max) {
        int choix; // contient la réponse à une boîte de dialog multiple
        int i, j;  // contient des compteurs

        String libre[]; // contient le tableau des sièges disponibles

        // compter le nombre de siège libre dans l'intervalle
        for(i = min, j = 0; i < max; i++)
            if(reservation[i] == false)
                j++;

        // initialiser le tableau de cette grandeur trouvée
        libre = new String[j];

        // créer une liste des numéros de sièges disponibles il faut
        // créer cette liste à l'envers pour une sortie plus logique
        i = j = 0;
        while(i < (max-min)) {
            if(reservation[min+i] == false) {
                libre[libre.length-j-1] = ""+(min+i+1);
                j++;
            }
            i++;
        }

        // demandé quel siège à réserver à partir de la liste
        choix = JOptionPane.showOptionDialog(
                null, "Quelle siège voulez-vous?", NOM,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                libre, libre[0]);

        // si l'utilisateur annule
        if(choix == -1) return -1;

        return Integer.parseInt(libre[choix]);
    }

    /*
     * Cette fonction regarde si toute les sièges pour les
     * fumeurs sont réservés.
     */
    private static boolean isFFull() {
        int i;

        for(i = 0; i < FUMEUR; i++)
            if(reservation[i] == false)
                return false;

        return true;
    }

    /*
     * Cette fonction regarde si toute les sièges pour les
     * non-fumeurs sont réservés.
     */
    private static boolean isNFull() {
        int i;

        for(i = FUMEUR; i < SIEGE; i++)
            if(reservation[i] == false)
                return false;

        return true;
    }

    /*
     * Cette fonction regarde si toute les sièges sont réservés.
     */
    private static boolean isFull() {
        int i;

        for(i = 0; i < SIEGE; i++)
            if(reservation[i] == false)
                return false;

        JOptionPane.showMessageDialog(null, "Tout les sièges sont déjà occupés.");
        return true;
    }

    /*
     * Cette fonction regarde si toute les sièges sont vides.
     */
    private static boolean isEmpty() {
        int i;

        for(i = 0; i < SIEGE; i++)
            if(reservation[i] == true)
                return false;

        JOptionPane.showMessageDialog(null, "Il n'y a aucune réservation pour l'instant.");
        return true;
    }

    /*
     * Cette fonction demande une question oui ou non.
     */
    private static boolean ask(String text) {
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

    /*
    * Si le programme doit se terminer en renvoyant une erreur
    * et sans qu'il plante, cette fonction est utilisé.
    */
    private static void quit(int code) {
        System.exit(code);
    }
}
