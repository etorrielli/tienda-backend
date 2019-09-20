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
public class OrdenesCompletasDTO {
    
    private String idOrden;
    private String creadoEn;
    List<OrdenesDetalle> lstDetalle;

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public String getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(String creadoEn) {
        this.creadoEn = creadoEn;
    }

    public List<OrdenesDetalle> getLstDetalle() {
        return lstDetalle;
    }

    public void setLstDetalle(List<OrdenesDetalle> lstDetalle) {
        this.lstDetalle = lstDetalle;
    }
    
    
}
