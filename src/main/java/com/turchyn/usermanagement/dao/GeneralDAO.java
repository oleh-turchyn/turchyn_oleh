package com.turchyn.usermanagement.dao;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO<T> {
    //create
    boolean create(T t) throws SQLException;

    //read
    List<T> read() throws SQLException;

    T getById(int id) throws SQLException;

    //update
    boolean update(T t) throws SQLException;

    //delete
    boolean delete(T t) throws SQLException;

}
