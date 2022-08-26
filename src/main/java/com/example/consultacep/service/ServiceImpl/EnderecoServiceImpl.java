package com.example.consultacep.service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.consultacep.model.Endereco;
import com.example.consultacep.repository.EnderecoRepository;
import com.example.consultacep.service.EnderecoService;


@Service
public class EnderecoServiceImpl implements EnderecoService{
   
    @Autowired
    EnderecoRepository eRespository;

    @Override
    public List<Endereco> getAll() {
        return  eRespository.findAll();
    }
    
}
