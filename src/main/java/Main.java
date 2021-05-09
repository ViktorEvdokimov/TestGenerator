import Entities.Group;
import Entities.GroupsFromDB;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

//        JsonGenerator.getJsonFile(
//                "jdbc:mysql://localhost:3306/groups_and_persons?useUnicode=true&serverTimezone=UTC",
//                "root", "root", 25, 500);

        JsonGenerator.getJsonFile("src/main/resources/Data/", 25, 500);

    }



}
