package Algoritma;

import java.util.Scanner;
import Matrix.Matrix;

public class Bikubik {

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
        m.InverseGaussJordan();
        return m;
    }

    public static Matrix changeMatrixSize() {
        int i, j, row = 0;

        Matrix m1 = new Matrix(0,0);
        Matrix m = new Matrix(16, 1);
        m1.loopInputFile();

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                m.data[row][0] = m1.data[i][j];
                row++;
            }
        }
        return m1;
    } 
    
    public static void main(String[] args) {
        Matrix m = changeMatrixSize();
        m.printMatrix();
    }
}

