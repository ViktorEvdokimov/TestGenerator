
import java.io.FileWriter;
import java.io.IOException;


public class  WriterToFile {
    private static FileWriter file;
    private final String address;

    public WriterToFile(String address) {
        this.address = address;
    }

    public void writeToFile(String object) {
        try {
            file = new FileWriter(address);
            file.write(object);

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

