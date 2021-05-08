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

    public Group[] generateGroups(int groupCount, int personCount){
        if (groupCount < 0 || personCount < 0){
            throw new IndexOutOfBoundsException("Quantity should be 0 or positive. Please enter suitable data.");
        }
        if (groupCount == 0){
            throw new IndexOutOfBoundsException("Quantity  of groups should be positive. Please enter suitable data.");
        }
        if(groupCount > names.size()){
            throw new IndexOutOfBoundsException("Quantity of groups more then size of names base. Please add new " +
                    "groups names or enter less groups quantity.");
        }
        Group[] groups = new Group[groupCount];
        int[] nameNumbersArray = getNameNumbersArray(groupCount);
        int[] quantityArray = getQuantityArray(groupCount, personCount);
        for (int i = 0; i < (groupCount); i++) {
            groups[i] = getRandomGroup(quantityArray[i], nameNumbersArray[i]);
            System.out.println(quantityArray[i]);
        }
        return groups;
    }

    public Group getRandomGroup (int personsQuantity, int nameNumber) {
        PersonsGenerator pg = new PersonsGenerator();
        Person[] persons = pg.getPersonArray(personsQuantity);
        String name = names.get(nameNumber);
        return new Group(name, persons);
    }

    private int[] getNameNumbersArray(int groupCount){
        int[] nameNumbers = new int[groupCount];
        for (int i = 0; i < (groupCount); i++) {
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
        for (int i = 0; i < groupCount; i++) {
            nameNumbers[i]--;
        }
        return nameNumbers;
    }

    private int[] getQuantityArray (int groupCount, int personCount){
        int definedPersons = 0;
        int[] quantityArray = new int[groupCount];
        for (int i = 0; i < (groupCount); i++) {
            int thisGroup;
            if (i < (groupCount-1)) {
                thisGroup = (int) (Math.random() * (personCount - definedPersons) * 2/ (groupCount - i));
                if (thisGroup > (personCount - definedPersons)) thisGroup = definedPersons;
            } else thisGroup = personCount - definedPersons;
            definedPersons +=thisGroup;
            quantityArray[i] = thisGroup;
        }
        return quantityArray;
    }
}
