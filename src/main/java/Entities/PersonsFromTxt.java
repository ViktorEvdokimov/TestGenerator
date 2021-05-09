package Entities;

import java.io.*;
import java.util.ArrayList;

public class PersonsFromTxt extends PersonsGenerator {
    private final String address;

    public PersonsFromTxt(String address) {
        this.address = address;
        putToList("ManFirstName.txt", manLastNames);
        putToList("ManLastName.txt", manFirstNames);
        putToList("ManPatronymic.txt", manPatronymics);
        putToList("WomanFirstName.txt", womanLastNames);
        putToList("WomanLastName.txt", womanFirstNames);
        putToList("WomanPatronymic.txt", womanPatronymics);
        putToList("streets.txt", streets);
    }

    private void putToList (String fileName, ArrayList target){
        File file = new File(address + fileName);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.length()>1) {
                    target.add(sCurrentLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
