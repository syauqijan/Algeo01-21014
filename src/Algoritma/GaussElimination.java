package Algoritma;
import Matrix.Matrix;
import java.util.Arrays;


public class GaussElimination {
    Matrix m;
 
 public GaussElimination(double A[][],double b[]) {  
    int row=A.length;
    int col=A[0].length;    
  
    m = new Matrix(row,col+1);
    for(int i=0;i<row;i++) {
     for(int j=0;j<col;j++){
      m.pELMT(A[i][j], i, j);
     } 
              
    }
    
    for(int i=0;i<row;i++) 
     m.pELMT(b[i], i, col);  
}




 public int maxpivot(int j) {
    
  int mr=j; double mx=0;
  for(int i=j;i<m.countRow();i++) 
  { 
   if (   m.ELMT(i, j) > mx ) {
      mx = m.ELMT(i, j);
      mr = i;
   }
  }
  return mr;
 }
  
 public void backsubsitute(int i,double sol[]) {
  
  double val =0;
  for(int j=m.countCol()-2;j>i;j--) {
    val =val +  sol[j] *m.ELMT(i, j);  
  }
  
    val = m.ELMT(i, m.countCol()-1) - val;
    sol[i] = val/m.ELMT(i, i);
          
 }
 /* 
   public static void swapRow(Matrix m, int r1, int r2) {
  
    for (int j = 0; j < m.col; j++) {
        double temp = m.data[r1][j];
        m.data[r1][j] = m.data[r2][j];
        m.data[r2][j] = temp;
    }
 */
     
 public static void add(Matrix m,int r1,int r2,double val) {  
  for (int i=0;i<m.countCol();i++) {
      double tmp=  val*m.ELMT(r1, i);
      m.pELMT(m.ELMT(r2, i)+tmp, r2, i);   
   }
}

/*
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
 */


 public void segitigaatas() {  
  for(int i=0;i<m.countRow()-1;i++) 
    {    
             int mr = this.maxpivot(i);
      if ( mr != i)
      m.swapRow(i, mr);        
      for(int r2=i+1;r2<m.countRow();r2++) 
  {
    double ratio= m.ELMT(r2, i) / m.ELMT(i, i);
    add(m, i, r2, -ratio);
  }
     }    
 }

 
 public double[] solution()
 {      
  double sol[]=new double[m.countRow()];
  System.out.println("Augmented matrix");
  m.printMatrix();
  
  this.segitigaatas();    
           
        for(int i=m.countRow()-1;i>=0;i--) {            
           backsubsitute(i,sol) ;            
     }           
     return sol;
  
 }
// ------------------------------------------------

public static void main(String[] args) {
  

    double A[][]= { {1,1,2},{2,-1,1},{1,2,3}};
    double b[]= {4,2,7};
  GaussElimination  ge= new GaussElimination(A, b);
  double solution[]=ge.solution();
  
  System.out.println("Solution of Equation");
  System.out.println(Arrays.toString(solution));

 }

}