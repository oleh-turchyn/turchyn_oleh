package com.turchyn;

import com.turchyn.usermanagement.model.OrderDetail;
import com.turchyn.usermanagement.model.TourOrder;

import com.turchyn.usermanagement.service.OrderDetailService;
import com.turchyn.usermanagement.service.TourOrderService;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
//        OrderService orderService = new OrderService();
//        ClientService clientService = new ClientService();
//        TourOrderService tourOrderService = new TourOrderService();
        OrderDetailService orderDetailService = new OrderDetailService();
        List<OrderDetail> list = orderDetailService.getAllData();

        System.out.println(list);
    }
}