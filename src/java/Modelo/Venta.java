/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author juramirezp
 */
public class Venta {
    int idVenta, precio;
    String marca, tipo, vehiculo, motor, descripcion, estado;

    public Venta() {
    }

    public Venta(int idVenta, int precio, String marca, String tipo, String vehiculo, String motor, String descripcion, String estado) {
        this.idVenta = idVenta;
        this.precio = precio;
        this.marca = marca;
        this.tipo = tipo;
        this.vehiculo = vehiculo;
        this.motor = motor;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public int getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public String getMotor() {
        return motor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
