/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.dto;

import com.tienda.model.Productos;
import java.util.List;

/**
 *
 * @author Edgar
 */
public class ProductosResponseDTO {
    
    private String error;
    private String mensaje;
    private List<Productos> lstProductos;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Productos> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<Productos> lstProductos) {
        this.lstProductos = lstProductos;
    }
    
    
    
}
