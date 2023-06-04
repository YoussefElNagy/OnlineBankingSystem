package com.payup.controllers.user.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Dashboarduser {

    @FXML
    private AnchorPane fragementContainer;

    @FXML
    void Onhomeclicked(MouseEvent event) throws IOException {
        AnchorPane lol = FXMLLoader.load(getClass().getResource("/layout/home_user.fxml"));
        fragementContainer.getChildren().setAll(lol);


    }

    @FXML
    void onOfficierclicked(MouseEvent event) throws IOException {
        AnchorPane lol = FXMLLoader.load(getClass().getResource("/layout/officer_user.fxml"));
        fragementContainer.getChildren().setAll(lol);

    }

    @FXML
    void ontransactionclicked(MouseEvent event) throws IOException {
        AnchorPane lol = FXMLLoader.load(getClass().getResource("/layout/tranaction_user.fxml"));
        fragementContainer.getChildren().setAll(lol);

    }
    @FXML
    void onprofileclickd(MouseEvent event) throws IOException {
        AnchorPane lol = FXMLLoader.load(getClass().getResource("/layout/home_user.fxml"));
        fragementContainer.getChildren().setAll(lol);
    }


}
