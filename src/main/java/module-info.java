module com.example.onlinebankingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;


    opens com.payup to javafx.fxml;
    exports com.payup;
    exports com.payup.models;
    opens com.payup.models to javafx.fxml;
    exports com.payup.controllers.landing;
    opens com.payup.controllers.landing to javafx.fxml;
    exports com.payup.controllers.user.dashboard;
    opens com.payup.controllers.user.dashboard to javafx.fxml;
    exports com.payup.controllers.user.transaction;
    opens com.payup.controllers.user.transaction to javafx.fxml;

    exports com.payup.controllers.admin.dashboard;
    opens com.payup.controllers.admin.dashboard to  javafx.fxml;


}