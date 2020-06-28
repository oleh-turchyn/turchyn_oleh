package com.turchyn.usermanagement.service;

import com.turchyn.usermanagement.dao.ClientDAO;
import com.turchyn.usermanagement.model.Client;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class ClientService implements IService<Client> {
    private static Logger logger = Logger.getLogger(ClientService.class.getName());
    ClientDAO clientDAO = new ClientDAO();
    @Override
    public void addData(Client client) throws SQLException {
        clientDAO.create(client);
    }

    @Override
    public List getAllData() throws SQLException {
        return clientDAO.read();
    }

    @Override
    public void deleteData(Client client) throws SQLException {
        clientDAO.delete(client);
    }

    @Override
    public void updateData(Client client) throws SQLException {
        clientDAO.update(client);
    }

    @Override
    public Client getDataById(int id) throws SQLException {
        return clientDAO.getById(id);
    }
}
