package com.payup;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.net.URISyntaxException;
import java.util.Objects;

public class NotificationPanel {
    static String y ;
    public static void setText(String y1){
       y = y1 ;
    }
    public static String getText(){
        return  y;
    }

    public  static void setNotifications(String y)  {
        Image tick = new Image(Objects.requireNonNull(NotificationPanel.class.getResource("/icons/icons8-correct-64.png")).toString());
        Image cross = new Image(Objects.requireNonNull(NotificationPanel.class.getResource("/icons/false.png")).toString());
        int x = switch (y) {
            case "Bill Paid Successfully", "Transaction Completed Successfully!" -> 1;
            case "Transaction Failed!", "Insufficient Funds" -> 0;
            default -> 0;
        };

        Notifications notification = Notifications.create()
                .title("Status")

                .darkStyle()
                .text(y)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);


        switch (x) {
            case 0 -> {
                notification.graphic(new ImageView(cross));
                notification.show();
            }
            case 1 -> {
                notification.graphic(new ImageView(tick));
                notification.show();
            }
        }



    }


}
