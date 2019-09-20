/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.dto;

import com.tienda.model.OrdenesDetalle;
import java.util.List;

/**
 *
 * @author Edgar
 */
public class OrdenesRequestDTO {
    
    private String token;
    private String idUsr;
    private List<OrdenesDetalle> lstOrdenesDetalle;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(String idUsr) {
        this.idUsr = idUsr;
    }

    public List<OrdenesDetalle> getLstOrdenesDetalle() {
        return lstOrdenesDetalle;
    }

    public void setLstOrdenesDetalle(List<OrdenesDetalle> lstOrdenesDetalle) {
        this.lstOrdenesDetalle = lstOrdenesDetalle;
    }
    
    
}
