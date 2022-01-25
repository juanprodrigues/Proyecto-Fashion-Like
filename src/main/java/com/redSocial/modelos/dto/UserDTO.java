package com.redSocial.modelos.dto;

import com.redSocial.modelos.entidad.Rol;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private Long dni;

    private String username;

    private String password;

    private Set<String> roles = new HashSet<>();

    public UserDTO(Long dni, String username, String password, Set<String> roles) {
        this.dni = dni;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
