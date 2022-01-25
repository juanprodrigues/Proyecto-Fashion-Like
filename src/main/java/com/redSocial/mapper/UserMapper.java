package com.redSocial.mapper;

import com.redSocial.modelos.dto.UserDTO;
import com.redSocial.modelos.entidad.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO, User> {

    @Mapping(target = "roles", ignore = true)
    User toEntity(UserDTO dto);

    @Mapping(target = "roles", ignore = true)
    UserDTO toDto(User entity);

    @Mapping(target = "roles", ignore = true)
    List<User> toEntity(List<UserDTO> dto);

    @Mapping(target = "roles", ignore = true)
    List<UserDTO> toDto(List<User> entity);

    default User fromId(Long id) {
        if (id == null) {
            return null;
        }
        User usuario = new User();
        usuario.setId(id);
        return usuario;
    }

}
