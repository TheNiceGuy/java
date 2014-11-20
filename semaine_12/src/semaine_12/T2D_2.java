package semaine_12;

public class T2D_2 {
    public static void main(String[] args) {
        final int X = 3;
        final int Y = 3;

        int vecteurA[]   = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int matriceB[][] = new int[X][Y];

        int i;
        int j;

        for(i = 0; i < X; i++)
            for(j = 0; j < Y; j++)
                matriceB[i][j] = vecteurA[i*X+j];

        for(i = 0; i < X; i++) {
            for(j = 0; j < Y; j++)
                System.out.print(matriceB[i][j]+" ");
            System.out.print("\n");
        }

        System.exit(0);
    }
}
