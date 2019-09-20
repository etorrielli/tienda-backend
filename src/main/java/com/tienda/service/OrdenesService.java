package com.tienda.service;

import com.tienda.dto.OrdenesCompletasDTO;
import com.tienda.dto.OrdenesRequestDTO;
import com.tienda.dto.Response;
import com.tienda.model.Login;
import com.tienda.model.Ordenes;
import com.tienda.model.OrdenesDetalle;
import com.tienda.repository.LoginRepository;
import com.tienda.repository.OrdenesDetalleRepository;
import com.tienda.repository.OrdenesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author etorrielli
 */
@Service
public class OrdenesService {

    static final Logger LOGGER = LoggerFactory.getLogger(OrdenesService.class);

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private OrdenesRepository ordenesRepository;

    @Autowired
    private OrdenesDetalleRepository ordenesDetalleRepository;

    public Response findAllByUser(String token, String idUsr) throws Exception {
        Response response = new Response();

        if (token != null && idUsr != null) {
            //validar usr/token en la bd
            Login login = loginRepository.findOneByIdAndToken(Integer.parseInt(idUsr), token);

            if (login != null) {

                //get ordenes del usuario
                List<Ordenes> lstOrdenes = ordenesRepository.findAllByUsuarioId(Integer.parseInt(idUsr));
                List<OrdenesCompletasDTO> lstOrdenesCompletasDTO = new ArrayList<>();

                for (Ordenes orden : lstOrdenes) {
                    OrdenesCompletasDTO ordenesCompletasDTO = new OrdenesCompletasDTO();
                    ordenesCompletasDTO.setIdOrden(orden.getId().toString());
                    ordenesCompletasDTO.setCreadoEn(orden.getCreadoEn().toString());

                    //get detalles de la orden
                    List<OrdenesDetalle> lstOrdenesDetalle = ordenesDetalleRepository.findAllByOrdenId(orden.getId());
                    ordenesCompletasDTO.setLstDetalle(lstOrdenesDetalle);

                    lstOrdenesCompletasDTO.add(ordenesCompletasDTO);
                }

                response.setData(lstOrdenesCompletasDTO);
            } else {
                response.setStatus(2);
            }
        } else {
            response.setStatus(3);
        }
        return response;
    }

    public Response save(OrdenesRequestDTO ordenesRequestDTO) throws Exception {
        Response response = new Response();
        if (ordenesRequestDTO.getIdUsr() != null && ordenesRequestDTO.getToken() != null) {
            //validar usr/token en la bd
            Login login = loginRepository.findOneByIdAndToken(Integer.parseInt(ordenesRequestDTO.getIdUsr()), ordenesRequestDTO.getToken());

            if (login != null) {
                Timestamp fecha = new Timestamp(System.currentTimeMillis());

                Ordenes ordenes = new Ordenes();
                ordenes.setUsuarioId(Integer.parseInt(ordenesRequestDTO.getIdUsr()));
                ordenes.setCreadoEn(fecha);
                Ordenes ordenResult = ordenesRepository.saveAndFlush(ordenes);

                if (ordenesRequestDTO.getLstOrdenesDetalle() != null && ordenesRequestDTO.getLstOrdenesDetalle().size() > 0) {
                    for (OrdenesDetalle det : ordenesRequestDTO.getLstOrdenesDetalle()) {

                        OrdenesDetalle ordenesDetalle = new OrdenesDetalle();
                        ordenesDetalle.setOrdenId(ordenResult.getId());
                        ordenesDetalle.setProductoId(det.getProductoId());
                        ordenesDetalleRepository.saveAndFlush(ordenesDetalle);
                    }
                    response.setData(ordenResult.getId());
                } else {
                    response.setStatus(1);
                    response.setMessage("La orden no posee items");
                }
            } else {
                response.setStatus(2);
            }
        } else {
            response.setStatus(3);
        }
        return response;
    }

    public Response delete(String token, String idUsr, String idOrden) throws Exception {
        Response response = new Response();

        if (token != null && idUsr != null) {
            //validar usr/token en la bd
            Login login = loginRepository.findOneByIdAndToken(Integer.parseInt(idUsr), token);

            if (login != null) {

                //get ordenes del usuario
                Ordenes ordenes = ordenesRepository.findOneByIdAndUsuarioId(Integer.parseInt(idOrden), Integer.parseInt(idUsr));

                if (ordenes != null) {
                    ordenesRepository.delete(ordenes);
                    response.setMessage("Se Elimino correctamente");
                } else {
                    response.setStatus(3);
                }
            } else {
                response.setStatus(2);
            }
        } else {
            response.setStatus(3);
        }
        return response;
    }

}