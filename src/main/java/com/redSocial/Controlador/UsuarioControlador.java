/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.Controlador;

import com.redSocial.modelos.dto.UsuarioDTO;
import com.redSocial.servicios.UsuarioServicio;
import com.redSocial.modelos.entidad.AjaxResponseProductos;
import com.redSocial.modelos.entidad.Rol;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JuanPC
 */
@RestController
@RequestMapping("usuario")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;



    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Rol>> getAll() {
        List<Rol> personajes = usuarioServicio.usuarios();
        return ResponseEntity.ok().body(personajes);
    }

    @GetMapping("/listar")
    @ResponseBody
    public ResponseEntity<AjaxResponseProductos> listar() {

        /* AjaxResponseProductos resultado = new AjaxResponseProductos();
        //Este producto no es el toma el ajax
        try {

            List<Rol> productosC = usuarioServicio.usuarios();

            resultado.setUsuarios(productosC);

        } catch (Exception e) {
            resultado.setMensaje(e.getMessage());

            return ResponseEntity.badRequest().body(resultado);
        } */
        return ResponseEntity.ok(null);
    }
    
    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<AjaxResponseProductos> crear(@RequestBody Rol producto) {
        /* AjaxResponseProductos resultado = new AjaxResponseProductos();
        try {
            System.out.println("ingreso de prodicto: "+producto.toString());
            usuarioServicio.crear(producto);

        } catch (Exception e) {
            resultado.setMensaje(e.getMessage());

            return ResponseEntity.badRequest().body(resultado);
        } */
        return ResponseEntity.ok(null);

    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> crearUsuarioNuevo(@RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {
        usuarioDTO = usuarioServicio.crear(usuarioDTO);
        return ResponseEntity.created(new URI("/nuevo"))
                .header(String.valueOf(HttpStatus.CREATED))
                .body(null);
    }

}
