package Algoritma;
import Matrix.Matrix;

public class Cramer {
    public static void Solve(Matrix A, Matrix B) {
        Matrix res = new Matrix(0,0);
        Matrix temp = new Matrix(0,0);
        double detA = A.Determinan();
        int i;
        res.createMatrix(A.row, 1);
        for (i=0; i<A.row; i++) {
            temp = copyM(A);
            temp.changeCol(i, B);
            res.pELMT(temp.Determinan()/detA, i, 0);
        }
        res.printSPL();
    }

    public static Matrix copyM(Matrix A) {
        Matrix res = new Matrix(0,0);
        res.createMatrix(A.row, A.col);
        int i, j;
        for (i=0; i<A.row; i++) {
            for (j=0; j<A.col; j++) {
                res.pELMT(A.ELMT(i, j), i, j);
            }
        }
        return res;
    }
    }
