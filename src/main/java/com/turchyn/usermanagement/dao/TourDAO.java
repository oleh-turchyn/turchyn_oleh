package com.turchyn.usermanagement.dao;

import com.turchyn.tool.ConnectionDB;
import com.turchyn.usermanagement.model.TourBase;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourDAO implements GeneralDAO<TourBase> {
    private ConnectionDB connectionDB;
    public TourDAO(){}
    public TourDAO(ConnectionDB connectionDB){
        this.connectionDB=connectionDB;
    }
    private static Logger logger = Logger.getLogger(TourDAO.class.getName());
    private static final String INSERT_TOURS_SQL = "INSERT INTO tours" + "  (title, location, transport, nutrition, duration, price) VALUES " +
            " (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_TOUR_BY_ID = "select * from tours where id=?";
    private static final String SELECT_ALL_TOURS = "select * from tours";
    private static final String DELETE_TOURS_SQL = "delete from tours where id=?";
    private static final String UPDATE_TOURS_SQL = "update tours set title = ?, location = ?, transport = ?, nutrition = ?, duration = ?, price = ? where id = ?;";

    @Override
    public void create(TourBase tour) {
        try (Connection c = ConnectionDB.getInstance().getConnection();
             PreparedStatement statement = c.prepareStatement(INSERT_TOURS_SQL);
        ) {
            statement.setString(1, tour.getTourTitle());
            statement.setString(2, tour.getTourLocation());
            statement.setString(3, tour.getTourTransport());
            statement.setString(4, tour.getTourNutrition());
            statement.setInt(5, tour.getTourDuration());
            statement.setInt(6, tour.getTourPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with create new field of TourDAO");
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<TourBase> read() {
        List<TourBase> listTour = new ArrayList<>();
        try (Connection c = ConnectionDB.getInstance().getConnection();
             Statement statement = c.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_TOURS);
        ) {
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
        } catch (SQLException e) {
            logger.error("Some problems with view list of TourDAO");
            logger.error(e.getMessage());
        }
        return listTour;
    }

    @Override
    public TourBase getById(int id) {
        TourBase tour = null;
        try (
                Connection c = ConnectionDB.getInstance().getConnection();
                PreparedStatement statement = c.prepareStatement(SELECT_TOUR_BY_ID);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String location = rs.getString("location");
                String transport = rs.getString("transport");
                String nutrition = rs.getString("nutrition");
                int duration = rs.getInt("duration");
                int price = rs.getInt("price");
                tour = new TourBase(id, title, location, transport, nutrition, duration, price);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view TourDAO by ID");
            logger.error(e.getMessage());
        }
        return tour;
    }

    @Override
    public void update(TourBase tour) {
        try (Connection c = ConnectionDB.getInstance().getConnection();
             PreparedStatement statement = c.prepareStatement(UPDATE_TOURS_SQL);) {
            statement.setString(1, tour.getTourTitle());
            statement.setString(2, tour.getTourLocation());
            statement.setString(3, tour.getTourTransport());
            statement.setString(4, tour.getTourNutrition());
            statement.setInt(5, tour.getTourDuration());
            statement.setInt(6, tour.getTourPrice());
            statement.setInt(7, tour.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with update field of TourDao");
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(TourBase tour) {
        try (
                Connection c = ConnectionDB.getInstance().getConnection();
                PreparedStatement statement = c.prepareStatement(DELETE_TOURS_SQL);
        ) {
            statement.setInt(1, tour.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with delete field of TourDAO");
            logger.error(e.getMessage());
        }
    }
}
