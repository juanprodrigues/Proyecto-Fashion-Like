/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.modelos.entidad;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author JuanPC
 */
@Entity
@Data
public class Reaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idReacionl;
    @ManyToOne
    private Usuario usuario;
    private String dislike;
    private Boolean alta;
    @ManyToMany(mappedBy = "likes_dados")
    private Set<Usuario> likes = new HashSet<>();
}
