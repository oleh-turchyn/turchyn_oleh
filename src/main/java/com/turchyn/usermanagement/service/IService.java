package com.turchyn.usermanagement.service;

import java.util.List;

public interface IService<T> {
    void addData(T t);

    List getData(int id);

    void deleteData(int id);

    void updateData(T t, int id);

    T getUserDataById(int id);

}
