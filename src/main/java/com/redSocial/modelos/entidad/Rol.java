/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.modelos.entidad;

import com.redSocial.modelos.enums.tipo;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author JuanPC
 */
@Entity
@Data
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    private tipo tipoRol;

}
