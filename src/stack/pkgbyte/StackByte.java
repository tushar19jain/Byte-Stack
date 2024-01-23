/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stack.pkgbyte;


/**
 *
 * @author jaint
 */
import controller.DatabaseController;
import view.HomePage;
public class StackByte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        HomePage homepage = new HomePage();
        homepage.setVisible(true);
        new DatabaseController();
    }
    
}
