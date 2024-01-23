/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DatabaseController;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.DownloadSuccess;

/**
 *
 * @author jaint
 */
public class DownloadFile extends DatabaseController {
    @SuppressWarnings("empty-statement")
    public void downloadFile(int unique_code_id){
        int code_id = unique_code_id;
        String fileDownloadPath = System.getProperty("user.home")+"/Downloads/MyCodeSnippets";
        System.out.println(fileDownloadPath);
        try {
            fetchUserFile = con.prepareStatement("SELECT code_file FROM cssp_files WHERE code_id = ?");
            try {
                FileOutputStream outputStream = new FileOutputStream(fileDownloadPath);
                fetchUserFile.setInt(1, code_id);
                getFileData = fetchUserFile.executeQuery();
                if(getFileData.next()){
                    InputStream fildata = getFileData.getBinaryStream("code_file");
                    byte [] buffer = new byte[1024];
                    int bytesRead;
                    try {
                        while((bytesRead = fildata.read(buffer)) != -1){
                            outputStream.write(buffer,0,bytesRead);
                            new DownloadSuccess().setVisible(true);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(DownloadFile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DownloadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DownloadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
