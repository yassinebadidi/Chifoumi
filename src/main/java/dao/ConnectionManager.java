package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private static Connection Instance;

    private ConnectionManager(){

    }

    public static Connection getInstance() {
        String url_db = "jdbc:mysql://localhost:3306/projet_posts";
        String user = "root";
        String mypassword = "yassine";
        if(Instance == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                Instance = DriverManager.getConnection(url_db, user, mypassword);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return Instance;
    }

    public static void closeConnection() throws SQLException {
        if (Instance != null && !Instance.isClosed()){
            Instance.close();
        }
    }
}
