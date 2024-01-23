/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static view.Dashboard.postContainer;
import view.FileUploadSuccess;

/**
 *
 * @author jaint
 */
public class CreatePost extends DatabaseController{
    public void fetchPostDetails(String filename , String fileDescription, String selectedItem, String path){
        int user_id = TokenManager.getToken();
        try {
            createNewPost = con.prepareStatement("INSERT INTO cssp_files(user_id, file_title,file_description, language,code_file) VALUES (?,?,?,?,LOAD_FILE(?))");
            createNewPost.setInt(1, user_id);
            createNewPost.setString(2, filename);
            createNewPost.setString(3, fileDescription);
            createNewPost.setString(4, selectedItem);
            createNewPost.setString(5,path );
            int rowAffected = createNewPost.executeUpdate();
            if(rowAffected > 0){
                new FileUploadSuccess().setVisible(true);
                postContainer.removeAll();
                postContainer.revalidate();
                postContainer.repaint();
                new FetchPosts().fectPostPanels();
                System.out.println("Uploaded");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreatePost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
