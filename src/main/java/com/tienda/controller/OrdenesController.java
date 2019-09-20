/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.controller;

import com.tienda.dto.*;
import com.tienda.model.Login;
import com.tienda.model.Ordenes;
import com.tienda.model.OrdenesDetalle;
import com.tienda.repository.LoginRepository;
import com.tienda.repository.OrdenesDetalleRepository;
import com.tienda.repository.OrdenesRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tienda.service.OrdenesService;
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
@RestController
@RequestMapping("/ordenes")
public class OrdenesController {

    @Autowired
    private OrdenesService ordenesService;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody OrdenesRequestDTO ordenesRequestDTO) throws Exception {
        Response response = ordenesService.save(ordenesRequestDTO);
        if (response.getStatus() == 2) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (response.getStatus() == 3) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{token}/{idUsr}/{idOrden}")
    public ResponseEntity<Object> delete(@PathVariable String token, @PathVariable String idUsr, @PathVariable String idOrden) throws Exception {
        Response response = ordenesService.delete(token, idUsr, idOrden);
        if (response.getStatus() == 2) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (response.getStatus() == 3) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{token}/{idUsr}")
    public ResponseEntity<Object> get(@PathVariable String token, @PathVariable String idUsr) throws Exception {
        Response response = ordenesService.findAllByUser(token, idUsr);
        if (response.getStatus() == 2) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (response.getStatus() == 3) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
