package Entities;



import java.sql.*;


public class GroupsFromDB extends GroupsGenerator{


    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private  final String url;
    private  final String user;
    private  final String pass;

    public GroupsFromDB(String url, String user, String pass) {
        this.url = url;
        this.pass = pass;
        this.user = user;
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

    @Override
    public Person[] getPerson(int personsQuantity) {
        PersonsGenerator pg = new PersonsFromDB(url, user, pass);
        Person[] persons = pg.getPersonArray(personsQuantity);
        return persons;
    }
}
