package com.example.consultacep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consultacep.model.Usuario;
import com.example.consultacep.service.UsuarioService;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "**",maxAge = 3600)
@RequestMapping("/user")
public class UsuarioController {
    
  @Autowired
  UsuarioService uService;


   @GetMapping()
   public ResponseEntity<Iterable<Usuario>> buscarTodos() {
       return ResponseEntity.ok(uService.getAll());
   }

   @PostMapping
   public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario usuario){
        uService.insertUser(usuario);
        return ResponseEntity.ok(usuario);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id ,Usuario usuario){
      uService.updateUser(id, usuario);       
      return ResponseEntity.ok(usuario);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deletar(@PathVariable Long id){
      uService.delete(id);   
      return ResponseEntity.ok().build();
   }
   
}
