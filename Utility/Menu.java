package Utility;

public class Menu {
    public static void mainMenu() {
        System.out.println("");
        System.out.println("    SELAMAT DATANG DI MATRIX CALCULATOR     ");
        System.out.println("");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks Balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Interpolasi Bicubic");
        System.out.println("6. Regresi Linier Berganda");
        System.out.println("7. BONUS");
        System.out.println("999. Keluar");
        System.out.print("Masukkan pilihan: ");
    }

    public static void splMenu() {
        System.out.println("");
        System.out.println("    PILIH METODE YANG INGIN DIGUNAKAN     ");
        System.out.println("");
        System.out.println("1. Metode Eliminasi Gauss");
        System.out.println("2. Metode Eliminasi Gauss-Jordan");
        System.out.println("3. Metode Matriks Balikan");
        System.out.println("4. Kaidah Cramer");
        System.out.println("0. Kembali");
        System.out.println("999. Keluar");
        System.out.print("Masukkan pilihan: ");
    }

    public static void determinantMenu() {
        System.out.println("");
        System.out.println("    PILIH METODE YANG INGIN DIGUNAKAN     ");
        System.out.println("");
        System.out.println("1. Metode Reduksi Baris");
        System.out.println("2. Metode Ekspansi Kofaktor");
        System.out.println("0. Kembali");
        System.out.println("999. Keluar");
        System.out.print("Masukkan pilihan: ");
    }

    public static void inverseMenu() {
        System.out.println("");
        System.out.println("    PILIH METODE YANG INGIN DIGUNAKAN     ");
        System.out.println("");
        System.out.println("1. Metode Gauss-Jordan");
        System.out.println("2. Matriks Adjoint");
        System.out.println("0. Kembali");
        System.out.println("999. Keluar");
        System.out.print("Masukkan pilihan: ");
    }

    public static void inputMenuType() {
        System.out.println("");
        System.out.println("            Pilih jenis input          ");
        System.out.println("1. File");
        System.out.println("2. Keyboard");
        System.out.println("0. Kembali");
        System.out.println("999. Keluar");
        System.out.print("Masukan pilihan: ");
    }

    public static void outputMenuType() {
        System.out.println("");
        System.out.println("            Pilih jenis output          ");
        System.out.println("1. File");
        System.out.println("2. Keyboard");
        System.out.println("0. Kembali");
        System.out.println("999. Keluar");
        System.out.print("Masukan pilihan: ");
    }

    public static void exitMenu() {
        System.out.println("\nApakah anda ingin kembali ke menu utama? (y/n)");
    }
}
