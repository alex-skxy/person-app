module alexskxy.personapp {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires com.google.gson;
    exports alexskxy.personapp.entity to com.google.gson;
    opens alexskxy.personapp.entity to com.google.gson;
    opens alexskxy.personapp;
}