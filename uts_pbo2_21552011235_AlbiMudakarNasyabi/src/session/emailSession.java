/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

/**
 *
 * @author albin
 */
public class emailSession {
     private static String emaill;
    
    public static void setemaillLogin(String emaill) {
       emailSession.emaill = emaill;
    }
    
    public static String getemaillLogin() {
        return emaill;
    }
}
