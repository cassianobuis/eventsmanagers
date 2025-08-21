package com.senai.eventsmanager.service;


import com.senai.eventsmanager.dto.UsuarioCreateDTO;
import com.senai.eventsmanager.entity.Usuario;
import com.senai.eventsmanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository Repository;

    public Usuario findById(UUID id){
        Usuario usuario = Repository.findById(id).orElseThrow();

        return usuario;
    }
    public UsuarioCreateDTO convertToDto(Usuario usuario){
        UsuarioCreateDTO usuarioCreateDTO = new UsuarioCreateDTO();
        usuarioCreateDTO.setCpf(usuario.getCpf());
        usuarioCreateDTO.setNome(usuario.getNome());
        usuarioCreateDTO.setEmail(usuario.getEmail());
        usuarioCreateDTO.setSenha(usuario.getSenha());
        usuarioCreateDTO.setTelefone(usuario.getTelefone());
        usuarioCreateDTO.setTipo(usuario.getTipo());
        usuarioCreateDTO.setDataNascimento(usuario.getDataNascimento());
        return usuarioCreateDTO;
    }
    public Usuario convertToEntity(UsuarioCreateDTO usuarioCreateDTO){
        Usuario usuario = new Usuario();
        usuario.setCpf(usuarioCreateDTO.getCpf());
        usuario.setNome(usuarioCreateDTO.getNome());
        usuario.setEmail(usuarioCreateDTO.getEmail());
        usuario.setSenha(usuarioCreateDTO.getSenha());
        usuario.setTelefone(usuarioCreateDTO.getTelefone());
        usuario.setTipo(usuarioCreateDTO.getTipo());
        usuario.setDataNascimento(usuarioCreateDTO.getDataNascimento());
        return usuario;
    }
}
