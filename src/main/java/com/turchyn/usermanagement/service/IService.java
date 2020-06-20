package com.turchyn.usermanagement.service;

import com.turchyn.usermanagement.model.TourBase;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
    void addData(T t) throws SQLException;

    List getData(int id) throws SQLException;

    void deleteData(T t) throws SQLException;

    void updateData(T t) throws SQLException;

    T getUserDataById(int id) throws SQLException;

}
