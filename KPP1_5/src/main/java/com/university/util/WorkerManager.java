package com.university.util;

import com.university.entities.*;

import java.util.ArrayList;
import java.util.List;

public class WorkerManager {
    private WorkerManager() {
    }

    public static List<Worker> createWorkers() {
        List<Worker> workers = new ArrayList<>();

        List<Career> careerIvan = new ArrayList<>();
        careerIvan.add(new Career("2010-01-01", "2012-01-01", "Manager", "IT"));
        careerIvan.add(new Career("2012-01-01", "2014-01-01", "Senior Manager", "IT"));
        List<Characteristic> characteristicsIvan = new ArrayList<>();
        characteristicsIvan.add(new Characteristic("Honest", 5));
        characteristicsIvan.add(new Characteristic("Hardworking", 4));
        characteristicsIvan.add(new Characteristic("Responsible", 5));
        Worker workerIvan = new Worker("Ivan", "Ivanov", new PassportInfo("ZL", 954321),
                1000, "University Of IT", careerIvan, characteristicsIvan);
        workers.add(workerIvan);

        List<Career> careerPetr = new ArrayList<>();
        careerPetr.add(new Career("2014-01-01", "2016-02-05", "Human Resource Manager", "Management"));
        careerPetr.add(new Career("2016-02-05", "2018-01-01", "Senior Human Resource Manager", "Management"));
        List<Characteristic> characteristicsPetr = new ArrayList<>();
        characteristicsPetr.add(new Characteristic("Honest", 3));
        characteristicsPetr.add(new Characteristic("Stressful", 4));
        Worker workerPetr = new Worker("Petr", "Petrov", new PassportInfo("TM", 654321),
                2000, "University Of Management", careerPetr, characteristicsPetr);
        workers.add(workerPetr);

        List<Career> careerSidor = new ArrayList<>();
        careerSidor.add(new Career("2018-01-01", "2020-06-01", "Junior Developer", "IT"));
        List<Characteristic> characteristicsSidor = new ArrayList<>();
        characteristicsSidor.add(new Characteristic("Stressful", 4));
        characteristicsSidor.add(new Characteristic("Hardworking", 5));
        Worker workerSidor = new Worker("Sidor", "Apteka", new PassportInfo("CM", 987654),
                3000, "No University", careerSidor, characteristicsSidor);
        workers.add(workerSidor);

        List<Career> careerVasiliy = new ArrayList<>();
        careerVasiliy.add(new Career("2018-05-01", "2020-01-01", "Middle Developer", "IT"));
        careerVasiliy.add(new Career("2020-01-01", "2022-01-01", "Senior Developer", "IT"));
        List<Characteristic> characteristicsVasiliy = new ArrayList<>();
        characteristicsVasiliy.add(new Characteristic("Wild", 5));
        characteristicsVasiliy.add(new Characteristic("Sociability", 3));
        Worker workerVasiliy = new Worker("Vasiliy", "Apnequ", new PassportInfo("RM", 12854699),
                4000, "University Of Economics", careerVasiliy, characteristicsVasiliy);
        workers.add(workerVasiliy);
        return workers;
    }
}
