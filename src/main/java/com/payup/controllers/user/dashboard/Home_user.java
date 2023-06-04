package com.payup.controllers.user.dashboard;


import com.payup.models.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Home_user {

    @FXML
    private Text datelabel;

    @FXML
    private Text hellosign;

    @FXML
    private Label accountnumber;

    @FXML
    private Label accountnumber1;

    @FXML
    public void initialize() {
       // Client C = new Client("Miso","Clown" ,"username,", "password");
       // hellosign.setText("Hello " + C.getFirstName() +" "+ C.getLastName()  +", Welcome Back");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMMM-YYYY");
        LocalDateTime now = LocalDateTime.now();
        datelabel.setText(dtf.format(now));
    }

    @FXML
    void nextcardclicked(MouseEvent event) {

    }

    @FXML
    void prevcardclicked(MouseEvent event) {

    }

}

