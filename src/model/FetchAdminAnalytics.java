/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.AdminDashboard;

/**
 *
 * @author jaint
 */
public class FetchAdminAnalytics extends DatabaseController {
     String totalFiles;
     String totalUser;
     String total_BannedUser;
   public  void FetchAdminAnalyticcs(){
       try {
           fetchAdminAnalytics = con.prepareStatement("select distinct COUNT(user_id) AS TOTAL_USER from cssp_users where role =  'user'");
           getAdminAnalytics = fetchAdminAnalytics.executeQuery();
           while(getAdminAnalytics.next()){
               totalUser = getAdminAnalytics.getString("TOTAL_USER");                
           }
           fetchTotalCodeFiles = con.prepareStatement("select COUNT(code_id) as CODE_FILES from cssp_files");
           totalCodeFiles = fetchTotalCodeFiles.executeQuery();
           while(totalCodeFiles.next()){
               totalFiles = totalCodeFiles.getString("CODE_FILES");
           }
           fetchTotalBannedUser = con.prepareStatement("select distinct COUNT(user_id) AS TOTAL_BANNED_USER from cssp_users where state = 1");
           totalBannedUser = fetchTotalBannedUser.executeQuery();
           while(totalBannedUser.next()){
               total_BannedUser = totalBannedUser.getString("TOTAL_BANNED_USER");
           }
           languageStats = con.prepareStatement("select MAX(COUNT(language)) from cssp_files");
           AdminDashboard.getAnalytics(totalUser,totalFiles,total_BannedUser);
       } catch (SQLException ex) {
           Logger.getLogger(FetchAdminAnalytics.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
