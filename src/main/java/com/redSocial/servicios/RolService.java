package com.redSocial.servicios;

import com.redSocial.modelos.dto.RolDTO;
import com.redSocial.modelos.entidad.Rol;
import com.redSocial.modelos.enums.tipo;

import java.util.Optional;

public interface RolService {

    public RolDTO crear(Rol rol);

    public Optional<RolDTO> getByTipoRol(tipo rolName);

}
