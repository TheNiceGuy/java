package pile;

public class CPile {
    public static final char CERR = ' ';
    public static final int  IERR = 1;

    private final int SIZE = 5;

    private char[] pile;
    private int pointer;

    // fonction de création de l'objet sans paramètre
    public CPile() {
        init(SIZE);
    }

    // fonction de création de l'objet
    public CPile(int size) {
        init(size);
    }

    // fonction d'initialisation
    private void init(int size) {
        pile = new char[size];
        pointer = 0;
    }

    // fonction qui réinitialise la pile
    public void reset() {
        pointer = 0;
    }

    // fonction qui ajoute un caractère à la pile
    public int add(char c) {
        pile[pointer] = c;
        pointer++;

        return 0;
    }

    // fonction qui obtient le prochaine caractère de la pile
    public char next() {
        char output;
        int i;

        output = pile[pointer-1];
        pointer--;

        return output;
    }

    // fonction qui retourne la taille actuelle de la pile
    public int size() {
        return pointer;
    }

    // fonction qui écrit la pile
    public String print() {
        int i;
        String output = "";

        for(i = 0; i < pointer; i++)
            output += "["+pile[i]+"] ";
        for(; i < pile.length; i++)
            output += "[  ] ";

        return output;
    }

    // fonction qui regarde si la pile est vide
    public boolean isEmpty() {
        if(pointer == 0)
            return true;
        return false;
    }

    // fonction qui regarde si la pile est pleine
    public boolean isFull() {
        if(pointer == pile.length)
            return true;
        return false;
    }
}
