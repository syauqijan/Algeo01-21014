package Algoritma;

import Matrix.Matrix;

public class SPLInverse {
    public static void Solve(Matrix A, Matrix B) {
        Matrix inv;
        inv = A.Inverse();
        inv.Multiply(B);
        inv.printSPL();
    }
    }
    
