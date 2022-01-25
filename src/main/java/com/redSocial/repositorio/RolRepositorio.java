/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.repositorio;

import com.redSocial.modelos.entidad.*;
import com.redSocial.modelos.entidad.Rol;
import com.redSocial.modelos.enums.tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author JuanPC
 */
@Repository
public interface RolRepositorio extends JpaRepository<Rol,Integer>{

    Optional<Rol> findByTipoRol(tipo roleNombre);
    
}
