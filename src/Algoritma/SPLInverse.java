package Algoritma;

import Matrix.Matrix;

public class SPLInverse {
    public static void Solve(Matrix A, Matrix B) {
        if (!A.isSquare()) {
            System.out.println("Matriks tidak memiliki balikan karena bukan matriks persegi, sehingga SPL tidak dapat diselesaikan menggunakan metode ini.");
        } else if (A.Determinan() == 0) {
            System.out.println("Determinan matriks adalah 0, sehingga matriks tidak memiliki balikan. SPL tidak dapat diselesaikan menggunakan metode ini.");
        } else {
            Matrix inv;
            inv = A.Inverse();
            inv.Multiply(B);
            inv.printSPL();
        }
    }
    }
    
