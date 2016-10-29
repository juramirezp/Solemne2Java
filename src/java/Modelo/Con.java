/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juramirezp
 */
public class Con {
    private static Connection cnx = null;
    
    public static Connection Conectar(){
        if (cnx == null) {
            try {
                //Establecer Conexion a Base de Datos
                Class.forName("com.mysql.jdbc.Driver");
                String server = "jdbc:mysql://localhost/";
                String BD = "Solemne2Java";
                String user = "root";
                String pass = "";
                cnx = (Connection) DriverManager.getConnection(server + BD, user, pass);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Con.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Con.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cnx;
    }
    
    public static void Cerrar(){
        if (cnx != null) {
            try {
                cnx.close();
            } catch (SQLException ex) {
                Logger.getLogger(Con.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
