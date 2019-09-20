/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.controller;

import com.tienda.dto.LoginRequestDTO;
import com.tienda.dto.LoginResponseDTO;
import com.tienda.dto.Response;
import com.tienda.model.Login;
import com.tienda.repository.LoginRepository;

import java.security.SecureRandom;
import java.util.List;

import com.tienda.service.LoginService;
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
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
        Response response = loginService.signIn(loginRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
