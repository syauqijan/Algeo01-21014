package Algoritma;

import java.util.Scanner;

import Matrix.Matrix;

public class Bicubic {
    
    public static Matrix inputBicubic() {

        int i, j;

        Scanner input = new Scanner(System.in);

        Matrix m = new Matrix(4, 2);
        System.out.println("Masukkan pasangan titik-titik: ");
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 2; j++) {
                m.data[i][j] = input.nextDouble();
            }
        }
        return m; 
    }
}
