module com.example.fitnesshelp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fitnesshelp to javafx.fxml;
    exports com.example.fitnesshelp;
    exports com.example.fitnesshelp.controllerGrafici;
    opens com.example.fitnesshelp.controllerGrafici to javafx.fxml;
}
