package com.university.kpp.util;

import com.university.kpp.entities.Toy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public final class FileManager {
    private FileManager() {}

    private static final String CONFIG_FILE = "src/main/resources/config.properties";

    private static String getFileName() {
        String fileName = "";
        try(FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileName = properties.getProperty("fileName");
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public static List<Toy> getToysInfo() {
        String fileName = getFileName();
        File file = new File(fileName);
        List<Toy> toys = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] toyInfo = line.split("\\|");
                prepareStrings(toyInfo);
                Toy toy = new Toy(toyInfo[0], toyInfo[1], toyInfo[2], toyInfo[3], toyInfo[4], toyInfo[5]);
                toys.add(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toys;
    }

    private static void prepareStrings(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].trim();
        }
    }
}
