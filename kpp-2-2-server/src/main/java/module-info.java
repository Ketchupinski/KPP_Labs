module com.university.kpp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.university.kpp to javafx.fxml;
    exports com.university.kpp;
    exports com.university.kpp.util;
}