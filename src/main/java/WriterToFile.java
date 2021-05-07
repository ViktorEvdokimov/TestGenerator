
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;


public class  WriterToFile {
    private static FileWriter file;
    private static final String address = "D:\\Projects\\TestGenerator\\src\\main\\resources\\groups.json";

    public static void writeToFile(JSONObject obj) {
        try {

            file = new FileWriter(address);
            file.write(obj.toJSONString());

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

