package Matrix;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.io.*;

public class Matrix {
    private int row, col;
    private double[][] data = null;

    // create empty matrix
    public emptyMatrix() {
        this.row = 0;
        this.col = 0;
    }

    // create and fill in matrix 
    public createMatrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.data = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pELMT(0, i, j)
            }
        }
    }

    // create identity matrix
    public identityMatrix(int x) {
        this.row = x;
        this.col = x;
        this.data = new double [x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (i == j) {
                    pELMT(1, i, j);
                } else {
                    pELMT(0, i, j)
                }
            }
        }
    }

    // create copy matrix
    public void copyMatrix (Matrix m) {
        this.row = m.countRow();
        this.col = m.countCol();
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                pELMT(m.ELMT(i,j), i, j)
            }
        }
    }

    // display matrix
    public void printMatrix() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.print(this.data[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    // return element in matrix
    public double ELMT(int i, int j) {
        return this.data[i][j];
    }

    // return number of rows
    public int countRow() {
        return this.row;
    }

    // return number of columns
    public void countRow() {
        return this.col;
    }

    // set element
    public void pELMT(double x, int row, int col) {
        this.data[row][col] = x;
    }

    // check if matrix is square
    public boolean isSquare() {
        return (this.countRow ==  this.countCol)
    }
}
