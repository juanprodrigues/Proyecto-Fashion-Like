/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.modelos.entidad;

import java.util.Date;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author JuanPC
 */
@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String direccion;
    private String apodo;
    private String foto;
    private String videoPresentacion;
    private Long dni;
    private Boolean alta;

 
    @ManyToMany
    private Set<Reaccion> likes_dados = new HashSet<Reaccion>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Posteo> posteosLista = new HashSet<Posteo>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Usuario> amigos = new HashSet<Usuario>();

    @Temporal(TemporalType.DATE)
    private Date fechaNacio;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Rol rol;

    public void addAmigo(Usuario u) {
        this.amigos.add(u);
    }

    public void addPost(Posteo post2) {
        this.posteosLista.add(post2);
    }

    public void addLike(Reaccion u) {
        this.likes_dados.add(u);
    }

}
