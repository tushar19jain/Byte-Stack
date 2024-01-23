/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.sql.SQLException;
import static view.Dashboard.postContainer;
import view.UserSnippets;
import view.deleteSuccess;

/**
 *
 * @author jaint
 */
public class DeleteSnippet extends DatabaseController {
    public void deleteSnippet(int code_id) throws SQLException{
        deleteUserSnippet = con.prepareStatement("DELETE FROM cssp_files WHERE  code_id = ?");
        deleteUserSnippet.setInt(1,code_id);
        deleteUserSnippet.executeUpdate();
        new deleteSuccess().setVisible(true);
        UserSnippets.userSnippetContainer.removeAll();
        UserSnippets.userSnippetContainer.revalidate();
        UserSnippets.userSnippetContainer.repaint();
        new fetchUserOwnedPost().fetchUserPostPanels();
        postContainer.removeAll();
        postContainer.revalidate();
        postContainer.repaint();
        new FetchPosts().fectPostPanels();
    }
}
