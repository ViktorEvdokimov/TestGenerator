package Entities;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class GroupsGenerator {

    protected ArrayList<String> names = new ArrayList<>();
    private final String address;

    public GroupsGenerator(String address) {
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


    public Group[] generateGroups(int groupCount, int personCount){
        if (groupCount < 0 || personCount < 0){
            throw new IndexOutOfBoundsException("Quantity should be 0 or positive. Please enter suitable data.");
        }
        if (groupCount == 0){
            throw new IndexOutOfBoundsException("Quantity  of groups should be positive. Please enter suitable data.");
        }
        if(groupCount > names.size()){
            throw new IndexOutOfBoundsException("Quantity of groups more then size of names base. Please add new " +
                    "groups names or enter less groups quantity.");
        }
        Group[] groups = new Group[groupCount];
        int[] nameNumbersArray = getNameNumbersArray(groupCount);
        int[] quantityArray = getQuantityArray(groupCount, personCount);
        for (int i = 0; i < (groupCount); i++) {
            groups[i] = getRandomGroup(quantityArray[i], nameNumbersArray[i]);
        }
        return groups;
    }

    public Group getRandomGroup (int personsQuantity, int nameNumber) {
        Person[] persons = getPerson(personsQuantity);
        String name = names.get(nameNumber);
        return new Group(name, persons);
    }

    public Person[] getPerson(int personsQuantity) {
        PersonsGenerator pg = new PersonsGenerator(address);
        Person[] persons = pg.getPersonArray(personsQuantity);
        return persons;
    }

    protected int[] getNameNumbersArray(int groupCount){
        int[] namesNumbers = new int[groupCount];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i< names.size(); i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<groupCount; i++) {
            namesNumbers[i] = list.get(i);
        }
        return namesNumbers;
    }

    protected int[] getQuantityArray (int groupCount, int personCount){
        int definedPersons = 0;
        int[] quantityArray = new int[groupCount];
        for (int i = 0; i < (groupCount); i++) {
            int thisGroup;
            if (i < (groupCount-1)) {
                thisGroup = (int) (Math.random() * (personCount - definedPersons) * 2/ (groupCount - i));
                if (thisGroup > (personCount - definedPersons)) thisGroup = definedPersons;
            } else thisGroup = personCount - definedPersons;
            definedPersons +=thisGroup;
            quantityArray[i] = thisGroup;
        }
        return quantityArray;
    }
}
