package com.turchyn.usermanagement.model;

import java.io.Serializable;

public class TourOrder implements Serializable {
    protected int id;
    protected String dateOrder;
    protected int clientCode;
    protected int tourCode;

    public TourOrder(){}
    public TourOrder(int id){
        this.id=id;
    };
    public TourOrder(int id, String dateOrder, int clientCode,int tourCode){
        this(dateOrder,clientCode,tourCode);
        this.id=id;
    }

    public TourOrder(String dateOrder, int clientCode, int tourCode) {
        this.dateOrder = dateOrder;
        this.clientCode = clientCode;
        this.tourCode = tourCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getClientCode() {
        return clientCode;
    }

    public void setClientCode(int clientCode) {
        this.clientCode = clientCode;
    }

    public int getTourCode() {
        return tourCode;
    }

    public void setTourCode(int tourCode) {
        this.tourCode = tourCode;
    }

    @Override
    public String toString() {
        return "TourOrder{" +
                "id=" + id +
                ", dateOrder='" + dateOrder + '\'' +
                ", clientCode=" + clientCode +
                ", tourCode=" + tourCode +
                '}';
    }
}
