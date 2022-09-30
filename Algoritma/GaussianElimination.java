package Algoritma;
import Matrix.Matrix;
import java.util.Arrays;

public class GaussianElimination {

 Matrix m;
 
 public GaussianElimination(double A[][],double b[]) {  
  int row=A.length;
  int col=A[0].length;
  
  m = new Matrix(row,col+1);
  for(int i=0;i<row;i++) {
   for(int j=0;j<col;j++) 
        m.pELMT(A[i][j], i, j);    
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
 public static void swapRow(Matrix m, int Row1, int Row2) {
  
  for (int j = 0; j < m.col; j++) {
      double temp = m.data[Row1][j];
      m.data[Row1][j] = m.data[Row2][j];
      m.data[Row2][j] = temp;
  }
  
}     
 public static void add(Matrix mat,int r2,int r1,double val) {  
  for (int n=0;n<mat.countCol();n++) {
      double tmp=  val*mat.ELMT(r1, n);
      mat.pELMT(mat.ELMT(r2, n)+tmp, r2, n);   
   }
}
 public void uppertriangular() {  
  for(int i=0;i<m.countRow()-1;i++) 
    {    
             int mr = this.maxpivot(i);
      if ( mr != i)
      swapRow(m, i, mr);        
      for(int r2=i+1;r2<m.countRow();r2++) 
  {
    double ratio= m.ELMT(r2, i) / m.ELMT(i, i);
    add(m, r2, i, -ratio);
  }
     }    
 }

 
 public double[] solution()
 {      
  double sol[]=new double[m.countRow()];
  System.out.println("Augmented mrix");
  System.out.println(m.toString());
  
  this.uppertriangular();    
           System.out.println("Upper Triangular mrix");
  System.out.println(m.toString());
     
        for(int i=m.countRow()-1;i>=0;i--) {            
           backsubsitute(i,sol) ;            
     }           
     return sol;
  
 }
   
 public static void main(String[] args) {
  
  double A[][]= { {2,3,-1},{4,4,-3},{-2,3,-1}};
  double b[]= {5,3,1};
  
  GaussianElimination  ge= new GaussianElimination(A,b);
  double solution[]=ge.solution();
  
  System.out.println("Solution of Equation");
  System.out.println(Arrays.toString(solution));

 }

}
 