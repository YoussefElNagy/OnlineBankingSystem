module com.example.onlinebankingsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.onlinebankingsystem to javafx.fxml;
    exports com.example.onlinebankingsystem;
}