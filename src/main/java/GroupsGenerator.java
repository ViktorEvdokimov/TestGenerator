import java.sql.*;
import java.util.ArrayList;

public class GroupsGenerator {
    private ArrayList<String> names = new ArrayList<>();

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private static final String url = "jdbc:mysql://localhost:3306/groups_and_persons?useUnicode=true&serverTimezone=UTC";
    private static final String user = "root";
    private static final String pass = "root";

    public GroupsGenerator() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM groups_and_persons.groups;");
            while (rs.next()) {
                names.add(names.size(), rs.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Group[] generateGroups(int quantityOfGroups, int quantityOfPersons){
        Group[] groups = new Group[quantityOfGroups];
        int[] nameNumbersArray = getNameNumbersArray(quantityOfGroups);
        int[] quantityArray = getQuantityArray(quantityOfGroups, quantityOfPersons);
        for (int i = 0; i < (quantityOfGroups); i++) {
            groups[i] = getRandomGroup(quantityArray[i], nameNumbersArray[i]);
        }
        return groups;
    }

    public Group getRandomGroup (int personsQuantity, int nameNumber) {
        PersonsGenerator pg = new PersonsGenerator();
        Person[] persons = pg.getPersonArray(personsQuantity);
        String name = names.get(nameNumber);
        return new Group(name, persons);
    }

    private int[] getNameNumbersArray(int quantityOfGroups){
        int[] nameNumbers = new int[quantityOfGroups];
        for (int i = 0; i < (quantityOfGroups); i++) {
            int nameNumber;
            boolean isNameNumberBusy;
            do {
                nameNumber = (int) (Math.random() * names.size() + 1);
                isNameNumberBusy = false;
                for (int number : nameNumbers) {
                    if ((number) == nameNumber) {
                        isNameNumberBusy = true;
                    }
                }
            }while (isNameNumberBusy);
            nameNumbers[i] = nameNumber;
        }
        for (int i = 0; i < quantityOfGroups; i++) {
            nameNumbers[i]--;
        }
        return nameNumbers;
    }

    private int[] getQuantityArray (int quantityOfGroups, int quantityOfPersons){
        int countOfDefinedPersons = 0;
        int[] quantityArray = new int[quantityOfGroups];
        for (int i = 0; i < (quantityOfGroups); i++) {
            int quantityOfDefinedPersons;
            if (i < (quantityOfGroups-1)) {
                quantityOfDefinedPersons = (int) (Math.random() * (quantityOfPersons - countOfDefinedPersons)
                        * 2 / (quantityOfGroups - i));
            } else quantityOfDefinedPersons = quantityOfPersons - countOfDefinedPersons;
            quantityArray[i] = quantityOfDefinedPersons;
        }
        return quantityArray;
    }
}
