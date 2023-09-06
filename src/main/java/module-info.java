module com.example.fitnesshelp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.xml.crypto;
    requires java.datatransfer;
    requires javafx.web;


    opens com.example.fitnesshelp to javafx.fxml;
    exports com.example.fitnesshelp;
    exports com.example.fitnesshelp.graphics_controllers;
    exports com.example.fitnesshelp.entities;
    opens com.example.fitnesshelp.graphics_controllers to javafx.fxml;
}
