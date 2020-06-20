package com.turchyn.usermanagement.service;

import com.turchyn.usermanagement.dao.TourDAO;
import com.turchyn.usermanagement.model.TourBase;

import java.sql.SQLException;
import java.util.List;

public class TourService implements IService<TourBase> {
    TourDAO tourDAO = new TourDAO();
    @Override
    public void addData(TourBase tourBase) throws SQLException {
        tourDAO.create(tourBase);
    }

    @Override
    public List getAllData() throws SQLException {
        return  tourDAO.read();
    }

    @Override
    public void deleteData(TourBase tourBase) throws SQLException {
        tourDAO.delete(tourBase);
    }

    @Override
    public void updateData(TourBase tourBase) throws SQLException {
        tourDAO.update(tourBase);
    }

    @Override
    public TourBase getDataById(int id) throws SQLException {
        return tourDAO.getById(id);
    }
}
