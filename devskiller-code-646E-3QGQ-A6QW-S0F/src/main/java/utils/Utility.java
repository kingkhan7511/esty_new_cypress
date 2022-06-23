package utils;

import Helper.Xls_Reader;

public class Utility {

    public static Xls_Reader reader() {
        String rel = System.getProperty("user.dir") + "\\src\\test\\java\\testData\\test.xlsx";
        Xls_Reader x = new Xls_Reader(rel);
        ;

        return x;
    }
}
