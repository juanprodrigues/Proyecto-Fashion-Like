package com.redSocial.servicios.util;

import com.redSocial.modelos.entidad.Rol;
import com.redSocial.modelos.enums.tipo;
import com.redSocial.servicios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    private RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol();
        rolAdmin.setTipoRol(tipo.ADMIN);
        Rol rolUsuario = new Rol();
        rolUsuario.setTipoRol(tipo.USUARIO);
        rolService.crear(rolAdmin);
        rolService.crear(rolUsuario);
    }
}
