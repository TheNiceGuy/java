package semaine_12;

public class T2D_1 {
    public static void main(String[] args) {
        int matriceA[][] = {{1, 1, 1, 1, 1},
                            {2, 2, 2, 2, 2},
                            {3, 3, 3, 3, 3},
                            {4, 4, 4, 4, 4},
                            {5, 5, 5, 5, 5}};
        int matriceB[][] = new int[matriceA.length][matriceA[0].length];

        int i;
        int j;

        for(i = 0; i < matriceA.length; i++)
            for(j = 0; j < matriceA[i].length; j++)
                matriceB[j][i] = matriceA[i][j];

        for(i = 0; i < matriceA.length; i++) {
            for(j = 0; j < matriceA[i].length; j++)
                System.out.print(matriceA[i][j]+" ");
            System.out.print("\t");

            for(j = 0; j < matriceA[i].length; j++)
                System.out.print(matriceB[i][j]+" ");
            System.out.print("\n");
        }

        System.exit(0);
    }
}
