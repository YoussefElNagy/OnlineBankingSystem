package com.payup.controllers.landing;

import com.payup.NotificationPanel;
import com.payup.controllers.SceneController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;



public class HelloController {

    @FXML
    void loginUserclicked(MouseEvent event) {
        SceneController.showClientloginScene(event);
    }

    @FXML
    void loginadminClicked(MouseEvent event)
    {



    }

}
