package com.example.consultacep.service.ServiceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.consultacep.model.Endereco;
import com.example.consultacep.model.Usuario;
import com.example.consultacep.repository.EnderecoRepository;
import com.example.consultacep.repository.UsuarioRepository;
import com.example.consultacep.service.UsuarioService;
import com.example.consultacep.service.ViaCepClient;


@Service
public class UsuarioServiceImpl  implements UsuarioService{
  
   final UsuarioRepository uRepository;
   final EnderecoRepository eRespository;
   final ViaCepClient viaCepClient;

     UsuarioServiceImpl(UsuarioRepository usuarioRepository,EnderecoRepository enderecoRepository,ViaCepClient vClient){
           this.uRepository = usuarioRepository;
           this.eRespository =enderecoRepository;
           this.viaCepClient =vClient;
     }


    @Override
    public Iterable<Usuario> getAll() {
        return uRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        Usuario  user  = uRepository.findById(id).orElseGet(()->{
            return null;
        });     
          return user;
    }

    @Override
    public Iterable<Usuario> listById(Long id) {
            return null;
    }


    @Override
    public void delete(Long id) {
         uRepository.deleteById(id);
    }

    @Override
    public void insertUser(Usuario usuario) { salvaCep(usuario);}


    @Override
    public void updateUser(Long id, Usuario usuario) {
      Optional<Usuario> user = uRepository.findById(id);
        if (user.isPresent()) {
            salvaCep(usuario);
        }else{
            System.out.println("Usuario nao encontrado");
        }
    }

    void salvaCep(Usuario user){
        String cep = user.getEndereco().getCep();   
          Endereco endereco = eRespository.findById(cep).orElseGet(()->{
               Endereco novoEndereco = viaCepClient.consultacep(cep);
                eRespository.save(novoEndereco);
            return novoEndereco;
          });      
          user.setEndereco(endereco);
        uRepository.save(user); 
    }
    
}
