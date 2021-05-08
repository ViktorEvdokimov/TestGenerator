package AddDataToDB;

import java.io.*;

public class FileReader {

    private FileInputStream fis;


    public String getFileContent(String address){
        File file = new File(address);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            String sCurrentLine;
            sb.append("(\'");
            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.length()>1) {
                    sb.append(sCurrentLine);
                    sb.append("\'), (\'");
                }
            }
            sb.setLength(sb.length()-4);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
