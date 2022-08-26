package com.example.consultacep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consultacep.model.Usuario;
import com.example.consultacep.service.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("user")
public class UsuarioController {
    
  @Autowired
  UsuarioService uService;


   @GetMapping()
   public ResponseEntity<Iterable<Usuario>> buscarTodos() {
       return ResponseEntity.ok(uService.getAll());
   }
   
}
