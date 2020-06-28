package com.turchyn.tool;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Logger logger = Logger.getLogger(ConnectionDB.class.getName());
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String jdbcURL = "jdbc:h2:D:\\EPAM Java Online\\turchyn_oleh\\db\\tours2";
    private static final String jdbcUsername = "sa";
    private static final String jdbcPassword = "pass";
    private static Connection jdbcConnection;


    public static void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName(DB_DRIVER);
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    public static void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    public static Connection getConnection() {
        return jdbcConnection;
    }
}
