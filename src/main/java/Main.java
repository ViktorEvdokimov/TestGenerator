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
        persons.add("Person: Vasya");
        persons.add("Person: Ivan");
        persons.add("Person: Masha");
        obj.put("Persons List", persons);
        WriterToFile.writeToFile(obj);

    }



}
