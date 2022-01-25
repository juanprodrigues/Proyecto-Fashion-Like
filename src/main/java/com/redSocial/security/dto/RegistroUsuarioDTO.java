package com.redSocial.security.dto;

import com.redSocial.modelos.dto.UserDTO;
import com.redSocial.modelos.dto.UsuarioDTO;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class RegistroUsuarioDTO {

    // Campos de UserDTO
    private Long dni;
    private String username;
    private String password;
    private Set<String> roles = new HashSet<>();


    // Campos de UsuarioDTO
    private String nombre;
    private String apellido;
    private String direccion;
    private String apodo;
    private String foto;
    private String videoPresentacion;
    private Boolean alta;
    private Date fechaNacio;


    public static UserDTO buildUserDTO(RegistroUsuarioDTO registroUsuarioDTO) {
        return new UserDTO(registroUsuarioDTO.getDni(),
                registroUsuarioDTO.getUsername(), registroUsuarioDTO.getPassword(),
                registroUsuarioDTO.getRoles());
    }

    public static UsuarioDTO buildUsuarioDTO(RegistroUsuarioDTO registroUsuarioDTO) {
        return new UsuarioDTO(registroUsuarioDTO.getNombre(), registroUsuarioDTO.getApellido(),
                registroUsuarioDTO.getDireccion(), registroUsuarioDTO.getApodo(), registroUsuarioDTO.getFoto(),
                registroUsuarioDTO.getVideoPresentacion(), registroUsuarioDTO.getAlta(), registroUsuarioDTO.getFechaNacio());
    }

}
