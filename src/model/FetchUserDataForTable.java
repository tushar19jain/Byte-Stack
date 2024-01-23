/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;
import static view.AllUserTable.userTable;

/**
 *
 * @author jaint
 */
public class FetchUserDataForTable extends DatabaseController {
       public void fetchUserDataForTable(){
           try {
               fetchUserData = con.prepareStatement("select user_id, first_name, last_name, username, state, role from cssp_users");
               fetchedUserData = fetchUserData.executeQuery();
               userTable.setModel(DbUtils.resultSetToTableModel(fetchedUserData));
           } catch (SQLException ex) {
               Logger.getLogger(FetchUserDataForTable.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
}
