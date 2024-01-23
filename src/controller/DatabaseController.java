/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.*;
/**
 *
 * @author jaint
 */

public class DatabaseController {
   protected Connection con;
   protected PreparedStatement matchUserCredential;
   protected ResultSet userID;
   protected PreparedStatement createNewUser;
   protected PreparedStatement fetchUserRealName;
   protected PreparedStatement createNewPost;
   protected ResultSet realname;
   protected PreparedStatement fetchUsersPost;
   protected PreparedStatement fetchUsernameForPost;
   protected ResultSet usernameForPost;
   protected ResultSet fetchedPost;
   protected PreparedStatement fetchAdminAnalytics;
   protected ResultSet getAdminAnalytics;
   protected PreparedStatement fetchTotalCodeFiles;
   protected ResultSet totalCodeFiles;
   protected PreparedStatement fetchTotalBannedUser;
   protected ResultSet totalBannedUser;
   protected PreparedStatement fetchAdminBanUser;
   protected ResultSet getBanUser;
   protected PreparedStatement fillUserTableRow;
   protected ResultSet getUserRow;
   protected PreparedStatement fetchUserOwnedPost;
   protected ResultSet userOwnedPost;
   protected PreparedStatement deleteUserSnippet;
   protected ResultSet statusOfSnippetDeletion;
   protected PreparedStatement likeCodeSnippet;
   protected PreparedStatement updateLikeCount;
   protected PreparedStatement languageStats;
   protected ResultSet languageStatsResult;
   protected PreparedStatement fetchUserDetails;
   protected ResultSet userDetails;
   protected PreparedStatement fetchUserData;
   protected ResultSet fetchedUserData;
   protected PreparedStatement fetchFilesData;
   protected ResultSet fetchedFilesData;
   protected PreparedStatement registerUserReport;
   protected ResultSet registeredUserReport;
   protected PreparedStatement updateNotificationCount;
   protected PreparedStatement setNotificationCount;
   protected ResultSet setCount;
   protected PreparedStatement fetchRepoertedUserData;
   protected ResultSet setPanelForRepoertedUserData;
   protected PreparedStatement userDetailsStructureModel;
   protected ResultSet userDetailsStructurePanels;
   protected PreparedStatement resetNotificationCount;
   protected PreparedStatement imposeBanOnUser;
   protected PreparedStatement fetchUserFile;
   protected ResultSet getFileData;
   public DatabaseController(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cssp?zeroDateTimeBehavior=CONVERT_TO_NULL");
   }catch(ClassNotFoundException | SQLException e){
       System.out.println(e);
   }
  }
}

