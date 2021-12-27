package com.redSocial;

import com.redSocial.Repositorio.PosteoRepositorio;
import com.redSocial.Repositorio.ReaccionRepositorio;
import com.redSocial.Repositorio.RolRepositorio;
import com.redSocial.Repositorio.UsuarioRepositorio;
import com.redSocial.entidad.*;
import com.redSocial.enums.tipo;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FhashioLikeApplication implements CommandLineRunner {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Autowired
    RolRepositorio rolRepositorio;

    public static void main(String[] args) {
        SpringApplication.run(FhashioLikeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Integer id = 1;

        try {
            Rol rol = rolRepositorio.findById(id).get();
            if (rol != null) {
                System.out.println("!!!!!"+rol.toString());
            }

        } catch (Exception e) {
            Rol rol = new Rol();
            rol.setCorreo("Fasion@like.com");
            rol.setPassword("1234");
            rol.setTipoRol(tipo.ADMIN);

            Usuario userAdmin = new Usuario();
            userAdmin.setNombre("Admin");
            userAdmin.setRol(rol);
            usuarioRepositorio.save(userAdmin);

        }
       

//        
//        Usuario usuari2 = new Usuario();
//        usuari2.setNombre("A");
//        
//        Usuario usuari3 = new Usuario();
//        usuari3.setNombre("B");
//        
//        Usuario usuario = new Usuario();
//        usuario.setNombre("C");
//        
//        usuario.addAmigo(usuari2);
//        usuario.addAmigo(usuari3);
//
//        
//        
//        usuarioRepositorio.save(usuario);
        }

    }
