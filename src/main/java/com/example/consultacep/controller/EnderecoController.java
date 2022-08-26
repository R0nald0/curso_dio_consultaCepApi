package com.example.consultacep.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consultacep.model.Endereco;
import com.example.consultacep.service.EnderecoService;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
    
    final EnderecoService eService;

    EnderecoController(EnderecoService enderecoService){
        this.eService =enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodos(){    
         return ResponseEntity.ok(eService.getAll());
    }


}
