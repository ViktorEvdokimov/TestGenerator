import Entities.Group;
import Entities.GroupsFromDB;
import Entities.GroupsFromTxt;
import Entities.GroupsGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonGenerator {

    private static Group[] groupsArray;



    public static void getJsonFile (String url, String user, String pass, int groupCount, int personCount){
        GroupsGenerator gg = new GroupsFromDB(url, user, pass);
        groupsArray = gg.generateGroups(groupCount, personCount);
        writeToFile();

    }

    public static void getJsonFile (String address, int groupCount, int personCount){
        GroupsGenerator gg = new GroupsFromTxt(address);
        groupsArray = gg.generateGroups(groupCount, personCount);
        writeToFile();
    }

    private static void writeToFile(){
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
