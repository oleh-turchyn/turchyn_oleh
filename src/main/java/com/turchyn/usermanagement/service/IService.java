package com.turchyn.usermanagement.service;

import com.turchyn.usermanagement.model.TourBase;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
    void addData(T t) throws SQLException;

    List getAllData() throws SQLException;

    void deleteData(T t) throws SQLException;

    void updateData(T t) throws SQLException;

    T getDataById(int id) throws SQLException;

}
