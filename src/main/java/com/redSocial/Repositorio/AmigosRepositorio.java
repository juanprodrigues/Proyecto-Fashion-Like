/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.Repositorio;

import com.redSocial.entidad.Amigos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JuanPC
 */
@Repository
public interface AmigosRepositorio extends JpaRepository<Amigos, Integer>{
    
}
