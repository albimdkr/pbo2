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
public class kodepeSession {
        private static String kodepeg;
    
    public static void setkodepegLogin(String kodepeg) {
        kodepeSession.kodepeg = kodepeg;
    }
    
    public static String getkodepegLogin() {
        return kodepeg;
    }
}
