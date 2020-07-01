package com.turchyn.tool;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Logger logger = Logger.getLogger(ConnectionDB.class.getName());
    private static ConnectionDB instance;
    private static Connection jdbcConnection;
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String jdbcURL = "jdbc:h2:D:\\EPAM Java Online\\turchyn_oleh\\db\\tours2";
    private static final String jdbcUsername = "sa";
    private static final String jdbcPassword = "pass";

    private ConnectionDB(){
        try {
            Class.forName(DB_DRIVER);
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            logger.info("Connected to database  is successfully");
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Problem with connection to database");
            logger.error(e.getMessage());
        }
    }

    public static ConnectionDB getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new ConnectionDB();
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return instance;
    }

    public Connection getConnection() {
        return jdbcConnection;
    }

//    public static void connect() throws SQLException {
//        if (jdbcConnection == null || jdbcConnection.isClosed()) {
//            try {
//                Class.forName(DB_DRIVER);
//                jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//                logger.info("Connected to database  is successfully");
//            } catch (ClassNotFoundException e) {
//                logger.error("Problem with connection to database");
//                logger.error(e.getMessage());
//                throw new SQLException(e);
//            }
//
//        }
//    }
//
//    public static void disconnect() throws SQLException {
//        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
//            jdbcConnection.close();
//        }
//    }
//    public static Connection getConnection() {
//        return jdbcConnection;
//    }
}
