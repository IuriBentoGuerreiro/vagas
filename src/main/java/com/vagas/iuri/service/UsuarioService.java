package com.vagas.iuri.service;

import com.vagas.iuri.model.Usuario;
import com.vagas.iuri.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        usuario.setUsername(usuario.getUsername());
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
}
