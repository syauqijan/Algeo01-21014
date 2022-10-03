package Utility;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.PrintStream;


public class saveFile {
    public File file;

    public static final String DATE_FORMAT_NOW = "yyyy_MM_dd_HH_mm_ss";
    public static String now() {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    return sdf.format(cal.getTime());
    }


    public void save()  {
        try {
            String tanggal = now();
            this.file = new File("test\\output\\output_"+tanggal+".txt");
            PrintStream printStream = new PrintStream(this.file);
            System.setOut(printStream);
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
        }
    }

    public void closeFile()  {
        PrintStream consoleStream = new PrintStream(
            new FileOutputStream(FileDescriptor.out));
        System.setOut(consoleStream);
        System.out.println("Berhasil menyimpan file sebagai "+this.file.getName());
    }
}

