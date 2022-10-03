package Algoritma;

import java.util.Scanner;
import Matrix.Matrix;

public class Bikubik {
    
    public static Matrix inputBicubic() {

        int i, j;

        Scanner input = new Scanner(System.in);

        Matrix m = new Matrix(4, 4);
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
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

    public static Matrix Matrix16x16() {

        int i, j, x, y, row, col;

        Matrix m = new Matrix(16, 16);
        row = 0;
        for (j = -1; j <= 2; j++) {
            for (i = -1; i <= 2; i++) {
                col = 0;
                for (y = 0; y <= 3; y++) {
                    for (x = 0; x <= 3; x++) {
                        m.data[row][col] = ((double) Math.pow(i,x) * (double) Math.pow(j, y));
                        col++;
                    }
                }
                row++;
            }
        }
        return m;
    }

    public static Matrix changeMatrixSize() {
        int i, j, row = 0, col = 0;

        Matrix m = new Matrix(16, 1);
        Matrix m1 = Bikubik.inputBicubic();

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                m.data[row][col] = m1.data[i][j];
                row++;
            }
        }
        return m;
    } 
    
    public static void main(String[] args) {
        Matrix16x16().printMatrix();
    }
}

