package com.senai.eventsmanager.service;


import com.senai.eventsmanager.Enum.UsuarioEnum;
import com.senai.eventsmanager.dto.UsuarioDTO;
import com.senai.eventsmanager.entity.Usuario;
import com.senai.eventsmanager.repository.UsuarioRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository Repository;


    public List<UsuarioDTO> findByTipo(UsuarioEnum tipo){
        List<Usuario> usuarios = Repository.findByTipo(tipo);
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
        for(Usuario usuario : usuarios){
            usuarioDTOs.add(toDto(usuario));
        }
        return usuarioDTOs;
    }

    public UsuarioDTO findById(Long id){
        Usuario usuario = Repository.findById(id).orElseThrow();

        return toDto(usuario);
    }
    //método para salvar um evento
    public UsuarioDTO save(UsuarioDTO usuarioCreateDTO) {
        Usuario usuario = toEntity(usuarioCreateDTO);
        usuario = Repository.save(usuario);
        return toDto(usuario);
    }
    //método para atulizar um evento
    public UsuarioDTO update(Long id,UsuarioDTO usuarioCreateDTO) {
        Usuario usuario = toEntity(usuarioCreateDTO);
        usuario.setId(id);
        usuario = Repository.save(usuario);
        return toDto(usuario);
    }
    //metodo para deletar um evento
    public void deleteById(Long id) {
        Repository.deleteById(id);
    }
    //metodo para listar todos os evento
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = Repository.findAll();
        List<UsuarioDTO> usuarioCreateDTOS = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioCreateDTOS.add(toDto(usuario));
        }
        return usuarioCreateDTOS;
    }

    public UsuarioDTO toDto(Usuario usuario){
        UsuarioDTO dto = new UsuarioDTO();
        BeanUtils.copyProperties(usuario, dto);
        return dto;
    }
    
    public Usuario toEntity (UsuarioDTO dto){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(dto, usuario);
        return usuario;
    }
}
