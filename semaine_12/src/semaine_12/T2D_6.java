package semaine_12;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class T2D_6 {
    final static int X = 3;
    final static int Y = 3;

    final static boolean[][] MTS = {{false, false, false},
                                    { true, false, false},
                                    { true,  true, false}};
    final static boolean[][] MTI = {{false,  true,  true},
                                    {false, false,  true},
                                    {false, false, false}};
    final static boolean[][] MI3 = {{false,  true,  true},
                                    { true, false,  true},
                                    { true,  true, false}};

    public static void main(String[] args) {
        int matrice[][] = new int[X][Y];
        int i;
        int j;

        String input;
        String print;

        for(i = 0; i < X; i++) {
            for(j = 0; j < Y; j++) {
                print = printMatrice(matrice);
                input = JOptionPane.showInputDialog(new JTextArea(print+"\nVeuillez entrer le nombre à la position ["+(j+1)+","+(X-i)+"]"));
                if(input == null)
                    System.exit(1);
                else
                    try {
                        matrice[i][j] = Integer.parseInt(input);
                    } catch(NumberFormatException except) {
                        matrice[i][j] = 0;
                    }
            }
        }
        print = printMatrice(matrice);

        JOptionPane.showMessageDialog(null, new JTextArea(matrice[0][0]+"\n\t"+
                                                          matrice[1][1]+"\n\t\t"+
                                                          matrice[2][2]+"\n\n"+
                                                          "Ces valeurs font partie de la diagonale principale."));

        JOptionPane.showMessageDialog(null, new JTextArea("\t\t"+matrice[0][2]+
                                                          "\n\t"+matrice[1][1]+
                                                          "\n"+matrice[2][0]+
                                                          "\n\nCes valeurs font partie de la diagonale secondaire."));

        for(i = 0; i < X; i++) {
            for(j = 0; j < Y; j++) {
                if((MTS[i][j] ==  true && matrice[i][j] != 0) ||
                   (MTS[i][j] == false && matrice[i][j] == 0)) {
                    i = X;
                    j = Y;
                }
            }
        }
        if(i == X+1)
            JOptionPane.showMessageDialog(null, new JTextArea(print+"\nCe n'est pas une matrice triangulaire supérieure."));
        else
            JOptionPane.showMessageDialog(null, new JTextArea(print+"\nC'est une matrice triangulaire supérieure."));

        for(i = 0; i < X; i++) {
            for(j = 0; j < Y; j++) {
                if((MTI[i][j] ==  true && matrice[i][j] != 0) ||
                   (MTI[i][j] == false && matrice[i][j] == 0)) {
                    i = X;
                    j = Y;
                }
            }
        }
        if(i == X+1)
            JOptionPane.showMessageDialog(null, new JTextArea(print+"\nCe n'est pas une matrice triangulaire inférieure."));
        else
            JOptionPane.showMessageDialog(null, new JTextArea(print+"\nC'est une matrice triangulaire inférieure."));

        for(i = 0; i < X; i++) {
            for(j = 0; j < Y; j++) {
                if((MI3[i][j] ==  true && matrice[i][j] != 0) ||
                   (MI3[i][j] == false && matrice[i][j] == 0)) {
                    i = X;
                    j = Y;
                }
            }
        }
        if(i == X+1)
            JOptionPane.showMessageDialog(null, new JTextArea(print+"\nCe n'est pas une matrice d'identité d'ordre 3."));
        else
            JOptionPane.showMessageDialog(null, new JTextArea(print+"\nC'est une matrice d'identité d'ordre 3."));
    }

    private static String printMatrice(int matrice[][]) {
        int i;
        int j;

        String output = "";

        for(i = 0; i < X; i++) {
            for(j = 0; j < Y; j++) {
                output += ""+matrice[i][j];
                if(j < Y-1)
                    output += "\t";
            }
            output += "\n";
        }

        return output;
    }
}
