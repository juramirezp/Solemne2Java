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

import Modelo.Venta;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author juramirezp
 */
public class ventas {
    public Venta consultarVenta(Connection c, int v){
        Venta detalle=null;
        
        try{
            PreparedStatement query = c.prepareStatement("select * from venta where idVenta= ?");
            query.setString(1, String.valueOf(v));
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                detalle=new Venta();
                detalle.setIdVenta(rs.getInt("idVenta"));
                detalle.setMarca(rs.getString("marca"));
                detalle.setTipo(rs.getString("tipo"));
                detalle.setVehiculo(rs.getString("vehiculo"));
                detalle.setMotor(rs.getString("motor"));
                detalle.setPrecio(rs.getInt("precio"));
                detalle.setDescripcion(rs.getString("descripcion"));
                detalle.setEstado(rs.getString("estado"));
            }
        }catch (SQLException ex){
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return detalle;
    }
    
    public List<Venta> listarVentas(Connection c){
        List<Venta> listaVentas=new ArrayList<>();
        
        try{
            PreparedStatement query = c.prepareStatement("select * from venta");
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                Venta detalle=new Venta();
                detalle.setIdVenta(rs.getInt("idVenta"));
                detalle.setMarca(rs.getString("marca"));
                detalle.setTipo(rs.getString("tipo"));
                detalle.setVehiculo(rs.getString("vehiculo"));
                detalle.setMotor(rs.getString("motor"));
                detalle.setPrecio(rs.getInt("precio"));
                detalle.setDescripcion(rs.getString("descripcion"));
                detalle.setEstado(rs.getString("estado"));
                listaVentas.add(detalle);
            }
        }catch (SQLException ex){
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaVentas;
    }
    
    public int actualizarEstado(Connection c, int v, String e){
        int afectadas = 0;
        
        try{
            PreparedStatement query = c.prepareStatement("update venta set estado= ? where idVenta= ?");
            query.setString(1, e);
            query.setString(2, String.valueOf(v));
            afectadas=query.executeUpdate();
            return afectadas;
        }catch(SQLException ex){
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return afectadas;
    }
    
    public int eliminarVenta(Connection c, int v){
        int afectadas = 0;
        
        try{
            PreparedStatement query = c.prepareStatement("delete from venta where idVenta=?");
            query.setString(1, String.valueOf(v));
            afectadas=query.executeUpdate();
            return afectadas;
        }catch(SQLException ex){
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return afectadas;
    }
    
    public int registrarVenta(Connection c, Venta v){
        int afectadas=0;
        
        try{
            PreparedStatement query=c.prepareStatement("INSERT INTO venta (marca, tipo, vehiculo, "
                    + "motor, precio, descripcion, estado) VALUES (?,?,?,?,?,?,?)");
            
            query.setString(1,v.getMarca());
            query.setString(2,v.getTipo());
            query.setString(3,v.getVehiculo());
            query.setString(4,v.getMotor());
            query.setString(5,String.valueOf(v.getPrecio()));
            query.setString(6,v.getDescripcion());
            query.setString(7,v.getEstado());
            afectadas=query.executeUpdate();
            return afectadas;
        }catch(SQLException ex){
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return afectadas;
    }
    
    
}
