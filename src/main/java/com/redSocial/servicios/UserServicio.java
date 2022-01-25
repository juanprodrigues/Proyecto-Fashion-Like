package com.redSocial.servicios;

import com.redSocial.modelos.dto.UserDTO;
import com.redSocial.security.dto.LoginUsuarioDTO;
import org.springframework.transaction.annotation.Transactional;

public interface UserServicio {

    public UserDTO getByUsername(String username);

    public Boolean existsByUsername(String username);

    public UserDTO login(LoginUsuarioDTO loginUsuarioDTO);

}
