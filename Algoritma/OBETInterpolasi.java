package Algoritma;

import Matrix.Matrix;

public class OBETInterpolasi {

    public static void gaussJordanElimination(Matrix m) {// transversal setiap baris
        for (int iBrs=0; iBrs<m.row;iBrs++) {
            int iKol = iBrs;
            while (allElmtColUnderIs0(m,iBrs,iKol) && (iKol<m.col-1)) {
                iKol++;
            }
            if (m.data[iBrs][iKol] == 0) {
                OBEInterpolasi.orderRow(m, iBrs, iKol);
            }

            for(int i=0; i<m.row; i++) {
                if (!OBEInterpolasi.allElmtRowIs0(m, i)) {
                    int iLead=0;
                    while (iLead<m.col && m.data[i][iLead]==0) {
                        iLead++;
                    }
                    double factor = m.data[i][iLead];
                    for (int j=iLead; j<m.col; j++) {
                        if (m.data[i][j] != 0) {
                            m.data[i][j] /= factor;
                        }
                    }
                }
            }
                
            // untuk baris di bawah m.baris
            for (int n=1;n<m.row;n++) {
                for (int i=iBrs+n; i<m.row; i++) {
                    if ((iKol !=m.col-1) && !OBEInterpolasi.allElmtColUnderIs0(m,iBrs,iBrs)) {
                    // if ((m.ELMT[iBrs+1][iBrs] != 0) && (iKol !=m.kolom-1)) {
                        double coeff = m.data[i][iBrs] / m.data[iBrs][iBrs];
                        for (int j=iKol; j<m.col; j++) {
                        
                                
                            m.data[i][j] -= coeff * m.data[iBrs][j];
                        }
                    }
                        
                }
            } 
        }
    
        for (int iBrs=1; iBrs<m.row;iBrs++) {
            int iKol = iBrs;
            for (int i=0; i<iBrs; i++) {
                if (m.data[i][iBrs] != 0) {
                    double coeff = m.data[i][iBrs] / m.data[iBrs][iBrs];
                    for (int j=iKol; j<m.col; j++) {
                        m.data[i][j] -= coeff * m.data[iBrs][j]; 
                    }
                }
            } 
        }
    }
    
    public static boolean allElmtColUnderIs0(Matrix m, int iBrs, int iKol) {
        // mengirimkan true jika semua elemen kolom iKol pada baris [iBrs...m.baris] adalah 0
        boolean is0 = true;
        int i=iBrs;
        while (i<m.row && is0) {
            is0 = m.data[i][iKol] == 0;
            i++;
        }
        return is0;
    }
    
}
