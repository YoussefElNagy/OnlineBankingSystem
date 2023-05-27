module com.example.onlinebankingsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.payup to javafx.fxml;
    exports com.payup;
    exports com.payup.models;
    opens com.payup.models to javafx.fxml;
    exports com.payup.controllers.landing;
    opens com.payup.controllers.landing to javafx.fxml;
}