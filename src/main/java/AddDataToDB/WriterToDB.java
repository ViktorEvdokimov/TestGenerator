package AddDataToDB;

import java.sql.*;

public class WriterToDB {

    private static final String url = "jdbc:mysql://localhost:3306/groups_and_persons?useUnicode=true&serverTimezone=UTC";
    private static final String user = "root";
    private static final String pass = "root";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public WriterToDB() {
    }

    public static void writeToDB(String dbName, String columnName, String values){
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            stmt.executeUpdate("TRUNCATE TABLE " + dbName + ";");
            stmt.executeUpdate("INSERT INTO " + dbName + "(" + columnName + ") VALUES " + values + ';');
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
