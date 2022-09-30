package Utility;

import java.io.File;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.PrintStream;


public class saveFile {
    public PrintStream stream;
    public File file;

    public static final String DATE_FORMAT_NOW = "yyyy_MM_dd_HH_mm_ss";
    public static String now() {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    return sdf.format(cal.getTime());
    }

    public void save() throws IOException {
        String tanggal = now();
        this.file = new File("test\\output\\output_"+tanggal+".txt");
        this.stream = new PrintStream(file);
        System.out.println("Isi file yang akan disimpan:\n");
        System.setOut(this.stream);
    }

    public void closeFile() throws IOException {
        System.out.println();
        System.out.println("Berhasil menyimpan output sebagai "+ (this.file).getName());
        this.stream.close();
    }
    
    }

