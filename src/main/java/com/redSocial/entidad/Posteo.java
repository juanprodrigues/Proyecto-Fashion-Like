/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author JuanPC
 */
@Entity
@Data
public class Posteo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idPosteo;
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    private String descipcion;
    private Boolean alta;
    private String imagenPosteo;

}
