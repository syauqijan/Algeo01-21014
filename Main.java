import java.util.Scanner;

import Algoritma.*;
import Matrix.Matrix;
import Utility.Menu;

public class Main {
    public static int pilihan;

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            Menu.mainMenu();
            pilihan = input.nextInt();
            if (pilihan == 1) {SPL();}
            else if (pilihan == 4) {Interpolation();}
            else if (pilihan == 5) {Bicubic();}
            else if (pilihan == 7) {
                System.out.println("    Terima kasih telah menggunakan Matrix Calculator    ");
            }
            else {System.out.println("Program " + pilihan + " tidak ditemukan");}
        } while (pilihan != 7);
    }
    public static void SPL(){
        Menu.splMenu();
    }
    public static void Interpolation() {
        Matrix m;
        double x;
        String fileName;

        Menu.inputMenuType();
        pilihan = input.nextInt();
        if (pilihan == 1) {
            m = new Matrix(0, 0);
            System.out.println("\nMasukkan nama file: ");
            fileName = input.next();
            m.InputFile(fileName);
            System.out.println("");
            m.printMatrix();
        } else {
            System.out.println("\nInput matriks: ");
            m = Interpolasi.inputTitik();
        }
        System.out.println("");
        x = Interpolasi.inputX();
        m = Interpolasi.changedToPolinom(m);

        /*
        Menu.outputMenuType();
        if (pilihan == 1) {

        }
        */

        Interpolasi.solveInterpolasi(m, x);
    }

    public static void Bicubic() {
        Matrix m;
        
        System.out.println("\nInput matriks: ");
        m = Bikubik.inputBicubic();
    }
}
