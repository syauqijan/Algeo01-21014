package Algoritma;

import java.util.Scanner;

import Matrix.Matrix;

public class Interpolasi {

    public static Matrix inputTitik() {
    // memasukkan input titik-titik yang diketahui

        int i, j;

        System.out.print("Masukkan jumlah pasangan: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        Matrix m = new Matrix(n, 2);
        System.out.println("Masukkan pasangan titik-titik: ");
        for (i = 0; i < n; i++) {
            for (j = 0; j < 2; j++) {
                m.data[i][j] = input.nextDouble();
            }
        }
        return m; 
    }

    public static double inputX() {

        System.out.println("Masukkan nilai yang akan ditaksir: ");
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();

        return x;
    }

    public static Matrix changedToPolinom(Matrix m) {

        int i,j;
        Matrix m1 = new Matrix(m.row, (m.row + 1));

        for (i = 0; i < m.row; i++) {
            for (j = 0; j < m.row; j++) {
                m1.pELMT(Math.pow(m.data[i][0], j), i, j);
            }
            m1.pELMT(m.data[i][1], i, m.row);
        }
        return m1;
    }

    public static void solveInterpolasi(Matrix m, double x) {
        
        double hasilTaksir = 0;
        Matrix n = m;
        
        // nunggu algoritmanya gauss
    }
}