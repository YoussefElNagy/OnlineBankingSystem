package com.payup.controllers.user.transaction;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;
import java.util.Objects;

import static java.lang.Double.parseDouble;


public class Transactionusercontrolller {
//urself
@FXML
private TextField accnumur2;

    @FXML
    private TextField acnumur1;
    @FXML
    private TextField amountur;
 // another account
 @FXML
 private TextField usrotheaccnum1;

    @FXML
    private TextField usrotheaccnum2;

    @FXML
    private TextField usrotheaccusr1;

    @FXML
    private TextField usrotheaccusr2;

    @FXML
    private TextField amountother;

    // anline purchases

    @FXML
    private TextField accnumpurs1;

    @FXML
    private TextField accnumpurs2;



    @FXML
    private TextField amountpurs;

 // pay bills

    @FXML
    private TextField accnumbill1;

    @FXML
    private ComboBox<String> combobill;



//buttons

    @FXML
    private Button butother;

    @FXML
    private Button butpaybill;

    @FXML
    private Button butpurrch;

    @FXML
    private Button butur;


    @FXML
    public void initialize() {

    }



    @FXML
    void paybillbtn(MouseEvent event) {

    }

    @FXML
    void purchasebtn(MouseEvent event) {

    }

    @FXML
    void transfer_to_otheracc(MouseEvent event) {

    }

    @FXML
    void transfer_to_urself(MouseEvent event) {
        if (Objects.equals(accnumur2.getText().trim(), "") || Objects.equals(acnumur1.getText().trim(), "") || Objects.equals(amountur.getText().trim(), "")) {
            if(Objects.equals(accnumur2.getText().trim(), acnumur1.getText().trim())){
            Alert as = new Alert(Alert.AlertType.ERROR);
            as.setTitle("Invalid Data");
            as.setContentText("Please Try again ");
            as.showAndWait();
            }

        }else {
            double amount = parseDouble(amountur.getText());
            opendialog(accnumur2.getText(),acnumur1.getText(),amount);
        }

    }





    void opendialog(String x1, String x2 , double amount){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Transactionusercontrolller.class.getResource("/layout/Confirmpayment.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
//            Logger.getLogger(ProffStaff.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConfirmTransaction confirmTransaction1 = loader.getController();
        confirmTransaction1.senddata(x1,x2,amount);

        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.getIcons().add(new Image(getClass().getResource("/icons/logicon.png").toString()));
        stage.setTitle("MONEY BIT");
        stage.setScene(new Scene(parent));
        stage.show();
    }

}
