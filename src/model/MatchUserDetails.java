/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.sql.SQLException;
import view.AdminDashboard;
import view.BanNotice;
import view.Dashboard;
import view.InvalidPaaswordOrUsername;
/**
 *
 * @author jaint
 */
public class MatchUserDetails extends DatabaseController{
    private String usr;
    private String pwd;
    protected int token;
    protected String userRole;
    protected int userState;
    protected String realName;
    public void getLoginFormData(String username, String password){
        usr = username;
        pwd = password;
        try {
            matchUserCredential = con.prepareStatement("select user_id, role, state, first_name from cssp_users where username = ? and password = ?");
            matchUserCredential.setString(1,usr);
            matchUserCredential.setString(2,pwd);
            userID = matchUserCredential.executeQuery();
            while(userID.next()){
              token = userID.getInt(1);
              userRole = userID.getString("role");
              userState = userID.getInt("state");
              realName = userID.getString("first_name");
              System.out.println(token);
              TokenManager.setToken(token);
            }
            if(token != 0 && userRole.equals("user") && userState == 0){
                System.out.println("Logged In"); 
                    Dashboard dashboard = new Dashboard();
                      dashboard.fetchName(realName);
                    dashboard.setVisible(true);
                    System.out.println("In modal"+""+realName);
                     new FetchPosts().fectPostPanels();
            }else if(token !=0 && userRole.equals("admin")&& userState == 0){
                AdminDashboard admin_dashboard = new AdminDashboard();
                admin_dashboard.setVisible(true);
                 new updateNotificationCount().getCount();
                 FetchAdminAnalytics FetchAdminAnalytics = new FetchAdminAnalytics();
                 FetchAdminAnalytics.FetchAdminAnalyticcs();
            }else if(token !=0 && userRole.equals("user") && userState == 1){
               new BanNotice().setVisible(true);
            }else if(token == 0){
                System.out.println("Invalid");
                new InvalidPaaswordOrUsername().setVisible(true);
            }
        } catch (SQLException ex) {
        }
    }
 }
    