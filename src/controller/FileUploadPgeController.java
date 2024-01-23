/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.CreatePost;

/**
 *
 * @author jaint
 */
public class FileUploadPgeController {
    public void getFileContent(String filename, String fileDescription, String selectedIteam,String path){
        String item;
        if(!filename.isBlank()){
            if(!fileDescription.isBlank()){
                if(!selectedIteam.isBlank()){
                    if(!path.isBlank()){
                         new CreatePost().fetchPostDetails(filename, fileDescription, selectedIteam, path);
                } 
            }
        }
    }
  }
}
