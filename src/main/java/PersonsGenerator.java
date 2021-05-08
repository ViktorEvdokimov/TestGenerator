


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonsGenerator {
    private ArrayList<String> lastNames = new ArrayList<>();
    private ArrayList<String> firstNames = new ArrayList<>();
    private ArrayList<String> patronymics = new ArrayList<>();
    private ArrayList<String> streets = new ArrayList<>();

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private static final String url = "jdbc:mysql://localhost:3306/groups_and_persons?useUnicode=true&serverTimezone=UTC";
    private static final String user = "root";
    private static final String pass = "root";

    public PersonsGenerator() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT man_first_name FROM man_first_name");
            while (rs.next()){
                firstNames.add(firstNames.size(), rs.getString(1));
            }

            rs = stmt.executeQuery("SELECT man_last_name FROM man_last_name");
            while (rs.next()){
                lastNames.add(lastNames.size(), rs.getString(1));
            }

            rs = stmt.executeQuery("SELECT man_patronymic FROM man_patronymic");
            while (rs.next()){
                patronymics.add(patronymics.size(), rs.getString(1));
            }

            rs = stmt.executeQuery("SELECT street FROM street");
            while (rs.next()){
                streets.add(streets.size(), rs.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Person[] getPersonArray (int quantity){
        Person persons[] = new Person[quantity];
        for (int i = 0; i < quantity; i++) {
            persons[i] = getRandomPerson();
        }
        return persons;
    }

    public Person getRandomPerson (){
        String lastName = lastNames.get((int) (Math.random()*lastNames.size()));
        String firstName = firstNames.get((int) (Math.random()*firstNames.size()));
        String patronymic = patronymics.get((int) (Math.random()*patronymics.size()));
        String address = streets.get((int) (Math.random()*streets.size())) + ' ' +
                (int)(Math.random() * 49 + 1) + " дом " + (int)(Math.random() * 199 + 1) + " квартира";
        long phoneNumber = 89000000000l + ((long) (Math.random()* 999999999));
        return new Person(firstName, lastName, patronymic, address, phoneNumber);
    }


}
