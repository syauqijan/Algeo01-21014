package Main;
import Algoritma.*;
import Matrix.*;

public class Main {
    public static void main(String[] args) {
        Matrix m, b;
        m = new Matrix(0,0);
        b = new Matrix(0,0);
        m.ScanMatrixPersegi();
        b.createMatrix(3, 1);
        b.pELMT(5, 0, 0);
        b.pELMT(3, 1, 0);
        b.pELMT(1, 2, 0);
        Cramer.Solve(m, b);
    }

}
