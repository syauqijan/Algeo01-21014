package Algoritma;

import Matrix.Matrix;

public class OBEInterpolasi {

    public static void OBE(Matrix m) {
        int row, col, i, j, k, n;
        double faktor, koefisien;

        for (row = 0; row < m.row; row++) {
            col = row;
            while (elmtCol0(m,row,col) && (col<(m.col-1))) {
                col++;
            }
            if (m.data[row][col] == 0) {
                Matrix.orderRow(m, row, col);
            }

            for(i = 0; i < m.row; i++) {
                if (!elmtRow0(m, i)) {
                    k = 0;
                    while (k < m.col && m.data[i][k] == 0) {
                        k++;
                    }
                    faktor = m.data[i][k];
                    for (j = k; j < m.col; j++) {
                        if (m.data[i][j] != 0) {
                            m.data[i][j] /= faktor;
                        }
                    }
                }
            }
                
            for (n = 1; n < m.row; n++) {
                for (i = row+n; i < m.row; i++) {
                    if ((col != m.col-1) && !elmtCol0(m, row, row)) {
                        koefisien = m.data[i][row] / m.data[row][row];
                        for (j = col; j<m.col; j++) {
                        
                                
                            m.data[i][j] -= koefisien * m.data[row][j];
                        }
                    }
                        
                }
            } 
        }
    
        for (row = 1; row < m.row; row++) {
            col = row;
            for (i=0; i<row; i++) {
                if (m.data[i][row] != 0) {
                    koefisien = m.data[i][row] / m.data[row][row];
                    for (j=col; j<m.col; j++) {
                        m.data[i][j] -= koefisien * m.data[row][j]; 
                    }
                }
            } 
        }
    }
    
    public static boolean elmtRow0(Matrix m, int idx) {
        boolean is0 = true;
        int j = 0;
        while ((j < m.col) && is0) {
            is0 = m.data[idx][j] == 0;
            j++;
        }
        return is0;
    }
    
    public static boolean elmtCol0(Matrix m, int row, int col) {
        boolean is0 = true;
        int i=row;
        while ((i < m.row) && is0) {
            is0 = m.data[i][col] == 0;
            i++;
        }
        return is0;
    }
}
