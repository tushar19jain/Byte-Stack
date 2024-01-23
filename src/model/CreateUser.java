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
import view.LoginPage;
import view.SuccessMessage;

/**
 *
 * @author jaint
 */

public class CreateUser extends DatabaseController {

     public void getRegisterFormData(String firstName, String lastName, String userName, String passWord, String securityQuestion, String securityAnswer){
        try {
            createNewUser = con.prepareStatement("INSERT INTO cssp_users(first_name,last_name,username,password,security_question,security_answer) VALUES (?,?,?,?,?,?)");
            createNewUser.setString(1, firstName);                        
            createNewUser.setString(2, lastName);
            createNewUser.setString(3, userName);
            createNewUser.setString(4, passWord);
            createNewUser.setString(5, securityQuestion);
            createNewUser.setString(6, securityAnswer);
            int rowAffected = createNewUser.executeUpdate();
            if(rowAffected == 1){
                new SuccessMessage().setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
