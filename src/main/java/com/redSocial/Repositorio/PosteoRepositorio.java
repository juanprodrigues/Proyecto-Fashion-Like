/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.Repositorio;

import com.redSocial.entidad.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JuanPC
 */
@Repository
public interface PosteoRepositorio extends JpaRepository<Posteo, Integer>{
    
}
