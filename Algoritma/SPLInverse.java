package Algoritma;
import Matrix.Matrix;

public class SPLInverse {
    public static void Solve(Matrix I, Matrix B) {
        I.Multiply(B);
        I.printSPL();
    }



    }
