package com.example.consultacep.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.consultacep.model.Endereco;
import com.example.consultacep.repository.EnderecoRepository;


@Service
public class EnderecoService {
     @Autowired
     EnderecoRepository enderecoRepository;

     @Autowired
     ViaCepClient viaCepClient;

    public List<Endereco> getAll(){
          return enderecoRepository.findAll();
    }

    
    public Endereco insertAdress(Endereco endereco){
          Optional<Endereco> eOptional = enderecoRepository.findById(endereco.getCep());
               if(eOptional.isPresent()){
                   return endereco;
                }
                else{
                    Endereco novoEndereco =  viaCepClient.consultacep(endereco.getCep());
                  enderecoRepository.save(novoEndereco);
                return novoEndereco;
                }

        }  

    public void upadateEndereco(String cep ,Endereco endereco){
              Optional<Endereco> eOptional  = enderecoRepository.findById(cep);
               if(eOptional.isPresent())
                  enderecoRepository.save(endereco);
              else
                  System.out.println("Endereco inválido");
        
    }

    public void delete (String cep){
         enderecoRepository.deleteById(cep);
    }
    
}
