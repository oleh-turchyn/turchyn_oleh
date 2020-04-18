package com.turchyn.tours;

public class Holiday extends TourBase {
    private String tourType;

    public Holiday(int id,String tourTitle, String tourLocation, String tourTransport, String tourNutrition, int tourDuration, int tourPrice, String tourType) {
        super(id,tourTitle, tourLocation, tourTransport, tourNutrition, tourDuration, tourPrice);
        this.tourType = tourType;
    }

    public String getTourType() {
        return tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
    }

    @Override
    public String toString() {
        return "Holiday{" +
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
