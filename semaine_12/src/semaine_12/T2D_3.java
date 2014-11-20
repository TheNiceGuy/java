package semaine_12;

public class T2D_3 {
    public static void main(String[] args) {
        int matriceA[][] = {{ 1,  2,  3,  4,  5},
                            { 6,  7,  8,  9, 10},
                            {11, 12, 13, 14, 15}};
        int matriceX[]   = new int[matriceA.length];
        int matriceY[]   = new int[matriceA[0].length];

        int i;
        int j;

        for(i = 0; i < matriceA.length; i++) {
            matriceX[i] = 0;

            for(j = 0; j < matriceA[0].length; j++)
                matriceX[i] += matriceA[i][j];
        }

        for(j = 0; j < matriceA[0].length; j++) {
            matriceY[j] = 0;

            for(i = 0; i < matriceA.length; i++) {
                matriceY[j] += matriceA[i][j];
            }
        }

        for(i = 0; i < matriceA.length; i++) {
            for(j = 0; j < matriceA[i].length; j++) {
                System.out.print(matriceA[i][j]+"\t");
                if(j == matriceA[i].length-1)
                    System.out.print("= "+matriceX[i]);
            }
            System.out.print("\n");
        }

        for(i = 0; i < matriceA[0].length; i++)
            System.out.print("=\t");
        System.out.print("\n");

        for(i = 0; i < matriceA[0].length; i++)
            System.out.print(matriceY[i]+"\t");
        System.out.print("\n");

        System.exit(0);
    }
}
