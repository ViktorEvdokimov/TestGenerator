package AddDataToDB;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileReader fr = new FileReader();
        WriterToDB.writeToDB("groups_and_persons.man_first_name", "man_first_name",
                fr.getFileContent("src/main/resources/Data/ManFirstName.txt"));
        WriterToDB.writeToDB("groups_and_persons.man_last_name", "man_last_name",
                fr.getFileContent("src/main/resources/Data/ManLastName.txt"));
        WriterToDB.writeToDB("groups_and_persons.man_patronymic", "man_patronymic",
                fr.getFileContent("src/main/resources/Data/ManPatronymic.txt"));
        WriterToDB.writeToDB("groups_and_persons.woman_first_name", "woman_first_name",
                fr.getFileContent("src/main/resources/Data/WomanFirstName.txt"));
        WriterToDB.writeToDB("groups_and_persons.woman_last_name", "woman_last_name",
                fr.getFileContent("src/main/resources/Data/WomanLastName.txt"));
        WriterToDB.writeToDB("groups_and_persons.woman_patronymic", "woman_patronymic",
                fr.getFileContent("src/main/resources/Data/WomanPatronymic.txt"));
        WriterToDB.writeToDB("groups_and_persons.street", "street",
                fr.getFileContent("src/main/resources/Data/streets.txt"));
        WriterToDB.writeToDB("groups_and_persons.groups", "name",
                fr.getFileContent("src/main/resources/Data/Groups.txt"));
    }
}
