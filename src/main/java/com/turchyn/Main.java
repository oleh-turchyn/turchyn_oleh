package com.turchyn;

import com.turchyn.usermanagement.model.TourBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static String jdbcURL = "jdbc:h2:D:\\EPAM Java Online\\turchyn_oleh\\db\\tours";
    private static String jdbcUsername = "sa";
    private static String jdbcPassword = "";
    public static void main(String[] args) throws Exception{
        try{
            insertWithStatement();
            List<TourBase>list = new ArrayList<>();
            list = listAllBooks();
            System.out.println(list);
            list.forEach(t->System.out.println(t));
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
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

    private static void  insertWithStatement() throws SQLException {
        Connection connection = getConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            //stmt.execute("create table tours2(id bigint primary key, title varchar(30),location varchar(30),transport varchar(30),nutrition varchar(30),duration int,price int)");
            //stmt.execute("insert into tours values (4,'ti','stryj','car','lunch',5,200)");
            ResultSet rs = stmt.executeQuery("select * from tours");
            System.out.println("testing");
            while (rs.next()) {
                System.out.println("Id " + rs.getInt("id")
                        + " title " + rs.getString("title")
                        + " location " + rs.getString("location")
                        + " transport " + rs.getString("transport")
                        +" nutr " + rs.getString("nutrition")
                        +" duration " + rs.getInt("duration")
                        +" price " + rs.getInt("price"));
            }

            //stmt.execute("DROP TABLE TOURS");
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static List<TourBase> listAllBooks() throws SQLException {
        Connection connection = getConnection();
        Statement stmt = null;
        List<TourBase> listTour = new ArrayList<>();

        String sql = "SELECT * FROM tours";

        stmt = connection.createStatement();

//        Statement statement = jdbcConnection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

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

        stmt.close();
        connection.commit();
        return listTour;
    }


}
