package com.turchyn.usermanagement.dao;

import com.turchyn.tool.ConnectionDB;
import com.turchyn.usermanagement.model.Client;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements GeneralDAO<Client> {
    private static Logger logger = Logger.getLogger(ClientDAO.class.getName());
    private static final String INSERT_CLIENTS_SQL = "INSERT INTO clients" + "  (first_name, last_name, patron_name, passport, tel_num) VALUES " +
            " (?, ?, ?, ?, ?);";
    private static final String SELECT_CLIENT_BY_ID = "select * from clients where id=?";
    private static final String SELECT_ALL_CLIENTS = "select * from clients";
    private static final String DELETE_CLIENTS_SQL = "delete from clients where id=?";
    private static final String UPDATE_CLIENTS_SQL = "update clients set first_name = ?, last_name = ?, patron_name = ?, passport = ?, tel_num = ? where id = ?;";

    @Override
    public void create(Client client) {
        try (Connection c = ConnectionDB.getInstance().getConnection();
             PreparedStatement statement = c.prepareStatement(INSERT_CLIENTS_SQL);
        ) {
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getPatrName());
            statement.setString(4, client.getPassport());
            statement.setString(5, client.getTelNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with create new field of ClientDAO");
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<Client> read() {
        List<Client> listClient = new ArrayList<>();
        try (Connection c = ConnectionDB.getInstance().getConnection();
             Statement statement = c.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_CLIENTS);
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String patronName = rs.getString("patron_name");
                String passport = rs.getString("passport");
                String telNum = rs.getString("tel_num");
                Client client = new Client(id, firstName, lastName, patronName, passport, telNum);
                listClient.add(client);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view list of ClientDAO");
            logger.error(e.getMessage());
        }
        return listClient;
    }

    @Override
    public Client getById(int id) {
        Client client = null;
        try (
                Connection c = ConnectionDB.getInstance().getConnection();
                PreparedStatement statement = c.prepareStatement(SELECT_CLIENT_BY_ID);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String patronName = rs.getString("patron_name");
                String passport = rs.getString("passport");
                String telNum = rs.getString("tel_num");
                client = new Client(id, firstName, lastName, patronName, passport, telNum);
            }
        } catch (SQLException e) {
            logger.error("Some problems with view ClientDAO by ID");
            logger.error(e.getMessage());
        }
        return client;
    }

    @Override
    public void update(Client client) {
        try (Connection c = ConnectionDB.getInstance().getConnection();
             PreparedStatement statement = c.prepareStatement(UPDATE_CLIENTS_SQL);) {
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getPatrName());
            statement.setString(4, client.getPassport());
            statement.setString(5, client.getTelNumber());
            statement.setInt(6, client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with update field of ClientDao");
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(Client client) {
        try (
                Connection c = ConnectionDB.getInstance().getConnection();
                PreparedStatement statement = c.prepareStatement(DELETE_CLIENTS_SQL);
        ) {
            statement.setInt(1, client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Some problems with delete field of ClientDAO");
            logger.error(e.getMessage());
        }
    }
}
