package com.redSocial.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@AllArgsConstructor
@Data
public class JwtDTO {


    private String token;
    private String bearer = "Bearer";
    private String emailUsuario;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDTO(String token, String emailUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.emailUsuario = emailUsuario;
        this.authorities = authorities;
    }

}
