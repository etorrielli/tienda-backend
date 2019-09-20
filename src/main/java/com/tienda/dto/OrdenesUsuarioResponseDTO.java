/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.dto;

import java.util.List;

/**
 *
 * @author Edgar
 */
public class OrdenesUsuarioResponseDTO {
    
    private String error;
    private String mensaje;
    private List<OrdenesCompletasDTO> lstOrdenesCompletasDTO;

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

    public List<OrdenesCompletasDTO> getLstOrdenesCompletasDTO() {
        return lstOrdenesCompletasDTO;
    }

    public void setLstOrdenesCompletasDTO(List<OrdenesCompletasDTO> lstOrdenesCompletasDTO) {
        this.lstOrdenesCompletasDTO = lstOrdenesCompletasDTO;
    }

    
    
    
}
