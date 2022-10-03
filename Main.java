import java.util.Scanner;

import Algoritma.*;
import Matrix.Matrix;
import Utility.Menu;
import java.awt.Desktop;
import Utility.saveFile;
import java.io.File;
import java.io.IOException;

public class Main {
    public static String pilihan;
    public static boolean flag;

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        start();
}
    public static void start() {
        do {
            Menu.mainMenu();
            flag = false;
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    SPL();
                    break;
                case "2":
                    Determinan();
                    break;
                case "3":
                    Inverse();
                    break;
                case "4":
                    Interpolation();
                    break;
                case "5":
                    Bicubic();
                    break;
                case "6":
                    RLB();
                    break;
                case "7":
                    BONUS();
                    break;
                case "999":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
        }
    } while (flag);
    }

    public static void SPL(){
        do {
            flag = false;
            Menu.splMenu();
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    SPLGauss();
                    break;
                case "2":
                    SPLGaussJordan();
                    break;
                case "3":
                    SPLInverse();
                    break;
                case "4":
                    SPLCramer();
                    break;
                case "0":
                    start();
                    break;
                case "999":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while (flag);
        
    }

    public static void Determinan() {
        
        do {
            flag = false;
            Menu.determinantMenu();
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    DetRed();
                    break;
                case "2":
                    DetKof();
                    break;
                case "0":
                    start();
                    break;
                case "999":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while(flag);

    }

    public static void Inverse() {
        do {
            flag = false;
            Menu.inverseMenu();
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    InvGaussJordan();
                    break;
                case "2":
                    InvAdj();
                    break;
                case "0":
                    start();
                    break;
                case "999":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while(flag);
    }

    public static void InvGaussJordan() {

    }

    public static void InvAdj() {
        do {
            flag = false;
            Menu.inputMenuType();
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    InvAdjFinal(1);
                    break;
                case "2":
                    InvAdjFinal(2);
                    break;
                case "0":
                    Inverse();
                    break;
                case "999":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while(flag);
        }

    public static void InvAdjFinal(int i) {
        Matrix m = new Matrix(0,0);
        if (i==1) {
            m.loopInputFile();
        } else {
            m.ScanMatrix(input);
        }
        do {
            flag = false;
            Menu.outputMenuType();
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    saveFile saver = new saveFile();
                    saver.save();
                    m.printInverse();
                    saver.closeFile();
                    break;
                case "2":
                    m.printInverse();
                    break;
                case "0":
                    InvAdj();
                    break;
                case "999":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while (flag);
        exit();
    }

    public static void Interpolation() {
        Matrix m;
        double x;
        String fileName;

        m = new Matrix(0, 0);
        Menu.inputMenuType();
        pilihan = input.nextLine();

        switch (pilihan) {
            case "1":
                System.out.println("\nMasukkan nama file: ");
                fileName = input.nextLine();
                m.InputFile(fileName);
                System.out.println("");
                m.printMatrix();
                break;
            case "2":
                System.out.println("\nInput matriks: ");
                m = Interpolasi.inputTitik();
                break;
            default:
                System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                flag = true;
                break;
        }
        System.out.println("");
        x = Interpolasi.inputX();
        m = Interpolasi.changedToPolinom(m);
        Interpolasi.solveInterpolasi(m, x);
    }

    public static void Bicubic() {
        Matrix m, xy, mInv;
        int i, j, row = 0;
        double fxy = 0;
        
        System.out.println("\nInput matriks: ");
        m = Bikubik.changeMatrixSize();
        xy = Bikubik.inputXY();
        mInv = (Bikubik.Matrix16x16()).Inverse();
        m.Multiply(mInv);

        for (j = 0; j < 4; j++) {
            for (i = 0; i < 4; i++) {
                fxy += m.ELMT(row, 0) * ((double) Math.pow(xy.data[0][0], i)) * ((double) Math.pow(xy.data[1][0], j));
                row++;
            }
        }
        System.out.printf("f(%.4f, %.4f) = %.4f\n",xy.data[0][0] , xy.data[1][0], fxy);
    }

    public static void RLB() {
    }

    public static void SPLGauss() {

    }

    public static void SPLGaussJordan() {

    }

    public static void SPLInverse() {

    }

    public static void SPLCramer() {
        do {
            flag = false;
            Menu.inputMenuType();
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    SPLCramerFinal(1);
                    break;
                case "2":
                    SPLCramerFinal(2);
                    break;
                case "0":
                    SPL();
                    break;
                case "999":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while(flag);
    }

    public static void SPLCramerFinal(int i) {
        Matrix m = new Matrix(0, 0);
        if (i == 1){
            m.loopInputFile();
        } else {
            System.out.println("Masukkan augmented matrix A dan B:");
            m.ScanMatrix(input);
        }
        do {
            flag = false;
            Menu.outputMenuType();
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    saveFile saver = new saveFile();
                    saver.save();
                    Cramer.Solve(m.deleteCol(m.countCol()-1), m.getCol(m.countCol()-1));
                    saver.closeFile();
                    break;
                case "2":
                    Cramer.Solve(m.deleteCol(m.countCol()-1), m.getCol(m.countCol()-1));
                    break;
                case "0":
                    SPLCramer();
                    break;
                case "999":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while (flag);
        exit();
    }

    public static void DetRed() {
        do {
            flag = false;
            Menu.inputMenuType();
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    DetRedFinal(1);
                    break;
                case "2":
                    DetRedFinal(2);
                    break;
                case "0":
                    Determinan();
                    break;
                case "999":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while (flag);
        
    }

    public static void DetRedFinal(int i)  {
        Matrix m = new Matrix(0, 0);
        if (i==1){
            m.loopInputFile();
        } else {
            m.ScanMatrixPersegi(input);
        }
        do {
            flag = false;
            Menu.outputMenuType();
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    saveFile saver = new saveFile();
                    saver.save();
                    m.printDeterminanReduksi();
                    saver.closeFile();
                    break;
                case "2":
                    m.printDeterminanReduksi();
                    break;
                case "0":
                    DetRed();
                    break;
                case "999":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while (flag);
        exit();
    }

    public static void DetKof() {
        do {
            flag = false;
            Menu.inputMenuType();
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    DetKofFinal(1);
                    break;
                case "2":
                    DetKofFinal(2);
                    break;
                case "0":
                    Determinan();
                    break;
                case "999":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while (flag);
        }
    
    public static void DetKofFinal(int i) {
        Matrix m = new Matrix(0, 0);
        if (i==1){
            m.loopInputFile();
        } else {
            m.ScanMatrixPersegi(input);
        }
        do {
            flag = false;
            Menu.outputMenuType();
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    saveFile saver = new saveFile();
                    saver.save();
                    m.printDeterminanKofaktor();
                    saver.closeFile();
                    break;
                case "2":
                    m.printDeterminanKofaktor();
                    break;
                case "0":
                    DetKof();
                    break;
                case "999":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while (flag);
        exit();

    }

    public static void BONUS() {
        try {
            String parent = System.getProperty("user.dir");
            String path = parent+"\\Bonus\\bonus.mp4";
            Desktop.getDesktop().open(new File(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

    public static void exit() {
        do {
            flag = false;
            Menu.exitMenu();
            pilihan = input.nextLine();
            switch (pilihan) {
                case "y":
                    start();
                    break;
                case "n":
                    System.out.println("\nTerima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan ulangi input.");
                    flag = true;
                    break;
            }
        } while (flag);
    }
    }