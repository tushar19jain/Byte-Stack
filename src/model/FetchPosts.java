/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.awt.Component;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Dashboard;
import static view.Dashboard.postContainer;
import view.PostStructure;

/**
 *
 * @author jaint
 */
public class FetchPosts extends DatabaseController {
         public void fectPostPanels() throws SQLException{
        try {
            fetchUsersPost = con.prepareStatement("SELECT first_name,file_title, file_description, file_like_count, language, date_of_uplode, code_file , code_id FROM cssp_files NATURAL JOIN cssp_users where state = 0");
            fetchedPost = fetchUsersPost.executeQuery();
            while(fetchedPost.next()){
                String postTitle = fetchedPost.getString("file_title");
                String postDescription = fetchedPost.getString("file_description");
                String likeCount = fetchedPost.getString("file_like_count");
                String date = fetchedPost.getString("date_of_uplode");
                String language = fetchedPost.getString("language");
                String username = fetchedPost.getString("first_name");
                int code_id = fetchedPost.getInt("code_id");
                Blob  fileConetnt =  fetchedPost.getBlob("code_file");
                String textData = new String(fileConetnt.getBytes(1, (int)fileConetnt.length()));
                
                System.out.println(postTitle);
                System.out.println(postDescription);
                System.out.println(likeCount);
                
                PostStructure snippet = new PostStructure(postTitle,postDescription,likeCount,date.toString(),language, username,code_id,textData);
                postContainer.add(snippet);
                postContainer.revalidate();
                postContainer.repaint();
                System.out.println(snippet);
            }
                    } catch (SQLException ex) {
            Logger.getLogger(FetchPosts.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            fetchedPost.close();
        }
    }
}
