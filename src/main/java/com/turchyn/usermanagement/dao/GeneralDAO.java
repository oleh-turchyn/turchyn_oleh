package com.turchyn.usermanagement.dao;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO<T> {
    //create
    void create(T t);

    //read
    List<T> read();

    T getById(int id);

    //update
    void update(T t);

    //delete
    void delete(T t);

}
