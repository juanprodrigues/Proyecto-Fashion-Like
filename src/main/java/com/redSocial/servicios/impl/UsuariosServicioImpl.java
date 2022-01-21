/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.servicios.impl;

import com.redSocial.repositorio.RolRepositorio;
import com.redSocial.servicios.UsuarioServicio;
import com.redSocial.modelos.dto.UsuarioDTO;
import com.redSocial.modelos.entidad.Rol;
import com.redSocial.enums.tipo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanPC
 */
@Service
public class UsuariosServicioImpl implements UsuarioServicio{
    @Autowired
    RolRepositorio rolRepositorio;
    
    @Override
    public  List<Rol> usuarios() {
        List<Rol> rols=rolRepositorio.findAll();
        return rols ;
    }

    @Override
    public void crear(Rol producto) {
        producto.setTipoRol(tipo.USUARIO);
    rolRepositorio.save(producto);
    }

    @Override
    public UsuarioDTO crear(UsuarioDTO usuarioDTO) {

        return null;

    }


}
