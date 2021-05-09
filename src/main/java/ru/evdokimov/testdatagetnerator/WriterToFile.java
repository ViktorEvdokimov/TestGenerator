package ru.evdokimov.testdatagetnerator;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URISyntaxException;


public class  WriterToFile {
    private static File file;
    private BufferedWriter writer;
    private final String address;

    public WriterToFile(String address) {
        this.address = address;
    }

    public void writeToFile(String object) {
        try {

            File f = new File(address);
            FileUtils.writeStringToFile(f, object, "UTF-8");

//            file = new File(address);
//            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
//            char[] obj = object.toCharArray();
//            for (char symbol: obj) {
////                writer.write(symbol);
//                printWriter.print(symbol);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

