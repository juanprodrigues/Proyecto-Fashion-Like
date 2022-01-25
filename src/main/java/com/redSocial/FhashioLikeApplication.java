package com.redSocial;

import com.redSocial.repositorio.RolRepositorio;
import com.redSocial.repositorio.UsuarioRepositorio;
import com.redSocial.modelos.enums.tipo;

import com.redSocial.modelos.entidad.Rol;
import com.redSocial.modelos.entidad.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FhashioLikeApplication {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Autowired
    RolRepositorio rolRepositorio;

    public static void main(String[] args) {
        SpringApplication.run(FhashioLikeApplication.class, args);
    }
}
