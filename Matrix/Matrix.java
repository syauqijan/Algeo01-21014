package Matrix;

public class Matrix {
    public int row, col;
    public double[][] data = null;

<<<<<<< HEAD
    // create empty matrix
    public void emptyMatrix() {
        this.row = 0;
        this.col = 0;
    }

    // create and fill in matrix 
    public  void createMatrix(int row, int col) {
=======
    // constructor
    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.data = new double[row][col];
    }

    // create and fill in matrix 
    public void createMatrix(int row, int col) {
>>>>>>> a5c200e45b4e459160cdb57e144796071bc69dc7
        this.row = row;
        this.col = col;
        this.data = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pELMT(0, i, j);
            }
        }
    }

    // create identity matrix
    public void identityMatrix(int x) {
        this.row = x;
        this.col = x;
        this.data = new double [x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (i == j) {
                    pELMT(1, i, j);
                } else {
                    pELMT(0, i, j);
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
                pELMT(m.ELMT(i,j), i, j);
            }
        }
    }

    // display matrix
    public void printMatrix() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.printf("%.2f", this.data[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static void printSPLSolution(double[] result) {
        for (int i=0; i<result.length; i++) {
            System.out.printf("x%d = %.4f\n",i+1, result[i]);
        }
    }
    
    
    public static void printSPLSolution(String[] result) {
        for (int i=0; i<result.length; i++) {
            System.out.printf("x%d = %s\n", i+1, result[i]);
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
    public int countCol() {
        return this.col;
    }

    // set element
    public void pELMT(double x, int row, int col) {
        this.data[row][col] = x;
    }

    // check if matrix is square
<<<<<<< HEAD
    public boolean isSquare(Matrix m) {
        return (m.countRow() ==  m.countCol());
=======
    public boolean isSquare() {
        return (this.row ==  this.col);
>>>>>>> a5c200e45b4e459160cdb57e144796071bc69dc7
    }
}
