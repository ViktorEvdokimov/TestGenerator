import Entities.Group;
import Entities.GroupsGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {
    public static void main(String[] args) {
        createJsonFile("src/main/resources/Data/", 25, 500);
    }

    public static void createJsonFile (String address, int groupCount, int personCount){
        GroupsGenerator gg = new GroupsGenerator(address);
        Group[] groupsArray = gg.generateGroups(groupCount, personCount);
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
