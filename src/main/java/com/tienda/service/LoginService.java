package com.tienda.service;

import com.tienda.dto.LoginRequestDTO;
import com.tienda.dto.LoginResponseDTO;
import com.tienda.dto.Response;
import com.tienda.model.Login;
import com.tienda.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

/**
 * @author etorrielli
 */
@Service
public class LoginService {

    static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private LoginRepository loginRepository;

    public Response signIn(LoginRequestDTO loginRequestDTO) throws Exception {

        Response response = new Response();
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();

        if (loginRequestDTO.getUsr() != null && loginRequestDTO.getPass() != null) {
            //validar usr/pass en la bd
            Login login = loginRepository.findOneByCorreoAndContrasena(loginRequestDTO.getUsr(), loginRequestDTO.getPass());

            if (login != null) {

                SecureRandom random = new SecureRandom();
                long longToken = Math.abs(random.nextLong());
                String token = Long.toString(longToken, 16);
                System.out.println("token: " + token);

                //guardar el token en bd
                login.setToken(token);
                loginRepository.saveAndFlush(login);

                loginResponseDTO.setError("0");
                loginResponseDTO.setMensaje("");
                loginResponseDTO.setToken(token);
                loginResponseDTO.setIdUsr(login.getId().toString());
            } else {
                loginResponseDTO.setError("1");
                loginResponseDTO.setMensaje("Correo o password invalidos.");
                loginResponseDTO.setToken("");
                loginResponseDTO.setIdUsr("");
            }
        } else {
            loginResponseDTO.setError("2");
            loginResponseDTO.setMensaje("Los campos no pueden ser nulos.");
            loginResponseDTO.setToken("");
            loginResponseDTO.setIdUsr("");
        }
        response.setData(loginResponseDTO);
        return response;
    }


}