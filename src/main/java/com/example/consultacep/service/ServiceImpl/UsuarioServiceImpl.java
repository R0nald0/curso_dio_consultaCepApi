package com.example.consultacep.service.ServiceImpl;

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

    @Override
    public Usuario findById(Long id) {
         uRepository.findById(id);
        return null;
    }

    @Override
    public Iterable<Usuario> listById() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Usuario updateUser(Long id, Usuario usuario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }
    
}
