package Algoritma;

import java.util.Scanner;
import Matrix.Matrix;

public class Bikubik {
    
    public static Matrix inputBicubic() {

        int i, j;

        Scanner input = new Scanner(System.in);

        Matrix m = new Matrix(4, 4);
        System.out.println("Masukkan pasangan titik-titik: ");
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 2; j++) {
                m.data[i][j] = input.nextDouble();
            }
        }
        return m;
    }

    public static Matrix inputXY() {
        // memasukkan input x yang akan ditaksir

        int j;

        Scanner input = new Scanner(System.in);

        Matrix m = new Matrix(1, 2);
        System.out.println("Masukkan nilai x dan y yang akan ditaksir: ");
        for (j = 0; j < 2; j++) {
            m.data[0][j] = input.nextDouble();
        }
        return m;
    }

    public static void Matrix16x16() {

        int i, j, x, y, row = 0, col = 0;

        Matrix m = new Matrix(16, 16);
        for (i = -1; i <= 2; i++) {
            for (j = -1; j <= 2; j++) {
                for (x = 0; x <= 3; x++) {
                    for (y = 0; y <= 3; y++) {
                        m.data[row][col] = ((double) Math.pow(i,x) * (double) Math.pow(j, y));
                        col++;
                    }
                }
                row++;
            }
        }
    }

    public static void changeMatrixSize() {
        int i, j, row = 0, col = 0;

        Matrix m = new Matrix(16, 1);
        Matrix m1 = Bikubik.inputBicubic();

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                m.data[row][col] = m1.data[i][j];
            }
        }
        row++;
    }
}
