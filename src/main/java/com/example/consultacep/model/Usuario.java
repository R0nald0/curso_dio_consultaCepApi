package com.example.consultacep.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name="tab_user")
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    @Column(name="nome")
     String nome;
    
    @ManyToOne
    Endereco endereco;
}
