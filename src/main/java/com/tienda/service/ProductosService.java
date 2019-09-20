package com.tienda.service;

import com.tienda.dto.Response;
import com.tienda.model.Productos;
import com.tienda.repository.ProductosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author etorrielli
 */
@Service
public class ProductosService {

    static final Logger LOGGER = LoggerFactory.getLogger(ProductosService.class);

    @Autowired
    private ProductosRepository productosRepository;

    public Response findAll() throws Exception {
        Response response = new Response();
        List<Productos> lstProductos = productosRepository.findAll();
        response.setData(lstProductos);
        return response;
    }

}