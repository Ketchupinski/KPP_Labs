package com.university.kpp.entities;

import java.io.Serial;
import java.io.Serializable;

public class Career implements Serializable {
    private String startDate;
    private String endDate;
    private String position;
    private String department;

    @Serial
    private static final long serialVersionUID = 412L;

    public Career(String startDate, String endDate, String position, String department) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.department = department;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
