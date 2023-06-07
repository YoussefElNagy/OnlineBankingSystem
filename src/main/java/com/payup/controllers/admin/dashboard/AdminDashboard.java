package com.payup.controllers.admin.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;

public class AdminDashboard {
    @FXML
    private Text Transaction_label;

    @FXML
    private AnchorPane fragementContainer;

    @FXML
    private Text officier_label;

    @FXML
    void onNewClientClicked(MouseEvent event) {

    }

    @FXML
    void onOfficierclicked(MouseEvent event) {

    }

    @FXML
    void onprofileclickd(MouseEvent event) {

    }
//    @FXML
//    private Text Home_label;
//
//    @FXML
//    private Text Transaction_label;
//
//    @FXML
//    private AnchorPane fragementContainer;
//
//    @FXML
//    private Text officier_label;
//
//
//    @FXML
//    public void initialize() throws IOException {
//        AnchorPane lol = FXMLLoader.load(getClass().getResource("/layout/home_user.fxml"));
//        fragementContainer.getChildren().setAll(lol);
//        Home_label.setFont(Font.font(null, FontWeight.BOLD,15));
//    }
//
//    @FXML
//    void onOfficierclicked(MouseEvent event) throws IOException {
//        AnchorPane lol = FXMLLoader.load(getClass().getResource("/layout/officer_user.fxml"));
//        fragementContainer.getChildren().setAll(lol);
//        Transaction_label.setFont(Font.font(null,FontWeight.NORMAL,15));
//        Home_label.setFont(Font.font(null,FontWeight.NORMAL,15));
//        officier_label.setFont(Font.font(null,FontWeight.BOLD,15));
//
//    }
//
//    @FXML
//    void onNewClientClicked(MouseEvent event) throws IOException {
//        AnchorPane lol = FXMLLoader.load(getClass().getResource("/layout/add_client.fxml"));
//        fragementContainer.getChildren().setAll(lol);
//        Transaction_label.setFont(Font.font(null,FontWeight.BOLD,15));
//        Home_label.setFont(Font.font(null,FontWeight.NORMAL,15));
//        officier_label.setFont(Font.font(null,FontWeight.NORMAL,15));
//
//    }
//    @FXML
//    void onprofileclickd(MouseEvent event) throws IOException {
//        AnchorPane lol = FXMLLoader.load(getClass().getResource("/layout/profile_page.fxml"));
//        fragementContainer.getChildren().setAll(lol);
//    }
}
