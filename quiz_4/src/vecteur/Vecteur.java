package vecteur;

public class Vecteur {
    final static int[]   vect =  { 1,  7,  8,  4,  9};
    final static int[][] mat  = {{11, 18, 12, 22, 25},
                                 {34, 89, 90, 35, 20},
                                 {12, 22, 67, 56, 88},
                                 {88, 45, 32, 11, 77},
                                 {72, 63, 34, 23, 90},
                                 {28, 73, 11, 26, 66}};

    public static void main(String[] args) {
        int[][] matResult = new int[mat.length][mat[0].length];
        int[][] matTemp;
        int i, j;

        print("Vecteur:");
        printVector(vect);

        print("Matrice:");
        printMatrix(mat);

        for(i = 0; i < vect.length; i++)
            matResult[0][i] = vect[i]+mat[0][i];

        print("Première étape:");
        printMatrix(matResult);

        for(i = 1; i < matResult.length; i++)
            for(j = 0; j < matResult[i].length; j++)
                matResult[i][j] = matResult[i-1][j]+mat[i][j];

        print("Deuxième étape:");
        printMatrix(matResult);

        matTemp = new int[matResult.length][matResult[0].length];
        for(i = 0; i < matResult.length; i++)
            for(j = 0; j < matResult[i].length; j++)
                matTemp[i][j] = matResult[i][j];

        matResult = new int[mat.length+1][mat[0].length];
        for(i = 0; i < matResult.length-1; i++)
            for(j = 0; j < matResult[i].length; j++)
                matResult[i][j] = matTemp[i][j];

        print("Troisième étape:");
        printMatrix(matResult);

        for(i = 0; i < vect.length; i++)
            matResult[matResult.length-1][i] = vect[i];

        print("Quatrième étape:");
        printMatrix(matResult);

        System.exit(0);
    }

    public static void print(String output) {
        System.out.println(output);
    }

    public static void printVector(int[] vect) {
        int i;

        for(i = 0; i < vect.length; i++)
            System.out.print(vect[i]+"\t");
        System.out.print("\n\n");
    }

    public static void printMatrix(int[][] mat) {
        int i, j;

        for(i = 0; i < mat.length; i++) {
            for(j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j]+"\t");
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
