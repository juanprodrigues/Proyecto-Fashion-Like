package com.redSocial.modelos.dto;

import com.redSocial.modelos.enums.tipo;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class RolDTO {

    private Integer id;
    private tipo tipoRol;

}
