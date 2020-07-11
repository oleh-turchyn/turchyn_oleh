package com.turchyn.usermanagement.dao;

import com.turchyn.tool.ConnectionDB;
import com.turchyn.usermanagement.model.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class OrderDetailDAO implements GeneralDAO<OrderDetail> {
    private static Logger logger = Logger.getLogger(OrderDetailDAO.class.getName());
    private static final String SELECT_ALL_ORDERS = "SELECT\n" +
            "    to.ID  AS ID,\n" +
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
    public void create(OrderDetail orderDetail) {
    }

    @Override
    public List<OrderDetail> read() {
        List<OrderDetail> listOrderDetail = new ArrayList<>();
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
                OrderDetail orderDetail = new OrderDetail(orderId, date, clientName, clientSurname, title);
                listOrderDetail.add(orderDetail);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view list of OrderDAO");
            logger.error(e.getMessage());
        }
        return listOrderDetail;
    }

    @Override
    public OrderDetail getById(int id) {
        return null;
    }

    @Override
    public void update(OrderDetail orderDetail) {

    }

    @Override
    public void delete(OrderDetail orderDetail) {
    }
}
