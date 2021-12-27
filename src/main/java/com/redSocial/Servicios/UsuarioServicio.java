/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.Servicios;

import com.redSocial.entidad.*;
import java.util.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanPC
 */

@Service
public interface UsuarioServicio {
    
     List<Rol> usuarios();
     void crear(Rol producto);
}
