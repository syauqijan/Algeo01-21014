import java.util.Scanner;

import Algoritma.*;
import Matrix.Matrix;
import Utility.Menu;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            Menu.mainMenu();
            pilihan = input.nextInt();

            if (pilihan == 5) {Interpolation();}
            else if (pilihan == 7) {
                System.out.println("    Terima kasih telah menggunakan Matrix Calculator    ");
            }
            else {System.out.println("Operasi " + pilihan + " tidak ditemukan");}
        } while (pilihan != 7);
    }
    

    public static void Interpolation() {
        Matrix m;
        double x;
        
        System.out.println("\nInput matriks: ");
        m = Interpolasi.inputTitik();
        m = Interpolasi.changedToPolinom(m);

        x = Interpolasi.inputX();
        Interpolasi.solveInterpolasi(m, x);
    }
}
