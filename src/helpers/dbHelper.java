package helpers;

import java.sql.*;

public class dbHelper {

    private static final String dbUAT = "jdbc:postgresql://srilu:0000/srilu_uat";
    private static final String dbuser = "Srilu";
    private static final String dbpass = "password";

    private static Connection conn;
    private static Statement st;
    private static ResultSet rs;
    private static String valueString;

    private static Connection getDBConn(){
        conn = null;

        try {
            Class.forName("org.postgressql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Not able to load PostgreSQL");
            e.printStackTrace();
            System.exit(1);
        }
        try {
            conn = DriverManager.getConnection(dbUAT, dbuser, dbpass);
        } catch (SQLException e){
            System.out.println("Not able to connect to DB");
            e.printStackTrace();
            System.exit(1);
        }
        return conn;
    }

    public static String fromColumn_GetString(String query, String column) throws SQLException {
        try {
            st = getDBConn().createStatement();
            rs = st.executeQuery(query);
            while (rs.next())
                valueString = rs.getString(column);
        } catch (SQLException e) {
            System.out.println("\n" + " Column does not exist. From Query - " + query);
            e.printStackTrace();
        }
        return valueString;
    }

    public static void del_fromTable(String query) throws SQLException {
        try {
            st = getDBConn().createStatement();
            st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("\n Table does not exist to delete");
            e.printStackTrace();
        }
    }

    public static void closeDB() throws SQLException {
        conn.close();
    }

}
