package com.senai.eventsmanager.controller;


import com.senai.eventsmanager.dto.UsuarioCreateDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/api/v1/usuario")

public class UsuarioController {

    @GetMapping ("/{id}")
    public UsuarioCreateDTO findById(@PathVariable("id")UUID id){
        return service.findById(id);
    }

    @GetMapping
    public List<UsuarioCreateDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    public UsuarioCreateDTO save(@RequestBody UsuarioCreateDTO usuarioCreateDTO){
        return service.save(usuarioCreateDTO);
    }
    @PutMapping("/{id")
public UsuarioCreateDTO update(@PathVariable("id")UUID id,
                               @RequestBody UsuarioCreateDTO usuarioCreateDTO){
        return service.update(id,usuarioCreateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteByid(@PathVariable("id")UUID id){
        service.deleteByID(id);
    }


}
