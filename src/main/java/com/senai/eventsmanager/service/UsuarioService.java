package com.senai.eventsmanager.service;


import com.senai.eventsmanager.dto.UsuarioDTO;
import com.senai.eventsmanager.entity.Usuario;
import com.senai.eventsmanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository Repository;

    public UsuarioDTO findById(UUID id){
        Usuario usuario = Repository.findById(id).orElseThrow();

        return convertToDto(usuario);
    }
    //método para salvar um evento
    public UsuarioDTO save(UsuarioDTO usuarioCreateDTO) {
        Usuario usuario = convertToEntity(usuarioCreateDTO);
        usuario = Repository.save(usuario);
        return convertToDto(usuario);
    }
    //método para atulizar um evento
    public UsuarioDTO update(UUID id,UsuarioDTO usuarioCreateDTO) {
        Usuario usuario = convertToEntity(usuarioCreateDTO);
        usuario.setId(id);
        usuario = Repository.save(usuario);
        return convertToDto(usuario);
    }
    //metodo para deletar um evento
    public void deleteById(UUID id) {
        Repository.deleteById(id);
    }
    //metodo para listar todos os evento
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = Repository.findAll();
        List<UsuarioDTO> usuarioCreateDTOS = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioCreateDTOS.add(convertToDto(usuario));
        }
        return usuarioCreateDTOS;
    }

    public UsuarioDTO convertToDto(Usuario usuario){
        UsuarioDTO usuarioCreateDTO = new UsuarioDTO();
        usuarioCreateDTO.setCpf(usuario.getCpf());
        usuarioCreateDTO.setNome(usuario.getNome());
        usuarioCreateDTO.setEmail(usuario.getEmail());
        usuarioCreateDTO.setSenha(usuario.getSenha());
        usuarioCreateDTO.setTelefone(usuario.getTelefone());
        usuarioCreateDTO.setTipo(usuario.getTipo());
        usuarioCreateDTO.setDataNascimento(usuario.getDataNascimento());
        return usuarioCreateDTO;
    }
    public Usuario convertToEntity(UsuarioDTO usuarioCreateDTO){
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
