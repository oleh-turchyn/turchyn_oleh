package com.turchyn;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import com.turchyn.tool.ConnectionDB;
import com.turchyn.usermanagement.dao.TourDAO;
import com.turchyn.usermanagement.model.TourBase;
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
public class TourDAOTest {
    @Mock private ConnectionDB connectionDB;

    @Mock private Connection connection;

    @Mock private PreparedStatement statement;

    @Mock private ResultSet rs;

//    private TourDAO tourDAO;
    private TourBase tour;

    @Before
    public void setUp() throws Exception{
        assertNotNull(connectionDB);
        when(connection.prepareStatement(any(String.class))).thenReturn(statement);
        when(connectionDB.getConnection()).thenReturn(connection);

        tour = new TourBase();
        tour.setId(1);
        tour.setTourTitle("Title");
        tour.setTourLocation("Lviv");
        tour.setTourTransport("bus");
        tour.setTourNutrition("all");
        tour.setTourDuration(3);
        tour.setTourPrice(560);

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(tour.getTourTitle());
        when(rs.getString(3)).thenReturn(tour.getTourLocation());
        when(rs.getString(4)).thenReturn(tour.getTourTransport());
        when(rs.getString(5)).thenReturn(tour.getTourNutrition());
        when(rs.getInt(6)).thenReturn(3);
        when(rs.getInt(7)).thenReturn(560);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void nullCreateThrowsException(){
//        new TourDAO(connectionDB).create(null);
//    }
    @Test
    public void createTourTest(){
        new TourDAO(connectionDB).create(tour);
    }

    @Test
    public void createAndGetByIdTourTest() throws Exception{
        TourDAO tourDAO = new TourDAO(connectionDB);
        tourDAO.create(tour);
        TourBase t1 = tourDAO.getById(1);
        assertEquals(tour,t1);
    }

    @Test
    public void deleteTourTest(){
        TourDAO tourDAO = new TourDAO(connectionDB);
        tourDAO.delete(tour);
        TourBase t1 = tourDAO.getById(1);
        assertNull(t1);
    }
    @Test
    public void updateTourTest(){
        TourDAO tourDAO = new TourDAO(connectionDB);
        tour.setTourPrice(500);
        tourDAO.update(tour);
        TourBase t1 = tourDAO.getById(1);
        assertEquals(500,t1.getTourPrice());

    }
    @Test
    public void listAllTest(){
        TourDAO tourDAO = new TourDAO(connectionDB);
        List<TourBase> list = (List<TourBase>) tourDAO.read();
        assertNotNull(list.size());
    }


}
