package Algoritma;

import Matrix.Matrix;

public class GaussElimination {
    public static int swapCount;            
    public static double constant;          

    public static void gaussElimination(Matrix m) {
        int i, j, k, iRow, iCol, iLead = 0;
        double coeff;
        swapCount = 0;
        constant = 1;

        if (m.row > m.col-1) {
            m.row = m.col-1;
        }

        for (iRow = 0; iRow < m.col; iRow++) {
            iCol = iRow;
            while (allElmtColUnderIs0(m, iRow, iCol) && (iCol < (m.col-1))) {
                iCol++;
            }
            if (m.data[iRow][iCol] == 0) {
                orderRow(m, iRow, iCol);
            }
            // mengubah elemen baris dibawah berdasar baris-iBrs (referensi)
            if (!((iCol == m.col-1) && allElmtColUnderIs0(m, iRow, iCol))) {
                // jika sudah di kolom terakhir dan elemen kolomnya kebawah adalah 0
                // maka tidak perlu dievaluasi lagi ntuk menghindari NaN
                for (j = iRow+1; j < m.col; j++) {
                    coeff = m.data[j][iCol]/m.data[iRow][iCol];
                    for (k = iCol; k < m.col; k++) {
                        m.data[j][k] -= m.data[iRow][k] * coeff;
                    }
                }
            }
        }

        // Membuat leading one tiap baris (jika elemen baris tidak all 0)
        for(i = 0; i < m.col; i++) {
            if (!allElmtRowIs0(m, i)) {
                while ((iLead < m.col) && (m.data[i][iLead]==0)) {
                    iLead++;
                }
                double factor = m.data[i][iLead];
                constant /= factor;
                for (j=iLead; j<m.col; j++) {
                    if (m.data[i][j] != 0) {
                        m.data[i][j] /= factor;
                    }
                }
            }
        }
    }

    public static void swapRow(Matrix m, int Row1, int Row2) {
        for (int j = 0; j < m.col; j++) {
            double temp = m.data[Row1][j];
            m.data[Row1][j] = m.data[Row2][j];
            m.data[Row2][j] = temp;
        }
        swapCount++;
    }

    public static boolean allElmtColUnderIs0(Matrix m, int iRow, int iCol) {
        // mengirimkan true jika semua elemen kolom iKol pada baris [iBrs...m.baris] adalah 0
        boolean is0 = true;
        int i = iRow;
        while ((i<m.row) && is0) {
            is0 = m.data[i][iCol] == 0;
            i++;
        }
        return is0;
    }

    public static boolean allElmtRowIs0(Matrix m, int idx) {
        // mengirimkan true jika semua elemen baris idx adalah 0
        boolean is0 = true;
        int j = 0;
        while ((j < m.col) && is0) {
            is0 = m.data[idx][j] == 0;
            j++;
        }
        return is0;
    }

    public static void orderRow(Matrix m, int iRow, int iCol) {
        // menukar baris idx jika m[idx][idx]=0 dengan baris lain dibawahnya yang elemennya tidak 0
        int i = iRow+1;
        while (i < m.row) {
            if (m.data[i][iCol] != 0) {
                swapRow(m, iRow, i);
                break;
            }
            i++;
        }
    }
}
