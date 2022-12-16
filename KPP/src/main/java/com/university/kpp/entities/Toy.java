package com.university.kpp.entities;

import java.util.Objects;

public class Toy {
    private String name;
    private int cost;
    private int minAge;
    private int maxAge;
    private String additionalInfo;
    private int additionalNumber;

    public Toy(String name, String cost, String minAge, String maxAge, String additionalInfo, String additionalNumber) {
        this.name = name;
        this.cost = Integer.parseInt(cost);
        this.minAge = Integer.parseInt(minAge);
        this.maxAge = Integer.parseInt(maxAge);
        this.additionalInfo = additionalInfo;
        this.additionalNumber = Integer.parseInt(additionalNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public int getAdditionalNumber() {
        return additionalNumber;
    }

    public void setAdditionalNumber(int additionalNumber) {
        this.additionalNumber = additionalNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return cost == toy.cost && minAge == toy.minAge && maxAge == toy.maxAge && additionalNumber == toy.additionalNumber && Objects.equals(name, toy.name) && Objects.equals(additionalInfo, toy.additionalInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, minAge, maxAge, additionalInfo, additionalNumber);
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", additionalNumber=" + additionalNumber +
                '}';
    }
}
