package com.turchyn.usermanagement.dao;

import com.turchyn.usermanagement.model.TourBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TourDAO {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static String jdbcURL = "jdbc:h2:D:\\EPAM Java Online\\turchyn_oleh\\db\\tours";
    private static String jdbcUsername = "sa";
    private static String jdbcPassword = "";

    private static final String INSERT_TOURS_SQL = "INSERT INTO tours" + "  (title, location, transport, nutrition, duration, price) VALUES " +
            " (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_TOUR_BY_ID = "select id, title, location, transport, nutrition, duration, price from tours where id=?";
    private static final String SELECT_ALL_TOURS = "select * from tours";
    private static final String DELETE_TOURS_SQL = "delete from tours where id=?";
    private static final String UPDATE_TOURS_SQL = "update tours set title = ?, location = ?, transport = ?, nutrition = ?, duration = ?, price = ? where id = ?;";

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertTour(TourBase tour) throws SQLException{
        System.out.println(INSERT_TOURS_SQL);

        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TOURS_SQL)){
            preparedStatement.setString(1,tour.getTourTitle());
            preparedStatement.setString(2,tour.getTourLocation());
            preparedStatement.setString(1,tour.getTourTransport());
            preparedStatement.setString(1,tour.getTourNutrition());
            preparedStatement.setInt(1,tour.getTourDuration());
            preparedStatement.setInt(1,tour.getTourPrice());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public TourBase selectTour(int id) throws SQLException{
       TourBase tour =  null;
       System.out.println(SELECT_TOUR_BY_ID);
       Connection connection = getConnection();
       PreparedStatement statement = connection.prepareStatement(SELECT_TOUR_BY_ID);
       statement.setInt(1,id);

       ResultSet rs =statement.executeQuery();

       if(rs.next()){
           String title = rs.getString("title");
           String location = rs.getString("location");
           String transport = rs.getString("transport");
           String nutrition = rs.getString("nutrition");
           int duration = rs.getInt("duration");
           int price = rs.getInt("price");

           tour = new TourBase(id,title, location,transport,nutrition,duration,price);
       }
       rs.close();
       statement.close();
       return tour;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_TOURS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(TourBase tour) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_TOURS_SQL);) {
            statement.setString(1, tour.getTourTitle());
            statement.setString(2, tour.getTourLocation());
            statement.setString(3, tour.getTourTransport());
            statement.setString(3, tour.getTourNutrition());
            statement.setInt(4, tour.getTourDuration());
            statement.setInt(4, tour.getTourPrice());
            statement.setInt(4, tour.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public static List<TourBase> listAllBooks() throws SQLException {
        Connection connection = getConnection();
        Statement statement = null;
        List<TourBase> listTour = new ArrayList<>();

        //String sql = "SELECT * FROM tours";

        statement = connection.createStatement();

//        Statement statement = jdbcConnection.createStatement();
        ResultSet rs = statement.executeQuery(SELECT_ALL_TOURS);

        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String location = rs.getString("location");
            String transport = rs.getString("transport");
            String nutrition = rs.getString("nutrition");
            int duration = rs.getInt("duration");
            int price = rs.getInt("price");
            TourBase tour = new TourBase(id, title, location,transport,nutrition,duration,price);
            listTour.add(tour);
        }
        rs.close();
        statement.close();
        connection.commit();
        return listTour;
    }

}
