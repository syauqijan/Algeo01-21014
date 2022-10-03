package Algoritma;
import java.util.Arrays;
import Matrix.Matrix;


public class GaussJordan {


 Matrix m; 
 public GaussJordan(double A[][],double b[]) {
  
  int row=A.length;
  int col=A[0].length;
  
  m = new Matrix(row,col+1);
  for(int i=0;i<row;i++) {
   for(int j=0;j<col;j++) 
        m.pELMT(A[i][j], i, j);    
  }
  
  for(int i=0;i<row;i++) {   
   m.pELMT(b[i], i, col);
  } 
  m.printMatrix();    
 }
 
 public void maxdiagonal() {    
  for(int i=0;i<m.countRow();i++)  
    {
       double mx=0; int mr=i;   
       for (int j=i;j<m.countRow();j++){ 
       if (  Math.abs(m.ELMT(j, i)) > mx ) {
           mx = Math.abs(m.ELMT(j, i));
           mr = j;
        }      
      }       
     if ( mr!=i ) {
        GaussElimination.swapRow(m, i, mr);      
     }
  }
    
 }
 
 public void divbydiag() {  
  for(int i=0;i<m.countRow();i++)  
    {
      double idia = m.ELMT(i, i);    
      for (int j=m.countRow();j<m.countCol();j++){
         m.pELMT(m.ELMT(i, j) / idia, i, j); 
     }    
       m.pELMT(m.ELMT(i, i)/idia, i, i); 
   }
 }
 
 
 public void diagonalize() 
    {      
       for(int i=0;i<m.countRow();i++)
          {             
           for(int r2=0;r2<m.countRow();r2++) {
           if ( i!=r2 ) { 
           double ratio= m.ELMT(r2, i) / m.ELMT(i, i);
           GaussElimination.add(m, i, r2, -ratio);   
           }         
         }
       }     
   }
          
 public double[] solution() {        
  this.maxdiagonal();
   
  this.diagonalize(); 
  
  this.divbydiag();
  
      
  double sol[]=new double[m.countRow()];   
  System.out.println("Unit Diagonal element ");
  m.printMatrix();
  for(int i=0;i<m.countRow();i++)    
        sol[i]= m.ELMT(i,m.countCol()-1);     
  return sol;  
 
 }
 
 public String toString() {
   return m.toString();
 }



 public static void main(String[] args) {
    
    double A[][]= { {1,1,2},{2,-1,1},{1,2,3}};
    double b[]= {4,2,7};
  GaussJordan gj = new GaussJordan(A,b);  
  double sol[] =gj.solution();
  System.out.println( "Solution of Equation" );
  System.out.println(Arrays.toString(sol));      
 }
}