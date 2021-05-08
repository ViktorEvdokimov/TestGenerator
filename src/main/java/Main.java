import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        GroupsGenerator gg = new GroupsGenerator();
        Group[] groupsArray = gg.generateGroups(10, 50);
        ObjectMapper obj = new ObjectMapper();
        try {
            String result = obj.writeValueAsString(groupsArray);
            WriterToFile writer = new WriterToFile("D:\\Projects\\TestGenerator\\src\\main\\resources\\groups.json");
            writer.writeToFile(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }



}
