package com.payup.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.EventObject;

public class SceneController {

    private static void showScene(Parent parent, EventObject eventObject) {
        Stage stage = (Stage) ((Node)eventObject.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public static void showuserdash(EventObject eventObject) {
        try {
            Parent root = FXMLLoader.load(SceneController.class.getResource("/layout/Dashboard_user.fxml"));
            showScene(root, eventObject);
        }catch (IOException e) { }
    }
    public static void showClientloginScene(EventObject eventObject) {
        try {
            Parent root = FXMLLoader.load(SceneController.class.getResource("/layout/login_user.fxml"));
            showScene(root, eventObject);
        }catch (IOException e) { }
    }
//
    public static void showWelcome(EventObject eventObject) {
        try {
            Parent root = FXMLLoader.load(SceneController.class.getResource("/layout/Welcome_Screen.fxml"));
            showScene(root, eventObject);
        }catch (IOException e) { }
    }
//    public static void showDashboardScene(EventObject eventObject) {
//        try {
//            Parent root = FXMLLoader.load(SceneController.class.getResource("/layout/dashboardStaff.fxml"));
//            showScene(root, eventObject);
//        }catch (IOException e) { }
//    }
//    public static void showDashboardproffScene(EventObject eventObject) {
//        try {
//            Parent root = FXMLLoader.load(SceneController.class.getResource("/layout/dashboardproff.fxml"));
//            showScene(root, eventObject);
//        }catch (IOException e) { }
//    }
//    public static void showDashboardstudentScene(EventObject eventObject) {
//        try {
//            Parent root = FXMLLoader.load(SceneController.class.getResource("/layout/dashboardStudent.fxml"));
//            showScene(root, eventObject);
//        }catch (IOException e) { }
//    }
//
//
//    public static void showStudentloginScene(EventObject eventObject) {
//        try {
//            Parent root = FXMLLoader.load(SceneController.class.getResource("/layout/loginStudent.fxml"));
//            showScene(root, eventObject);
//        }catch (IOException e) { }
//    }
}
