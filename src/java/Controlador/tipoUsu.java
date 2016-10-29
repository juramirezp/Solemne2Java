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


import Modelo.TipoUsuario;
/**
 *
 * @author juramirezp
 */
public class tipoUsu {
    public TipoUsuario verificarTipo(Connection c, int t){
        TipoUsuario tipo=null;
        
        try{
            PreparedStatement query = c.prepareStatement("select * from tipoUsuario where idTipoUsuario= ?");
            query.setString(1, String.valueOf(t));
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                tipo=new TipoUsuario();
                tipo.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                tipo.setCodigo(rs.getInt("codigo"));
                tipo.setGlosa(rs.getString("glosa"));
            }
        }catch (SQLException ex){
            Logger.getLogger(TipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipo;
    }
}
