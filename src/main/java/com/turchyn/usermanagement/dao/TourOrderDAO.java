package com.turchyn.usermanagement.dao;

import com.turchyn.tool.ConnectionDB;
import com.turchyn.usermanagement.model.TourOrder;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourOrderDAO implements  GeneralDAO<TourOrder>{
    private ConnectionDB connectionDB;
    public TourOrderDAO(){}
    public TourOrderDAO(ConnectionDB connectionDB){
        this.connectionDB=connectionDB;
    }
    private static Logger logger = Logger.getLogger(TourOrderDAO.class.getName());
        private static final String DELETE_ORDER_SQL = "delete from TOURORDER where id = ?";
    private static final String INSERT_ORDER_SQL = "INSERT INTO TOURORDER" + "  (date_order, client_code, tour_code) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_ALL_ORDER = "select * from TOURORDER";
    private static final String SELECT_ORDER_BY_ID = "select * from TOURORDER where id=?";
    private static final String UPDATE_ORDER_SQL = "update TOURORDER set date_order = ?, client_code = ?, tour_code = ? where id = ?;";
    @Override
    public void create(TourOrder tourOrder) {
        try (Connection c = ConnectionDB.getInstance().getConnection();
             PreparedStatement statement = c.prepareStatement(INSERT_ORDER_SQL);
        ) {
            statement.setString(1, tourOrder.getDateOrder());
            statement.setInt(2, tourOrder.getClientCode());
            statement.setInt(3, tourOrder.getTourCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with create new field of TourOrderDAO");
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<TourOrder> read() {
        List<TourOrder> listTourOrder = new ArrayList<>();
        try (Connection c = ConnectionDB.getInstance().getConnection();
             Statement statement = c.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_ORDER);
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("date_order");
                int clientCode = rs.getInt("client_code");
                int tourCode = rs.getInt("tour_code");
                TourOrder tourOrder = new TourOrder(id,date,clientCode,tourCode);
                listTourOrder.add(tourOrder);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view list of TourOrderDAO");
            logger.error(e.getMessage());
        }
        return listTourOrder;

    }

    @Override
    public TourOrder getById(int id) {
        TourOrder tourOrder = null;
        try (
                Connection c = ConnectionDB.getInstance().getConnection();
                PreparedStatement statement = c.prepareStatement(SELECT_ORDER_BY_ID);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String date = rs.getString("date_order");
                int clientCode = rs.getInt("client_code");
                int tourCode = rs.getInt("tour_code");
                tourOrder = new TourOrder(id, date,clientCode,tourCode);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view TourOrderDAO by ID");
            logger.error(e.getMessage());
        }
        return tourOrder;
    }

    @Override
    public void update(TourOrder tourOrder) {
        try (Connection c = ConnectionDB.getInstance().getConnection();
             PreparedStatement statement = c.prepareStatement(UPDATE_ORDER_SQL);) {
            statement.setString(1, tourOrder.getDateOrder());
            statement.setInt(2, tourOrder.getClientCode());
            statement.setInt(3, tourOrder.getTourCode());
            statement.setInt(4, tourOrder.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with update field of TourOrderDAO");
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(TourOrder tourOrder) {
        try (
                Connection c = ConnectionDB.getInstance().getConnection();
                PreparedStatement statement = c.prepareStatement(DELETE_ORDER_SQL);
        ) {
            statement.setInt(1, tourOrder.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with delete field of TourOrderDAO");
            logger.error(e.getMessage());
        }
    }
}
