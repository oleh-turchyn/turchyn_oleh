package com.turchyn.usermanagement.service;

import com.turchyn.usermanagement.dao.OrderDetailDAO;
import com.turchyn.usermanagement.model.OrderDetail;
import org.apache.log4j.Logger;

import java.util.List;

public class OrderDetailService implements IService<OrderDetail> {
    private static Logger logger = Logger.getLogger(OrderDetailService.class.getName());
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

    @Override
    public void addData(OrderDetail orderDetail) {
    }

    @Override
    public List getAllData() {
        return orderDetailDAO.read();
    }

    @Override
    public void deleteData(OrderDetail orderDetail) {
        orderDetailDAO.delete(orderDetail);
    }

    @Override
    public void updateData(OrderDetail orderDetail) {

    }

    @Override
    public OrderDetail getDataById(int id) {
        return null;
    }
}
