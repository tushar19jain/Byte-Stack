/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.BanSuccessMessage;
import view.userDetailsStructure;

/**
 *
 * @author jaint
 */
public class ImposeBan extends DatabaseController {
    public void imposeBan(String user){
        String username = user;
        try {
            imposeBanOnUser = con.prepareStatement("update cssp_users set state = 1 where username = ?");
            imposeBanOnUser.setString(1,username);
            int rowAffected = imposeBanOnUser.executeUpdate();
            if(rowAffected > 0){
                new BanSuccessMessage().setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImposeBan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
