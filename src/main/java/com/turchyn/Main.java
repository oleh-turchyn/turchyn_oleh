package com.turchyn;

import com.turchyn.usermanagement.dao.ClientDAO;
import com.turchyn.usermanagement.dao.OrderDAO;
import com.turchyn.usermanagement.model.Client;
import com.turchyn.usermanagement.model.Order;
import com.turchyn.usermanagement.service.ClientService;
import com.turchyn.usermanagement.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        ClientService clientService = new ClientService();
        List<Client> list = orderService.getAllData();

        System.out.println(list);
    }
}