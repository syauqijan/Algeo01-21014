package Algoritma;
import java.util.Arrays;
import java.util.Scanner;

import Matrix.Matrix;


public class GaussJordan {


 Matrix m; 
 public GaussJordan(Matrix A, Matrix b) {
  
  m = new Matrix(A.row,A.col+1);
  for(int i=0;i<A.row;i++) {
   for(int j=0;j<A.col;j++) 
        m.pELMT(A.data[i][j], i, j);    
  }
  
  for(int i=0;i<A.row;i++) {   
   m.pELMT(b.data[i][0], i, A.col);
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
        m.swapRow(i, mr);      
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

 public static Matrix inputTitik() {
  // memasukkan input titik-titik (x,y) yang diketahui

      int i, j;

      System.out.print("Masukkan jumlah baris matriks : ");
      Scanner input = new Scanner(System.in);
      int row = input.nextInt();
      System.out.println("");
      System.out.print("Masukkan jumlah kolom matriks : ");
      int col = input.nextInt();
      System.out.println("");
      Matrix m = new Matrix(row,col);
      System.out.println("Masukkan matriks : ");
      for (i = 0; i < row; i++) {
          for (j = 0; j < col; j++) {
              m.data[i][j] = input.nextDouble();
          }
      }
      return m; 
  }

  public static Matrix inputHasil(Matrix A) {
    // memasukkan input titik-titik (x,y) yang diketahui

        int i, j;

        Matrix b = new Matrix(A.row, 1);
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan hasil: ");
        for (i = 0; i < A.row; i++) {
            for (j = 0; j < 1; j++) {
                b.data[i][j] = input.nextDouble();
            }
        }
        return b; 
    }

 public static void main(String[] args) {
    
  Matrix A = inputTitik();
  Matrix b = inputHasil(A);
  GaussJordan gj = new GaussJordan(A,b);  
  double sol[] =gj.solution();
  System.out.println( "Solution of Equation" );
  System.out.println(Arrays.toString(sol));      
 }
}