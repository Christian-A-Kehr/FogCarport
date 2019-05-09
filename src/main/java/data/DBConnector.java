/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Mkhansen
 */
public class DBConnector {

    private Connection connection = null;
    //Constants
    private static final String IP = "174.138.1.102";
    private static final String PORT = "3306";
    public static final String DATABASE = "Fog";
    private static final String USERNAME = "TOPDOG";
    private static final String PASSWORD = "unlimitedpower";

    public DBConnector() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?UseSSL=false";
            Properties props = new Properties();
            props.put("user", USERNAME);
            props.put("password", PASSWORD);
            props.put("allowMultiQueries", true);
            props.put("useUnicode", true);
            props.put("useJDBCCompliantTimezoneShift", true);
            props.put("useLegacyDatetimeCode", false);
            props.put("serverTimezone", "CET");
            this.connection = DriverManager.getConnection(url, props);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
            throw new SQLException(ex.getMessage());
        }
    }
    public Connection getConnection() {
        return this.connection;
    }

}
