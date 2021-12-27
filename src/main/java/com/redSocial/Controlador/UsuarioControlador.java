/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redSocial.Controlador;

import com.redSocial.Servicios.UsuarioServicio;
import com.redSocial.entidad.AjaxResponseProductos;
import com.redSocial.entidad.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

        AjaxResponseProductos resultado = new AjaxResponseProductos();
        //Este producto no es el toma el ajax
        try {

            List<Rol> productosC = usuarioServicio.usuarios();

            resultado.setUsuarios(productosC);

        } catch (Exception e) {
            resultado.setMensaje(e.getMessage());

            return ResponseEntity.badRequest().body(resultado);
        }
        return ResponseEntity.ok(resultado);
    }
    
    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<AjaxResponseProductos> crear(@RequestBody Rol producto) {
        AjaxResponseProductos resultado = new AjaxResponseProductos();
        try {
            System.out.println("ingreso de prodicto: "+producto.toString());
            usuarioServicio.crear(producto);

        } catch (Exception e) {
            resultado.setMensaje(e.getMessage());

            return ResponseEntity.badRequest().body(resultado);
        }
        return ResponseEntity.ok(resultado);

    }

}
