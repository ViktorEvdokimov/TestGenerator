import java.util.Arrays;

public class Group {
    private String name;
    private Person[] persons;

    public Group(String name, Person[] persons) {
        this.name = name;
        this.persons = persons;
    }


    @Override
    public String toString() {
        return "{\n" +
                "name = '" + name + "\',\n" +
                "persons = " + Arrays.toString(persons) + " \n" +
                '}';
    }
}
