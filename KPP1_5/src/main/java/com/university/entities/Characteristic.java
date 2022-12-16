package com.university.entities;

import java.io.Serial;
import java.io.Serializable;

public class Characteristic implements Serializable {
    private String name;
    private int value;

    @Serial
    private static final long serialVersionUID = 41242L;

    public Characteristic(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
