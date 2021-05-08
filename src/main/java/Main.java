import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();

        JSONArray groups = new JSONArray();
        GroupsGenerator gg = new GroupsGenerator();
        Group[] groupsArray = gg.generateGroups(10, 50);
        for (Group group: groupsArray) {
            groups.add(group);
        }
        obj.put("Groups List: ", groups);
        WriterToFile writer = new WriterToFile("D:\\Projects\\TestGenerator\\src\\main\\resources\\groups.json");
        writer.writeToFile(obj);

    }



}
