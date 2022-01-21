/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.modelos.entidad;

import com.redSocial.enums.tipo;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author JuanPC
 */
@Entity
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idRol;
    private String correo;
    private String password;
    
    @Enumerated(EnumType.STRING)
    private tipo tipoRol;

}
