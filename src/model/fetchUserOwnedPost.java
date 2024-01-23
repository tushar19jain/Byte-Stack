/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static view.Dashboard.postContainer;
import view.PostStructure;
import view.UserOwnSnippetStructure;
import static view.UserSnippets.userSnippetContainer;
//import static view.userOwnSnippet.userSnippetContainer;

/**
 *
 * @author jaint
 */
public class fetchUserOwnedPost extends DatabaseController {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public void fetchUserPostPanels() throws SQLException{
      ArrayList <Object> mySnippets = new ArrayList<>();
        try {
            fetchUserOwnedPost = con.prepareStatement("SELECT code_id, file_title, file_description, language FROM cssp_files where user_id = ?");
            fetchUserOwnedPost.setInt(1, TokenManager.getToken());
            userOwnedPost = fetchUserOwnedPost.executeQuery();
            while(userOwnedPost.next()){
                String postTitle = userOwnedPost.getString("file_title");
                String postDescription = userOwnedPost.getString("file_description");
                String language = userOwnedPost.getString("language");
                int codeId = userOwnedPost.getInt("code_id");
              
                UserOwnSnippetStructure snippet = new   UserOwnSnippetStructure(postTitle,postDescription,language,codeId);
                mySnippets.add(snippet);
                
                
               for(int i = 0 ; i< mySnippets.size(); i++){
                     userSnippetContainer.add(snippet);
                userSnippetContainer.revalidate();
                userSnippetContainer.repaint();
               }         
                System.out.println("Insidewvarwgv" + " " +postTitle);
            }
                    } catch (SQLException ex) {
            Logger.getLogger(FetchPosts.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             userOwnedPost.close();
        }
    }
}
