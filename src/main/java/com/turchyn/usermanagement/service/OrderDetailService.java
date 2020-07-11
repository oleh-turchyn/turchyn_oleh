package com.turchyn.usermanagement.service;

import com.turchyn.usermanagement.dao.OrderDetailDAO;
import org.apache.log4j.Logger;

import java.util.List;

public class OrderDetailService {
    private static Logger logger = Logger.getLogger(OrderDetailService.class.getName());
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    public List getAllData() {
        return orderDetailDAO.read();
    }
}
