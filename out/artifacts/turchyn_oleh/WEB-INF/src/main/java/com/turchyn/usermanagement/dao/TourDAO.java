package com.turchyn.usermanagement.dao;

import com.turchyn.usermanagement.model.TourBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourDAO {
    private static final String DB_DRIVER = "org.h2.Driver";
    //    private static String jdbcURL = "jdbc:h2:D:\\EPAM Java Online\\turchyn_oleh\\db\\tours";
//    private static String jdbcUsername = "sa";
//    private static String jdbcPassword = "";
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    private static final String INSERT_TOURS_SQL = "INSERT INTO tours" + "  (title, location, transport, nutrition, duration, price) VALUES " +
            " (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_TOUR_BY_ID = "select * from tours where id=?";
    private static final String SELECT_ALL_TOURS = "select * from tours";
    private static final String DELETE_TOURS_SQL = "delete from tours where id=?";
    private static final String UPDATE_TOURS_SQL = "update tours set title = ?, location = ?, transport = ?, nutrition = ?, duration = ?, price = ? where id = ?;";

    public TourDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
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

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertTour(TourBase tour) throws SQLException {
        System.out.println(INSERT_TOURS_SQL);
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(INSERT_TOURS_SQL);
        statement.setString(1, tour.getTourTitle());
        statement.setString(2, tour.getTourLocation());
        statement.setString(3, tour.getTourTransport());
        statement.setString(4, tour.getTourNutrition());
        statement.setInt(5, tour.getTourDuration());
        statement.setInt(6, tour.getTourPrice());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;

    }

    public List<TourBase> listAllTours() throws SQLException {
        List<TourBase> listTour = new ArrayList<>();
        connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet rs = statement.executeQuery(SELECT_ALL_TOURS);

        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String location = rs.getString("location");
            String transport = rs.getString("transport");
            String nutrition = rs.getString("nutrition");
            int duration = rs.getInt("duration");
            int price = rs.getInt("price");
            TourBase tour = new TourBase(id, title, location, transport, nutrition, duration, price);
            listTour.add(tour);
        }
        rs.close();
        statement.close();
        disconnect();
        return listTour;
    }

    public boolean deleteTour(TourBase tour) throws SQLException {
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(DELETE_TOURS_SQL);
        statement.setInt(1, tour.getId());
        boolean deletedRow = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return deletedRow;
    }

    public boolean updateTour(TourBase tour) throws SQLException {
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(UPDATE_TOURS_SQL);
        statement.setString(1, tour.getTourTitle());
        statement.setString(2, tour.getTourLocation());
        statement.setString(3, tour.getTourTransport());
        statement.setString(4, tour.getTourNutrition());
        statement.setInt(5, tour.getTourDuration());
        statement.setInt(6, tour.getTourPrice());
        statement.setInt(7,tour.getId());
        boolean updatedRow = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return updatedRow;
    }

    public TourBase getTour(int id) throws SQLException {
        TourBase tour = null;
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(SELECT_TOUR_BY_ID);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            String title = rs.getString("title");
            String location = rs.getString("location");
            String transport = rs.getString("transport");
            String nutrition = rs.getString("nutrition");
            int duration = rs.getInt("duration");
            int price = rs.getInt("price");
            tour = new TourBase(id,title, location, transport, nutrition, duration, price);
        }
        rs.close();
        statement.close();
        return tour;
    }


}
