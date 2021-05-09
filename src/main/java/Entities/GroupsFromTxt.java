package Entities;

import java.io.*;

public class GroupsFromTxt extends GroupsGenerator{
    private final String address;

    public GroupsFromTxt(String address) {
        this.address = address;
        File file = new File(address + "Groups.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.length()>1) {
                    names.add(sCurrentLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public Person[] getPerson(int personsQuantity) {
        PersonsGenerator pg = new PersonsFromTxt(address);
        Person[] persons = pg.getPersonArray(personsQuantity);
        return persons;
    }
}
