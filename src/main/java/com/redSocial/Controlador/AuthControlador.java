package com.redSocial.Controlador;

import com.redSocial.modelos.dto.UserDTO;
import com.redSocial.security.dto.JwtDTO;
import com.redSocial.security.dto.LoginUsuarioDTO;
import com.redSocial.security.dto.RegistroUsuarioDTO;
import com.redSocial.security.jwt.JwtProvider;
import com.redSocial.servicios.AutenticacionServicio;
import com.redSocial.servicios.UserServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/auth")
public class AuthControlador {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServicio userServicio;

    @Autowired
    private AutenticacionServicio autenticacionServicio;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody RegistroUsuarioDTO registroUsuarioDTO) throws URISyntaxException {
        // userDTO = userServicio.crear(userDTO);
        autenticacionServicio.registroUsuario(registroUsuarioDTO);
        return ResponseEntity.created(new URI("/auth/nuevo"))
                .header(String.valueOf(HttpStatus.CREATED))
                .body(null);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@RequestBody LoginUsuarioDTO loginUsuarioDTO) {
        JwtDTO jwtDTO = autenticacionServicio.login(loginUsuarioDTO);
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }

}
