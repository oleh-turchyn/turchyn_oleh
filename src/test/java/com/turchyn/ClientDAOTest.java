package com.turchyn;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import com.turchyn.tool.ConnectionDB;
import com.turchyn.usermanagement.dao.ClientDAO;
import com.turchyn.usermanagement.model.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ClientDAOTest {
    @Mock private ConnectionDB connectionDB;

    @Mock private Connection connection;

    @Mock private PreparedStatement statement;

    @Mock private ResultSet rs;

    private Client client;

    @Before
    public void setUp() throws Exception{
        assertNotNull(connectionDB);
        when(connection.prepareStatement(any(String.class))).thenReturn(statement);
        when(connectionDB.getConnection()).thenReturn(connection);

        client = new Client();
        client.setId(3);
        client.setFirstName("Jason");
        client.setLastName("Warn");
        client.setPatrName("Jon");
        client.setPassport("003");
        client.setTelNumber("39033");

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(3);
        when(rs.getString(2)).thenReturn(client.getFirstName());
        when(rs.getString(3)).thenReturn(client.getLastName());
        when(rs.getString(4)).thenReturn(client.getPatrName());
        when(rs.getString(5)).thenReturn(client.getPassport());
        when(rs.getString(6)).thenReturn(client.getTelNumber());
    }
    @Test
    public void createClientTest(){
        new ClientDAO(connectionDB).create(client);
    }
    @Test
    public void createAndGetByIdClientTest() throws Exception{
        ClientDAO clientDAO = new ClientDAO(connectionDB);
        clientDAO.create(client);
        Client c1 = clientDAO.getById(3);
        assertEquals(client,c1);
    }
    @Test
    public void deleteClientTest(){
        ClientDAO clientDAO = new ClientDAO(connectionDB);
        clientDAO.delete(client);
        Client c1 = clientDAO.getById(1);
        assertNull(c1);
    }
    @Test
    public void updateTourTest(){
        ClientDAO clientDAO = new ClientDAO(connectionDB);
        client.setPassport("00001");
        clientDAO.update(client);
        Client c1 = clientDAO.getById(1);
        assertEquals("00001",c1.getPassport());
    }
    @Test
    public void listAllTest(){
        ClientDAO clientDAO = new ClientDAO(connectionDB);
        List<Client> list = (List<Client>) clientDAO.read();
        assertNotNull(list.size());
    }
}
