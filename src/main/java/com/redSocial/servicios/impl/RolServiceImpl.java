package com.redSocial.servicios.impl;

import com.redSocial.mapper.RolMapper;
import com.redSocial.modelos.dto.RolDTO;
import com.redSocial.modelos.entidad.Rol;
import com.redSocial.modelos.enums.tipo;
import com.redSocial.repositorio.RolRepositorio;
import com.redSocial.servicios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private RolMapper rolMapper;

    @Override
    public RolDTO crear(Rol rol) {
        rol = rolRepositorio.save(rol);
        return rolMapper.toDto(rol);
    }

    @Override
    public Optional<RolDTO> getByTipoRol(tipo rolName) {
        RolDTO rolDTO = rolMapper.toDto(rolRepositorio.findByTipoRol(rolName).get());
        return Optional.of(rolDTO);
    }
}
