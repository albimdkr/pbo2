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
public class ubahpasSession {
         private static String ubahpas;
    
    public static void setubahpasLogin(String ubahpas) {
        ubahpasSession.ubahpas = ubahpas;
    }
   
    public static String getubahpasLogin() {
        return ubahpas;
    }
}
