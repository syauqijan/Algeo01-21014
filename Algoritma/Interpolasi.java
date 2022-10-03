package Algoritma;

import java.util.Scanner;
import Matrix.Matrix;

import Utility.Menu;

public class Interpolasi {

    public static Matrix inputTitik() {
    // memasukkan input titik-titik (x,y) yang diketahui

        int i, j;

        System.out.print("Masukkan jumlah pasangan: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("");
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
    // memasukkan input x yang akan ditaksir
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Masukkan nilai yang akan ditaksir: ");
        double x = input.nextDouble();

        return x;
    }

    public static Matrix changedToPolinom(Matrix m) {
    // mengubah titik-titik menjadi matriks polinom

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

    public static double[] solusiTunggal(Matrix m) {
    // mengeluarkan output solusi tunggal

        double[] result = new double[m.col-1];
        for(int i=m.col-2; i>=0; i--) {
            result[i] = m.data[i][m.col-1];
            for(int j=i+1; j<m.col-1; j++) {
                result[i] -= m.data[i][j]*result[j];
            }
        }
        return result;
    }

    public static void solveInterpolasi(Matrix m, double x) {
        
        double hasilTaksir = 0;
        Matrix n = m;
        OBEInterpolasi.OBE(m);
        double[] result = solusiTunggal(n);

        System.out.println("");
        System.out.print("Penyelesaian sistem persamaan dengan metode eliminasi Gauss menghasilkan: ");
        System.out.println("");
        for (int i=0; i < result.length-1; i++) {
            System.out.format("a(%d) = %.4E, ", i, result[i]);
        }
        System.out.format("a%d = %.4E.\n ", result.length-1, result[result.length-1]);

        System.out.println("");
        System.out.format("Polinom interpolasi yang melalui ke-%d buah titik tersebut adalah p%d(x) =", result.length, result.length-1);
        System.out.println("");
        for (int i=0;i<result.length-1;i++) {
            if (i == 0) {
                System.out.format("%.4E +", result[i]);
            } else {
                System.out.format(" %.4Ex^%d +", result[i], i);
            }
        }
        System.out.format(" %.4E^%d.\n", result[result.length-1], result.length-1);
        
        System.out.println("");
        for (int i=0;i<result.length;i++) {
            hasilTaksir += result[i] * Math.pow(x, i);
        }

        System.out.format("Dengan menggunakan polinom ini, maka nilai fungsi pada x = %.1f dapat ditaksir sebagai berikut: p%d(%.1f) = ", x, result.length-1, x);
        System.out.println("");
        for (int i=0;i<result.length-1;i++) {
            if (i == 0) {
                System.out.format("%.4E +", result[i]);
            } else {
                System.out.format(" %.4E(%.1f)^%d +", result[i], x, i);
            }
        }
        System.out.format(" %.4E(%.1f)^%d = %.4f\n", result[result.length-1], x, result.length-1, hasilTaksir);
    }
}