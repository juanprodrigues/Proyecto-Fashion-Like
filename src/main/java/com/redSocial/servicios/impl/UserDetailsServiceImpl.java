package com.redSocial.servicios.impl;

import com.redSocial.mapper.UserMapper;
import com.redSocial.modelos.entidad.User;
import com.redSocial.repositorio.UserRespositorio;
import com.redSocial.security.entidad.UserPrincipal;
import com.redSocial.servicios.errors.ValueNotPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRespositorio userRespositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRespositorio.findByUsername(username);
        if (!user.isPresent()) {
            throw new ValueNotPresent();
        }
        return UserPrincipal.build(user.get());
    }
}
