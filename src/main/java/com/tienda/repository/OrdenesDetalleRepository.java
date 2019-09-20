/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.repository;

import com.tienda.model.OrdenesDetalle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Edgar
 */
public interface OrdenesDetalleRepository extends JpaRepository<OrdenesDetalle,Integer> {
    
    List<OrdenesDetalle> findAllByOrdenId(int orderId);
    
}
