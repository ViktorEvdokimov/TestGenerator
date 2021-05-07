
public class PersonsGenerator {
    private String[] lastNames = new String[] {"Ivanov", "Petrov", "Sidorov", "Hohlov", "Vasilev"};
    private String[] firstNames = new String[] {"Niklai", "Ivan", "Viktor"};
    private String[] patronymics = new String[] {"Sergeevich", "Anatolyevich", "Georgevich", "Stanislavovich"};
    private String[] streets = new String[] {"Lenin str. ", "50 years VLKSM str. ", "Sunrise str. "};

    public Person[] getPersonArray (int quantity){
        Person persons[] = new Person[quantity];
        for (int i = 0; i < quantity; i++) {
            String lastName = lastNames[(int) (Math.random()*lastNames.length)];
            String firstName = firstNames[(int) (Math.random()*firstNames.length)];
            String patronymic = patronymics[(int) (Math.random()* patronymics.length)];
            String address = streets[(int) (Math.random()* streets.length)] +
                    (int)(Math.random()* 50) + " house " + (int)(Math.random()* 200) + " flat";
            long phoneNumber = 89000000000l + ((long) (Math.random()* 999999999));
            int GUID = i+1;
            persons[i] = new Person(firstName, lastName, patronymic, address, phoneNumber, GUID);
        }
        return persons;
    }
}
