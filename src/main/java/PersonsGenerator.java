


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonsGenerator {
    private ArrayList<String> manLastNames = new ArrayList<>();
    private ArrayList<String> manFirstNames = new ArrayList<>();
    private ArrayList<String> manPatronymics = new ArrayList<>();
    private ArrayList<String> womanLastNames = new ArrayList<>();
    private ArrayList<String> womanFirstNames = new ArrayList<>();
    private ArrayList<String> womanPatronymics = new ArrayList<>();
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

            rs = stmt.executeQuery("SELECT woman_first_name FROM woman_first_name");
            while (rs.next()){
                womanFirstNames.add(womanFirstNames.size(), rs.getString(1));
            }

            rs = stmt.executeQuery("SELECT woman_last_name FROM woman_last_name");
            while (rs.next()){
                womanLastNames.add(womanLastNames.size(), rs.getString(1));
            }

            rs = stmt.executeQuery("SELECT woman_patronymic FROM woman_patronymic");
            while (rs.next()){
                womanPatronymics.add(womanPatronymics.size(), rs.getString(1));
            }

            rs = stmt.executeQuery("SELECT man_first_name FROM man_first_name");
            while (rs.next()){
                manFirstNames.add(manFirstNames.size(), rs.getString(1));
            }

            rs = stmt.executeQuery("SELECT man_last_name FROM man_last_name");
            while (rs.next()){
                manLastNames.add(manLastNames.size(), rs.getString(1));
            }

            rs = stmt.executeQuery("SELECT man_patronymic FROM man_patronymic");
            while (rs.next()){
                manPatronymics.add(manPatronymics.size(), rs.getString(1));
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
        String lastName;
        String firstName;
        String patronymic;
        if(Math.random()>0.5) {
             lastName = manLastNames.get((int) (Math.random() * manLastNames.size()));
             firstName = manFirstNames.get((int) (Math.random() * manFirstNames.size()));
             patronymic = manPatronymics.get((int) (Math.random() * manPatronymics.size()));
        } else {
             lastName = womanLastNames.get((int) (Math.random() * womanLastNames.size()));
             firstName = womanFirstNames.get((int) (Math.random() * womanFirstNames.size()));
             patronymic = womanPatronymics.get((int) (Math.random() * womanPatronymics.size()));
        }
        String address = streets.get((int) (Math.random()*streets.size())) + ' ' +
                (int)(Math.random() * 49 + 1) + " дом " + (int)(Math.random() * 199 + 1) + " квартира";
        long phoneNumber = 89000000000l + ((long) (Math.random()* 999999999));
        return new Person(firstName, lastName, patronymic, address, phoneNumber);
    }


}
