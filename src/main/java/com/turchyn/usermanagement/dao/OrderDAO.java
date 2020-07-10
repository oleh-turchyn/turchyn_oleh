package com.turchyn.usermanagement.dao;

import com.turchyn.tool.ConnectionDB;
import com.turchyn.usermanagement.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class OrderDAO implements GeneralDAO<Order> {
    private static Logger logger = Logger.getLogger(OrderDAO.class.getName());
    private static final String SELECT_ALL_ORDERS = "SELECT\n" +
            "    to.ORDER_ID  AS ID,\n" +
            "    to.DATE_ORDER,\n" +
            "    c.first_name AS clientname,\n" +
            "    c.LAST_NAME AS clientsurname,\n" +
            "    t.title AS tourtitle\n" +
            "\n" +
            "FROM TOURORDER to\n" +
            "INNER JOIN\n" +
            "     CLIENTS C on to.CLIENT_CODE = C.ID\n" +
            "INNER JOIN\n" +
            "    TOURS t ON to.TOUR_CODE = t.ID";

    @Override
    public void create(Order order) {

    }

    @Override
    public List<Order> read() {
        List<Order> listOrder = new ArrayList<>();
        try (Connection c = ConnectionDB.getInstance().getConnection();
             Statement statement = c.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_ORDERS);
        ) {
            while (rs.next()) {
                int orderId = rs.getInt("id");
                String date = rs.getString("date_order");
                String clientName = rs.getString("clientname");
                String clientSurname = rs.getString("clientsurname");
                String title = rs.getString("tourtitle");
                Order order = new Order(orderId, date, clientName, clientSurname, title);
                listOrder.add(order);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view list of OrderDAO");
            logger.error(e.getMessage());
        }
        return listOrder;
    }

    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Order order) {

    }
}
