/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.modelos.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.*;
import javax.persistence.*;

import lombok.Data;

/**
 *
 * @author JuanPC
 */
@Entity
@Data
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String direccion;
    private String apodo;
    private String foto;
    private String videoPresentacion;

    private Boolean alta;

 
    /* @ManyToMany
    private Set<Reaccion> likes_dados = new HashSet<Reaccion>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Posteo> posteosLista = new HashSet<Posteo>(); */

    /* @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Usuario> amigos = new HashSet<Usuario>(); */

    @Temporal(TemporalType.DATE)
    private Date fechaNacio;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    /* public void addAmigo(Usuario u) {
        this.amigos.add(u);
    } */

    /* public void addPost(Posteo post2) {
        this.posteosLista.add(post2);
    } */

    /* public void addLike(Reaccion u) {
        this.likes_dados.add(u);
    } */

}
