package Entities;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonsFromDB extends PersonsGenerator {


    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private final String url;
    private final String user;
    private final String pass;

    public PersonsFromDB(String url, String user, String pass) {
        this.url = url;
        this.pass = pass;
        this.user = user;
        putToList("woman_first_name", "woman_first_name", womanFirstNames);
        putToList("woman_last_name", "woman_last_name", womanLastNames);
        putToList("woman_patronymic", "woman_patronymic", womanPatronymics);
        putToList("man_first_name", "man_first_name", manFirstNames);
        putToList("man_last_name", "man_last_name", manLastNames);
        putToList("man_patronymic", "man_patronymic", manPatronymics);
        putToList("street", "street", streets);
    }

    private void putToList (String tableName, String columnName, ArrayList target){
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT " + columnName + " FROM " + tableName);
            while (rs.next()){
                target.add(target.size(), rs.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
