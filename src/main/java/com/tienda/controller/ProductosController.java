/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.controller;

import com.tienda.dto.ProductosResponseDTO;
import com.tienda.dto.Response;
import com.tienda.model.Productos;
import com.tienda.repository.ProductosRepository;

import java.util.List;

import com.tienda.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * @author Edgar
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    ProductosService productosService;

    @GetMapping
    public ResponseEntity<?> list() throws Exception {
        Response response = productosService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
