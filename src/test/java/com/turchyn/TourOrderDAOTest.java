package com.turchyn;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import com.turchyn.tool.ConnectionDB;
import com.turchyn.usermanagement.dao.TourOrderDAO;
import com.turchyn.usermanagement.model.TourOrder;
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
public class TourOrderDAOTest {
    @Mock private ConnectionDB connectionDB;

    @Mock private Connection connection;

    @Mock private PreparedStatement statement;

    @Mock private ResultSet rs;

    private TourOrder tourOrder;

    @Before
    public void setUp() throws Exception{
        assertNotNull(connectionDB);
        when(connection.prepareStatement(any(String.class))).thenReturn(statement);
        when(connectionDB.getConnection()).thenReturn(connection);

        tourOrder = new TourOrder();
        tourOrder.setId(4);
        tourOrder.setDateOrder("2020-05-04");
        tourOrder.setClientCode(3);
        tourOrder.setTourCode(10);


        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(4);
        when(rs.getString(2)).thenReturn(tourOrder.getDateOrder());
        when(rs.getInt(3)).thenReturn(tourOrder.getClientCode());
        when(rs.getInt(4)).thenReturn(tourOrder.getTourCode());
    }
    @Test
    public void createTourOrderTest(){
        new TourOrderDAO(connectionDB).create(tourOrder);
    }
    @Test
    public void createAndGetByIdTourOrderTest() throws Exception{
        TourOrderDAO tourOrderDAO = new TourOrderDAO(connectionDB);
        tourOrderDAO.create(tourOrder);
        TourOrder to1 = tourOrderDAO.getById(4);
        assertEquals(tourOrder,to1);
    }
    @Test
    public void deleteTourOrderTest(){
        TourOrderDAO tourOrderDAO = new TourOrderDAO(connectionDB);
        tourOrderDAO.delete(tourOrder);
        TourOrder c1 = tourOrderDAO.getById(4);
        assertNull(c1);
    }
    @Test
    public void updateTourOrderTest(){
        TourOrderDAO tourOrderDAO = new TourOrderDAO(connectionDB);
        tourOrder.setDateOrder("2020-10-04");
        tourOrderDAO.update(tourOrder);
        TourOrder to1 = tourOrderDAO.getById(4);
        assertEquals("2020-10-04",to1.getDateOrder());
    }
    @Test
    public void listAllTourOrder(){
        TourOrderDAO tourOrderDAO = new TourOrderDAO(connectionDB);
        List<TourOrder> list = (List<TourOrder>) tourOrderDAO.read();
        assertNotNull(list.size());
    }
}
