package com.example.consultacep.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.consultacep.model.Endereco;

@FeignClient(name = "viacep",url = "http://viacep.com.br/ws/")
public interface ViaCepClient {

    @GetMapping(value ="{cep}/json/")
    Endereco consultacep(@PathVariable("cep") String cep);
          
}
