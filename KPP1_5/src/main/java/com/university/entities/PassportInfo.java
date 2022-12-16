package com.university.entities;

import java.io.Serial;
import java.io.Serializable;

public class PassportInfo implements Serializable {
    private String series;
    private int number;

    @Serial
    private static final long serialVersionUID = 41242111L;

    public PassportInfo(String series, int number) {
        this.series = series;
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
