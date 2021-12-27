/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.ServiciosImlp;

import com.redSocial.Repositorio.RolRepositorio;
import com.redSocial.Servicios.UsuarioServicio;
import com.redSocial.entidad.Rol;
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
    
    
}
