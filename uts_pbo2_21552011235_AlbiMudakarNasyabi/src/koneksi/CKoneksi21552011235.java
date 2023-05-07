/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author albin
 */
public class CKoneksi21552011235 {
private static Connection koneksi;
    public static Connection getKoneksi(){
        if (koneksi == null){
            try {
                String dbURL ="jdbc:mysql://localhost:3306/db_uts_pbo2_21552011235";
                String username = "root";
                String password = "";
                koneksi = DriverManager.getConnection(dbURL,username,password);

                System.out.println("Koneksi Berhasil");
            } catch (SQLException e) {
                System.out.println("Error : " +e);
            }
        }
        return koneksi;
    }
    
    public static void main(String[] args){
        getKoneksi();
    }
}