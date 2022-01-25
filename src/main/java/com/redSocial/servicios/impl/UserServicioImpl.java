package com.redSocial.servicios.impl;

import com.redSocial.mapper.RolMapper;
import com.redSocial.mapper.UserMapper;
import com.redSocial.modelos.dto.UserDTO;
import com.redSocial.modelos.entidad.Rol;
import com.redSocial.modelos.entidad.User;
import com.redSocial.modelos.enums.tipo;
import com.redSocial.repositorio.UserRespositorio;
import com.redSocial.security.dto.LoginUsuarioDTO;
import com.redSocial.security.jwt.JwtProvider;
import com.redSocial.servicios.RolService;
import com.redSocial.servicios.UserServicio;
import com.redSocial.servicios.errors.UsernameAlreadyUsedException;
import com.redSocial.servicios.errors.ValueNotPresent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@Slf4j
public class UserServicioImpl implements UserServicio {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRespositorio userRespositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RolService rolService;

    @Autowired
    private RolMapper rolMapper;

    @Override
    @Transactional(readOnly = true)
    public UserDTO getByUsername(String username) {
        Optional<User> user = userRespositorio.findByUsername(username);
        if (!user.isPresent()) {
            throw new ValueNotPresent();
        }
        return userMapper.toDto(user.get());
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean existsByUsername(String username) {
        return userRespositorio.existsByUsername(username);
    }

    @Override
    public UserDTO login(LoginUsuarioDTO loginUsuarioDTO) {
        return null;
    }

}
