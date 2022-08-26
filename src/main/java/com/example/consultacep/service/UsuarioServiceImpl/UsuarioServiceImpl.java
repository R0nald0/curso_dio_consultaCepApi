package com.example.consultacep.service.UsuarioServiceImpl;

import org.springframework.stereotype.Service;

import com.example.consultacep.model.Usuario;
import com.example.consultacep.repository.UsuarioRepository;
import com.example.consultacep.service.UsuarioService;


@Service
public class UsuarioServiceImpl  implements UsuarioService{
  
   final UsuarioRepository uRepository;


     UsuarioServiceImpl(UsuarioRepository usuarioRepository){
           this.uRepository = usuarioRepository;
     }

    @Override
    public Iterable<Usuario> getAll() {
        return uRepository.findAll();
    }
    
}
