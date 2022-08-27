package com.example.consultacep.service;

import com.example.consultacep.model.Usuario;

public interface UsuarioService {

    Iterable<Usuario> getAll();

    Usuario findById(Long id);

    Iterable<Usuario> listById();

    void insertUser(Usuario usuario);

    void updateUser(Long id , Usuario usuario);

    void delete(Long id);
    
}
