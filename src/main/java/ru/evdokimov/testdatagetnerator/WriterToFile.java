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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

