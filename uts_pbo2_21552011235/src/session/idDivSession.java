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
public class idDivSession {
    private static String idDiv;
    
    public static void setidDivLogin(String idDiv) {
        idDivSession.idDiv = idDiv;
    }
    
    public static String getidDivLogin() {
        return idDiv;
    }
}
