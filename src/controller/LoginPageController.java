/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.MatchUserDetails;
import view.FieldEmpty;

/**
 *
 * @author jaint
 */
public class LoginPageController {
    public void fetchLoginPageFieldData(String username, String password){
            if(!username.isBlank()){
                if(!password.isBlank()){
                    System.out.println(username + " " + password);
                    new MatchUserDetails().getLoginFormData(username, password);
            } else{
                    new FieldEmpty().setVisible(true);
           }
        }
    }       
}
