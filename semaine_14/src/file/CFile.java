package file;

public class CFile {
    public static final char CERR = ' ';
    public static final int  IERR = 1;

    private final int SIZE = 5;

    private char[] file;
    private int pointer;

    // fonction de création de l'objet sans paramètre
    public CFile() {
        init(SIZE);
    }

    // fonction de création de l'objet
    public CFile(int size) {
        init(size);
    }

    // fonction d'initialisation
    private void init(int size) {
        file = new char[size];
        pointer = 0;
    }

    // fonction qui réinitialise la file
    public void reset() {
        pointer = 0;
    }

    // fonction qui ajoute un caractère à la file
    public int add(char c) {
        file[pointer] = c;
        pointer++;

        return 0;
    }

    // fonction qui obtient le prochaine caractère de la file
    public char next() {
        char output;
        int i;

        output = file[0];

        for(i = 1; i < file.length; i++) {
            file[i-1] = file[i];
        }
        pointer--;

        return output;
    }

    // fonction qui retourne la taille actuelle de la file
    public int size() {
        return pointer;
    }

    // fonction qui écrit la file
    public String print() {
        int i;
        String output = "";

        for(i = 0; i < pointer; i++)
            output += "["+file[i]+"] ";
        for(; i < file.length; i++)
            output += "[  ] ";

        return output;
    }

    // fonction qui regarde si la file est vide
    public boolean isEmpty() {
        if(pointer == 0)
            return true;
        return false;
    }

    // fonction qui regarde si la file est pleine
    public boolean isFull() {
        if(pointer == file.length)
            return true;
        return false;
    }
}
