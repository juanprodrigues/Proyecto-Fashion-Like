package com.redSocial.servicios;

import com.redSocial.mapper.RolMapper;
import com.redSocial.mapper.UserMapper;
import com.redSocial.mapper.UsuarioMapper;
import com.redSocial.modelos.dto.UserDTO;
import com.redSocial.modelos.dto.UsuarioDTO;
import com.redSocial.modelos.entidad.Rol;
import com.redSocial.modelos.entidad.User;
import com.redSocial.modelos.entidad.Usuario;
import com.redSocial.modelos.enums.tipo;
import com.redSocial.repositorio.UserRespositorio;
import com.redSocial.repositorio.UsuarioRepositorio;
import com.redSocial.security.dto.JwtDTO;
import com.redSocial.security.dto.LoginUsuarioDTO;
import com.redSocial.security.dto.RegistroUsuarioDTO;
import com.redSocial.security.jwt.JwtProvider;
import com.redSocial.servicios.errors.UsernameAlreadyUsedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class AutenticacionServicio {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRespositorio userRespositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private RolMapper rolMapper;

    @Autowired
    private RolService rolService;

    public void registroUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        UserDTO userDTO = RegistroUsuarioDTO.buildUserDTO(registroUsuarioDTO);
        if (userRespositorio.existsByUsername(userDTO.getUsername())) {
            throw new UsernameAlreadyUsedException();
        }
        User user = userMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(generateRolesUsuario(userDTO));
        user = userRespositorio.save(user);

        log.info("-----> User: {}", user);

        Usuario usuario = usuarioMapper.toEntity(RegistroUsuarioDTO.buildUsuarioDTO(registroUsuarioDTO));
        usuario.setUser(user);

        log.info("-----> Usuario: {}", usuario);

        usuarioRepositorio.save(usuario);

    }

    public JwtDTO login(LoginUsuarioDTO loginUsuarioDTO) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginUsuarioDTO.getUsername(),
                        loginUsuarioDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generadorToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return jwtDTO;
    }

    private Set<Rol> generateRolesUsuario(UserDTO usuarioDTO) {
        Set<Rol> roles = new HashSet<>();
        Rol rolUsuario = rolMapper.toEntity(rolService.getByTipoRol(tipo.USUARIO).get());
        roles.add(rolUsuario);
        if (usuarioDTO.getRoles().contains("admin")) {
            Rol rolAdmin = rolMapper.toEntity(rolService.getByTipoRol(tipo.ADMIN).get());
            roles.add(rolAdmin);
        }
        return roles;
    }

}
