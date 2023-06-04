package com.payup.controllers.landing;

import com.payup.models.Bank;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MONEYBIT extends Application {
    public static Bank Moneybit = new Bank() ;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MONEYBIT.class.getResource("/layout/Welcome_Screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(new Image(getClass().getResource("/icons/logicon.png").toString()));
        stage.setTitle("MONEY BIT");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        Moneybit.setdatabase_Clients();
        launch();
    }
}