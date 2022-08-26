package com.example.consultacep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.consultacep.model.Endereco;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco,String>{
    
}
