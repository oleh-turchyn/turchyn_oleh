package com.turchyn.usermanagement.service;

import com.turchyn.usermanagement.model.TourBase;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
    void addData(T t);

    List getAllData();

    void deleteData(T t);

    void updateData(T t);

    T getDataById(int id);

}
