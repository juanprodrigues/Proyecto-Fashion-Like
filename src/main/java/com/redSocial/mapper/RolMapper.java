package com.redSocial.mapper;

import com.redSocial.modelos.dto.RolDTO;
import com.redSocial.modelos.entidad.Rol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RolMapper extends EntityMapper<RolDTO, Rol> {
}
