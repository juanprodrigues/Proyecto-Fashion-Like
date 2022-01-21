/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.servicios;

import java.util.*;

import com.redSocial.modelos.dto.UsuarioDTO;
import com.redSocial.modelos.entidad.Rol;

/**
 *
 * @author JuanPC
 */

public interface UsuarioServicio {
    
     List<Rol> usuarios();
     void crear(Rol producto);

     UsuarioDTO crear(UsuarioDTO usuarioDTO);
}
