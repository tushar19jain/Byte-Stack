/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jaint
 */
public class TokenManager {
 private static int token;
 public static int getToken(){
     return token;
 }
 public static int setToken(int newToken){
     token = newToken;
     return 0;
 }
}
