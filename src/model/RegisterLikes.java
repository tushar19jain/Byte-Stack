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

/**
 *
 * @author jaint
 */
public class RegisterLikes extends DatabaseController {
     public void addLike(int user_id, int code_id){
        try {
            likeCodeSnippet = con.prepareStatement("insert into like_table values (?, ?)");
            likeCodeSnippet.setInt(1,user_id);
            likeCodeSnippet.setInt(2,code_id);
            int rowAffected = likeCodeSnippet.executeUpdate();     
            if(rowAffected > 0){
                System.out.println("Liked");
                updateLikeCount = con.prepareStatement("UPDATE cssp_files SET `file_like_count` = file_like_count+1 WHERE code_id = ?");
                updateLikeCount.setInt(1, code_id);
                int likeAffected = updateLikeCount.executeUpdate();
                postContainer.removeAll();
                postContainer.revalidate();
                postContainer.repaint();
                new FetchPosts().fectPostPanels();
                System.out.println("liked Updated");
            }
        } catch (SQLException ex1) {
            try {
                likeCodeSnippet = con.prepareStatement("DELETE FROM like_table WHERE user_id = ? AND code_id = ?");
                likeCodeSnippet.setInt(1,user_id);
                likeCodeSnippet.setInt(2,code_id);
                likeCodeSnippet.executeUpdate();
                updateLikeCount = con.prepareStatement("UPDATE cssp_files SET `file_like_count` = file_like_count-1 WHERE code_id = ?");
                updateLikeCount.setInt(1, code_id);
                updateLikeCount.executeUpdate();
                postContainer.removeAll();
                postContainer.revalidate();
                postContainer.repaint();
                new FetchPosts().fectPostPanels();
                System.out.println("liked Updated");
            } catch (SQLException ex2) {
                Logger.getLogger(RegisterLikes.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
           
    }   
}
