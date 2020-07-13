package com.turchyn;

import com.turchyn.tool.ConnectionDB;
import com.turchyn.usermanagement.dao.OrderDetailDAO;
import com.turchyn.usermanagement.model.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class OrderDetailTest {
    @Mock
    private ConnectionDB connectionDB;
    private OrderDetail orderDetail;
    @Test
    public void listAllTest(){
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO(connectionDB);
        List<OrderDetail> list = (List<OrderDetail>) orderDetailDAO.read();
        assertNotNull(list.size());
    }
}

