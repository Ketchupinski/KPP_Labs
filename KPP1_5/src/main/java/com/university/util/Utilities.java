package com.university.util;

import com.university.entities.*;

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
}
