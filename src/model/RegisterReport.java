/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaint
 */
public class RegisterReport extends DatabaseController {
    public void registerReport(int code_id, String filename){
        int user_id = TokenManager.getToken();
        int file_id = code_id;
        String title = filename;
        try {
            registerUserReport = con.prepareStatement("insert into report_table values(?,?,?)");
            registerUserReport.setInt(1,user_id);
            registerUserReport.setInt(2,file_id);
            registerUserReport.setString(3,title);
            int rowAffected = registerUserReport.executeUpdate();
            if(rowAffected > 0){
                updateNotificationCount = con.prepareStatement("update notification set NotificationCount = NotificationCount + 1");
                updateNotificationCount.executeUpdate();
 
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(RegisterReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
