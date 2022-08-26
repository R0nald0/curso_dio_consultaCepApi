package com.example.consultacep.service;

import com.example.consultacep.model.Usuario;

public interface UsuarioService {

    Iterable<Usuario> getAll();

    Usuario findById(Long id);

    Iterable<Usuario> listById();

    Usuario updateUser(Long id , Usuario usuario);

    void delete(Long id);
    
}
