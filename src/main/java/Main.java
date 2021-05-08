import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        GroupsGenerator gg = new GroupsGenerator();
        Group[] groupsArray = gg.generateGroups(20, 500);
        ObjectMapper obj = new ObjectMapper();
        try {
            String result = obj.writeValueAsString(groupsArray);
            WriterToFile writer = new WriterToFile("src/main/resources/groups.json");
            writer.writeToFile(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }



}
