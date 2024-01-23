/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static view.AdminDashboard.notificationCountValue;
import view.NotificationDashboard;
import view.userDetailsStructure;

/**
 *
 * @author jaint
 */
public class FetchReportedUserData extends DatabaseController {
    public void fetchReportUserData(){
       ArrayList<Integer> userIds = new ArrayList<>();
        try {
            fetchRepoertedUserData = con.prepareStatement("select DISTINCT cssp_files.user_id as reported_user from cssp_files, report_table where cssp_files.code_id = report_table.code_id ");
            setPanelForRepoertedUserData = fetchRepoertedUserData.executeQuery();
            while(setPanelForRepoertedUserData.next()){
                 userIds.add(setPanelForRepoertedUserData.getInt("reported_user"));
            }
            resetNotificationCount = con.prepareStatement("UPDATE notification SET NotificationCount = 0 ");
            resetNotificationCount.executeUpdate();
            notificationCountValue.setText("0");
            userDetailsStructureModel = con.prepareStatement("select username, state, role from cssp_users where user_id = ?");
            for(int i = 0 ; i <userIds.size()  ; i++ ){
                userDetailsStructureModel.setInt(1, userIds.get(i));
                userDetailsStructurePanels = userDetailsStructureModel.executeQuery();
                while(userDetailsStructurePanels.next()){
                    String usr = userDetailsStructurePanels.getString("username");
                    String s = userDetailsStructurePanels.getString("state");
                    String r = userDetailsStructurePanels.getString("role");
                    userDetailsStructure usd = new userDetailsStructure(usr,r,s);
                    NotificationDashboard.reportContainer.add(usd);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FetchReportedUserData.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
        // Close the result set
        if (userDetailsStructurePanels != null) {
            try {
                userDetailsStructurePanels.close();
            } catch (SQLException ex) {
                Logger.getLogger(FetchReportedUserData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
       }
}
