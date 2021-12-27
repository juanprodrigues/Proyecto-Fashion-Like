/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.entidad;

import java.util.List;
import lombok.Data;

/**
 *
 * @author JuanPC
 */
@Data
public class AjaxResponseProductos {

    String mensaje;

    List<Rol> usuarios;

}
