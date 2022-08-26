package com.example.consultacep.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;

@Entity
@Table( name= "tab_endereco")
@Data
public class Endereco {
    @Id

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
