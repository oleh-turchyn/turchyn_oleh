package com.turchyn.usermanagement.service;

import com.turchyn.usermanagement.dao.OrderDAO;
import com.turchyn.usermanagement.model.Order;
import org.apache.log4j.Logger;

import java.util.List;

public class OrderService implements IService<Order> {
    private static Logger logger = Logger.getLogger(OrderService.class.getName());
    OrderDAO orderDAO = new OrderDAO();

    @Override
    public void addData(Order order) {
    }

    @Override
    public List getAllData() {
        return orderDAO.read();
    }

    @Override
    public void deleteData(Order order) {
        orderDAO.delete(order);
    }

    @Override
    public void updateData(Order order) {

    }

    @Override
    public Order getDataById(int id) {
        return null;
    }
}
