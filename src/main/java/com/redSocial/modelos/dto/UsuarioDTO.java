package com.redSocial.modelos.dto;

import com.redSocial.modelos.entidad.Posteo;
import com.redSocial.modelos.entidad.Reaccion;
import com.redSocial.modelos.entidad.Rol;
import com.redSocial.modelos.entidad.Usuario;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String direccion;
    private String apodo;
    private String foto;
    private String videoPresentacion;
    private Boolean alta;


    private Date fechaNacio;


    public UsuarioDTO(String nombre, String apellido, String direccion, String apodo,
                      String foto, String videoPresentacion, Boolean alta, Date fechaNacio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.apodo = apodo;
        this.foto = foto;
        this.videoPresentacion = videoPresentacion;
        this.alta = alta;
        this.fechaNacio = fechaNacio;
    }
}
