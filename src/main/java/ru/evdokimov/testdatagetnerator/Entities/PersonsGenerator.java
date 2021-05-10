package ru.evdokimov.testdatagetnerator.Entities;

import java.io.*;
import java.util.ArrayList;


public class PersonsGenerator {
    protected ArrayList<String> manLastNames = new ArrayList<String>();
    protected ArrayList<String> manFirstNames = new ArrayList<String>();
    protected ArrayList<String> manPatronymics = new ArrayList<String>();
    protected ArrayList<String> womanLastNames = new ArrayList<String>();
    protected ArrayList<String> womanFirstNames = new ArrayList<String>();
    protected ArrayList<String> womanPatronymics = new ArrayList<String>();
    protected ArrayList<String> streets = new ArrayList<String>();
    private final String address;

    /** Во время создания обьекта считываются мужские и женские ФИО (из отдельных файлов), и названия улиц из файла
     * и записываются в коллекцию **/
    public PersonsGenerator(String address) {
        this.address = address;
        putToList("ManFirstName.txt", manFirstNames);
        putToList("ManLastName.txt", manLastNames);
        putToList("ManPatronymic.txt", manPatronymics);
        putToList("WomanFirstName.txt", womanFirstNames);
        putToList("WomanLastName.txt", womanLastNames);
        putToList("WomanPatronymic.txt", womanPatronymics);
        putToList("streets.txt", streets);
    }

    /** Создание массива из "quantity" персон **/
    public Person[] getPersonArray (int quantity){
        if (quantity < 0){
            throw new IndexOutOfBoundsException("Quantity should be 0 or positive. Please enter suitable data.");
        }
        Person persons[] = new Person[quantity];
        for (int i = 0; i < quantity; i++) {
            persons[i] = getRandomPerson();
        }
        return persons;
    }

    /** Создание случайной персоны. Сначала случайно выбирается пол, затем, в зависимости от пола, случайным образом
     * назначаются фамилия, имя, отчество, название улицы из коллекций. Номер дома случайное число от 1 до 50, квартира
     * от 1 до 200. GUID назначается в конструкторе класса "Person" **/
    public Person getRandomPerson (){
        String lastName;
        String firstName;
        String patronymic;
        if(Math.random()>0.5) {
            lastName = manLastNames.get((int) (Math.random() * manLastNames.size()));
            firstName = manFirstNames.get((int) (Math.random() * manFirstNames.size()));
            patronymic = manPatronymics.get((int) (Math.random() * manPatronymics.size()));
        } else {
            lastName = womanLastNames.get((int) (Math.random() * womanLastNames.size()));
            firstName = womanFirstNames.get((int) (Math.random() * womanFirstNames.size()));
            patronymic = womanPatronymics.get((int) (Math.random() * womanPatronymics.size()));
        }
        String address = streets.get((int) (Math.random()*streets.size())) + ' ' +
                (int)(Math.random() * 49 + 1) + " дом " + (int)(Math.random() * 199 + 1) + " квартира";
        long phoneNumber = 89000000000l + ((long) (Math.random()* 999999999));
        return new Person(firstName, lastName, patronymic, address, phoneNumber);
    }

    /** Данные из файла "fileName" записываются в коллекцию "target" **/
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
