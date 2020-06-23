package com.turchyn.usermanagement.dao;

import com.turchyn.usermanagement.model.Client;
import com.turchyn.usermanagement.model.TourBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.turchyn.tool.ConnectionDB.*;

public class ClientDAO implements GeneralDAO<Client> {
    private Connection jdbcConnection;
    private static final String INSERT_CLIENTS_SQL = "INSERT INTO clients" + "  (first_name, last_name, patron_name, passport, tel_num) VALUES " +
            " (?, ?, ?, ?, ?);";
    private static final String SELECT_CLIENT_BY_ID = "select * from clients where id=?";
    private static final String SELECT_ALL_CLIENTS = "select * from clients";
    private static final String DELETE_CLIENTS_SQL = "delete from clients where id=?";
    private static final String UPDATE_CLIENTS_SQL = "update clients set first_name = ?, last_name = ?, patron_name = ?, passport = ?, tel_num = ? where id = ?;";
    @Override
    public boolean create(Client client) throws SQLException {
        connect();
        jdbcConnection = getConnection();
        PreparedStatement statement = jdbcConnection.prepareStatement(INSERT_CLIENTS_SQL);
        statement.setString(1,client.getFirstName() );
        statement.setString(2, client.getLastName());
        statement.setString(3, client.getPatrName());
        statement.setString(4, client.getPassport());
        statement.setString(5, client.getTelNumber());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    @Override
    public List<Client> read() throws SQLException {
        List<Client> listClient = new ArrayList<>();
        connect();
        jdbcConnection = getConnection();
        Statement statement = jdbcConnection.createStatement();
        ResultSet rs = statement.executeQuery(SELECT_ALL_CLIENTS);

        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String patronName = rs.getString("patron_name");
            String passport = rs.getString("passport");
            String telNum = rs.getString("tel_num");
            Client client = new Client(id, firstName, lastName, patronName, passport,telNum);
            listClient.add(client);
        }
        rs.close();
        statement.close();
        disconnect();
        return listClient;
    }

    @Override
    public Client getById(int id) throws SQLException {
        Client client = null;
        connect();
        jdbcConnection = getConnection();
        PreparedStatement statement = jdbcConnection.prepareStatement(SELECT_CLIENT_BY_ID);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String patronName = rs.getString("patron_name");
            String passport = rs.getString("passport");
            String telNum = rs.getString("tel_num");
            client = new Client(id, firstName, lastName, patronName, passport,telNum);
        }
        rs.close();
        statement.close();
        return client;
    }

    @Override
    public boolean update(Client client) throws SQLException {
        connect();
        jdbcConnection = getConnection();
        PreparedStatement statement = jdbcConnection.prepareStatement(UPDATE_CLIENTS_SQL);
        statement.setString(1, client.getFirstName());
        statement.setString(2, client.getLastName());
        statement.setString(3, client.getPatrName());
        statement.setString(4, client.getPassport());
        statement.setString(5, client.getTelNumber());
        statement.setInt(6, client.getId());
        boolean updatedRow = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return updatedRow;
    }

    @Override
    public boolean delete(Client client) throws SQLException {
        connect();
        jdbcConnection = getConnection();
        PreparedStatement statement = jdbcConnection.prepareStatement(DELETE_CLIENTS_SQL);
        statement.setInt(1, client.getId());
        boolean deletedRow = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return deletedRow;
    }
}
