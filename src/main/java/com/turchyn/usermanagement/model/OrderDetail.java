package com.turchyn.usermanagement.model;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    protected int orderId;
    protected String dateOrder;
    protected String clientName;
    protected String clientSurname;
    protected String titleTour;

    public OrderDetail(){}
    public OrderDetail(int orderId){
        this.orderId=orderId;
    }
    public OrderDetail(int orderId, String dateOrder, String clientName, String clientSurname, String titleTour){
        this(dateOrder,clientName,clientSurname,titleTour);
        this.orderId = orderId;
    }

    public OrderDetail(String dateOrder, String clientName, String clientSurname, String titleTour) {
        this.dateOrder = dateOrder;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.titleTour = titleTour;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getTitleTour() {
        return titleTour;
    }

    public void setTitleTour(String titleTour) {
        this.titleTour = titleTour;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", dateOrder='" + dateOrder + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", titleTour='" + titleTour + '\'' +
                '}';
    }
}
