package com.university.kpp.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Worker implements Serializable {
    private String firstName;
    private String lastName;
    private PassportInfo passportInfo;
    private int salary;
    private String education;
    private List<Career> career;
    private List<Characteristic> characteristics;

    @Serial
    private static final long serialVersionUID = 41242421L;

    public Worker() {}

    public Worker(String firstName, String lastName, PassportInfo passportInfo, int salary,
                  String education, List<Career> career, List<Characteristic> characteristics) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportInfo = passportInfo;
        this.salary = salary;
        this.education = education;
        this.career = career;
        this.characteristics = characteristics;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PassportInfo getPassportInfo() {
        return passportInfo;
    }

    public void setPassportInfo(PassportInfo passportInfo) {
        this.passportInfo = passportInfo;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<Career> getCareer() {
        return career;
    }

    public void setCareer(List<Career> career) {
        this.career = career;
    }

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public double getAverageMark() {
        return characteristics.stream()
                .mapToInt(Characteristic::getValue)
                .average()
                .orElse(0);
    }
}
