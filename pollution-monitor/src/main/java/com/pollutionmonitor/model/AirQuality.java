package com.pollutionmonitor.model;

import java.util.Date;

public class AirQuality {
    
    private Date date;

    public AirQuality() {
    }

    public AirQuality(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AirQuality [date=" + date + "]";
    } 
}
