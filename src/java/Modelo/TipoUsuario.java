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
public class TipoUsuario {
    int idTipoUsuario, codigo;
    String glosa;

    public TipoUsuario() {
    }

    public TipoUsuario(int idTipoUsuario, int codigo, String glosa) {
        this.idTipoUsuario = idTipoUsuario;
        this.codigo = codigo;
        this.glosa = glosa;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }
    
    
}
