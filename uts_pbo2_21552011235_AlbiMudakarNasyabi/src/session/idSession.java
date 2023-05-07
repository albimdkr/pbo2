package session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author albin
 */
public class idSession {
    private static String idUSer;
    
    public static void setidUSerLogin(String idUSer) {
        idSession.idUSer = idUSer;
    }
    
    public static String getidUSerLogin() {
        return idUSer;
    }
}
