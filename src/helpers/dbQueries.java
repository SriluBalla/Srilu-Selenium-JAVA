package helpers;

public class dbQueries {

    public static String query;

    public static String selLogin(String id){
        query = "SELECT * FROM table WHERE id = " + id + "';";
        return query;
    }

    public static String del_Login(String id){
        query = "DELETE FROM table WHERE id = " + id + "';";
        return query;
    }

    public static String count_Login(String id){
        query = "SELECT DISTINCT COUNT (col_name) FROM table WHERE id = " + id + "';";
        return query;
    }
}
