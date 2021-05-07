import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
        JSONObject obj = new JSONObject();
        obj.put("Name", "First group");

        JSONArray persons = new JSONArray();
        PersonsGenerator pg = new PersonsGenerator();
        Person personsArray[] = pg.getPersonArray(50);
        for (Person person: personsArray) {
            persons.add(person);
        }
        obj.put("Persons List", persons);
        WriterToFile writer = new WriterToFile("D:\\Projects\\TestGenerator\\src\\main\\resources\\groups.json");
        writer.writeToFile(obj);

    }



}
