package com.example.consultacep.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consultacep.model.Endereco;
import com.example.consultacep.service.EnderecoService;



@RestController
@CrossOrigin(origins = "**",maxAge = 3600)
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

    @PostMapping
    public ResponseEntity<Endereco> inserir(@RequestBody Endereco endereco){
        return ResponseEntity.ok(eService.insertAdress(endereco));
    }

    @PutMapping("/{cep}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable String cep,@RequestBody Endereco endereco){
            eService.upadateEndereco(cep, endereco);
            return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{cep}")
    public ResponseEntity<Void> deletar(@PathVariable String cep){
            return ResponseEntity.ok().build();
    }

    


}
