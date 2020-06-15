package com.turchyn.usermanagement.model;

public class TourBase {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected int id;
    protected String tourTitle;
    //protected String tourType;
    protected String tourLocation;
    protected String tourTransport;
    protected String tourNutrition;
    protected int tourDuration; // number of days
    protected int tourPrice;


    public TourBase(){}
    public TourBase(int id){
        this.id = id;
    }
    public TourBase(int id,String tourTitle, String tourLocation, String tourTransport, String tourNutrition, int tourDuration, int tourPrice) {
        this(tourTitle,tourLocation,tourTransport,tourNutrition,tourDuration,tourPrice);
        this.id=id;
    }
    public TourBase(String tourTitle, String tourLocation, String tourTransport, String tourNutrition, int tourDuration, int tourPrice){
        this.tourTitle = tourTitle;
        this.tourLocation = tourLocation;
        this.tourTransport = tourTransport;
        this.tourNutrition = tourNutrition;
        this.tourDuration = tourDuration;
        this.tourPrice = tourPrice;
    }

    public String getTourTitle() {
        return tourTitle;
    }

    public void setTourTitle(String tourTitle) {
        this.tourTitle = tourTitle;
    }

    public String getTourLocation() {
        return tourLocation;
    }

    public void setTourLocation(String tourLocation) {
        this.tourLocation = tourLocation;
    }

    public String getTourTransport() {
        return tourTransport;
    }

    public void setTourTransport(String tourTransport) {
        this.tourTransport = tourTransport;
    }

    public String getTourNutrition() {
        return tourNutrition;
    }

    public void setTourNutrition(String tourNutrition) {
        this.tourNutrition = tourNutrition;
    }

    public int getTourDuration() {
        return tourDuration;
    }

    public void setTourDuration(int tourDuration) {
        this.tourDuration = tourDuration;
    }

    public int getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(int tourPrice) {
        this.tourPrice = tourPrice;
    }

    @Override
    public String toString() {
        return "TourBase{" +
                "tourID='" + id + '\'' +
                "tourTitle='" + tourTitle + '\'' +
                ", tourLocation='" + tourLocation + '\'' +
                ", tourTransport='" + tourTransport + '\'' +
                ", tourNutrition='" + tourNutrition + '\'' +
                ", tourDuration=" + tourDuration +
                ", tourPrice=" + tourPrice +
                '}';
    }
}
