package Matrix;

import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.io.InputStreamReader;


public class Matrix {
    public int row, col;
    public double[][] data = null;

    // constructor
    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.data = new double[row][col];
    }

    // create and fill in matrix 
    public void createMatrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.data = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pELMT(0, i, j);
            }
        }
    }

    public void ScanMatrix(Scanner scan) {
            System.out.println("Matrix berukuran baris x kolom.");
            System.out.print("Masukkan jumlah baris: ");
            int m = scan.nextInt();
            System.out.print("Masukkan jumlah kolom: ");
            int n = scan.nextInt();
            this.createMatrix(m, n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    double x = scan.nextDouble();
                    pELMT(x, i, j);
                }
            }
        }

    public void ScanMatrixPersegi(Scanner scan) {
            System.out.print("Masukkan ukuran matriks persegi: ");
            int n = scan.nextInt();
            this.createMatrix(n, n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double x = scan.nextDouble();
                    this.pELMT(x, i, j);
                }
        }
    }

    public void ScanMatrixB(Scanner scan) {
            System.out.print("Masukkan jumlah baris: ");
            int n = scan.nextInt();
            this.createMatrix(1, n);
            for (int i = 0; i < n; i++) {
                double x = scan.nextDouble();
                pELMT(x, 0, i);
            }
        }

    /* 
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
    */


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
            System.out.println();
        }
    }

    // print SPL
    public void printSPL() {
        System.out.println("Solusi SPL:");
        for (int i = 0; i < this.countRow(); i++) {
            System.out.println("x"+(i+1)+" = " + this.data[i][0]);
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

    public boolean isFileExist(String namefile) {
        String parent = System.getProperty("user.dir");
        String path = parent + "\\test\\" + namefile;
        File file = new File(path);
        return file.exists();
    }

    public void loopInputFile() {
        System.out.println("\nMasukkan nama file: ");
        BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));
        String nameFile;
        try {
            nameFile = scn.readLine();
            while(!isFileExist(nameFile) || nameFile.equals("")) {
                System.out.println("File tidak ditemukan.");
                System.out.println("\nMasukkan nama file: ");
                nameFile = scn.readLine();
            } this.InputFile(nameFile);
            } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        }
        


    public void InputFile(String namefile) {
        String parent = System.getProperty("user.dir");
        String path = parent + "\\test\\" + namefile;
        File file = new File(path);
        try {
            Scanner source = new Scanner(file);
            int n = 0;
            int m = 0;
            while (source.hasNextLine()){
                n = (source.nextLine().trim().split(" ")).length;
                m++;
            }
            source.close();
            this.createMatrix(m, n);
            source = new Scanner(file);
            for (int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    double x = source.nextFloat();
                    this.pELMT(x, i, j);
                }
            }
            source.close();
            System.out.println("File berhasil dibaca.");
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan.");

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
    public boolean isSquare() {
        return (this.row ==  this.col);
    }

    // mereturn matrix tanpa kolom col
    public Matrix deleteCol(int col) {
        Matrix res = new Matrix(this.row, this.col-1);
        res.createMatrix(this.row, this.col-1);
        int i, j;
        for (i=0; i<this.row; i++) {
            for (j=0; j<col; j++) {
                res.pELMT(this.ELMT(i, j), i, j);
            }
            for (j=col+1; j<this.col; j++) {
                res.pELMT(this.ELMT(i, j), i, j-1);
            }
        }
        return res;
    }

    // mereturn matrix dari kolom col
    public Matrix getCol(int col) {
        Matrix m = new Matrix(this.row, 1);
        m.createMatrix(this.row, 1);
        for (int i = 0; i < this.row; i++) {
            m.pELMT(this.ELMT(i, col), i, 0);
        }
        return m;
    }

    // penggantian kolom i dengan matrix m, prekondisi: matrix m berkolom 1
    public void changeCol(int i, Matrix m) {
        for (int j = 0; j < this.row; j++) {
            this.pELMT(m.ELMT(j, 0), j, i);
        }
    }

    public void MultiplySkalar(double x) {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                this.data[i][j] *= x;
            }
        }
    }

    // mengalikan matrix dengan matrix m
    public void Multiply(Matrix m) {
        if (this.col == m.row) {
            Matrix temp = new Matrix(this.row, m.countCol());
            temp.createMatrix(this.row, m.countCol());
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < m.countCol(); j++) {
                    double sum = 0;
                    for (int k = 0; k < this.col; k++) {
                        sum += this.data[i][k] * m.ELMT(k, j);
                    }
                    temp.pELMT(sum, i, j);
                }
            }
            this.copyMatrix(temp);
        } else {
            System.out.println("Matrix tidak dapat dikalikan karena ukuran tidak sesuai.");
        }
    }

    public void printDeterminan() {
        if (this.isSquare()) {
            System.out.println("Hasil determinan: " + this.Determinan());
        } else {
            System.out.println("Determinan tidak dapat dihitung karena bukan matriks persegi.");
        }
    }

    // menghitung determinan matrix
    public double Determinan() {
        // KAMUS LOKAL
        double det = 0;
        int i, j, k;
        Matrix temp;
        // ALGORITMA
            if (this.row == 1) {
                return this.ELMT(0,0);
            } else if (this.row == 2) {
                return (this.ELMT(0,0) * this.ELMT(1,1)) - (this.ELMT(0,1) * this.ELMT(1,0));
            } else {
                det = 0;
                for (i = 0; i < this.row; i++) {
                    temp = new Matrix(this.row - 1, this.col - 1);
                    temp.createMatrix(this.row - 1, this.col - 1);
                    for (j = 1; j < this.row; j++) {
                        for (k = 0; k < this.col; k++) {
                            if (k < i) {
                                temp.pELMT(this.ELMT(j,k), j - 1, k);
                            } else if (k > i) {
                                temp.pELMT(this.ELMT(j,k), j - 1, k - 1);
                            }
                        }
                    }
                    det += Math.pow(-1, i) * this.ELMT(0,i) * temp.Determinan();
                }
                return det;
            }
    } 

    // mengetahui matrix adjoin
    public Matrix Adjoin() {
        // KAMUS LOKAL
        Matrix temp;
        Matrix adj;
        int i, j, k, l;
        // ALGORITMA
        if (this.isSquare()) {
            adj = new Matrix(this.row, this.col);
            adj.createMatrix(this.row, this.col);
            for (i = 0; i < this.row; i++) {
                for (j = 0; j < this.col; j++) {
                    temp = new Matrix(this.row - 1, this.col - 1);
                    temp.createMatrix(this.row - 1, this.col - 1);
                    for (k = 0; k < this.row; k++) {
                        for (l = 0; l < this.col; l++) {
                            if (k < i && l < j) {
                                temp.pELMT(this.ELMT(k,l), k, l);
                            } else if (k < i && l > j) {
                                temp.pELMT(this.ELMT(k,l), k, l - 1);
                            } else if (k > i && l < j) {
                                temp.pELMT(this.ELMT(k,l), k - 1, l);
                            } else if (k > i && l > j) {
                                temp.pELMT(this.ELMT(k,l), k - 1, l - 1);
                            }
                        }
                    }
                    adj.pELMT(Math.pow(-1, i + j) * temp.Determinan(), i, j);
                }
            }
            return adj;
        } else {
            System.out.println("Matriks bukan persegi");
            return null;
        }
    }

    public void Transpose() {
        // KAMUS LOKAL
        Matrix temp = new Matrix(this.col, this.row);
        int i, j;
        // ALGORITMA
        temp.createMatrix(this.col, this.row);
        for (i = 0; i < this.row; i++) {
            for (j = 0; j < this.col; j++) {
                temp.pELMT(this.ELMT(i,j), j, i);
            }
        }
        this.copyMatrix(temp);
    }

    // mengetahui inverse matrix
    public Matrix Inverse() {
        // KAMUS LOKAL
        Matrix inv;
        double det;
        // ALGORITMA
        det = this.Determinan();
            inv = this.Adjoin();
            inv.Transpose();
            inv.MultiplySkalar(1 / det);
            return inv;
    }

    public void printInverse() {
        if (!this.isSquare()) {
            System.out.println("Matriks tidak memiliki balikan karena bukan matriks persegi.");
        } else if (this.Determinan() == 0) {
            System.out.println("Determinan matriks adalah 0, sehingga matriks tidak memiliki balikan.");
        } else {
            this.Inverse().printMatrix();
        }
    }

    public void printDeterminanKofaktor() { 
        if (this.isSquare()) {
            System.out.println("Hasil determinan: "+this.DeterminanKofaktor());
        } else {
            System.out.println("Determinan tidak dapat dihitung karena bukan matriks persegi.");
        }
    }

    // mencari determinan matrix dengan kofaktor
    public double DeterminanKofaktor() {
        // KAMUS LOKAL
        double det = 0;
        int i, j, k;
        Matrix temp;
        // ALGORITMA
            if (this.row == 1) {
                return this.ELMT(0,0);
            } else if (this.row == 2) {
                return (this.ELMT(0,0) * this.ELMT(1,1)) - (this.ELMT(0,1) * this.ELMT(1,0));
            } else {
                det = 0;
                for (i = 0; i < this.row; i++) {
                    temp = new Matrix(this.row - 1, this.col - 1);
                    temp.createMatrix(this.row - 1, this.col - 1);
                    for (j = 1; j < this.row; j++) {
                        for (k = 0; k < this.col; k++) {
                            if (k < i) {
                                temp.pELMT(this.ELMT(j,k), j - 1, k);
                            } else if (k > i) {
                                temp.pELMT(this.ELMT(j,k), j - 1, k - 1);
                            }
                        }
                    }
                    det += Math.pow(-1, i) * this.ELMT(0,i) * temp.DeterminanKofaktor();
                }
                return det;
            }
    }

    // swap row matrix
    public void swapRow(int row1, int row2) {
        // KAMUS LOKAL
        double temp;
        int i;
        // ALGORITMA
        for (i = 0; i < this.col; i++) {
            temp = this.ELMT(row1,i);
            this.pELMT(this.ELMT(row2,i), row1, i);
            this.pELMT(temp, row2, i);
        }
    }

    public static void orderRow(Matrix m, int iRow, int iCol) {
        // menukar baris idx jika m[idx][idx]=0 dengan baris lain dibawahnya yang elemennya tidak 0
        int i = iRow+1;
        while (i < m.row) {
            if (m.data[i][iCol] != 0) {
                m.swapRow(iRow, i);
                break;
            }
            i++;
        }
    }

    // swap col matrix
    public void swapCol(int col1, int col2) {
        // KAMUS LOKAL
        double temp;
        int i;
        // ALGORITMA
        for (i = 0; i < this.row; i++) {
            temp = this.ELMT(i,col1);
            this.pELMT(this.ELMT(i,col2), i, col1);
            this.pELMT(temp, i, col2);
        }
    }

    // mengalikan baris matrix dengan skalar
    public void multiplyRow(int row, double multiplier) {
        // KAMUS LOKAL
        int i;
        // ALGORITMA
        for (i = 0; i < this.col; i++) {
            this.pELMT(this.ELMT(row,i) * multiplier, row, i);
        }
    }


    public void addMultipleRow(int row1, int row2, double multiplier) {
        // KAMUS LOKAL
        int i;
        // ALGORITMA
        for (i = 0; i < this.col; i++) {
            this.pELMT(this.ELMT(row1,i) + (this.ELMT(row2,i) * multiplier), row1, i);
        }
    }

    public void printDeterminanReduksi() { 
        if (this.isSquare()) {
            System.out.println("\nHasil determinan: "+this.DeterminanReduksi());
        } else {
            System.out.println("Determinan tidak dapat dihitung karena bukan matriks persegi.");
        }
    }

    public double DeterminanReduksi(){
        // KAMUS LOKAL
        int i, j, k, n, a;
        double det, total, n1, n2, n3, temp;
        // ALGORITMA
        n = countRow();
        det = 1;
        total = 1;

        for (i = 0; i<n; i++) {
            a = i;

            while (a < n && ELMT(a, i) == 0) {
                a++;
            }
            if (a == n) {
                return 0;
            }

        // Swap baris
        
            if (a != i) {
                for (j = 0; j < n; j++) {
                    temp = ELMT(i, j);
                    pELMT(ELMT(a, j), i, j);
                    pELMT(temp, a, j);
                }
                det = det * Math.pow(-1, a - i);
            }

            for (j = i+1; j<n; j++) {
                n1 = ELMT(i, i);
                n2 = ELMT(j, i);
    
                for (k=0; k<n; k++) {
                    n3 = (n1*ELMT(j, k)) - (n2*ELMT(i, k));
                    pELMT(n3, j, k);
                }
    
                total *= n1;
            }
        }
    
        // menghitung determinan
        for (i = 0; i<n;i++) {
            det *= ELMT(i, i);
        }

        return (det/total);
    }

    public void printInverseGaussJordan() {
        if (this.isSquare()) {
            this.InverseGaussJordan();
            if (!this.isAnyNaNInf()) {
                this.printMatrix();
            } else {
                System.out.println("Matriks tidak memiliki balikan karena tidak dapat menghasilkan matriks identitas setelah dilakukan operasi OBE.");
            }
        } else {     
            System.out.println("Matriks tidak memiliki balikan karena bukan matriks persegi.");
        }
        }

    public boolean isAnyNaNInf() {
        int n = countRow();
        for (int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (Double.isNaN(this.ELMT(i, j)) || Double.isInfinite(this.ELMT(i, j))) {
                    return true;
                }
            }
        } return false;
    }

    public void InverseGaussJordan() {
        // KAMUS LOKAL
        int i, j, n;
        double temp;
        // ALGORITMA
        n = countRow();
        Matrix tempMatrix = new Matrix(n, n);
        tempMatrix.createMatrix(n, n);
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                tempMatrix.pELMT(ELMT(i, j), i, j);
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i == j) {
                    pELMT(1, i, j);
                } else {
                    pELMT(0, i, j);
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (tempMatrix.ELMT(i, i) == 0) {
                for (j = i + 1; j < n; j++) {
                    if (tempMatrix.ELMT(j, i) != 0) {
                        tempMatrix.swapRow(i, j);
                        this.swapRow(i, j);
                        break;
                    }
                }
            }

            temp = tempMatrix.ELMT(i, i);
            tempMatrix.multiplyRow(i, 1/temp);
            this.multiplyRow(i, 1/temp);

            for (j = 0; j < n; j++) {
                if (j != i) {
                    temp = tempMatrix.ELMT(j, i);
                    tempMatrix.addMultipleRow(j, i, -temp);
                    this.addMultipleRow(j, i, -temp);
                }
            }
        }
    }
/*
    // tes inputfile
    public static void main(String[] args) throws IOException {
        Matrix m = new Matrix(0, 0);
        m.loopInputFile();
        m.printMatrix();
    }
*/

}