package com.turchyn.usermanagement.service;

import com.turchyn.usermanagement.dao.TourOrderDAO;
import com.turchyn.usermanagement.model.TourOrder;
import org.apache.log4j.Logger;

import java.util.List;

public class TourOrderService implements IService<TourOrder> {
    private static Logger logger = Logger.getLogger(TourOrderService.class.getName());
    TourOrderDAO tourOrderDAO = new TourOrderDAO();
    @Override
    public void addData(TourOrder tourOrder) {
        tourOrderDAO.create(tourOrder);
    }

    @Override
    public List getAllData() {
        return tourOrderDAO.read();
    }

    @Override
    public void deleteData(TourOrder tourOrder) {
        tourOrderDAO.delete(tourOrder);
    }

    @Override
    public void updateData(TourOrder tourOrder) {
        tourOrderDAO.update(tourOrder);
    }

    @Override
    public TourOrder getDataById(int id) {
        return tourOrderDAO.getById(id);
    }
}
