package semaine_12;

public class T2D_4 {
    public static void main(String[] args) {
        int matriceA[][] = {{1, 1, 1, 1},
                            {2, 2, 2, 2},
                            {3, 3, 3, 3}};
        int matriceB[][] = {{1, 2, 3},
                            {1, 2, 3},
                            {1, 2, 3},
                            {1, 2, 3}};
        int vecteurAB[]  = new int[matriceA.length];

        int i;
        int j;
        int x;
        int y;
        int sommei;
        int sommej;

        for(i = 0; i < matriceA.length; i++) {
            sommei = 0;
            sommej = 0;

            for(j = 0; j < matriceA[i].length; j++) {
                sommei += matriceA[i][j];
                sommej += matriceB[j][i];
            }

            vecteurAB[i] = sommei*sommej;
        }

        System.out.print(  "Matrice A:\n");
        for(i = 0; i < matriceA.length; i++) {
            for(j = 0; j < matriceA[i].length; j++)
                System.out.print(matriceA[i][j]+" ");
            System.out.print("\n");
        }

        System.out.print("\nMatrice B:\n");
        for(i = 0; i < matriceB.length; i++) {
            for(j = 0; j < matriceB[i].length; j++)
                System.out.print(matriceB[i][j]+" ");
            System.out.print("\n");
        }

        System.out.print("\nVecteur AB:\n");
        for(i = 0; i < vecteurAB.length; i++) {
            System.out.print(vecteurAB[i]+" ");
        }
        System.out.print("\n");

        System.exit(0);
    }
}
