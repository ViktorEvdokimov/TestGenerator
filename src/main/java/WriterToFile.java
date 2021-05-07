
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;


public class  WriterToFile {
    private static FileWriter file;
    private final String address;

    public WriterToFile(String address) {
        this.address = address;
    }

    public void writeToFile(JSONObject obj) {
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

