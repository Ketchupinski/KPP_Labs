package com.university.kpp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DepartmentApplication extends Application {
    public static boolean isAutoMode = false;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DepartmentApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Human Resources Department");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("auto")) {
            isAutoMode = true;
        }
        launch();
    }
}