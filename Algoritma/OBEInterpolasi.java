package Algoritma;

import Matrix.Matrix;

public class OBEInterpolasi {

    public static void OBE(Matrix m) {
        int row, col, i, j, n, iLead;
        for (row = 0; row < m.row; row++) {
            col = row;
            while (allElmtColUnderIs0(m,row,col) && (col<(m.col-1))) {
                col++;
            }
            if (m.data[row][col] == 0) {
                Matrix.orderRow(m, row, col);
            }

            for(i = 0; i < m.row; i++) {
                if (!allElmtRowIs0(m, i)) {
                    iLead=0;
                    while (iLead < m.col && m.data[i][iLead] == 0) {
                        iLead++;
                    }
                    double factor = m.data[i][iLead];
                    for (j = iLead; j < m.col; j++) {
                        if (m.data[i][j] != 0) {
                            m.data[i][j] /= factor;
                        }
                    }
                }
            }
                
            for (n = 1; n < m.row; n++) {
                for (i = row+n; i < m.row; i++) {
                    if ((col != m.col-1) && !allElmtColUnderIs0(m, row, row)) {
                        double coeff = m.data[i][row] / m.data[row][row];
                        for (j = col; j<m.col; j++) {
                        
                                
                            m.data[i][j] -= coeff * m.data[row][j];
                        }
                    }
                        
                }
            } 
        }
    
        for (row = 1; row < m.row; row++) {
            col = row;
            for (i=0; i<row; i++) {
                if (m.data[i][row] != 0) {
                    double coeff = m.data[i][row] / m.data[row][row];
                    for (j=col; j<m.col; j++) {
                        m.data[i][j] -= coeff * m.data[row][j]; 
                    }
                }
            } 
        }
    }
    
    public static boolean allElmtRowIs0(Matrix m, int idx) {
        boolean is0 = true;
        int j = 0;
        while ((j < m.col) && is0) {
            is0 = m.data[idx][j] == 0;
            j++;
        }
        return is0;
    }
    
    public static boolean allElmtColUnderIs0(Matrix m, int row, int col) {
        boolean is0 = true;
        int i=row;
        while ((i < m.row) && is0) {
            is0 = m.data[i][col] == 0;
            i++;
        }
        return is0;
    }
}
