module com.university {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.university to javafx.fxml;
    exports com.university;
    exports com.university.entities;
    exports com.university.util;
}