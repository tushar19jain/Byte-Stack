/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Dashboard;

/**
 *
 * @author jaint
 */
public class FetchUserRealName extends DatabaseController{
    public String realUserName;
    public void fetchUserRealName(){
        try {
            fetchUserRealName = con.prepareStatement("select first_name from cssp_user where user_id = ?");
            fetchUserRealName.setInt(1, TokenManager.getToken());
            realname = fetchUserRealName.executeQuery();
            while(realname.next()){
                realUserName = realname.getString("first_name");
                System.out.print(realUserName);
            }
            Dashboard db = new Dashboard();
            db.fetchName(realUserName);
            db.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FetchUserRealName.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
