package semaine_12;

public class T2D_5 {
    public static void main(String[] args) {
        int vecteurA[]   = {5,
                            2,
                            4,
                            3,
                            2};
        int matriceB[][] = {{10, 15, 20},
                            {30, 20, 10},
                            {10, 15, 20},
                            {30, 20, 20},
                            {10, 20, 10}};
        int matriceR[][] = new int[matriceB.length][matriceB[0].length];

        int i;
        int j;

        for(i = 0; i < vecteurA.length; i++)
            for(j = 0; j < matriceR[i].length; j++)
                matriceR[i][j] = vecteurA[i]*matriceB[i][j];

        for(i = 0; i < matriceR.length; i++) {
            for(j = 0; j < matriceR[i].length; j++)
                System.out.print(matriceR[i][j]+" ");
            System.out.print("\n");
        }

        System.exit(0);
    }
}
