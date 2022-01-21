package com.redSocial.modelos.dto;

import com.redSocial.modelos.entidad.Posteo;
import com.redSocial.modelos.entidad.Reaccion;
import com.redSocial.modelos.entidad.Rol;
import com.redSocial.modelos.entidad.Usuario;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDTO {

    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String direccion;
    private String apodo;
    private String foto;
    private String videoPresentacion;
    private Long dni;
    private Boolean alta;


    private Date fechaNacio;


}
