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
import static view.AllFilesTable.allFilesTable;

/**
 *
 * @author jaint
 */
public class FetchFilesDataForTable extends DatabaseController {
    public void fetchFilesDataForTable(){
        try {
            fetchFilesData = con.prepareStatement("select user_id, file_title, file_description, file_like_count, language, date_of_uplode from cssp_files");
            fetchedFilesData = fetchFilesData.executeQuery();
            allFilesTable.setModel(DbUtils.resultSetToTableModel(fetchedFilesData));
        } catch (SQLException ex) {
            Logger.getLogger(FetchFilesDataForTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
