/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.sql.SQLException;
import static view.AdminDashboard.notificationCountValue;

/**
 *
 * @author jaint
 */
public class updateNotificationCount extends DatabaseController {
    public void getCount() throws SQLException{
        setNotificationCount = con.prepareStatement("select NotificationCount from notification");
        setCount = setNotificationCount.executeQuery();
        while(setCount.next()){
            String count = setCount.getString("NotificationCount");
            notificationCountValue.setText(count);
        }
    }
}
