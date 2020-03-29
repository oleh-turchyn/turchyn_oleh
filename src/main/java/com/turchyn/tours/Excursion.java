package com.turchyn.tours;

public class Excursion extends TourBase {
    private  String tourType;

    public Excursion(String tourTitle, String tourLocation, String tourTransport, String tourNutrition, int tourDuration, int tourPrice, String tourType) {
        super(tourTitle, tourLocation, tourTransport, tourNutrition, tourDuration, tourPrice);
        this.tourType=tourType;
    }

    public String getTourType() {
        return tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "tourType='" + tourType + '\'' +
                ", tourTitle='" + tourTitle + '\'' +
                ", tourLocation='" + tourLocation + '\'' +
                ", tourTransport='" + tourTransport + '\'' +
                ", tourNutrition='" + tourNutrition + '\'' +
                ", tourDuration=" + tourDuration +
                ", tourPrice=" + tourPrice +
                '}';
    }
}
