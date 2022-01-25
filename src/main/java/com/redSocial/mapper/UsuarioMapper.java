package com.redSocial.mapper;

import com.redSocial.modelos.dto.UsuarioDTO;
import com.redSocial.modelos.entidad.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {

    Usuario toEntity(UsuarioDTO usuarioDTO);

    UsuarioDTO toDto(Usuario entity);

    List<Usuario> toEntity(List<UsuarioDTO> dto);

    List<UsuarioDTO> toDto(List<Usuario> entity);

    default Usuario fromId(Long id) {
        if (id == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);
        return usuario;
    }

}
