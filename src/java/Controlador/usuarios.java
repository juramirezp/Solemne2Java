/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Modelo.Usuario;
/**
 *
 * @author juramirezp
 */
public class usuarios {
    public Usuario login(Connection c, String usu, String pass){
        Usuario user=null;
        
        try{
            PreparedStatement query = c.prepareStatement("select * from usuario where usuario = ? and pass = ?");
            query.setString(1, usu);
            query.setString(2, pass);
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                user = new Usuario();
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setEmail(rs.getString("email"));
                user.setUsuario(rs.getString("usuario"));
                user.setPass(rs.getString("pass"));
                user.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
            }
        }catch (SQLException ex){
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
        
    }
}
