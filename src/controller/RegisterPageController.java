/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.CreateUser;
import view.Insufficient_Information;

/**
 *
 * @author jaint
 */
public class RegisterPageController {
    public void getRegisterFormData(String firstname, String lastname, String username, String password, String confirmpassword, String securityquestion, String securityanswer){
        if(!firstname.isBlank())
        {
            if(!lastname.isBlank())
            {
                if(!username.isBlank())
                {
                    if(!password.isBlank())
                    {
                        if(!confirmpassword.isBlank())
                        {
                            if(!securityquestion.isBlank() && !securityanswer.isBlank())
                            {
                                if(password.equals(confirmpassword))
                                {
                                    CreateUser createUser = new CreateUser();
                                    createUser.getRegisterFormData(firstname,lastname,username,password,securityquestion,securityanswer);
                                }                              }
                        }
                    }
                }
            }
        }
    }
}
