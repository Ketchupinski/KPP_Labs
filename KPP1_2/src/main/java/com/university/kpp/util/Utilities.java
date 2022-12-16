package com.university.kpp.util;

import com.university.kpp.entities.Worker;

import java.io.*;
import java.util.Comparator;
import java.util.List;

public final class Utilities {
    private Utilities() {
    }

    public static void sortByPassportSeries(List<Worker> container) {
        container.sort(Comparator.comparing(worker -> worker.getPassportInfo().getSeries()));
    }

    public static void sortByPassportNumber(List<Worker> container) {
        container.sort(Comparator.comparingInt(worker -> worker.getPassportInfo().getNumber()));
    }

    public static void sortBySalary(List<Worker> container) {
        container.sort(Comparator.comparingInt(Worker::getSalary));
    }

    public static void sortByAverageMark(List<Worker> container) {
        container.sort(Comparator.comparingDouble(Worker::getAverageMark));
    }

    public static void serializeWorkers(List<Worker> workers) {
        try (FileOutputStream fos = new FileOutputStream("workersData");
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(workers);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static List<Worker> deserializeWorkers() {
        Container<Worker> workers = new Container<>();

        try (FileInputStream fis = new FileInputStream("workersData");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            workers = (Container<Worker>) ois.readObject();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return workers;
    }

    public static boolean checkIfPassSeriesCorrect(String series) {
        series = prepareStringToCheck(series);
        return series.matches("^[A-Z]+M$"); // ...M
    }

    public static boolean checkIfPassSeriesCorrect(String series, String letter) {
        series = prepareStringToCheck(series);
        return series.matches("^[A-Z]+" + letter + "$");
    }

    public static boolean checkIfPassNumberCorrect(int number) {
        String numberString = String.valueOf(number);
        return numberString.matches("^\\d+8\\d+6\\d+$"); // ...8...6...
    }

    public static boolean checkIfLastNameCorrect(String lastName) {
        lastName = prepareStringToCheck(lastName);
        return lastName.matches("^Ap[a-z]+e[a-z]+$"); // Ар...е...
    }

    private static String prepareStringToCheck(String string) {
        string = string.replaceAll("\\s+", "");
        return string;
    }
}
