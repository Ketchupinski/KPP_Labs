package com.university.kpp.util;

import com.university.kpp.entities.Career;
import com.university.kpp.entities.Characteristic;
import com.university.kpp.entities.PassportInfo;
import com.university.kpp.entities.Worker;

import java.util.List;

public class WorkerManager {
    private WorkerManager() {
    }

    public static List<Worker> createWorkers() {
        List<Worker> workers = new Container<>();

        List<Career> careerIvan = new Container<>();
        careerIvan.add(new Career("2010-01-01", "2012-01-01", "Manager", "IT"));
        careerIvan.add(new Career("2012-01-01", "2014-01-01", "Senior Manager", "IT"));
        List<Characteristic> characteristicsIvan = new Container<>();
        characteristicsIvan.add(new Characteristic("Honest", 5));
        characteristicsIvan.add(new Characteristic("Hardworking", 4));
        characteristicsIvan.add(new Characteristic("Responsible", 2));
        Worker workerIvan = new Worker("Ivan", "Aperen", new PassportInfo("LM", 989654),
                1000, "University Of IT", careerIvan, characteristicsIvan);
        workers.add(workerIvan);

        List<Career> careerPetr = new Container<>();
        careerPetr.add(new Career("2014-01-01", "2016-02-05", "Human Resource Manager", "Management"));
        careerPetr.add(new Career("2016-02-05", "2018-01-01", "Senior Human Resource Manager", "Management"));
        List<Characteristic> characteristicsPetr = new Container<>();
        characteristicsPetr.add(new Characteristic("Honest", 5));
        characteristicsPetr.add(new Characteristic("Stressful", 3));
        Worker workerPetr = new Worker("Petr", "Petrov", new PassportInfo("BB", 654321),
                2000, "University Of Management", careerPetr, characteristicsPetr);
        workers.add(workerPetr);

        List<Career> careerSidor = new Container<>();
        careerSidor.add(new Career("2018-01-01", "2020-06-01", "Junior Developer", "IT"));
        List<Characteristic> characteristicsSidor = new Container<>();
        characteristicsSidor.add(new Characteristic("Stressful", 2));
        characteristicsSidor.add(new Characteristic("Hardworking", 3));
        Worker workerSidor = new Worker("Sidor", "Apteka", new PassportInfo("CM", 987654),
                3000, "No University", careerSidor, characteristicsSidor);
        workers.add(workerSidor);

        List<Career> careerVasiliy = new Container<>();
        careerVasiliy.add(new Career("2018-05-01", "2020-01-01", "Middle Developer", "IT"));
        careerVasiliy.add(new Career("2020-01-01", "2022-01-01", "Senior Developer", "IT"));
        List<Characteristic> characteristicsVasiliy = new Container<>();
        characteristicsVasiliy.add(new Characteristic("Wild", 4));
        characteristicsVasiliy.add(new Characteristic("Sociability", 5));
        Worker workerVasiliy = new Worker("Vasiliy", "Apnequ", new PassportInfo("RK", 1285464),
                4000, "University Of Economics", careerVasiliy, characteristicsVasiliy);
        workers.add(workerVasiliy);
        return workers;
    }
}
